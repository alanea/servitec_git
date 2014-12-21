/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.controller;

import com.eidetech.servitec.model.domain.Imagen;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;

/**
 *
 * @author laptop-w8
 */
@ManagedBean
@ApplicationScoped
public class ImagenesBean implements Serializable {

    private List<Imagen> imagenes;

    /**
     * Creates a new instance of ImagenesBean
     */
    public ImagenesBean() {
    }

    @PostConstruct
    public void init() {
        imagenes = new ArrayList();
        imagenes.add(new Imagen(""));
        imagenes.add(new Imagen(""));
        imagenes.add(new Imagen(""));
        imagenes.add(new Imagen(""));
    }

    public List<Imagen> getImagenes() {
        return imagenes;
    }

}
