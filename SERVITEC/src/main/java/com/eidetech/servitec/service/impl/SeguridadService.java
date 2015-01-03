/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.service.impl;

import com.eidetech.servitec.model.dao.IClienteDao;
import com.eidetech.servitec.model.dao.IConfiguracionDao;
import com.eidetech.servitec.model.dao.IPersonaDao;
import com.eidetech.servitec.model.dao.IPersonalDao;
import com.eidetech.servitec.model.dao.ISedeDao;
import com.eidetech.servitec.model.dao.ITablaTipoDao;
import com.eidetech.servitec.model.dao.IUsuarioClienteDao;
import com.eidetech.servitec.model.dao.IUsuarioPersonalDao;
import com.eidetech.servitec.model.domain.entity.Cliente;
import com.eidetech.servitec.model.domain.entity.ConfiguracionMenu;
import com.eidetech.servitec.model.domain.entity.ConfiguracionPermiso;
import com.eidetech.servitec.model.domain.entity.ConfiguracionPermisoCliente;
import com.eidetech.servitec.model.domain.entity.ConfiguracionSubmenu;
import com.eidetech.servitec.model.domain.entity.Personal;
import com.eidetech.servitec.model.domain.entity.Sede;
import com.eidetech.servitec.model.domain.entity.TablaTipo;
import com.eidetech.servitec.model.domain.entity.UsuarioCliente;
import com.eidetech.servitec.model.domain.entity.UsuarioPersonal;
import com.eidetech.servitec.model.util.UtilUsuario;
import com.eidetech.servitec.model.util.validator.ValidatorCliente;
import com.eidetech.servitec.model.util.validator.ValidatorConfiguracion;
import com.eidetech.servitec.model.util.validator.ValidatorPersonal;
import com.eidetech.servitec.model.util.validator.ValidatorSede;
import com.eidetech.servitec.service.ISeguridadService;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author laptop-w8
 */
@Service("seguridadService")
@Transactional(readOnly = true)
public class SeguridadService implements ISeguridadService, Serializable {

    @Autowired
    IConfiguracionDao configuracionDao;
    @Autowired
    IPersonalDao personalDao;
    @Autowired
    IPersonaDao personaDao;
    @Autowired
    IUsuarioPersonalDao usuarioPersonalDao;
    @Autowired
    IUsuarioClienteDao usuarioClienteDao;
    @Autowired
    ITablaTipoDao tablaTipoDao;
    @Autowired
    IClienteDao clienteDao;
    @Autowired
    ISedeDao sedeDao;

    @Override
    public Sede obtenerSede() {
        Sede sede = new Sede();
        sede.setId_sede("SEDE01");
        return sedeDao.obtenerSede(sede);
    }

    @Override
    public void inicializarConfiguracion(Sede sede) {
        UsuarioPersonal usuario = new UsuarioPersonal();
        usuario.setDname("admin");

        if (!usuarioPersonalDao.existeUsuarioPersonal(usuario)) {

            ConfiguracionMenu menu = new ConfiguracionMenu();
            menu.setDnombre(UtilUsuario.TIPO_MENU_ADMIN);
            ConfiguracionMenu c = configuracionDao.obtenerConfiguracionMenuPersonal(menu);
            Personal personal = new Personal();
            personal.setDnombres("Persona 01");
            personal.setDapellidoPaterno("Apellido 01");
            personal.setDapellidoMaterno("Apellido 02");

            personalDao.agregarPersonal(personal);

            usuario.setDpassword("admin");
            usuario.setDtipo(UtilUsuario.TIPO_USUARIO_ADMIN);
            usuario.setDuserCreacion("admin");
            usuario.setFuserCreacion(new Date());
            usuario.setPersonal(personal);
            usuario.setSede(sede);
            usuario.setMenu(UtilUsuario.getMenu(c));

            usuarioPersonalDao.agregarUsuarioPersonal(usuario);
        }
    }

    @Override
    public boolean registrarNuevoPersonal(Personal personal) {
        return personalDao.agregarPersonal(personal);
    }

    @Override
    public boolean registrarNuevoUsuarioPersonal(UsuarioPersonal usuarioPersonal) {
        if (!ValidatorPersonal.esValidoUsuarioPersonal(usuarioPersonal)) {
            return false;
        }

//        ConfiguracionMenu c = null;
//        if (usuarioPersonal.getDtipo().equals(UtilUsuario.TIPO_USUARIO_ADMIN)) {
//            ConfiguracionMenu menu = new ConfiguracionMenu();
//            menu.setDnombre(UtilUsuario.TIPO_MENU_ADMIN);
//            c = configuracionDao.obtenerConfiguracionMenuPersonal(menu);
//        } else {
//            if (usuarioPersonal.getDtipo().equals(UtilUsuario.TIPO_USUARIO_TECNICO)) {
//
//                ConfiguracionMenu menu = new ConfiguracionMenu();
//                menu.setDnombre(UtilUsuario.TIPO_MENU_TECNICO);
//                c = configuracionDao.obtenerConfiguracionMenuPersonal(menu);
//            }
//        }
//        usuarioPersonal.setMenu(UtilUsuario.getMenu(c));
        usuarioPersonal.setFuserCreacion(new Date());
        return usuarioPersonalDao.agregarUsuarioPersonal(usuarioPersonal);
    }

