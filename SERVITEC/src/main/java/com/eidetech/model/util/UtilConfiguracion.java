/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.util;

import com.eidetech.model.domain.entity.ConfiguracionMenu;
import com.eidetech.model.domain.entity.ConfiguracionPermiso;
import com.eidetech.model.domain.entity.ConfiguracionSubmenu;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author laptop-w8
 */
public class UtilConfiguracion {

    public static ConfiguracionMenu obtenerMenu(List<ConfiguracionMenu> menus, String id_menu) {
        ConfiguracionMenu cm = null;
        if (menus != null && !menus.isEmpty() && UtilCadena.cadenaValido(id_menu)) {
            for (ConfiguracionMenu c : menus) {
                if (c.getId_menu().equals(id_menu)) {
                    return c;
                }
            }
        }
        return cm;
    }

    public static ConfiguracionSubmenu obtenerSubmenu(List<ConfiguracionSubmenu> submenus, String id_submenu) {
        ConfiguracionSubmenu cs = null;
        if (submenus != null && !submenus.isEmpty() && UtilCadena.cadenaValido(id_submenu)) {
            for (ConfiguracionSubmenu c : submenus) {
                if (c.getId_submenu().equals(id_submenu)) {
                    return c;
                }
            }
        }
        return cs;
    }

    public static List<ConfiguracionSubmenu> listaSubmenu(List<ConfiguracionMenu> menus) {
        List<ConfiguracionSubmenu> l = new ArrayList();
        if (menus != null && !menus.isEmpty()) {
            for (ConfiguracionMenu c : menus) {
                if (c.getSubmenus() != null && !c.getSubmenus().isEmpty()) {
                    for (ConfiguracionSubmenu cs : c.getSubmenus()) {
                        l.add(cs);
                    }
                }
            }
        }
        return l;
    }

    public static List<ConfiguracionPermiso> listaPermiso(List<ConfiguracionMenu> menus){
        List<ConfiguracionPermiso> l = new ArrayList();
        if (menus != null && !menus.isEmpty()) {
            for (ConfiguracionMenu c : menus) {
                if (c.getSubmenus() != null && !c.getSubmenus().isEmpty()) {
                    for (ConfiguracionSubmenu cs : c.getSubmenus()) {
                        if(cs.getPermisos()!=null && !cs.getPermisos().isEmpty()){
                            for(ConfiguracionPermiso cp:cs.getPermisos()){
                                l.add(cp);
                            }
                        }
                    }
                }
            }
        }
        return l;
    }
}
