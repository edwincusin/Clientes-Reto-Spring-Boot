package com.krakedev.clientes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;

import com.krakedev.clientes.entidades.Cliente;
import com.krakedev.clientes.services.ServicioCliente;

@Service
class ServicioClienteTest {

    private ServicioCliente servicio;

    // Se ejecuta antes de cada prueba
    // Inicializa un servicio limpio (sin datos previos)
    @BeforeEach
    void setUp() {
        servicio = new ServicioCliente();
    }

    // =========================
    // CREATE (CREAR CLIENTE)
    // =========================

    @Test
    void crearClienteExitoso() {
        // Se crea un cliente nuevo
        Cliente cliente = new Cliente("123", "Juan", "Perez");

        // Se ejecuta el método crear
        Cliente resultado = servicio.crear(cliente);

        // Se verifica que el cliente fue creado correctamente
        assertNotNull(resultado); // No debe ser null
        assertEquals("123", resultado.getCedula()); // La cédula debe coincidir
    }

    @Test
    void noDebeCrearClienteDuplicado() {
        // Se crean dos clientes con la misma cédula
        Cliente c1 = new Cliente("123", "Juan", "Perez");
        Cliente c2 = new Cliente("123", "Carlos", "Lopez");

        // Se guarda el primero
        servicio.crear(c1);

        // Se intenta guardar el duplicado
        Cliente resultado = servicio.crear(c2);

        // Se verifica que NO se creó el segundo cliente
        assertNull(resultado); // Debe retornar null
    }

    // =========================
    // READ (BUSCAR POR CEDULA)
    // =========================

    @Test
    void buscarClienteExistente() {
        // Se agrega un cliente
        Cliente cliente = new Cliente("123", "Juan", "Perez");
        servicio.crear(cliente);

        // Se busca el cliente por cédula
        Cliente encontrado = servicio.buscarporCedula("123");

        // Se valida que el cliente existe
        assertNotNull(encontrado);
        assertEquals("Juan", encontrado.getNombre());
    }

    @Test
    void buscarClienteNoExistente() {
        // Se busca una cédula que no existe
        Cliente encontrado = servicio.buscarporCedula("999");

        // Se verifica que no se encontró nada
        assertNull(encontrado);
    }

    // =========================
    // READ (LISTAR CLIENTES)
    // =========================

    @Test
    void listarClientes() {
        // Se agregan dos clientes
        servicio.crear(new Cliente("1", "A", "A"));
        servicio.crear(new Cliente("2", "B", "B"));

        // Se obtiene la lista de clientes
        List<Cliente> lista = servicio.listar();

        // Se valida que la lista tenga 2 elementos
        assertEquals(2, lista.size());
    }

    @Test
    void listarSinClientes() {
        // No se agregan clientes

        // Se obtiene la lista
        List<Cliente> lista = servicio.listar();

        // Se verifica que esté vacía
        assertTrue(lista.isEmpty());
    }

    // =========================
    // UPDATE (ACTUALIZAR CLIENTE)
    // =========================

    @Test
    void actualizarClienteExistente() {
        // Se crea un cliente inicial
        servicio.crear(new Cliente("123", "Juan", "Perez"));

        // Se crea un objeto con nuevos datos
        Cliente actualizado = new Cliente("123", "Carlos", "Lopez");

        // Se ejecuta la actualización
        Cliente resultado = servicio.actualizar("123", actualizado);

        // Se valida que la actualización fue exitosa
        assertNotNull(resultado);
        assertEquals("Carlos", resultado.getNombre());
        assertEquals("Lopez", resultado.getApellido());
    }

    @Test
    void actualizarClienteNoExistente() {
        // Se intenta actualizar un cliente que no existe
        Cliente actualizado = new Cliente("999", "Carlos", "Lopez");

        Cliente resultado = servicio.actualizar("999", actualizado);

        // Se valida que no se pudo actualizar
        assertNull(resultado);
    }

    // =========================
    // DELETE (ELIMINAR CLIENTE)
    // =========================

    @Test
    void eliminarClienteExistente() {
        // Se crea un cliente
        servicio.crear(new Cliente("123", "Juan", "Perez"));

        // Se elimina el cliente
        boolean eliminado = servicio.Eliminar("123");

        // Se verifica que se eliminó correctamente
        assertTrue(eliminado);

        // Se valida que ya no exista en la lista
        assertNull(servicio.buscarporCedula("123"));
    }

    @Test
    void eliminarClienteNoExistente() {
        // Se intenta eliminar un cliente que no existe
        boolean eliminado = servicio.Eliminar("999");

        // Se valida que la operación falló
        assertFalse(eliminado);
    }
}