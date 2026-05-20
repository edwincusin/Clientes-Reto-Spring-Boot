package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SelectCliente {

	private static final Logger log = LogManager.getFormatterLogger(SelectCliente.class);

	public static void main(String[] args) {
		Connection con= null;
		PreparedStatement ps=null;
		ResultSet  rs=null;// para guardas filas devueltas por select
		
		try {
			con=Conexion.getConnection();
			String sql="""
						SELECT * FROM clientes;
					""";
			ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {//mientas exista filas o retorne true continua en el while
				
				String cedula =rs.getString("cedula");
				String nombre =rs.getString("nombre");
				String apellido =rs.getString("apellido");
				int edad =rs.getInt("edad");
				log.info("Cliente: cedula: "+cedula +" nombre:"+ nombre+ " Apellido: "+apellido+ " Edad: "+edad );
				
				
			}
			
		} catch (Exception e) {
			log.error("Error al traer datos ",e.getMessage());
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
