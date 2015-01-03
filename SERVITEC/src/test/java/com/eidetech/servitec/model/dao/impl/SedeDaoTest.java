/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.servitec.model.dao.impl;

import com.eidetech.servitec.model.dao.ISedeDao;
import com.eidetech.servitec.model.domain.entity.Sede;
import com.eidetech.servitec.model.domain.entity.UsuarioPersonal;
import java.util.Date;
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
public class SedeDaoTest {
    @Autowired
    ISedeDao sedeDao;

    @Ignore
    @Test
    public void testAgregarSede() {
        System.out.println("agregarSede");
        Sede sede = new Sede();
        sede.setId_sede("SEDE01");
        sede.setDnombre("Sede");
        sede.setDuserCreacion("admin");
        sede.setFuserCreacion(new Date());
        boolean expResult = true;
        boolean result = sedeDao.agregarSede(sede);
        assertEquals(expResult, result);
    }

    @Ignore
    @Test
    public void testActualizarSede() {
        System.out.println("actualizarSede");
        Sede sede = null;
        SedeDao instance = new SedeDao();
        boolean expResult = false;
        boolean result = instance.actualizarSede(sede);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testObtenerSede() {
        System.out.println("obtenerSede");
        Sede sede = new Sede();
        sede.setId_sede("SEDE01");
        Sede result = sedeDao.obtenerSede(sede);
        assertNotNull(result);
        System.out.println("resultado: "+result.getDnombre());
    }

    @Ignore
    @Test
    public void testObtenerListaSedes() {
        System.out.println("obtenerListaSedes");
        SedeDao instance = new SedeDao();
        List<Sede> expResult = null;
        List<Sede> result = instance.obtenerListaSedes();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testAgregarListaSede() {
        System.out.println("agregarListaSede");
        List<Sede> sedes = null;
        SedeDao instance = new SedeDao();
        boolean expResult = false;
        boolean result = instance.agregarListaSede(sedes);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

}
