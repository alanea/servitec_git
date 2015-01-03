/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.servitec.model.dao.impl;

import com.eidetech.servitec.model.dao.IProductoClienteDao;
import com.eidetech.servitec.model.domain.entity.Cliente;
import com.eidetech.servitec.model.domain.entity.HistorialProductoCliente;
import com.eidetech.servitec.model.domain.entity.ProductoCliente;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author laptop-w8
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/applicationContext.xml"})
public class ProductoClienteDaoTest {
    
    @Autowired
    IProductoClienteDao productoClienteDao;

    @Ignore
    @Test
    public void testAgregarProducto() {
        System.out.println("agregarProducto");
        ProductoCliente productoCliente = new ProductoCliente();
        productoCliente.setDproducto("lbesswa10f5l4u");
        
        Cliente cliente=new Cliente();
        cliente.setId_cliente("47695222");
        productoCliente.setCliente(cliente);
        
        boolean expResult = true;
        boolean result = productoClienteDao.agregarProducto(productoCliente);
        assertEquals(expResult, result);
    }

    @Ignore
    @Test
    public void testActualizarProducto() {
        System.out.println("actualizarProducto");
        ProductoCliente productoCliente = null;
        ProductoClienteDao instance = new ProductoClienteDao();
        boolean expResult = false;
        boolean result = instance.actualizarProducto(productoCliente);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testObtenerListaProducto() {
        System.out.println("obtenerListaProducto");
        Cliente cliente = null;
        ProductoClienteDao instance = new ProductoClienteDao();
        List<ProductoCliente> expResult = null;
        List<ProductoCliente> result = instance.obtenerListaProducto(cliente);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testAgregarHistorialProducto() {
        System.out.println("agregarHistorialProducto");
        HistorialProductoCliente historialProductoCliente = null;
        ProductoClienteDao instance = new ProductoClienteDao();
        boolean expResult = false;
        boolean result = instance.agregarHistorialProducto(historialProductoCliente);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testActualizarHistorialProducto() {
        System.out.println("actualizarHistorialProducto");
        HistorialProductoCliente historialProductoCliente = null;
        ProductoClienteDao instance = new ProductoClienteDao();
        boolean expResult = false;
        boolean result = instance.actualizarHistorialProducto(historialProductoCliente);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
