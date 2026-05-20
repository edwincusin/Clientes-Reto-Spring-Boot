package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Conexion {
	
	private static final Logger log = LogManager.getFormatterLogger(Conexion.class);
	private static final String URL = "jdbc:postgresql://localhost:5432/postgres_movilis";
	private static final String USER = "postgres";
	private static final String PASSWORD = "pgadmin4";
	
	public static Connection getConnection() {
		
		try {
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			log.info("CONEXION EXITOSA");
			return con;			
		} catch (SQLException e) {
			log.error("ERROR DE CONEXION : " + e.getMessage());
			throw new RuntimeException("No se pudo conectar a la BDD",e);//propagar el error
		}
		
	}
}
