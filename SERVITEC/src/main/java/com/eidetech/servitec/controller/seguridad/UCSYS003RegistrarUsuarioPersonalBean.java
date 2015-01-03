/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.controller.seguridad;

import com.eidetech.servitec.controller.acceso.UCSYS001LoginPersonalBean;
import com.eidetech.servitec.model.domain.entity.ConfiguracionMenu;
import com.eidetech.servitec.model.domain.entity.Personal;
import com.eidetech.servitec.model.domain.entity.UsuarioPersonal;
import com.eidetech.servitec.model.util.UtilConfiguracion;
import com.eidetech.servitec.model.util.UtilUsuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.context.RequestContext;

/**
 *
 * @author laptop-w8
 */
@ManagedBean(name = "registrarUsuarioPersonal")
@ViewScoped
public class UCSYS003RegistrarUsuarioPersonalBean implements Serializable {

    private UsuarioPersonal usuario;
    private List<Personal> personas;
    private List<Personal> personasFiltrados;
    private HashMap hmPersonas;
    private String id_menu;
    private List<ConfiguracionMenu> menus;
    private List<SelectItem> siMenu;
    @ManagedProperty(value = "#{loginPersonal}")
    private UCSYS001LoginPersonalBean beanUsuario;

    /**
     * Creates a new instance of UCSYS003RegistrarUsuarioPersonalBean
     */
    public UCSYS003RegistrarUsuarioPersonalBean() {
        usuario = new UsuarioPersonal();
        usuario.setPersonal(new Personal());
        hmPersonas = new HashMap();
    }

    @PostConstruct
    public void init() {
        personas = beanUsuario.getSeguridadService().listaPersonas();
        menus = beanUsuario.getSeguridadService().listaConfiguracionMenuPersonal();
        siMenu = listaSiMenu();
    }

    public void registrarNuevoUsuario() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesMessage mensaje;
        boolean exito = false;

        ConfiguracionMenu menu=UtilConfiguracion.obtenerMenu(menus, id_menu);
        usuario.setMenu(UtilUsuario.getMenu(menu));
        usuario.setDtipo(UtilUsuario.TIPO_USUARIO_TECNICO);
        usuario.setSede(beanUsuario.getUsuario().getSede());
        usuario.setDuserCreacion(beanUsuario.getUsuario().getId_usuario());

        if (beanUsuario.getSeguridadService().registrarNuevoUsuarioPersonal(usuario)) {
            mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro existoso", usuario.getDname());
            exito = true;
        } else {
            mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se Registro ", usuario.getDname());
        }

        FacesContext.getCurrentInstance().addMessage("growl_registro_usuario", mensaje);
        if (exito) {
            String indexUsuario = "usuario_mantenimiento_usuario.xhtml";
            requestContext.addCallbackParam("view", indexUsuario);
            requestContext.addCallbackParam("estaRegistrado", true);
            usuario = new UsuarioPersonal();
        } else {
            requestContext.addCallbackParam("estaRegistrado", false);
        }
    }

    public List<Personal> completarPersonal(String query) {
        List<Personal> personasFiltrado = new ArrayList();

        hmPersonas = new HashMap();
        for (int i = 0; i < personas.size(); i++) {
            Personal p = personas.get(i);
            if ((p.getDnombres() + " " + p.getDapellidoPaterno() + " " + p.getDapellidoMaterno()).toLowerCase().contains(query.toLowerCase())) {
                personasFiltrado.add(p);
                hmPersonas.put(p.getId_personal(), p);
            }
        }

        return personasFiltrado;
    }

    private List<SelectItem> listaSiMenu() {
        List<SelectItem> l = new ArrayList();
        if (menus != null && !menus.isEmpty()) {
            for (ConfiguracionMenu c : menus) {
                SelectItem s = new SelectItem(c.getId_menu(), c.getDnombre());
                l.add(s);
            }
        }
        return l;
    }

    public UsuarioPersonal getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioPersonal usuario) {
        this.usuario = usuario;
    }

    public UCSYS001LoginPersonalBean getBeanUsuario() {
        return beanUsuario;
    }

    public void setBeanUsuario(UCSYS001LoginPersonalBean beanUsuario) {
        this.beanUsuario = beanUsuario;
    }

    public List<Personal> getPersonas() {
        return personas;
    }

    public List<Personal> getPersonasFiltrados() {
        return personasFiltrados;
    }

    public HashMap getHmPersonas() {
        return hmPersonas;
    }

    public List<SelectItem> getSiMenu() {
        return siMenu;
    }

}
