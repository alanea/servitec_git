/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.util;

import com.eidetech.servitec.model.domain.entity.ConfiguracionMenu;
import com.eidetech.servitec.model.domain.entity.ConfiguracionPermiso;
import com.eidetech.servitec.model.domain.entity.ConfiguracionPermisoCliente;
import com.eidetech.servitec.model.domain.entity.ConfiguracionSubmenu;
import com.eidetech.servitec.model.domain.entity.Menu;
import com.eidetech.servitec.model.domain.entity.Permiso;
import com.eidetech.servitec.model.domain.entity.PermisoCliente;
import com.eidetech.servitec.model.domain.entity.Submenu;
import com.eidetech.servitec.model.domain.entity.UsuarioCliente;
import com.eidetech.servitec.model.domain.entity.UsuarioPersonal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author laptop-w8
 */
public class UtilUsuario {

    public static String TIPO_MENU_ADMIN = "MENU_ADMIN";
    public static String TIPO_MENU_TECNICO = "MENU_TECNICO";
    public static String TIPO_USUARIO_ADMIN = "ADMIN";
    public static String TIPO_USUARIO_TECNICO = "TECNICO";
    public static String TIPO_CLIENTE_PERSONA="PERSONA";
    public static String TIPO_CLIENTE_EMPRESA="EMPRESA";

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

    public static Menu getMenu(ConfiguracionMenu configuracion) {
        Menu menu = null;
        if (configuracion != null) {
            menu = new Menu();
            menu.setDnombre(configuracion.getDnombre());
            menu.setNorden(configuracion.getNorden());
            menu.setSubmenus(new HashSet());
            if (configuracion.getSubmenus() != null && !configuracion.getSubmenus().isEmpty()) {
                for (ConfiguracionSubmenu csm : configuracion.getSubmenus()) {
                    Submenu s1 = new Submenu();
                    s1.setDnombre(csm.getDnombre());
                    s1.setNorden(csm.getNorden());
                    s1.setPermisos(new HashSet());

                    if (csm.getPermisos() != null && !csm.getPermisos().isEmpty()) {
                        for (ConfiguracionPermiso cp : csm.getPermisos()) {
                            Permiso p1 = new Permiso();
                            p1.setBestado(true);
                            p1.setDnombre(cp.getDnombre());
                            p1.setDurl(cp.getDurl());
                            p1.setNorden(cp.getNorden());
                            p1.setFcreacion(new Date());
                            p1.setSubmenu(s1);
                            s1.getPermisos().add(p1);
                        }
                    }

                    s1.setMenu(menu);
                    menu.getSubmenus().add(s1);
                }
            }
        }
        return menu;
    }

    public static Set<PermisoCliente> getPermisoCliente(UsuarioCliente usuarioCliente, List<ConfiguracionPermisoCliente> lista) {
        Set<PermisoCliente> l = new HashSet();
        if (lista != null) {
            for (ConfiguracionPermisoCliente cpc : lista) {
                PermisoCliente p = new PermisoCliente();
                p.setCliente(usuarioCliente);
                p.setDnombre(cpc.getDnombre());
                p.setDurl(cpc.getDurl());
                p.setNorden(cpc.getNorden());
                l.add(p);
            }
        }
        return l;
    }

    public static List<Permiso> listaPermisosPersonal(UsuarioPersonal personal) {
        List<Permiso> l = new ArrayList();
        if (personal != null) {
            Menu menu = personal.getMenu();
            if (menu != null && menu.getSubmenus() != null) {
                for (Submenu sub : menu.getSubmenus()) {
                    if (sub != null && sub.getPermisos() != null) {
                        for (Permiso p : sub.getPermisos()) {
                            l.add(p);
                        }
                    }
                }
            }
        }
        return l;
    }

    public static List<PermisoCliente> listaPermisosCliente(UsuarioCliente cliente) {
        List<PermisoCliente> l = new ArrayList();
        if (cliente != null && cliente.getPermisos() != null) {
            for (PermisoCliente p : cliente.getPermisos()) {
                l.add(p);
            }
        }
        return l;
    }
}
