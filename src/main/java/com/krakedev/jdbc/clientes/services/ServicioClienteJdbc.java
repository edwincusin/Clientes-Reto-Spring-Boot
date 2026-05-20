package com.krakedev.jdbc.clientes.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.krakedev.clientes.entidades.Cliente;
import com.krakedev.jdbc.clientes.ClienteJdbc;

@Service
public class ServicioClienteJdbc {
	
	public Cliente insertar(Cliente cliente) {
		return ClienteJdbc.insertar(cliente.getCedula(), cliente.getNombre(), cliente.getApellido(), cliente.getEdad());
	}
	
	public List<Cliente> listar(){
		return ClienteJdbc.listar();
	}
	
	public Cliente buscarPorCedula(String cedula) {
		return ClienteJdbc.buscarPorCedula(cedula);
	}
	
	public Cliente actualizar(String cedula,  Cliente clienteNuevo) {
		return ClienteJdbc.actualizar(cedula, clienteNuevo.getNombre(), clienteNuevo.getApellido(), clienteNuevo.getEdad());
	}
	
	public boolean eliminar(String cedula) {
		return ClienteJdbc.eliminar(cedula);
	}
	
}
