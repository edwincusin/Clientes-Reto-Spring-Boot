package com.krakedev.jdbc.clientes.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.clientes.entidades.Cliente;
import com.krakedev.clientes.services.ServicioCliente;
import com.krakedev.jdbc.clientes.services.ServicioClienteJdbc;

@RestController
@RequestMapping("/clientes")
public class ClienteJdbcController {
	
	private final ServicioClienteJdbc servicioCliente;	
	
	public ClienteJdbcController(ServicioClienteJdbc servicioCliente) {
		this.servicioCliente = servicioCliente;
	}
	
	@PostMapping
	public Cliente insertar(@RequestBody Cliente cliente) {
		return servicioCliente.insertar(cliente);
	}
	
	@GetMapping
	public List<Cliente> listar(){
		return servicioCliente.listar();
	}
	
	@GetMapping("/{cedula}")
	public Cliente buscarPorCedula(@PathVariable String cedula) {
		return servicioCliente.buscarPorCedula(cedula);
	}
	
	@PutMapping("/{cedula}")
	public Cliente actualizar(@PathVariable String cedula,  @RequestBody Cliente clienteNuevo) {
		return servicioCliente.actualizar(cedula, clienteNuevo);
	}
	
	@DeleteMapping("/{cedula}")
	public boolean eliminar(@PathVariable String cedula) {
		return servicioCliente.eliminar(cedula);
	}
}
