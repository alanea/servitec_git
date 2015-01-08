/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.service.impl;

import com.eidetech.model.dao.IConfiguracionDao;
import com.eidetech.model.dao.IUsuarioPersonalDao;
import com.eidetech.model.domain.entity.ConfiguracionMenu;
import com.eidetech.model.domain.entity.ConfiguracionPermiso;
import com.eidetech.model.domain.entity.ConfiguracionPermisoCliente;
import com.eidetech.model.domain.entity.ConfiguracionSubmenu;
import com.eidetech.model.domain.entity.Menu;
import com.eidetech.model.domain.entity.Permiso;
import com.eidetech.model.domain.entity.Sede;
import com.eidetech.model.domain.entity.Submenu;
import com.eidetech.model.domain.entity.TablaTipo;
import com.eidetech.model.domain.entity.UsuarioCliente;
import com.eidetech.model.domain.entity.UsuarioPersonal;
import com.eidetech.model.util.UtilUsuario;
import com.eidetech.service.ISeguridadService;
import java.util.ArrayList;
import java.util.HashSet;
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
public class SeguridadServiceTest {

    @Autowired
    ISeguridadService seguridadService;
    @Autowired
    IUsuarioPersonalDao usuarioPersonalDao;
    @Autowired
    IConfiguracionDao configuracionDao;

