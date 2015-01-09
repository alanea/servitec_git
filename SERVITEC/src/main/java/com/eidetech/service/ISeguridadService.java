/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.service;

import com.eidetech.model.domain.entity.ConfiguracionMenu;
import com.eidetech.model.domain.entity.ConfiguracionPermiso;
import com.eidetech.model.domain.entity.ConfiguracionPermisoCliente;
import com.eidetech.model.domain.entity.ConfiguracionSubmenu;
import com.eidetech.model.domain.entity.Permiso;
import com.eidetech.model.domain.entity.Sede;
import com.eidetech.model.domain.entity.TablaTipo;
import com.eidetech.model.domain.entity.UsuarioCliente;
import com.eidetech.model.domain.entity.UsuarioPersonal;
import java.util.List;

/**
 *
 * @author laptop-w8
 */
public interface ISeguridadService {

    public UsuarioPersonal loginUsuarioPersonal(UsuarioPersonal usuarioPersonal);

    public UsuarioCliente loginUsuarioCliente(UsuarioCliente usuarioCliente);

    public Sede obtenerSede();

    public void inicializarConfiguracion(Sede sede);

    public boolean registrarUsuarioPersonal(UsuarioPersonal usuarioPersonal);

    public boolean registrarUsuarioCliente(UsuarioCliente usuario);

    public boolean registrarTabla(TablaTipo tabla);

    public boolean registrarTipo(TablaTipo tipo);

    public boolean modificarTablaTipo(TablaTipo tablaTipo);

    public List<TablaTipo> obtenerTablaTipos();

    public boolean registrarConfiguracionMenuPersonal(ConfiguracionMenu menu);

    public boolean registrarConfiguracionSubmenuPersonal(ConfiguracionSubmenu submenu);

    public boolean registrarConfiguracionPermisoPersonal(ConfiguracionPermiso permiso);

    public boolean modificarConfiguracionMenuPersonal(ConfiguracionMenu menu);

    public boolean modificarConfiguracionSubmenuPersonal(ConfiguracionSubmenu submenu);

    public boolean modificarConfiguracionPermisoPersonal(ConfiguracionPermiso permiso);

    public List<ConfiguracionMenu> listaConfiguracionMenuPersonal();

    public boolean registrarConfiguracionPermisoCliente(ConfiguracionPermisoCliente permisoCliente);

    public boolean modificarConfiguracionPermisoCliente(ConfiguracionPermisoCliente permisoCliente);

    public List<ConfiguracionPermisoCliente> listaConfiguracionPermisoCliente();

    public List<UsuarioPersonal> listaUsuarioPersonal(Sede sede);

    public boolean modificarUsuarioPersonal(UsuarioPersonal usuarioPersonal);

    public boolean modificarSede(Sede sede);

    public List<UsuarioCliente> listaUsuarioCliente();

    public boolean modificarUsuarioCliente(UsuarioCliente usuarioCliente);

    public boolean modificarPermisoUsuarioPersonal(UsuarioPersonal usuarioPersonal, List<Permiso> nuevo_permisos);
    
    public boolean cambiarClaveUsuarioCliente(UsuarioCliente usuarioCliente,String clave_actual,String clave_nueva);
}
