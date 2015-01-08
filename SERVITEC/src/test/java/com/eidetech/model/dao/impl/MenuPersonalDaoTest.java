/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.dao.impl;

import com.eidetech.model.dao.IConfiguracionDao;
import com.eidetech.model.dao.IMenuPersonalDao;
import com.eidetech.model.domain.entity.ConfiguracionMenu;
import com.eidetech.model.domain.entity.Menu;
import com.eidetech.model.domain.entity.Permiso;
import com.eidetech.model.domain.entity.Submenu;
import com.eidetech.model.util.UtilUsuario;
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
public class MenuPersonalDaoTest {

    @Autowired
    IMenuPersonalDao menuPersonalDao;
    @Autowired
    IConfiguracionDao configuracionDao;

    @Ignore
    @Test
    public void testAgregarMenuPersonal() {
        System.out.println("agregarMenuPersonal");

        ConfiguracionMenu menu = new ConfiguracionMenu();
        menu.setDnombre(UtilUsuario.TIPO_MENU_ADMIN);
        ConfiguracionMenu c = configuracionDao.obtenerConfiguracionMenuPersonal(menu);

        Menu m = UtilUsuario.getMenu(c);
        boolean expResult = true;
        boolean result = menuPersonalDao.agregarMenuPersonal(m);
        assertEquals(expResult, result);
    }

    @Ignore
    @Test
    public void testAgregarSubmenuPersonal() {
        System.out.println("agregarSubmenuPersonal");
        Submenu submenu = null;
        MenuPersonalDao instance = new MenuPersonalDao();
        boolean expResult = false;
        boolean result = instance.agregarSubmenuPersonal(submenu);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testAgregarPermisoPersonal() {
        System.out.println("agregarPermisoPersonal");
        Permiso permiso = null;
        MenuPersonalDao instance = new MenuPersonalDao();
        boolean expResult = false;
        boolean result = instance.agregarPermisoPersonal(permiso);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testEliminarSubmenuPersonal() {
        System.out.println("eliminarSubmenuPersonal");
        Submenu submenu = null;
        MenuPersonalDao instance = new MenuPersonalDao();
        boolean expResult = false;
        boolean result = instance.eliminarSubmenuPersonal(submenu);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testEliminarPermisoPersonal() {
        System.out.println("eliminarPermisoPersonal");
        Permiso permiso = null;
        MenuPersonalDao instance = new MenuPersonalDao();
        boolean expResult = false;
        boolean result = instance.eliminarPermisoPersonal(permiso);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

}
