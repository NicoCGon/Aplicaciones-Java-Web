package Practica1;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;

public class Init {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws SQLException {
		Numero[][] matrizEjemplo1 = {	{new NumeroReal(new BigDecimal("-3")), new NumeroEntero(new BigInteger("3"))}, 
										{new NumeroReal(new BigDecimal("4")), new NumeroComplejo(new BigDecimal("2"), new BigDecimal("3"))}
		};
		Numero[][] matrizEjemplo2 = {	{new NumeroReal(new BigDecimal("4")), new NumeroEntero(new BigInteger("7"))}, 
										{new NumeroReal(new BigDecimal("2")), new NumeroEntero(new BigInteger("6"))}
		};
		Numero[][] matrizEjemploDeterminante = {	{new NumeroReal(new BigDecimal("1")), new NumeroEntero(new BigInteger("4")), new NumeroEntero(new BigInteger("9"))}, 
													{new NumeroReal(new BigDecimal("7")), new NumeroEntero(new BigInteger("2")), new NumeroEntero(new BigInteger("5"))}, 
													{new NumeroReal(new BigDecimal("6")), new NumeroEntero(new BigInteger("8")), new NumeroEntero(new BigInteger("3"))}
		};
		Matriz matriz1 = new Matriz(matrizEjemplo1);
		Matriz matriz2 = new Matriz(matrizEjemplo2);
		Matriz matrizdeterminante = new Matriz(matrizEjemploDeterminante);
		
		Matriz suma = CalculadoraDeMatrices.sumar(matriz1, matriz2);
		Matriz resta = CalculadoraDeMatrices.restar(matriz1, matriz2);
		CalculadoraDeMatrices.traza(matriz1);
		CalculadoraDeMatrices.determinante(matriz1);
		CalculadoraDeMatrices.determinante(matrizdeterminante);
		throw new SQLException("Error al consultar la matriz");
	}

}
