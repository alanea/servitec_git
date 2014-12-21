/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.servitec.model.dao.impl;

import com.eidetech.servitec.model.dao.ITablaTipoDao;
import com.eidetech.servitec.model.domain.entity.TablaTipo;
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
public class TablaTipoDaoTest {
    @Autowired
    ITablaTipoDao tablaTipoDao;
    
    @Ignore
    @Test
    public void testAgregarTablaTipo() {
        System.out.println("agregarTablaTipo");
        TablaTipo tablaTipo = null;
        TablaTipoDao instance = new TablaTipoDao();
        boolean expResult = false;
        boolean result = instance.agregarTablaTipo(tablaTipo);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testAgregarTodoTablaTipo() {
        System.out.println("agregarTodoTablaTipo");
        List<TablaTipo> lista = null;
        TablaTipoDao instance = new TablaTipoDao();
        boolean expResult = false;
        boolean result = instance.agregarTodoTablaTipo(lista);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testActualizarTablaTipo() {
        System.out.println("actualizarTablaTipo");
        TablaTipo tablaTipo = null;
        TablaTipoDao instance = new TablaTipoDao();
        boolean expResult = false;
        boolean result = instance.actualizarTablaTipo(tablaTipo);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

//    @Ignore
    @Test
    public void testObtenerTodoTablaTipo() {
        System.out.println("obtenerTodoTablaTipo");
        List<TablaTipo> result = tablaTipoDao.obtenerTodoTablaTipo();
        assertNotNull(result);
        for(TablaTipo r:result){
            System.out.println(r.getDdescripcion());
        }
    }
    
}
