package com.krakedev.productos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.productos.entidades.Producto;
import com.krakedev.productos.services.ProductoServicio;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    // Inyección del servicio
    private final ProductoServicio productoServicio;

    public ProductoController(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    // ➕ CREAR PRODUCTO
    @PostMapping
    public Producto crear(@RequestBody Producto producto) {
        return productoServicio.crear(producto);
    }

    // 📋 LISTAR PRODUCTOS
    @GetMapping
    public List<Producto> listar() {
        return productoServicio.listar();
    }

    // 🔍 BUSCAR POR CÓDIGO
    @GetMapping("/{codigo}")
    public Producto buscar(@PathVariable int codigo) {
        return productoServicio.buscarPorCodigo(codigo);
    }

    // ✏️ ACTUALIZAR PRODUCTO
    @PutMapping("/{codigo}")
    public Producto actualizar(@PathVariable int codigo,
                               @RequestBody Producto productoActualizado) {
        return productoServicio.actualizar(codigo, productoActualizado);
    }

    // ❌ ELIMINAR PRODUCTO
    @DeleteMapping("/{codigo}")
    public boolean eliminar(@PathVariable int codigo) {
        return productoServicio.eliminar(codigo);
    }
}