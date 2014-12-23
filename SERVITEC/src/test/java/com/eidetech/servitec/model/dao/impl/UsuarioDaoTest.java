/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.servitec.model.dao.impl;

import com.eidetech.servitec.model.dao.IConfiguracionDao;
import com.eidetech.servitec.model.dao.IPersonalDao;
import com.eidetech.servitec.model.dao.ISedeDao;
import com.eidetech.servitec.model.dao.IUsuarioDao;
import com.eidetech.servitec.model.domain.entity.ConfiguracionMenu;
import com.eidetech.servitec.model.domain.entity.Personal;
import com.eidetech.servitec.model.domain.entity.Sede;
import com.eidetech.servitec.model.domain.entity.UsuarioCliente;
import com.eidetech.servitec.model.domain.entity.UsuarioPersonal;
import com.eidetech.servitec.model.util.UtilUsuario;
import java.util.Date;
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
public class UsuarioDaoTest {
    
    @Autowired
    IUsuarioDao usuarioDao;
    @Autowired
    IConfiguracionDao configuracionDao;
    @Autowired
    ISedeDao sedeDao;
    @Autowired
    IPersonalDao personalDao;
    
//    @Ignore
    @Test
    public void testAgregarUsuarioPersonal() {
        System.out.println("agregarUsuarioPersonal");
        Sede sede = new Sede();
        sede.setId_sede("SEDE01");
        Sede s = sedeDao.obtenerSede(sede);
        
        
        ConfiguracionMenu menu = new ConfiguracionMenu();
        menu.setDnombre(UtilUsuario.TIPO_MENU_ADMIN);
        ConfiguracionMenu c = configuracionDao.obtenerConfiguracionMenuPersonal(menu);
        
        Personal personal=new Personal();
        personal.setDnombres("Persona 01");
        personal.setDapellidoPaterno("Apellido 01");
        personal.setDapellidoMaterno("Apellido 02");
        personalDao.agregarPersonal(personal);
        
        UsuarioPersonal usuario = new UsuarioPersonal();
        usuario.setDname("admin");
        usuario.setDpassword("admin");
        usuario.setDtipo(UtilUsuario.TIPO_USUARIO_ADMIN);
        usuario.setDuserCreacion("admin");
        usuario.setFuserCreacion(new Date());
        
        usuario.setPersonal(personal);
        usuario.setSede(s);
        usuario.setMenu(UtilUsuario.getMenu(c));
        
        boolean expResult = true;
        boolean result = usuarioDao.agregarUsuarioPersonal(usuario);
        assertEquals(expResult, result);
    }

    @Ignore
    @Test
    public void testAgregarUsuarioCliente() {
        System.out.println("agregarUsuarioCliente");
        UsuarioCliente usuario = null;
        UsuarioDao instance = new UsuarioDao();
        boolean expResult = false;
        boolean result = instance.agregarUsuarioCliente(usuario);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testExisteUsuarioPersonal() {
        System.out.println("existeUsuarioPersonal");
        UsuarioPersonal usuario = null;
        UsuarioDao instance = new UsuarioDao();
        boolean expResult = false;
        boolean result = instance.existeUsuarioPersonal(usuario);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testExisteUsuarioCliente() {
        System.out.println("existeUsuarioCliente");
        UsuarioCliente usuario = null;
        UsuarioDao instance = new UsuarioDao();
        boolean expResult = false;
        boolean result = instance.existeUsuarioCliente(usuario);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testObtenerUsuarioPersonal() {
        System.out.println("obtenerUsuarioPersonal");
        UsuarioPersonal usuario = null;
        UsuarioDao instance = new UsuarioDao();
        UsuarioPersonal expResult = null;
        UsuarioPersonal result = instance.obtenerUsuarioPersonal(usuario);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testObtenerUsuarioCliente() {
        System.out.println("obtenerUsuarioCliente");
        UsuarioCliente usuarioCliente = null;
        UsuarioDao instance = new UsuarioDao();
        UsuarioCliente expResult = null;
        UsuarioCliente result = instance.obtenerUsuarioCliente(usuarioCliente);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
