package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UpdateCliente {

	private static final Logger log = LogManager.getFormatterLogger(UpdateCliente.class);
	
	public static void main(String[] args) {
		Connection con= null;
		PreparedStatement ps=null;
		try {
			con=Conexion.getConnection();
			String sql="""
						UPDATE clientes SET nombre = ?, apellido=?, edad =?
						WHERE CEDULA = ?;
					""";
			ps=con.prepareStatement(sql);
			ps.setString(1, "IVAN");
			ps.setString(2, "CARRASCO");
			ps.setInt(3, 15);
			ps.setString(4, "1234567800");
			
			int filas =ps.executeUpdate();
			log.info("Filas actualizadas : "+filas);
			
		} catch (Exception e) {
			log.error("ERROR AL ACTUALIZAR : "+e.getMessage());
			
		}finally{
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