    @Ignore
    @Test
    public void testLoginUsuarioPersonal() {
        System.out.println("loginUsuarioPersonal");
        UsuarioPersonal usuario = null;
        SeguridadService instance = new SeguridadService();
        UsuarioPersonal expResult = null;
        UsuarioPersonal result = instance.loginUsuarioPersonal(usuario);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testLoginUsuarioCliente() {
        System.out.println("loginUsuarioCliente");
        UsuarioCliente usuarioCliente = null;
        SeguridadService instance = new SeguridadService();
        UsuarioCliente expResult = null;
        UsuarioCliente result = instance.loginUsuarioCliente(usuarioCliente);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testObtenerSede() {
        System.out.println("obtenerSede");
        SeguridadService instance = new SeguridadService();
        Sede expResult = null;
        Sede result = instance.obtenerSede();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testInicializarConfiguracion() {
        System.out.println("inicializarConfiguracion");
        Sede sede = null;
        SeguridadService instance = new SeguridadService();
        instance.inicializarConfiguracion(sede);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testRegistrarUsuarioPersonal() {
        System.out.println("registrarUsuarioPersonal");
        UsuarioPersonal usuarioPersonal = null;
        SeguridadService instance = new SeguridadService();
        boolean expResult = false;
        boolean result = instance.registrarUsuarioPersonal(usuarioPersonal);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testRegistrarUsuarioCliente() {
        System.out.println("registrarUsuarioCliente");
        UsuarioCliente usuario = null;
        SeguridadService instance = new SeguridadService();
        boolean expResult = false;
        boolean result = instance.registrarUsuarioCliente(usuario);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testRegistrarTabla() {
        System.out.println("registrarTabla");
        TablaTipo tabla = null;
        SeguridadService instance = new SeguridadService();
        boolean expResult = false;
        boolean result = instance.registrarTabla(tabla);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testRegistrarTipo() {
        System.out.println("registrarTipo");
        TablaTipo tipo = null;
        SeguridadService instance = new SeguridadService();
        boolean expResult = false;
        boolean result = instance.registrarTipo(tipo);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testModificarTablaTipo() {
        System.out.println("modificarTablaTipo");
        TablaTipo tablaTipo = null;
        SeguridadService instance = new SeguridadService();
        boolean expResult = false;
        boolean result = instance.modificarTablaTipo(tablaTipo);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testObtenerTablaTipos() {
        System.out.println("obtenerTablaTipos");
        SeguridadService instance = new SeguridadService();
        List<TablaTipo> expResult = null;
        List<TablaTipo> result = instance.obtenerTablaTipos();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testRegistrarConfiguracionMenuPersonal() {
        System.out.println("registrarConfiguracionMenuPersonal");
        ConfiguracionMenu menu = null;
        SeguridadService instance = new SeguridadService();
        boolean expResult = false;
        boolean result = instance.registrarConfiguracionMenuPersonal(menu);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testRegistrarConfiguracionSubmenuPersonal() {
        System.out.println("registrarConfiguracionSubmenuPersonal");
        ConfiguracionSubmenu submenu = null;
        SeguridadService instance = new SeguridadService();
        boolean expResult = false;
        boolean result = instance.registrarConfiguracionSubmenuPersonal(submenu);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testRegistrarConfiguracionPermisoPersonal() {
        System.out.println("registrarConfiguracionPermisoPersonal");
        ConfiguracionPermiso permiso = null;
        SeguridadService instance = new SeguridadService();
        boolean expResult = false;
        boolean result = instance.registrarConfiguracionPermisoPersonal(permiso);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testModificarConfiguracionMenuPersonal() {
        System.out.println("modificarConfiguracionMenuPersonal");
        ConfiguracionMenu menu = null;
        SeguridadService instance = new SeguridadService();
        boolean expResult = false;
        boolean result = instance.modificarConfiguracionMenuPersonal(menu);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testModificarConfiguracionSubmenuPersonal() {
        System.out.println("modificarConfiguracionSubmenuPersonal");
        ConfiguracionSubmenu submenu = null;
        SeguridadService instance = new SeguridadService();
        boolean expResult = false;
        boolean result = instance.modificarConfiguracionSubmenuPersonal(submenu);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testModificarConfiguracionPermisoPersonal() {
        System.out.println("modificarConfiguracionPermisoPersonal");
        ConfiguracionPermiso permiso = null;
        SeguridadService instance = new SeguridadService();
        boolean expResult = false;
        boolean result = instance.modificarConfiguracionPermisoPersonal(permiso);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testListaConfiguracionMenuPersonal() {
        System.out.println("listaConfiguracionMenuPersonal");
        SeguridadService instance = new SeguridadService();
        List<ConfiguracionMenu> expResult = null;
        List<ConfiguracionMenu> result = instance.listaConfiguracionMenuPersonal();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testRegistrarConfiguracionPermisoCliente() {
        System.out.println("registrarConfiguracionPermisoCliente");
        ConfiguracionPermisoCliente permisoCliente = null;
        SeguridadService instance = new SeguridadService();
        boolean expResult = false;
        boolean result = instance.registrarConfiguracionPermisoCliente(permisoCliente);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testModificarConfiguracionPermisoCliente() {
        System.out.println("modificarConfiguracionPermisoCliente");
        ConfiguracionPermisoCliente permisoCliente = null;
        SeguridadService instance = new SeguridadService();
        boolean expResult = false;
        boolean result = instance.modificarConfiguracionPermisoCliente(permisoCliente);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testListaConfiguracionPermisoCliente() {
        System.out.println("listaConfiguracionPermisoCliente");
        SeguridadService instance = new SeguridadService();
        List<ConfiguracionPermisoCliente> expResult = null;
        List<ConfiguracionPermisoCliente> result = instance.listaConfiguracionPermisoCliente();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testListaUsuarioPersonal() {
        System.out.println("listaUsuarioPersonal");
        Sede sede = null;
        SeguridadService instance = new SeguridadService();
        List<UsuarioPersonal> expResult = null;
        List<UsuarioPersonal> result = instance.listaUsuarioPersonal(sede);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testModificarUsuarioPersonal() {
        System.out.println("modificarUsuarioPersonal");
        UsuarioPersonal usuarioPersonal = null;
        SeguridadService instance = new SeguridadService();
        boolean expResult = false;
        boolean result = instance.modificarUsuarioPersonal(usuarioPersonal);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testModificarSede() {
        System.out.println("modificarSede");
        Sede sede = null;
        SeguridadService instance = new SeguridadService();
        boolean expResult = false;
        boolean result = instance.modificarSede(sede);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testListaUsuarioCliente() {
        System.out.println("listaUsuarioCliente");
        SeguridadService instance = new SeguridadService();
        List<UsuarioCliente> expResult = null;
        List<UsuarioCliente> result = instance.listaUsuarioCliente();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testModificarUsuarioCliente() {
        System.out.println("modificarUsuarioCliente");
        UsuarioCliente usuarioCliente = null;
        SeguridadService instance = new SeguridadService();
        boolean expResult = false;
        boolean result = instance.modificarUsuarioCliente(usuarioCliente);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testModificarPermisoUsuarioPersonal() {
        System.out.println("modificarPermisoUsuarioPersonal");
        UsuarioPersonal usuario = new UsuarioPersonal("admin", "admin");
        UsuarioPersonal u = usuarioPersonalDao.obtenerUsuarioPersonal(usuario);

        ConfiguracionMenu configuracionMenu = new ConfiguracionMenu();
        configuracionMenu.setDnombre(UtilUsuario.TIPO_MENU_ADMIN);
        ConfiguracionMenu cm = configuracionDao.obtenerConfiguracionMenuPersonal(configuracionMenu);

        Menu m = u.getMenu();
        List<Permiso> todos = UtilUsuario.listaPermisosPersonal(UtilUsuario.getMenu(cm));
        List<Permiso> nuevo_permisos = new ArrayList();
        Permiso p1 = new Permiso();
        p1.setDurl("usuario_mantenimiento_usuario_cliente.xhtml");
        Permiso p2 = new Permiso();
        p2.setDurl("usuario_servicio_horario.xhtml");
        Permiso p3 = new Permiso();
        p3.setDurl("usuario_mantenimiento_tabla.xhtml");
        Permiso p4 = new Permiso();
        p4.setDurl("usuario_mantenimiento_personal.xhtml");

        if (todos.contains(p1)) {
            int i1 = todos.indexOf(p1);
            Permiso p = todos.get(i1);
            nuevo_permisos.add(p);
        }
        if (todos.contains(p2)) {
            int i1 = todos.indexOf(p2);
            Permiso p = todos.get(i1);
            nuevo_permisos.add(p);
        }
        if (todos.contains(p3)) {
            int i1 = todos.indexOf(p3);
            Permiso p = todos.get(i1);
            nuevo_permisos.add(p);
        }
        if (todos.contains(p4)) {
            int i1 = todos.indexOf(p4);
            Permiso p = todos.get(i1);
            nuevo_permisos.add(p);
        }

        for (Permiso p : nuevo_permisos) {
            System.out.println("permiso nuevo posible:" + p.getDnombre());
        }

//        Menu menu_n2 = UtilUsuario.getMenuListaPermiso(nuevo_permisos, m);
//        System.out.println("menu:" + menu_n2.getDnombre());
//        for (Submenu s : menu_n2.getSubmenus()) {
//            System.out.println("submenu:::" + s.getDnombre());
//            for (Permiso p : s.getPermisos()) {
//                System.out.println("\tpermiso:::" + p.getDnombre());
//            }
//        }

        for (Permiso p : nuevo_permisos) {
            Submenu s = UtilUsuario.obtenerSubmenu(m.getSubmenus(), p.getSubmenu());
            if (s == null) {
                Submenu s1 = new Submenu();
                s1.setDnombre(p.getSubmenu().getDnombre());
                s1.setNorden(p.getSubmenu().getNorden());
                s1.setPermisos(new HashSet());
                s1.setMenu(m);
                s1.getPermisos().add(p);
                p.setSubmenu(s1);
                m.getSubmenus().add(s1);
            } else {
                Permiso pn = UtilUsuario.obtenerPermiso(s.getPermisos(), p);
                if (pn == null) {
                    p.setSubmenu(s);
                    s.getPermisos().add(p);
                }
            }
        }
        List<Permiso> l = UtilUsuario.listaPermisosPersonal(m);

        System.out.println(".--------nuevos permisos");
        for (Permiso p : l) {
            System.out.println("permiso:" + p.getDurl());
        }
//        boolean expResult = true;
//        boolean result = seguridadService.modificarPermisoUsuarioPersonal(u, nuevo_permisos);
//        assertEquals(expResult, result);
    }

}
