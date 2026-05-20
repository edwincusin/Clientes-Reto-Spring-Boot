package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InsertCliente {

	private static final Logger log = LogManager.getFormatterLogger(InsertCliente.class);
	private static final String URL = "jdbc:postgresql://localhost:5432/postgres_movilis";
	private static final String USER = "postgres";
	private static final String PASSWORD = "pgadmin4";

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement ps=null;
		String sql = """
				INSERT INTO clientes(cedula, nombre, apellido, edad)
				VALUES(?,?,?,?);
				""";
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			
			ps=con.prepareStatement(sql);
			ps.setString(1, "1234567800");
			ps.setString(2, "DARWIN");
			ps.setString(3, "CHARES");
			ps.setInt(4, 32);
			
			int filas =ps.executeUpdate();
			log.info("filas insertadas: "+filas);
			
		} catch (SQLException e) {
			log.error("ERROR DE CONEXION : " + e.getMessage());

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
