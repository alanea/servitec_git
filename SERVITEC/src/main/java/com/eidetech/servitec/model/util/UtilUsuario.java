/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.util;

import com.eidetech.servitec.model.domain.entity.Menu;
import com.eidetech.servitec.model.domain.entity.Permiso;
import com.eidetech.servitec.model.domain.entity.Submenu;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author laptop-w8
 */
public class UtilUsuario {

    public static MenuModel getMenuUsuario(Menu menu) {
        MenuModel modelo = new DefaultMenuModel();
        if (menu != null && menu.getSubmenus() != null && !menu.getSubmenus().isEmpty()) {
            for (Submenu s : menu.getSubmenus()) {
                DefaultSubMenu submenu = new DefaultSubMenu(s.getDnombre());
                if (s.getPermisos() != null && !s.getPermisos().isEmpty()) {
                    for (Permiso p : s.getPermisos()) {
                        DefaultMenuItem item = new DefaultMenuItem(p.getDnombre());
                        item.setUrl(p.getDurl());
                        item.setIcon("ui-icon-home");
                        submenu.addElement(item);
                    }
                }
                modelo.addElement(submenu);
            }
        }
        return modelo;
    }
}
