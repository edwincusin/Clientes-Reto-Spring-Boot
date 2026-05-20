package com.krakedev.excepciones;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EscribirArchivo {

	private static Logger log= LogManager.getLogger(EscribirArchivo.class);
	
	public static void main(String[] args) {

		try {
			FileWriter escritor =new FileWriter("contacto.txt",true);// este sobre escribe manteniendo lo que ya esta registrado
			escritor.write("Geovany\n");
			escritor.write("Cusin\n");
			escritor.write("0961918927\n");
			
			escritor.close();
			log.info("Archivo creado con exito");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("OCURRRIO UN ERROR : ", e.getMessage());
		}
		

	}

}
