package com.krakedev.clientes.services;

import java.util.ArrayList;
import java.util.List;

import com.krakedev.clientes.ClientesApplication;
import com.krakedev.clientes.entidades.Cliente;

public class ServicioCliente {
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

	// METODO CLIENTE
	public Cliente buscarporCedula(String cedulaString) {

		for (Cliente cliente : clientes) {
			if (cliente.getCedula().equals(cedulaString)) {
				return cliente;
			}
		}
		return null;
	}

	// METODO CREAR CLIENTE : retornamo cliente creado
	public Cliente crear(Cliente clienteNuevo) {
		Cliente existente = buscarporCedula(clienteNuevo.getCedula());

		if (existente == null) {
			clientes.add(clienteNuevo);
			return clienteNuevo;
		}
		return null;

	}

	// METODO LISTAR CLIENTES
	public List<Cliente> listar() {
		return clientes;
	}

	// METODO ACTUALIZAR : retornamos cliente actualizado
	public Cliente actualizar(String cedula,Cliente clienteActualizado) {
		Cliente cliente=buscarporCedula(cedula);	
		if(cliente!=null) {
			cliente.setNombre(clienteActualizado.getNombre());
			cliente.setApellido(clienteActualizado.getApellido());
		}
		return cliente;
	}
	
	//METODO ELIMINAR 
	public boolean Eliminar(String cedula) {
		Cliente clienteEliminar=buscarporCedula(cedula);
		if (clienteEliminar!=null) {
			return clientes.remove(clienteEliminar); // true
		}
		return false;
		
	}
	
	
}
