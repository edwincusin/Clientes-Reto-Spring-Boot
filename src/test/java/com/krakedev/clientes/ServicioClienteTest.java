package com.krakedev.clientes;

import com.krakedev.clientes.services.ServicioCliente;

public class ServicioClienteTest {

    private ServicioCliente servicio;
/*
    // Se ejecuta antes de cada prueba → inicializa el servicio en memoria
    @BeforeEach
    public void setUp() {
        servicio = new ServicioCliente();
    }

    // =========================
    // TEST CREAR
    // =========================

    @Test
    public void testCrearClienteNuevo() {
        // Caso positivo: se crea un cliente que no existe
        Cliente cliente = new Cliente("123", "Juan", "Perez");

        Cliente resultado = servicio.crear(cliente);

        // Verificamos que el cliente fue creado correctamente
        assertNotNull(resultado);
        assertEquals("123", resultado.getCedula());
    }

    @Test
    public void testCrearClienteDuplicado() {
        // Caso negativo: no debe permitir crear clientes con misma cédula
        Cliente cliente1 = new Cliente("123", "Juan", "Perez", "juan@mail.com");
        Cliente cliente2 = new Cliente("123", "Pedro", "Lopez", "pedro@mail.com");

        servicio.crear(cliente1);
        Cliente resultado = servicio.crear(cliente2);

        // Debe retornar null porque ya existe
        assertNull(resultado);
    }

    // =========================
    // TEST BUSCAR
    // =========================

    @Test
    public void testBuscarClienteExistente() {
        // Caso positivo: buscar cliente existente
        Cliente cliente = new Cliente("123", "Juan", "Perez", "juan@mail.com");
        servicio.crear(cliente);

        Cliente resultado = servicio.buscarporCedula("123");

        assertNotNull(resultado);
        assertEquals("Juan", resultado.getNombre());
    }

    @Test
    public void testBuscarClienteNoExistente() {
        // Caso negativo: buscar cliente que no existe
        Cliente resultado = servicio.buscarporCedula("999");

        assertNull(resultado);
    }

    // =========================
    // TEST LISTAR
    // =========================

    @Test
    public void testListarClientes() {
        // Se agregan clientes y se verifica la lista
        servicio.crear(new Cliente("1", "A", "A", "a@mail.com"));
        servicio.crear(new Cliente("2", "B", "B", "b@mail.com"));

        List<Cliente> lista = servicio.listar();

        assertEquals(2, lista.size());
    }

    // =========================
    // TEST ACTUALIZAR
    // =========================

    @Test
    public void testActualizarClienteExistente() {
        // Caso positivo: actualizar un cliente existente
        Cliente cliente = new Cliente("123", "Juan", "Perez", "juan@mail.com");
        servicio.crear(cliente);

        Cliente actualizado = new Cliente("123", "Carlos", "Lopez", "carlos@mail.com");

        Cliente resultado = servicio.actualizar("123", actualizado);

        assertNotNull(resultado);
        assertEquals("Carlos", resultado.getNombre());
        assertEquals("Lopez", resultado.getApellido());
    }

    @Test
    public void testActualizarClienteNoExistente() {
        // Caso negativo: intentar actualizar cliente que no existe
        Cliente actualizado = new Cliente("999", "X", "Y", "x@mail.com");

        Cliente resultado = servicio.actualizar("999", actualizado);

        assertNull(resultado);
    }

    // =========================
    // TEST ELIMINAR
    // =========================

    @Test
    public void testEliminarClienteExistente() {
        // Caso positivo: eliminar cliente existente
        Cliente cliente = new Cliente("123", "Juan", "Perez", "juan@mail.com");
        servicio.crear(cliente);

        boolean resultado = servicio.eliminar("123");

        assertTrue(resultado);
    }

    @Test
    public void testEliminarClienteNoExistente() {
        // Caso negativo: eliminar cliente que no existe
        boolean resultado = servicio.eliminar("999");

        assertFalse(resultado);
    }
    
    */
}