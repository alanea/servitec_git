/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.model.dao.impl;

import com.eidetech.model.dao.ICategoriaDao;
import com.eidetech.model.domain.entity.Categoria;
import com.eidetech.model.util.converter.ConverterCategoria;
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
public class CategoriaDaoTest {
    @Autowired
    ICategoriaDao categoriaDao;

    @Ignore
    @Test
    public void testAgregarCategoria() {
        System.out.println("agregarCategoria");
        Categoria categoria = null;
        CategoriaDao instance = new CategoriaDao();
        boolean expResult = false;
        boolean result = instance.agregarCategoria(categoria);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testAgregarTodoCategoria() {
        System.out.println("agregarTodoCategoria");
        List<Categoria> lista = ConverterCategoria.obtenerCategorias("/home/laptop-w8/Escritorio/Enlace hacia laptop-w8/Google Drive/STAQ/ServiTec/DATA/DCW_20141104100432_1.csv");
        boolean expResult = true;
        boolean result = categoriaDao.agregarTodoCategoria(lista);
        assertEquals(expResult, result);
    }

    @Ignore
    @Test
    public void testExisteCategoria() {
        System.out.println("existeCategoria");
        Categoria especialidad = null;
        CategoriaDao instance = new CategoriaDao();
        boolean expResult = false;
        boolean result = instance.existeCategoria(especialidad);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testActualizarCategoria() {
        System.out.println("actualizarCategoria");
        Categoria categoria = null;
        CategoriaDao instance = new CategoriaDao();
        boolean expResult = false;
        boolean result = instance.actualizarCategoria(categoria);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testObtenerCategoria() {
        System.out.println("obtenerCategoria");
        Categoria categoria = null;
        CategoriaDao instance = new CategoriaDao();
        Categoria expResult = null;
        Categoria result = instance.obtenerCategoria(categoria);
        assertEquals(expResult, result);
    }

    @Ignore
    @Test
    public void testObtenerTodoCategoria() {
        System.out.println("obtenerTodoCategoria");
        List<Categoria> result = categoriaDao.obtenerTodoCategoria();
        assertNotNull(result);
        for(Categoria c:result){
            System.out.println("Categoria:"+c.getId_categoria());
        }
    }
    
}
