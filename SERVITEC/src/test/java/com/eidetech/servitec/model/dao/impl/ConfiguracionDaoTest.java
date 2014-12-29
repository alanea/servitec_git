/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.dao.impl;

import com.eidetech.servitec.model.dao.IConfiguracionDao;
import com.eidetech.servitec.model.domain.entity.ConfiguracionMenu;
import com.eidetech.servitec.model.domain.entity.ConfiguracionPermiso;
import com.eidetech.servitec.model.domain.entity.ConfiguracionPermisoCliente;
import com.eidetech.servitec.model.domain.entity.ConfiguracionSubmenu;
import com.eidetech.servitec.model.util.UtilUsuario;
import java.util.HashSet;
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
public class ConfiguracionDaoTest {

    @Autowired
    IConfiguracionDao configuracionDao;

    @Ignore
    @Test
    public void testAgregarConfiguracionMenuPersonal() {
        System.out.println("agregarConfiguracionMenuPersonal");
//        ConfiguracionMenu menu = new ConfiguracionMenu();
//        menu.setDnombre("MENU");
//        menu.setNorden(1);
//        menu.setSubmenus(new HashSet());
//
//        ConfiguracionSubmenu submenu1 = new ConfiguracionSubmenu();
//        submenu1.setDnombre("Horario");
//        submenu1.setNorden(1);
//        submenu1.setPermisos(new HashSet());
//
//        ConfiguracionPermiso permiso11 = new ConfiguracionPermiso();
//        permiso11.setDnombre("Horario");
//        permiso11.setDurl("horario.xhtml");
//        permiso11.setNorden(1);
//        permiso11.setSubmenu(submenu1);
//        submenu1.getPermisos().add(permiso11);
//
//        ConfiguracionSubmenu submenu2 = new ConfiguracionSubmenu();
//        submenu2.setDnombre("Control de equipos");
//        submenu2.setNorden(2);
//        submenu2.setPermisos(new HashSet());
//
//        ConfiguracionPermiso permiso21 = new ConfiguracionPermiso();
//        permiso21.setDnombre("Pendientes por revisar");
//        permiso21.setDurl("pendiente_revisar.xhtml");
//        permiso21.setNorden(1);
//        permiso21.setSubmenu(submenu2);
//        ConfiguracionPermiso permiso22 = new ConfiguracionPermiso();
//        permiso22.setDnombre("Pendiente por reparar");
//        permiso22.setDurl("pendiente_reparar.xhtml");
//        permiso22.setNorden(2);
//        permiso22.setSubmenu(submenu2);
//        ConfiguracionPermiso permiso23 = new ConfiguracionPermiso();
//        permiso23.setDnombre("Reparados");
//        permiso23.setDurl("reparados.xhtml");
//        permiso23.setNorden(3);
//        permiso23.setSubmenu(submenu2);
//        ConfiguracionPermiso permiso24 = new ConfiguracionPermiso();
//        permiso24.setDnombre("Pendientes domicilio");
//        permiso24.setDurl("pendiente_domicilio.xhtml");
//        permiso24.setNorden(4);
//        permiso24.setSubmenu(submenu2);
//
//        submenu2.getPermisos().add(permiso21);
//        submenu2.getPermisos().add(permiso22);
//        submenu2.getPermisos().add(permiso23);
//        submenu2.getPermisos().add(permiso24);
//
//        submenu1.setMenu(menu);
//        submenu2.setMenu(menu);
//
//        menu.getSubmenus().add(submenu1);
//        menu.getSubmenus().add(submenu2);

        ConfiguracionMenu menu = new ConfiguracionMenu();
        menu.setDnombre("MENU_ADMIN");
        menu.setNorden(0);
        menu.setSubmenus(new HashSet());

        ConfiguracionSubmenu submenu1 = new ConfiguracionSubmenu();
        submenu1.setDnombre("Usuario y Permisos");
        submenu1.setNorden(1);
        submenu1.setPermisos(new HashSet());

        ConfiguracionPermiso permiso11 = new ConfiguracionPermiso();
        permiso11.setDnombre("Crear usuario");
        permiso11.setDurl("admin_crear_tecnico.xhtml");
        permiso11.setNorden(1);
        permiso11.setSubmenu(submenu1);
        
        submenu1.getPermisos().add(permiso11);
        
        menu.getSubmenus().add(submenu1);
        
        boolean expResult = true;
        boolean result = configuracionDao.agregarConfiguracionMenuPersonal(menu);
        assertEquals(expResult, result);
    }

    @Ignore
    @Test
    public void testAgregarConfiguracionSubmenuPersonal() {
        System.out.println("agregarConfiguracionSubmenuPersonal");
        ConfiguracionSubmenu submenu = null;
        ConfiguracionDao instance = new ConfiguracionDao();
        boolean expResult = false;
        boolean result = instance.agregarConfiguracionSubmenuPersonal(submenu);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testAgregarConfiguracionPermisoPersonal() {
        System.out.println("agregarConfiguracionPermisoPersonal");
        ConfiguracionPermiso permiso = null;
        ConfiguracionDao instance = new ConfiguracionDao();
        boolean expResult = false;
        boolean result = instance.agregarConfiguracionPermisoPersonal(permiso);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testAgregarConfiguracionPermisoCliente() {
        System.out.println("agregarConfiguracionPermisoCliente");
        ConfiguracionPermisoCliente permiso1 = new ConfiguracionPermisoCliente();
        permiso1.setDnombre("Generar orden de servicio");
        permiso1.setDurl("cliente_servicio_generar_cita.xhtml");
        permiso1.setNorden(1);

        ConfiguracionPermisoCliente permiso2 = new ConfiguracionPermisoCliente();
        permiso2.setDnombre("Mostrar estado");
        permiso2.setDurl("cliente_servicio_mostrar_estado.xhtml");
        permiso2.setNorden(2);

        ConfiguracionPermisoCliente permiso3 = new ConfiguracionPermisoCliente();
        permiso3.setDnombre("Servicios");
        permiso3.setDurl("cliente_servicios.xhtml");
        permiso3.setNorden(3);

        boolean expResult = true;
        boolean result = true;
        configuracionDao.agregarConfiguracionPermisoCliente(permiso1);
        configuracionDao.agregarConfiguracionPermisoCliente(permiso2);
        configuracionDao.agregarConfiguracionPermisoCliente(permiso3);
        assertEquals(expResult, result);
    }

    @Ignore
    @Test
    public void testObtenerConfiguracionMenuPersonal() {
        System.out.println("obtenerConfiguracionMenuPersonal");
        ConfiguracionMenu menu = new ConfiguracionMenu();
        menu.setDnombre(UtilUsuario.TIPO_MENU_TECNICO);
        ConfiguracionMenu result = configuracionDao.obtenerConfiguracionMenuPersonal(menu);
        assertNotNull(result);
        System.out.println("resultado: "+result.getNorden());
        for(ConfiguracionSubmenu s:result.getSubmenus()){
            System.out.println("sub:"+s.getDnombre());
        }
    }

}
