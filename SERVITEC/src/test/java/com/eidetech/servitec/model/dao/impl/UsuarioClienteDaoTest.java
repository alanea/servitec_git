/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.servitec.model.dao.impl;

import com.eidetech.servitec.model.dao.IConfiguracionDao;
import com.eidetech.servitec.model.dao.IUsuarioClienteDao;
import com.eidetech.servitec.model.domain.entity.ConfiguracionPermisoCliente;
import com.eidetech.servitec.model.domain.entity.Persona;
import com.eidetech.servitec.model.domain.entity.UsuarioCliente;
import com.eidetech.servitec.model.util.UtilUsuario;
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
public class UsuarioClienteDaoTest {
    
    @Autowired
    IConfiguracionDao configuracionDao;
    @Autowired
    IUsuarioClienteDao usuarioClienteDao;
    
    @Ignore
    @Test
    public void testAgregarUsuarioCliente() {
        System.out.println("agregarUsuarioCliente");
        UsuarioCliente usuario = new UsuarioCliente();
        usuario.setDname("q_okd@hotmail.com");
        usuario.setDpassword("123456");
        usuario.setFuserCreacion(new Date());
        
        Persona persona=new Persona();
        persona.setId_persona("47923082");
        persona.setDnombres("");
        persona.setDapellidoPaterno("");
        persona.setDapellidoMaterno("");
        persona.setFnacimiento(new Date());
        persona.setFuserCreacion(new Date());
        
        
        List<ConfiguracionPermisoCliente> lcpc = configuracionDao.obtenerListaConfiguracionPermisoCliente();
        usuario.setPermisos(UtilUsuario.getPermisoCliente(usuario, lcpc));
        
        usuario.setPersona(persona);
        
        boolean expResult = true;
        boolean result = usuarioClienteDao.agregarUsuarioCliente(usuario);
        assertEquals(expResult, result);
    }

    @Ignore
    @Test
    public void testExisteUsuarioCliente() {
        System.out.println("existeUsuarioCliente");
        UsuarioCliente usuario = null;
        UsuarioClienteDao instance = new UsuarioClienteDao();
        boolean expResult = false;
        boolean result = instance.existeUsuarioCliente(usuario);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testObtenerUsuarioCliente() {
        System.out.println("obtenerUsuarioCliente");
        UsuarioCliente usuarioCliente = null;
        UsuarioClienteDao instance = new UsuarioClienteDao();
        UsuarioCliente expResult = null;
        UsuarioCliente result = instance.obtenerUsuarioCliente(usuarioCliente);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
