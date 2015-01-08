/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.model.dao.impl;

import com.eidetech.model.dao.IConfiguracionDao;
import com.eidetech.model.dao.IMenuPersonalDao;
import com.eidetech.model.dao.IPersonalDao;
import com.eidetech.model.dao.ISedeDao;
import com.eidetech.model.dao.IUsuarioPersonalDao;
import com.eidetech.model.domain.entity.ConfiguracionMenu;
import com.eidetech.model.domain.entity.Personal;
import com.eidetech.model.domain.entity.Sede;
import com.eidetech.model.domain.entity.UsuarioPersonal;
import com.eidetech.model.util.UtilUsuario;
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
public class UsuarioPersonalDaoTest {
    
    @Autowired
    IUsuarioPersonalDao usuarioDao;
    @Autowired
    IConfiguracionDao configuracionDao;
    @Autowired
    ISedeDao sedeDao;
    @Autowired
    IPersonalDao personalDao;
    @Autowired
    IMenuPersonalDao menuPersonalDao;
    
    @Ignore
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
        
//        menuPersonalDao.agregarMenuPersonal(usuario.getMenu());
        
        boolean expResult = true;
        boolean result = usuarioDao.agregarUsuarioPersonal(usuario);
        
        assertEquals(expResult, result);
    }


    @Ignore
    @Test
    public void testExisteUsuarioPersonal() {
        System.out.println("existeUsuarioPersonal");
        UsuarioPersonal usuario = null;
        UsuarioPersonalDao instance = new UsuarioPersonalDao();
        boolean expResult = false;
        boolean result = instance.existeUsuarioPersonal(usuario);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testObtenerUsuarioPersonal() {
        System.out.println("obtenerUsuarioPersonal");
        UsuarioPersonal usuario = new UsuarioPersonal("admin", "admin");
        
        UsuarioPersonal result = usuarioDao.obtenerUsuarioPersonal(usuario);
        assertNotNull(result);
        System.out.println("id usuario="+result.getId_usuario());
    }

    @Ignore
    @Test
    public void testActualizarUsuarioPersonal() {
        System.out.println("actualizarUsuarioPersonal");
        UsuarioPersonal usuarioPersonal = null;
        UsuarioPersonalDao instance = new UsuarioPersonalDao();
        boolean expResult = false;
        boolean result = instance.actualizarUsuarioPersonal(usuarioPersonal);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testObtenerListaUsuarioPersonal() {
        System.out.println("obtenerListaUsuarioPersonal");
        Sede sede = null;
        UsuarioPersonalDao instance = new UsuarioPersonalDao();
        List<UsuarioPersonal> expResult = null;
        List<UsuarioPersonal> result = instance.obtenerListaUsuarioPersonal(sede);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
