package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Init {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws Exception {
		//Ej1
		List<String> listaCompras = Arrays.asList("harina","huevo","aceite","tomate","lechuga","sal");
		listaCompras.forEach(System.out::println);
		
		//Ej2
		List<Libro> listaLibros = Arrays.asList(
				new Libro(300, "Artificial Intelligence: A Modern approach.", "Stuart Russell y Peter Norvig"),
				new Libro(400, "Computer Networks","Andrew Tanenbaum y David Wetherall"),
				new Libro(400, "Modern Operating Systems"," Andrew Tanenbaum y Herbert Bos")
		);
		listaLibros.forEach(System.out::println);
		
		//Ej3
		Set treeSet = (Set) new TreeSet();
		treeSet.add(38634898);
		treeSet.add(22635698);
		treeSet.add(19982452);
		System.out.println(treeSet);
		
		//Ej4
		ArrayList<Thread> clients = new ArrayList<Thread>();
        for (int i = 0; i < 5; i++) {
            clients.add(new Person(i));
        }
        for (Thread thread : clients) {
            thread.start();
        }
    }

}
