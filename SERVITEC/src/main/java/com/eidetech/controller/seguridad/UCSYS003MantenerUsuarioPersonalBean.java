/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.controller.seguridad;

import com.eidetech.model.domain.entity.ConfiguracionMenu;
import com.eidetech.model.domain.entity.Menu;
import com.eidetech.model.domain.entity.Permiso;
import com.eidetech.model.domain.entity.Sede;
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
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

/**
 *
 * @author laptop-w8
 */
@ManagedBean(name = "mantenerUsuarioPersonal")
@ViewScoped
public class UCSYS003MantenerUsuarioPersonalBean implements Serializable {

    private HashMap hmPermisoPersonal;
    private DualListModel<Permiso> listaDualPermiso;
    private List<UsuarioPersonal> listaUsuario;
    private List<UsuarioPersonal> listaUsuarioFiltrado;
    private UsuarioPersonal usuarioPersonal;
    private Menu menu;
    private List<Permiso> listaPermisoTodo;
    @ManagedProperty(value = "#{loginPersonal}")
    private UCSYS001LoginPersonalBean beanUsuario;

    /**
     * Creates a new instance of UCSYS003MantenerUsuarioPersonalBean
     */
    public UCSYS003MantenerUsuarioPersonalBean() {
    }

    @PostConstruct
    public void init() {
        Sede s = beanUsuario.getUsuario().getSede();
        listaUsuario = beanUsuario.getSeguridadService().listaUsuarioPersonal(s);
        listaDualPermiso = new DualListModel(new ArrayList(), new ArrayList());
        List<ConfiguracionMenu> lcm = beanUsuario.getSeguridadService().listaConfiguracionMenuPersonal();
        menu = new Menu();
        if (UtilLista.esValidaLista(lcm)) {
            for (ConfiguracionMenu c : lcm) {
                if (c.getDnombre().equals(UtilUsuario.TIPO_MENU_ADMIN)) {
                    menu = UtilUsuario.getMenu(c);
                }
            }
        }
        listaPermisoTodo = UtilUsuario.listaPermisosPersonal(menu);
        hmPermisoPersonal = new HashMap();
        for (Permiso p : listaPermisoTodo) {
            hmPermisoPersonal.put(p.getDurl(), p);
        }
    }

    public void inicializarPickList() {
        List<Permiso> l2 = UtilUsuario.listaPermisosPersonal(usuarioPersonal.getMenu());
        List<Permiso> l1 = UtilUsuario.quitarPermisos(listaPermisoTodo, l2);

        listaDualPermiso = new DualListModel(l1, l2);
    }

    public void onRowEdit(RowEditEvent event) {
        UsuarioPersonal e = (UsuarioPersonal) event.getObject();
        FacesMessage msg;

        if (beanUsuario.getSeguridadService().modificarUsuarioPersonal(e)) {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizado", e.getDname());
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No actualizado", e.getDname());
        }

        FacesContext.getCurrentInstance().addMessage("growl_modificar", msg);
    }

    public void onRowCancel(RowEditEvent event) {
        UsuarioPersonal e = (UsuarioPersonal) event.getObject();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Edicion Cancelada", e.getDname());
        FacesContext.getCurrentInstance().addMessage("growl_modificar", msg);
    }

    public void onTransfer(TransferEvent event) {
        StringBuilder builder = new StringBuilder();
        for (Object item : event.getItems()) {
            builder.append(((Permiso) item).getDnombre()).append("<br/>");
        }

        FacesMessage msg = new FacesMessage();
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        msg.setSummary("Permiso transferido");
        msg.setDetail(builder.toString());

        FacesContext.getCurrentInstance().addMessage("growl_modificar_permiso", msg);
    }

    public void registrarNuevoPermisos() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesMessage msg;
        boolean exito = false;

        if (beanUsuario.getSeguridadService().modificarPermisoUsuarioPersonal(usuarioPersonal, listaDualPermiso.getTarget())) {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizado", usuarioPersonal.getDname());
            exito = true;
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No actualizado", usuarioPersonal.getDname());
        }

        FacesContext.getCurrentInstance().addMessage("growl_modificar_permiso", msg);

        if (exito) {
            String indexUsuario = "usuario_mantenimiento_usuario.xhtml";
            requestContext.addCallbackParam("view", indexUsuario);
            requestContext.addCallbackParam("estaRegistrado", true);
            usuarioPersonal = null;
        } else {
            requestContext.addCallbackParam("estaRegistrado", false);
        }
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

    public List<UsuarioPersonal> getListaUsuario() {
        return listaUsuario;
    }

    public List<UsuarioPersonal> getListaUsuarioFiltrado() {
        return listaUsuarioFiltrado;
    }

    public void setListaUsuarioFiltrado(List<UsuarioPersonal> listaUsuarioFiltrado) {
        this.listaUsuarioFiltrado = listaUsuarioFiltrado;
    }

    public UCSYS001LoginPersonalBean getBeanUsuario() {
        return beanUsuario;
    }

    public void setBeanUsuario(UCSYS001LoginPersonalBean beanUsuario) {
        this.beanUsuario = beanUsuario;
    }

    public UsuarioPersonal getUsuarioPersonal() {
        return usuarioPersonal;
    }

    public void setUsuarioPersonal(UsuarioPersonal usuarioPersonal) {
        this.usuarioPersonal = usuarioPersonal;
    }

}
