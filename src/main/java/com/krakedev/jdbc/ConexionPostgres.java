package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConexionPostgres {
	
	private static final Logger log=LogManager.getFormatterLogger(ConexionPostgres.class);
	
	public static void main(String[] args) {
		
		Connection con=null;
		try {
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres_movilis","postgres","pgadmin4");
			log.info("Conexxion exitosa");
		} catch (SQLException e) {
			log.error("Error de conexion:  "+e.getMessage());
		}finally {
			try {
				if(con!=null) {
					con.close();
					log.info("CONEXION CERRADA");
				}
			} catch (SQLException e) {
				log.error("Error al cerar o terminar conexion: "+e.getMessage());
			}
		}

		
		
	}
	
	
}
