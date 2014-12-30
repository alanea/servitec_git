/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.controller;

import com.eidetech.servitec.model.domain.Imagen;
import com.eidetech.servitec.service.ISeguridadService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author laptop-w8
 */
@ManagedBean(name="indexBean")
@ApplicationScoped
public class IndexBean implements Serializable {

    private List<Imagen> noticias;
    private List<Imagen> productos;
    private List<Imagen> servicios;
    
    @ManagedProperty(value = "#{seguridadService}")
    ISeguridadService seguridadService;

    /**
     * Creates a new instance of ImagenesBean
     */
    public IndexBean() {
    }

    @PostConstruct
    public void init() {
        Imagen n1=new Imagen();
        n1.setDurl("index.xhtml");
        n1.setDnombre("tienda.jpg");
        n1.setDtitulo("Eidetech S.A.C.");
        n1.setDdescripcion("Infraestructura de computo hardware y software <br/>"
                + "Tienda 1046 - Compupalace");
        
        noticias=new ArrayList();
        noticias.add(n1);
        
        Imagen p1=new Imagen();
        p1.setDurl("productos.xhtml");
        p1.setDnombre("sonido.png");
        p1.setDtitulo("Sonido y música");
        p1.setDdescripcion("Productos y accesorios");
        Imagen p2=new Imagen();
        p2.setDurl("productos.xhtml");
        p2.setDnombre("laptop.png");
        p2.setDtitulo("PC y laptop");
        p2.setDdescripcion("Accesorios de laptos y computadoras");
        Imagen p3=new Imagen();
        p3.setDurl("productos.xhtml");
        p3.setDnombre("celular.png");
        p3.setDtitulo("Smartphone");
        p3.setDdescripcion("Celular inteligentes");
        Imagen p4=new Imagen();
        p4.setDurl("productos.xhtml");
        p4.setDnombre("wifi.png");
        p4.setDtitulo("WiFi y Bluetooth");
        p4.setDdescripcion("Wifi");
        
        productos=new ArrayList();
        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        productos.add(p4);
        
        Imagen s1=new Imagen();
        s1.setDurl("servicios.xhtml");
        s1.setDnombre("servicio.png");
        s1.setDtitulo("Reparacion domiciliaria");
        s1.setDdescripcion("Orden de servicio tecnico a peticion del cliente");
        Imagen s2=new Imagen();
        s2.setDurl("servicios.xhtml");
        s2.setDnombre("servicio.png");
        s2.setDtitulo("Diagnostico preventivo");
        s2.setDdescripcion("Ofrecemos la revision preventiva de los equipos");
        Imagen s3=new Imagen();
        s3.setDurl("servicios.xhtml");
        s3.setDnombre("servicio.png");
        s3.setDtitulo("Reparacion");
        s3.setDdescripcion("Reparacion de distintos equipos en la tienda principal");
        
        servicios=new ArrayList();
        servicios.add(s1);
        servicios.add(s2);
        servicios.add(s3);
        
        seguridadService.inicializarConfiguracion();
    }

    public List<Imagen> getNoticias() {
        return noticias;
    }

    public List<Imagen> getProductos() {
        return productos;
    }

    public List<Imagen> getServicios() {
        return servicios;
    }

    public ISeguridadService getSeguridadService() {
        return seguridadService;
    }

    public void setSeguridadService(ISeguridadService seguridadService) {
        this.seguridadService = seguridadService;
    }

}
