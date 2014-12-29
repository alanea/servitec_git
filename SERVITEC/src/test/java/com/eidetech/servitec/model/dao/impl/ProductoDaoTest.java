/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.servitec.model.dao.impl;

import com.eidetech.servitec.model.domain.entity.Producto;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author laptop-w8
 */
public class ProductoDaoTest {
    
    public ProductoDaoTest() {
    }

    @Ignore
    @Test
    public void testAgregarProducto() {
        System.out.println("agregarProducto");
        Producto producto = null;
        ProductoDao instance = new ProductoDao();
        boolean expResult = false;
        boolean result = instance.agregarProducto(producto);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testAgregarTodoProducto() {
        System.out.println("agregarTodoProducto");
        List<Producto> lista = null;
        ProductoDao instance = new ProductoDao();
        boolean expResult = false;
        boolean result = instance.agregarTodoProducto(lista);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testExisteProducto() {
        System.out.println("existeProducto");
        Producto producto = null;
        ProductoDao instance = new ProductoDao();
        boolean expResult = false;
        boolean result = instance.existeProducto(producto);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testActualizarProducto() {
        System.out.println("actualizarProducto");
        Producto producto = null;
        ProductoDao instance = new ProductoDao();
        boolean expResult = false;
        boolean result = instance.actualizarProducto(producto);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testObtenerProducto() {
        System.out.println("obtenerProducto");
        Producto producto = null;
        ProductoDao instance = new ProductoDao();
        Producto expResult = null;
        Producto result = instance.obtenerProducto(producto);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testObtenerTodoProducto() {
        System.out.println("obtenerTodoProducto");
        ProductoDao instance = new ProductoDao();
        List<Producto> expResult = null;
        List<Producto> result = instance.obtenerTodoProducto();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
