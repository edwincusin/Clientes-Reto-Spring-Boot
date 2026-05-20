package com.krakedev.productos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.krakedev.productos.entidades.Producto;
import com.krakedev.productos.services.ProductoServicio;

public class ProductoServicioTest {

    private ProductoServicio servicio;

    // 🔧 Se ejecuta antes de cada prueba
    @BeforeEach
    public void setUp() {
        servicio = new ProductoServicio();
    }

    // ✅ PRUEBAS PARA CREAR

    @Test
    public void testCrearProductoCorrectamente() {
        // Crea un producto nuevo y verifica que se agregue correctamente
        Producto p = new Producto("Fideo", 1, 10.5, 10);

        Producto resultado = servicio.crear(p);

        assertNotNull(resultado); // Debe crearse
        assertEquals(1, servicio.listar().size()); // Debe existir en la lista
    }

    @Test
    public void testCrearProductoDuplicado() {
        // Intenta crear dos productos con el mismo código
        Producto p1 = new Producto("Fideo", 1, 10.5, 10);
        Producto p2 = new Producto("Arroz", 1, 12.0, 5);

        servicio.crear(p1);
        Producto resultado = servicio.crear(p2);

        assertNull(resultado); // No debe permitir duplicados
        assertEquals(1, servicio.listar().size()); // Solo debe haber uno
    }

    // ✅ PRUEBAS PARA BUSCAR

    @Test
    public void testBuscarProductoExistente() {
        // Busca un producto que sí existe
        Producto p = new Producto("Fideo", 1, 10.5, 10);
        servicio.crear(p);

        Producto encontrado = servicio.buscarPorCodigo(1);

        assertNotNull(encontrado);
        assertEquals("Fideo", encontrado.getNombre());
    }

    @Test
    public void testBuscarProductoNoExistente() {
        // Busca un producto que NO existe
        Producto encontrado = servicio.buscarPorCodigo(999);

        assertNull(encontrado);
    }

    // ✅ PRUEBAS PARA LISTAR

    @Test
    public void testListarProductos() {
        // Verifica que la lista contenga los productos creados
        servicio.crear(new Producto("Fideo", 1, 10.5, 10));
        servicio.crear(new Producto("Arroz", 2, 12.0, 5));

        List<Producto> lista = servicio.listar();

        assertEquals(2, lista.size());
    }

    @Test
    public void testListarVacio() {
        // Verifica que la lista esté vacía al inicio
        List<Producto> lista = servicio.listar();

        assertTrue(lista.isEmpty());
    }

    // ✅ PRUEBAS PARA ACTUALIZAR

    @Test
    public void testActualizarProductoExistente() {
        // Actualiza un producto existente
        Producto original = new Producto("Fideo", 1, 10.5, 10);
        servicio.crear(original);

        Producto actualizado = new Producto("Arroz", 1, 20.0, 50);

        Producto resultado = servicio.actualizar(1, actualizado);

        assertNotNull(resultado);
        assertEquals("Arroz", resultado.getNombre());
        assertEquals(20.0, resultado.getPrecio());
        assertEquals(50, resultado.getStock());
    }

    @Test
    public void testActualizarProductoNoExistente() {
        // Intenta actualizar un producto que no existe
        Producto actualizado = new Producto("Arroz", 1, 20.0, 50);

        Producto resultado = servicio.actualizar(999, actualizado);

        assertNull(resultado);
    }

    // ✅ PRUEBAS PARA ELIMINAR

    @Test
    public void testEliminarProductoExistente() {
        // Elimina un producto que sí existe
        Producto p = new Producto("Fideo", 1, 10.5, 10);
        servicio.crear(p);

        boolean eliminado = servicio.eliminar(1);

        assertTrue(eliminado);
        assertEquals(0, servicio.listar().size());
    }

    @Test
    public void testEliminarProductoNoExistente() {
        // Intenta eliminar un producto que no existe
        boolean eliminado = servicio.eliminar(999);

        assertFalse(eliminado);
    }
}