/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.model.dao.impl;

import com.eidetech.model.dao.impl.TablaTipoDao;
import com.eidetech.model.dao.ITablaTipoDao;
import com.eidetech.model.domain.entity.TablaTipo;
import com.eidetech.model.util.UtilTablaTipo;
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
    public void testObtenerTodoTablaTipo() {
        System.out.println("obtenerTodoTablaTipo");
        List<TablaTipo> result = tablaTipoDao.obtenerTodoTablaTipo();
//        result = UtilTablaTipo.listaTipos(result, UtilTablaTipo.TABLA);
        assertNotNull(result);
        
        for(TablaTipo r:result){
            System.out.println(r);
        }
    }

    @Ignore
    @Test
    public void testAgregarTabla() {
        System.out.println("agregarTabla");
        TablaTipo tabla = new TablaTipo();
        tabla.setDdescripcion("SONIDO Y MUSICA");
        boolean expResult = true;
        boolean result = tablaTipoDao.agregarTabla(tabla);
        assertEquals(expResult, result);
    }

    @Ignore
    @Test
    public void testAgregarTipo() {
        System.out.println("agregarTipo");
        TablaTipo tipo = new TablaTipo();
        tipo.setDtabla("45");
        tipo.setDdescripcion("");
        boolean expResult = true;
        boolean result = tablaTipoDao.agregarTipo(tipo);
        assertEquals(expResult, result);
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
    
}
