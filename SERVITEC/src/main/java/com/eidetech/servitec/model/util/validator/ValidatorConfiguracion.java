/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.util.validator;

import com.eidetech.servitec.model.domain.entity.ConfiguracionMenu;
import com.eidetech.servitec.model.domain.entity.ConfiguracionPermiso;
import com.eidetech.servitec.model.domain.entity.ConfiguracionSubmenu;
import com.eidetech.servitec.model.util.UtilCadena;

/**
 *
 * @author laptop-w8
 */
public class ValidatorConfiguracion {

    public static boolean esValidoMenuPersonal(ConfiguracionMenu menu) {
        if (menu != null) {
            return UtilCadena.cadenaValido(menu.getDnombre());
        }
        return false;
    }

    public static boolean esValidoSubmenuPersonal(ConfiguracionSubmenu submenu) {
        if (submenu != null && submenu.getMenu() != null) {
            if (!esValidoMenuPersonal(submenu.getMenu())) {
                return false;
            }
            return UtilCadena.cadenaValido(submenu.getDnombre());
        }
        return false;
    }

    public static boolean esValidoPermisoPersonal(ConfiguracionPermiso permiso) {
        if (permiso != null && permiso.getSubmenu() != null && permiso.getSubmenu().getMenu() != null) {
            if (!esValidoSubmenuPersonal(permiso.getSubmenu())) {
                return false;
            }
            return UtilCadena.cadenaValido(permiso.getDnombre()) && UtilCadena.cadenaValido(permiso.getDurl());
        }
        return false;
    }
}