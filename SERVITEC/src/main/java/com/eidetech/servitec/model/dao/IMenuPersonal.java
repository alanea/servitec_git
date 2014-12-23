/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.dao;

import com.eidetech.servitec.model.domain.entity.Menu;
import com.eidetech.servitec.model.domain.entity.Permiso;
import com.eidetech.servitec.model.domain.entity.Submenu;

/**
 *
 * @author laptop-w8
 */
public interface IMenuPersonal {

    public boolean agregarMenuPersonal(Menu menu);

    public boolean agregarSubmenuPersonal(Submenu submenu);

    public boolean agregarPermisoPersonal(Permiso permiso);

    public boolean eliminarSubmenuPersonal(Submenu submenu);

    public boolean eliminarPermisoPersonal(Permiso permiso);
}
