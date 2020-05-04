package FlujoDatos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Serializer;

public class Init {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		//Ej1
		System.out.println("Escriba su nombre");
		String teclado = new Scanner(System.in).nextLine();
		String salida = "hola " + teclado;
		System.out.println(salida);

		//Ej2
		try {
			throw new Exception("hola ha ocurrido un error " + teclado);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		//Ej3 y Ej4

		FileWriter flwriter = null;
		
		try {
			File directory = new File("C:\\EjemploTemporal");
			if(!directory.exists())
				directory.mkdir();
			
			File file = new File("C:\\EjemploTemporal\\java.txt");
	        if (!file.exists())
	            file.createNewFile();
	        
		
			flwriter = new FileWriter("C:\\EjemploTemporal\\java.txt");
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			bfwriter.write(salida);
			bfwriter.close();
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (flwriter != null) {
				try {
					flwriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		//Ej5
		ExampleThread exampleThread = new ExampleThread(teclado, salida);
		exampleThread.run();
		
		//Ej6
        Element root = new Element("header");
        for (int i = 0; i < 10; i++)
            root.appendChild(new Element("line"));
        Document doc = new Document(root);
        
        File file = new File("C:\\EjemploTemporal\\java.xml");
        if (!file.exists())
            file.createNewFile();
            
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        Serializer serializer = new Serializer(fileOutputStream, "UTF-8");
        serializer.setIndent(4);
        serializer.write(doc);
    }

}
