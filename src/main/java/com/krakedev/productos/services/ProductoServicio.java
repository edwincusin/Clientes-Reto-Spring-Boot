package com.krakedev.productos.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.krakedev.productos.entidades.Producto;

@Service
public class ProductoServicio {

    private ArrayList<Producto> productos = new ArrayList<>();

    // 🔍 BUSCAR POR CÓDIGO
    public Producto buscarPorCodigo(int codigo) {
        for (Producto producto : productos) {
            if (producto.getCodigo() == codigo) {
                return producto;
            }
        }
        return null;
    }

    // ➕ CREAR PRODUCTO
    public Producto crear(Producto productoNuevo) {
        Producto existente = buscarPorCodigo(productoNuevo.getCodigo());

        if (existente == null) {
            productos.add(productoNuevo);
            return productoNuevo;
        }
        return null;
    }

    // 📋 LISTAR PRODUCTOS
    public List<Producto> listar() {
        return productos;
    }

    // ✏️ ACTUALIZAR PRODUCTO
    public Producto actualizar(int codigo, Producto productoActualizado) {
        Producto producto = buscarPorCodigo(codigo);

        if (producto != null) {
            producto.setNombre(productoActualizado.getNombre());
            producto.setPrecio(productoActualizado.getPrecio());
            producto.setStock(productoActualizado.getStock());
        }

        return producto;
    }

    // ❌ ELIMINAR PRODUCTO
    public boolean eliminar(int codigo) {
        Producto productoEliminar = buscarPorCodigo(codigo);

        if (productoEliminar != null) {
            return productos.remove(productoEliminar);
        }
        return false;
    }
}