    @Override
    public List<Personal> listaPersonas() {
        return personalDao.obtenerTodoPersonal();
    }

    @Override
    public boolean registrarCliente(UsuarioCliente usuario) {
        if (!ValidatorCliente.esClienteValido(usuario)) {
            return false;
        }
        usuario.setFuserCreacion(new Date());
        usuario.setDname(usuario.getPersona().getDemail());
        usuario.getPersona().setFuserCreacion(new Date());

        Cliente cliente = new Cliente();
        cliente.setId_cliente(usuario.getPersona().getId_persona());
        cliente.setDdni(usuario.getPersona().getId_persona());
        cliente.setDtipo(UtilUsuario.TIPO_CLIENTE_PERSONA);
        cliente.setDnombre(usuario.getPersona().getDnombres() + ", " + usuario.getPersona().getDapellidoPaterno() + " " + usuario.getPersona().getDapellidoMaterno());

        clienteDao.agregarCliente(cliente);

        if (personaDao.existePersona(usuario.getPersona())) {
            return false;
        }
        List<ConfiguracionPermisoCliente> lcpc = configuracionDao.obtenerListaConfiguracionPermisoCliente();
        usuario.setPermisos(UtilUsuario.getPermisoCliente(usuario, lcpc));
        return usuarioClienteDao.agregarUsuarioCliente(usuario);
    }

    @Override
    public boolean registrarTabla(TablaTipo tabla) {
        tabla.setDtabla("0");
        tabla.setDtipo("");
        tabla.setDvalorAbreviado("");
        return tablaTipoDao.agregarTabla(tabla);
    }

    @Override
    public boolean registrarTipo(TablaTipo tipo) {
        tipo.setDvalorAbreviado("");

        return tablaTipoDao.agregarTipo(tipo);
    }

    @Override
    public boolean modificarTablaTipo(TablaTipo tablaTipo) {
        tablaTipo.setFuserModificacion(new Date());
        return tablaTipoDao.actualizarTablaTipo(tablaTipo);
    }

    @Override
    public List<TablaTipo> obtenerTablaTipos() {
        return tablaTipoDao.obtenerTodoTablaTipo();
    }

    @Override
    public boolean registrarConfiguracionMenuPersonal(ConfiguracionMenu menu) {
        if (!ValidatorConfiguracion.esValidoMenuPersonal(menu)) {
            return false;
        }
        return configuracionDao.agregarConfiguracionMenuPersonal(menu);
    }

    @Override
    public boolean registrarConfiguracionSubmenuPersonal(ConfiguracionSubmenu submenu) {
        if (!ValidatorConfiguracion.esValidoSubmenuPersonal(submenu)) {
            return false;
        }
        return configuracionDao.agregarConfiguracionSubmenuPersonal(submenu);
    }

    @Override
    public boolean registrarConfiguracionPermisoPersonal(ConfiguracionPermiso permiso) {
        if (!ValidatorConfiguracion.esValidoPermisoPersonal(permiso)) {
            return false;
        }
        return configuracionDao.agregarConfiguracionPermisoPersonal(permiso);
    }

    @Override
    public boolean modificarConfiguracionMenuPersonal(ConfiguracionMenu menu) {
        return configuracionDao.actualizarConfiguracionMenuPersonal(menu);
    }

    @Override
    public boolean modificarConfiguracionSubmenuPersonal(ConfiguracionSubmenu submenu) {
        return configuracionDao.actualizarConfiguracionSubmenuPersonal(submenu);
    }

    @Override
    public boolean modificarConfiguracionPermisoPersonal(ConfiguracionPermiso permiso) {
        return configuracionDao.actualizarConfiguracionPermisoPersonal(permiso);
    }

    @Override
    public List<ConfiguracionMenu> listaConfiguracionMenuPersonal() {
        return configuracionDao.obtenerListaConfiguracionMenuPersonal();
    }

    @Override
    public boolean registrarConfiguracionPermisoCliente(ConfiguracionPermisoCliente permisoCliente) {
        return configuracionDao.agregarConfiguracionPermisoCliente(permisoCliente);
    }

    @Override
    public boolean modificarConfiguracionPermisoCliente(ConfiguracionPermisoCliente permisoCliente) {
        return configuracionDao.actualizarConfiguracionPermisoCliente(permisoCliente);
    }

    @Override
    public List<ConfiguracionPermisoCliente> listaConfiguracionPermisoCliente() {
        return configuracionDao.obtenerListaConfiguracionPermisoCliente();
    }

    @Override
    public List<UsuarioPersonal> listaUsuarioPersonal(Sede sede) {
        return usuarioPersonalDao.obtenerListaUsuarioPersonal(sede);
    }

    @Override
    public boolean modificarUsuarioPersonal(UsuarioPersonal usuarioPersonal) {
        return usuarioPersonalDao.actualizarUsuarioPersonal(usuarioPersonal);
    }

    @Override
    public boolean modificarSede(Sede sede) {
        if(!ValidatorSede.esValidoSede(sede)){
            return false;
        }
        sede.setFuserModificacion(new Date());
        return sedeDao.actualizarSede(sede);
    }

    @Override
    public boolean modificarPersonal(Personal personal) {
        return personalDao.actualizarPersonal(personal);
    }

}
