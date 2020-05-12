package ConectionBD;

import java.sql.*;
import java.util.Arrays;
import java.util.List;
import Collections.Libro;

public class Init {

	public static void main(String[] args) throws Exception {
		List<Libro> listaLibros = Arrays.asList(
				new Libro(300, "Artificial Intelligence: A Modern approach.", "Stuart Russell y Peter Norvig"),
				new Libro(400, "Computer Networks","Andrew Tanenbaum y David Wetherall"),
				new Libro(400, "Modern Operating Systems"," Andrew Tanenbaum y Herbert Bos")
		);

		try{
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","admin","admin");
			Statement statement = connection.createStatement();
			insertLibros(connection, listaLibros);
			queryResult(statement.executeQuery("select * from test.libros"));
		}catch (Exception e){
			System.out.print("Excepcion: "+ e);
		}
	}
	@SuppressWarnings("unused")
	private static void insertLibros(Connection connection, List<Libro> listaLibros) {
		listaLibros.forEach(libro -> {
			PreparedStatement preparedStatement;
			try {
				preparedStatement = connection.prepareStatement("insert into test.libros values(?, ?, ?)");
				preparedStatement.setInt(1, libro.getId());
	            preparedStatement.setString(2, libro.getTitulo());
	            preparedStatement.setString(3, libro.getAutor());
	            preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		});
	}

	private static void queryResult(ResultSet resultSet){
		try {
			while (resultSet.next()) {
				System.out.println(String.join(" ", "Isbn:", resultSet.getString("isbn"), "Titulo:", resultSet.getString("titulo")));
			}
		}
		catch (Exception e) {
			System.out.println("Error al mostrar la consulta");
		}
	}

}
