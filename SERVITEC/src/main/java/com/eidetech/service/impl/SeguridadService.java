/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.service.impl;

import com.eidetech.model.dao.IClienteDao;
import com.eidetech.model.dao.IConfiguracionDao;
import com.eidetech.model.dao.IMenuPersonalDao;
import com.eidetech.model.dao.IPersonaDao;
import com.eidetech.model.dao.IPersonalDao;
import com.eidetech.model.dao.IProductoClienteDao;
import com.eidetech.model.dao.IReservacionDao;
import com.eidetech.model.dao.ISedeDao;
import com.eidetech.model.dao.ITablaTipoDao;
import com.eidetech.model.dao.IUsuarioClienteDao;
import com.eidetech.model.dao.IUsuarioPersonalDao;
import com.eidetech.model.domain.entity.Cliente;
import com.eidetech.model.domain.entity.ConfiguracionMenu;
import com.eidetech.model.domain.entity.ConfiguracionPermiso;
import com.eidetech.model.domain.entity.ConfiguracionPermisoCliente;
import com.eidetech.model.domain.entity.ConfiguracionSubmenu;
import com.eidetech.model.domain.entity.Menu;
import com.eidetech.model.domain.entity.Permiso;
import com.eidetech.model.domain.entity.Personal;
import com.eidetech.model.domain.entity.ProductoCliente;
import com.eidetech.model.domain.entity.Reservacion;
import com.eidetech.model.domain.entity.Sede;
import com.eidetech.model.domain.entity.Submenu;
import com.eidetech.model.domain.entity.TablaTipo;
import com.eidetech.model.domain.entity.UsuarioCliente;
import com.eidetech.model.domain.entity.UsuarioPersonal;
import com.eidetech.model.util.UtilUsuario;
import com.eidetech.model.util.validator.ValidatorCliente;
import com.eidetech.model.util.validator.ValidatorConfiguracion;
import com.eidetech.model.util.validator.ValidatorPersonal;
import com.eidetech.model.util.validator.ValidatorSede;
import com.eidetech.service.ISeguridadService;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
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
    @Autowired
    IMenuPersonalDao menuPersonalDao;
    @Autowired
    IReservacionDao reservacionDao;
    @Autowired
    IProductoClienteDao productoClienteDao;

    @Override
    public UsuarioPersonal loginUsuarioPersonal(UsuarioPersonal usuario) {
        return usuarioPersonalDao.obtenerUsuarioPersonal(usuario);
    }

    @Override
    public UsuarioCliente loginUsuarioCliente(UsuarioCliente usuarioCliente) {
        UsuarioCliente u = usuarioClienteDao.obtenerUsuarioCliente(usuarioCliente);
        if (u != null) {
            Cliente c = new Cliente();
            c.setId_cliente(u.getPersona().getId_persona());
            u.setCliente(clienteDao.obtenerCliente(c));

            List<Reservacion> lr = reservacionDao.obtenerListaReservacion(u.getCliente());
            u.getCliente().setReservaciones(new HashSet());
            if (lr != null) {
                u.getCliente().getReservaciones().addAll(lr);
            }

            List<ProductoCliente> lp = productoClienteDao.obtenerListaProducto(u.getCliente());
            u.getCliente().setProductos(new HashSet());
            if (lp != null) {
                u.getCliente().getProductos().addAll(lp);
            }
            return u;
        }
        return null;
    }

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
    public boolean registrarUsuarioPersonal(UsuarioPersonal usuarioPersonal) {
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
    public boolean registrarUsuarioCliente(UsuarioCliente usuario) {
        if (!ValidatorCliente.esClienteValido(usuario)) {
            return false;
        }
        usuario.setFuserCreacion(new Date());
        usuario.setDname(usuario.getPersona().getDemail());
        usuario.getPersona().setFuserCreacion(new Date());
        usuario.setDestado(UtilUsuario.ESTADO_USUARIO_ACTIVADO);

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
        if (!ValidatorSede.esValidoSede(sede)) {
            return false;
        }
        sede.setFuserModificacion(new Date());
        return sedeDao.actualizarSede(sede);
    }

    @Override
    public List<UsuarioCliente> listaUsuarioCliente() {
        return usuarioClienteDao.obtenerListaUsuarioCliente();
    }

    @Override
    public boolean modificarUsuarioCliente(UsuarioCliente usuarioCliente) {
        return usuarioClienteDao.actualizarUsuarioCliente(usuarioCliente);
    }

    @Override
    public boolean modificarPermisoUsuarioPersonal(UsuarioPersonal usuarioPersonal, List<Permiso> nuevo_permisos) {
        if (usuarioPersonal == null || usuarioPersonal.getMenu() == null) {
            return false;
        }

        Menu m = usuarioPersonal.getMenu();
        
        List<Permiso> lt=UtilUsuario.listaPermisosPersonal(m);
        for(Permiso p:lt){
            p.setBestado(false);
        }
        
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
                    p.setBestado(true);
                    p.setSubmenu(s);
                    s.getPermisos().add(p);
                }else{
                    pn.setBestado(true);
                }
            }
        }
        
        List<Permiso> l = UtilUsuario.listaPermisosPersonal(m);

        System.out.println(".--------nuevos permisos");
        for (Permiso p : l) {
            System.out.println("permiso:" + p.getDurl()+"-submenu:"+p.getSubmenu().getDnombre()+",estado="+p.isBestado());
        }

        if (menuPersonalDao.agregarMenuPersonal(m)) {
            usuarioPersonal.setMenu(m);
            return true;
        }
        return false;
    }

}
