package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeleteCliente {
	private static final Logger log = LogManager.getFormatterLogger(UpdateCliente.class);

	public static void main(String[] args) {
		Connection con= null;
		PreparedStatement ps=null;
		try {
			con=Conexion.getConnection();
			String sql="""
						DELETE clientes
						WHERE CEDULA = ?;
					""";

			ps.setString(1, "1234567800");
			
			int filas =ps.executeUpdate();
			log.info("Filas ELIMINADAS : "+filas);
			
		} catch (Exception e) {
			log.error("ERROR AL ELIMINAR : "+e.getMessage());
			
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
