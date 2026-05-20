package com.krakedev.excepciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LeerArchivo {

	private static Logger log= LogManager.getLogger(LeerArchivo.class);
	
	public static void main(String[] args) {

		try {
			FileReader lectorArchivo= new FileReader("contacto.txt"); // abre el archivo
			BufferedReader lector = new BufferedReader(lectorArchivo); // lee el archivo
			
			
			for(int i=0; i<6;i++) {
				log.info(lector.readLine());
			}
			
			lector.close();
			
		} catch (IOException e) {//excepcion global
			// TODO Auto-generated catch block
			
			log.error("Error al leer el archivo", e);
			
		}

	}

}
