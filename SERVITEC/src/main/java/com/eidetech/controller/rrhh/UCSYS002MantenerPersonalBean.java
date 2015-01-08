/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.controller.rrhh;

import com.eidetech.controller.seguridad.UCSYS001LoginPersonalBean;
import com.eidetech.model.domain.entity.Personal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author laptop-w8
 */
@ManagedBean(name = "mantenerPersonal")
@ViewScoped
public class UCSYS002MantenerPersonalBean implements Serializable {

    private List<Personal> personas;
    private List<Personal> personasFiltradas;
    @ManagedProperty(value = "#{loginPersonal}")
    private UCSYS001LoginPersonalBean beanUsuario;

    /**
     * Creates a new instance of UCSYS002MantenerPersonalBean
     */
    public UCSYS002MantenerPersonalBean() {
    }

    @PostConstruct
    public void init() {
        personas = beanUsuario.getRrhhService().listaPersonal();
    }

    public List<Personal> getPersonas() {
        return personas;
    }

    public List<Personal> getPersonasFiltradas() {
        return personasFiltradas;
    }

    public void setPersonasFiltradas(List<Personal> personasFiltradas) {
        this.personasFiltradas = personasFiltradas;
    }

    public UCSYS001LoginPersonalBean getBeanUsuario() {
        return beanUsuario;
    }

    public void setBeanUsuario(UCSYS001LoginPersonalBean beanUsuario) {
        this.beanUsuario = beanUsuario;
    }

}
