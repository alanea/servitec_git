/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.util;

import com.eidetech.model.domain.entity.ConfiguracionMenu;
import com.eidetech.model.domain.entity.ConfiguracionPermiso;
import com.eidetech.model.domain.entity.ConfiguracionPermisoCliente;
import com.eidetech.model.domain.entity.ConfiguracionSubmenu;
import com.eidetech.model.domain.entity.Menu;
import com.eidetech.model.domain.entity.Permiso;
import com.eidetech.model.domain.entity.PermisoCliente;
import com.eidetech.model.domain.entity.Submenu;
import com.eidetech.model.domain.entity.UsuarioCliente;
import com.eidetech.model.domain.entity.UsuarioPersonal;
import com.eidetech.model.util.validator.ValidatorConfiguracion;
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
    public static String TIPO_CLIENTE_PERSONA = "PERSONA";
    public static String TIPO_CLIENTE_EMPRESA = "EMPRESA";
    public static String ESTADO_USUARIO_ACTIVADO = "1";
    public static String ESTADO_USUARIO_DESACTIVADO = "2";
    public static String ESTADO_USUARIO_NO_PROCESADO = "3";
    public static String ESTADO_USUARIO_RETIRADO = "4";

    public static MenuModel getMenuUsuario(Menu menu) {
        MenuModel modelo = new DefaultMenuModel();
        if (menu != null && menu.getSubmenus() != null && !menu.getSubmenus().isEmpty()) {
            for (Submenu s : menu.getSubmenus()) {
                DefaultSubMenu submenu = new DefaultSubMenu(s.getDnombre());
                if (s.getPermisos() != null && !s.getPermisos().isEmpty()) {
                    for (Permiso p : s.getPermisos()) {
                        if (p.isBestado()) {
                            DefaultMenuItem item = new DefaultMenuItem(p.getDnombre());
                            item.setUrl(p.getDurl());
                            submenu.addElement(item);
                        }
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
                            if (p.isBestado()) {
                                l.add(p);
                            }
                        }
                    }
                }
            }
        }
        return l;
    }

    public static List<Permiso> listaPermisosPersonal(Menu menu) {
        List<Permiso> l = new ArrayList();
        if (menu != null && menu.getSubmenus() != null) {
            for (Submenu sub : menu.getSubmenus()) {
                if (sub != null && sub.getPermisos() != null) {
                    for (Permiso p : sub.getPermisos()) {
                        if (p.isBestado()) {
                            l.add(p);
                        }
                    }
                }
            }
        }
        return l;
    }

    public static List<Permiso> quitarPermisos(List<Permiso> todos, List<Permiso> l) {
        List<Permiso> ln = new ArrayList();
        if (todos != null && l != null) {
            for (Permiso p : todos) {
                if (!l.contains(p)) {
                    ln.add(p);
                }
            }
        }
        return ln;
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

    public static Submenu obtenerSubmenu(Set<Submenu> l, Submenu s) {
        if (UtilLista.esValidoConjunto(l) && s != null) {
            for (Submenu s1 : l) {
                if (s.getDnombre().equals(s1.getDnombre())) {
                    return s1;
                }
            }
        }
        return null;
    }

    public static Permiso obtenerPermiso(Set<Permiso> l, Permiso p) {
        if (UtilLista.esValidoConjunto(l) && p != null) {
            for (Permiso p1 : l) {
                if (p1.getDurl().equals(p.getDurl())) {
                    return p1;
                }
            }
        }
        return null;
    }

    public static Menu getMenuListaPermiso(List<Permiso> l, Menu menu) {
        Menu m = new Menu();
        if (UtilLista.esValidaLista(l) && menu != null) {
            m.setDnombre(menu.getDnombre());
            m.setNorden(menu.getNorden());
            m.setSubmenus(new HashSet());

            for (Permiso p : l) {
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
                        p.setSubmenu(s);
                        s.getPermisos().add(p);
                    }
                }
            }
        }

        return m;
    }
}
