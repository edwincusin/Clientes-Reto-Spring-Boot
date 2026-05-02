package com.krakedev.clientes.services;

import java.util.ArrayList;
import java.util.List;

import com.krakedev.clientes.ClientesApplication;
import com.krakedev.clientes.entidades.Cliente;

public class ServicioCliente {
	private ArrayList<Cliente> clientes= new ArrayList<Cliente>();
	
	
	//METODO CLIENTE
	public Cliente buscarporCedula(String cedulaString) {
		
		for(Cliente cliente:clientes) {
			if(cliente.getCedula().equals(cedulaString)) {
				return cliente;
			}
		}
		return null;
	}
	//METODO CREAR CLIENTE 
	public Cliente crear(Cliente clienteNuevo) {
		Cliente existente=buscarporCedula(clienteNuevo.getCedula());
		
		if(existente==null) {
			clientes.add(clienteNuevo);
			return clienteNuevo;
		}else {
			return null;
		}
		
	}
	
	//METODO LISTAR CLIENTES
	public List<Cliente> listar(){
		return clientes;
	}
}
