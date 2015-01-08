/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.controller.seguridad;

import com.eidetech.model.domain.entity.ConfiguracionMenu;
import com.eidetech.model.domain.entity.Menu;
import com.eidetech.model.domain.entity.Permiso;
import com.eidetech.model.domain.entity.Personal;
import com.eidetech.model.domain.entity.UsuarioPersonal;
import com.eidetech.model.util.UtilLista;
import com.eidetech.model.util.UtilUsuario;
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
import org.primefaces.context.RequestContext;
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

/**
 *
 * @author laptop-w8
 */
@ManagedBean(name = "registrarUsuarioPersonal")
@ViewScoped
public class UCSYS003RegistrarUsuarioPersonalBean implements Serializable {

    private HashMap hmPermisoPersonal;
    private DualListModel<Permiso> listaDualPermiso;
    private UsuarioPersonal usuario;
    private List<Personal> personas;
    private List<Personal> personasFiltrados;
    private HashMap hmPersonas;
    private Menu menu;
    @ManagedProperty(value = "#{loginPersonal}")
    private UCSYS001LoginPersonalBean beanUsuario;

    /**
     * Creates a new instance of UCSYS003RegistrarUsuarioPersonalBean
     */
    public UCSYS003RegistrarUsuarioPersonalBean() {
        usuario = new UsuarioPersonal();
        usuario.setPersonal(new Personal());
        hmPersonas = new HashMap();
        hmPermisoPersonal=new HashMap();
        listaDualPermiso = new DualListModel(new ArrayList(), new ArrayList());        
    }

    @PostConstruct
    public void init() {
        personas = beanUsuario.getRrhhService().listaPersonal();
        List<ConfiguracionMenu> menus = beanUsuario.getSeguridadService().listaConfiguracionMenuPersonal();
        menu = new Menu();
        if (UtilLista.esValidaLista(menus)) {
            for (ConfiguracionMenu c : menus) {
                if (c.getDnombre().equals(UtilUsuario.TIPO_MENU_ADMIN)) {
                    menu = UtilUsuario.getMenu(c);
                }
            }
        }
        
        List<Permiso> listaPermisoTodo = UtilUsuario.listaPermisosPersonal(menu);
        for (Permiso p : listaPermisoTodo) {
            hmPermisoPersonal.put(p.getDurl(), p);
        }
        List<Permiso> l1 = UtilUsuario.listaPermisosPersonal(menu);
        List<Permiso> l2 = new ArrayList();
        listaDualPermiso = new DualListModel(l1, l2);
    }

    public void registrarNuevoUsuario() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesMessage mensaje;
        boolean exito = false;

        usuario.setMenu(UtilUsuario.getMenuListaPermiso(listaDualPermiso.getTarget(), menu));
        usuario.setSede(beanUsuario.getUsuario().getSede());
        usuario.setDuserCreacion(beanUsuario.getUsuario().getId_usuario());

        if (beanUsuario.getSeguridadService().registrarUsuarioPersonal(usuario)) {
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
    
    public void onTransfer(TransferEvent event) {
        StringBuilder builder = new StringBuilder();
        for (Object item : event.getItems()) {
            builder.append(((Permiso) item).getDnombre()).append("\n");
        }

        FacesMessage msg = new FacesMessage();
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        msg.setSummary("Permiso transferido");
        msg.setDetail(builder.toString());

        FacesContext.getCurrentInstance().addMessage("growl_registro_usuario", msg);
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

    public HashMap getHmPermisoPersonal() {
        return hmPermisoPersonal;
    }

    public DualListModel<Permiso> getListaDualPermiso() {
        return listaDualPermiso;
    }

    public void setListaDualPermiso(DualListModel<Permiso> listaDualPermiso) {
        this.listaDualPermiso = listaDualPermiso;
    }

}
