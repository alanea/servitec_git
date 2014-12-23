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

/**
 *
 * @author laptop-w8
 */
public interface IConfiguracionDao {

    public boolean agregarConfiguracionMenuPersonal(ConfiguracionMenu menu);

    public boolean agregarConfiguracionSubmenuPersonal(ConfiguracionSubmenu submenu);

    public boolean agregarConfiguracionPermisoPersonal(ConfiguracionPermiso permiso);

    public boolean agregarConfiguracionPermisoCliente(ConfiguracionPermisoCliente permiso);
    
    public ConfiguracionMenu obtenerConfiguracionMenuPersonal(ConfiguracionMenu menu);
}
