package com.krakedev.excepciones;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckendEjemplo {

	public static void main(String[] args) {
		 System.out.println("Inicia el programa");

	        try {
	            FileReader archivo = new FileReader("archivo.txt");
	            System.out.println("Archivo abierto");

	        } catch (FileNotFoundException e) {

	            // TODO Auto-generated catch block
	            System.out.println("Error el archivo no fue encontrado: " + e.getMessage());
	            e.printStackTrace();
	        }

	}

}
