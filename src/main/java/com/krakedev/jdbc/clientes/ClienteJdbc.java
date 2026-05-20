package com.krakedev.jdbc.clientes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.clientes.entidades.Cliente;
import com.krakedev.jdbc.Conexion;

public class ClienteJdbc {

	private static final Logger log = LogManager.getFormatterLogger(ClienteJdbc.class);
	
	//METODO INSERTAR CLIENTE
	public static Cliente insertar(String cedula, String nombre, String apellido, int edad) {
		
		Connection con=null; 
		PreparedStatement ps=null;
		Cliente cliente=null;
		
		try {
			con=Conexion.getConnection();
			String sql="""
					INSERT INTO clientes(cedula, nombre, apellido, edad)
					VALUES(?,?,?,?); 
					""";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, cedula);
			ps.setString(2, nombre);
			ps.setString(3, apellido);
			ps.setInt(4, edad);
			
			cliente =new Cliente(cedula, nombre, apellido, edad);
			int filas = ps.executeUpdate();
			
			log.info("Filas insertadas : "+filas);
			
		} catch (Exception e) {
			log.error("ERROR AL INSERTAR " +e);
			throw new RuntimeException("ERROR AL INSERTAR"+e.getMessage());
		}finally {
			try {
				con.close();
				log.error("CIERRE DE CONEXION NORMAL");
			} catch (SQLException e) {
				log.error("ERROR AL CERRAR CONEXION " +e);
			}
		}
		return cliente;
		
	}
	
	//RETORNAR LISTA DE CLIENTES
	
	public static List<Cliente> listar(){
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		Connection con=null; 
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			con=Conexion.getConnection();
			String sql="""
					SELECT * FROM clientes; 
					""";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				Cliente cliente=new Cliente(rs.getString("cedula"), rs.getString("nombre"), rs.getString("apellido"), rs.getInt("edad"));
				clientes.add(cliente);
			}			
			log.info("LISTA COMPLETA");		
			
		} catch (Exception e) {
			log.error("ERROR AL LISTAR " +e);
			throw new RuntimeException("ERROR AL LISTAR R"+e.getMessage());
		}finally {
			try {
				con.close();
				log.error("CIERRE DE CONEXION NORMAL");
			} catch (SQLException e) {
				log.error("ERROR AL CERRAR CONEXION " +e);
			}
		}
		
		return clientes;
	}
	
	//RECUPERAR POR NUMERO DE CEDULA
	
	public static Cliente buscarPorCedula(String cedula) {

		Connection con=null; 
		PreparedStatement ps=null;
		ResultSet rs=null;
		Cliente cliente=null;
		
		try {
			con=Conexion.getConnection();
			String sql="""
					SELECT * FROM clientes
					WHERE cedula=?; 
					""";
			ps=con.prepareStatement(sql);
			ps.setString(1, cedula);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				cliente=new Cliente(rs.getString("cedula"), rs.getString("nombre"), rs.getString("apellido"), rs.getInt("edad"));
			}			
			log.info("cliente encontrado");		
			
		} catch (Exception e) {
			log.error("ERROR AL CONSULTAR POR CEDULA " +e);
			throw new RuntimeException("ERROR AL CONSULTAR POR CEDULA"+e.getMessage());
		}finally {
			try {
				con.close();
				log.error("CIERRE DE CONEXION NORMAL");
			} catch (SQLException e) {
				log.error("ERROR AL CERRAR CONEXION " +e);
			}
		}
		
		return cliente;
	}
	
	
	//ACTUALIZAR  POR NUMERO DE CEDULA
	
	public static Cliente actualizar(String cedula, String nuevoNombre, String nuevoApellido, int nuevaEdad) {

		Connection con=null; 
		PreparedStatement ps=null;
		Cliente cliente=null;
		
		try {
			con=Conexion.getConnection();
			String sql="""
					UPDATE clientes
					SET nombre=?,apellido=?, edad=?
					WHERE cedula=?; 
					""";
			ps=con.prepareStatement(sql);
			ps.setString(1, nuevoNombre);
			ps.setString(2, nuevoApellido);
			ps.setInt(3, nuevaEdad);
			
			ps.setString(4, cedula);
			
			cliente =new Cliente(cedula, nuevoNombre, nuevoApellido, nuevaEdad);
			
			int filas = ps.executeUpdate();
			
			log.info("Filas actualziadas "+filas);		
			log.info("cliente actualizado");		
			
		} catch (Exception e) {
			log.error("ERROR AL ACTUALIZAR POR CEDULA " +e);
			throw new RuntimeException("ERROR AL ACTUALIZAR POR CEDULA "+e.getMessage());
		}finally {
			try {
				con.close();
				log.error("CIERRE DE CONEXION NORMAL");
			} catch (SQLException e) {
				log.error("ERROR AL CERRAR CONEXION " +e);
			}
		}
		
		return cliente;
	}
	
	//ELIMINAR  POR NUMERO DE CEDULA
	
	public static boolean eliminar(String cedula) {
		Connection con=null; 
		PreparedStatement ps=null;
		
		try {
			con=Conexion.getConnection();
			String sql="""
					DELETE FROM clientes
					WHERE cedula=?; 
					""";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, cedula);
			
			int filas = ps.executeUpdate();
			
			log.info("Filas ELIMINADA "+filas);		
			log.info("cliente eliminado");	
			
			return true;
			
		} catch (Exception e) {
			log.error("ERROR AL ELIMINAR POR CEDULA " +e);
			throw new RuntimeException("ERROR AL ELIMINAR POR CEDULA"+e.getMessage());
			
		}finally {
			try {
				con.close();
				log.error("CIERRE DE CONEXION NORMAL");
			} catch (SQLException e) {
				log.error("ERROR AL CERRAR CONEXION " +e);
			}
		}
		
	}
	
	
}
