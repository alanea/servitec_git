/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.service;

import com.eidetech.servitec.model.domain.entity.ConfiguracionMenu;
import com.eidetech.servitec.model.domain.entity.ConfiguracionPermiso;
import com.eidetech.servitec.model.domain.entity.ConfiguracionPermisoCliente;
import com.eidetech.servitec.model.domain.entity.ConfiguracionSubmenu;
import com.eidetech.servitec.model.domain.entity.Personal;
import com.eidetech.servitec.model.domain.entity.Sede;
import com.eidetech.servitec.model.domain.entity.TablaTipo;
import com.eidetech.servitec.model.domain.entity.UsuarioCliente;
import com.eidetech.servitec.model.domain.entity.UsuarioPersonal;
import java.util.List;

/**
 *
 * @author laptop-w8
 */
public interface ISeguridadService {
    
    public Sede obtenerSede();

    public void inicializarConfiguracion(Sede sede);

    public boolean registrarNuevoPersonal(Personal personal);

    public boolean registrarNuevoUsuarioPersonal(UsuarioPersonal usuarioPersonal);

    public List<Personal> listaPersonas();

    public boolean registrarCliente(UsuarioCliente usuario);

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
    
    public boolean modificarPersonal(Personal personal);
}
