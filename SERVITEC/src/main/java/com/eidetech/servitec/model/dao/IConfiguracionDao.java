/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.dao;

import com.eidetech.servitec.model.domain.entity.ConfiguracionMenu;
import com.eidetech.servitec.model.domain.entity.ConfiguracionPermiso;
import com.eidetech.servitec.model.domain.entity.ConfiguracionPermisoCliente;
import com.eidetech.servitec.model.domain.entity.ConfiguracionSubmenu;
import java.util.List;

/**
 *
 * @author laptop-w8
 */
public interface IConfiguracionDao {

    public static String PRE_MENU = "MEN";
    public static String PRE_SUBMENU = "SUB";
    public static String PRE_PERMISO = "PER";

    public boolean agregarConfiguracionMenuPersonal(ConfiguracionMenu menu);

    public boolean agregarConfiguracionSubmenuPersonal(ConfiguracionSubmenu submenu);

    public boolean agregarConfiguracionPermisoPersonal(ConfiguracionPermiso permiso);

    public boolean agregarConfiguracionPermisoCliente(ConfiguracionPermisoCliente permiso);

    public ConfiguracionMenu obtenerConfiguracionMenuPersonal(ConfiguracionMenu menu);

    public List<ConfiguracionPermisoCliente> obtenerListaConfiguracionPermisoCliente();

    public boolean actualizarConfiguracionMenuPersonal(ConfiguracionMenu menu);

    public boolean actualizarConfiguracionSubmenuPersonal(ConfiguracionSubmenu submenu);

    public boolean actualizarConfiguracionPermisoPersonal(ConfiguracionPermiso permiso);

    public boolean actualizarConfiguracionPermisoCliente(ConfiguracionPermisoCliente permiso);

    public List<ConfiguracionMenu> obtenerListaConfiguracionMenuPersonal();
}
