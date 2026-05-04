package com.krakedev.clientes.controller;

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

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	// Servicio inyectado por Spring para gestionar la lógica de clientes
	private final ServicioCliente servicioCliente;
	
	public ClienteController(ServicioCliente servicioCliente) {
		this.servicioCliente = servicioCliente;
	}

	// ENDPOINTS

	// Crea un nuevo cliente
	@PostMapping
	public Cliente crear(@RequestBody Cliente cliente) {
		return servicioCliente.crear(cliente);
	}
	
	// Obtiene la lista de todos los clientes
	@GetMapping
	public List<Cliente> listar() {
		return servicioCliente.listar();
	}
	
	// Busca un cliente por su cédula
	@GetMapping("/{cedula}")
	public Cliente buscar(@PathVariable String cedula) {
		return servicioCliente.buscarporCedula(cedula);
	}
	
	// Actualiza los datos de un cliente existente
	@PutMapping("/{cedula}")
	public Cliente actualizar(@PathVariable String cedula, @RequestBody Cliente clienteActualizado) {
		return servicioCliente.actualizar(cedula, clienteActualizado);
	}
	
	// Elimina un cliente por su cédula
	@DeleteMapping("/{cedula}")
	public boolean eliminar(@PathVariable String cedula) {
		return servicioCliente.eliminar(cedula);
	}

}
