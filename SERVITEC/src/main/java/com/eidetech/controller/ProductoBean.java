/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.controller;

import com.eidetech.model.domain.entity.Categoria;
import com.eidetech.model.domain.entity.Producto;
import com.eidetech.model.util.UtilCadena;
import com.eidetech.service.IPortalService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;

/**
 *
 * @author laptop-w8
 */
@ManagedBean(name = "productoBean")
@ApplicationScoped
public class ProductoBean implements Serializable {

    List<Categoria> categorias;
    List<Producto> productos;
    List<SelectItem> siCategoria;

    @ManagedProperty(value = "#{portalService}")
    IPortalService portalService;

    @PostConstruct
    public void init() {
        inicializarValores();
    }

    public void actualizarValores() {
        inicializarValores();
    }

    private void inicializarValores() {
        productos = new ArrayList();
        categorias = portalService.obtenerCategorias();
        if (categorias != null) {
            for (Categoria c : categorias) {
                for (Producto p : c.getProductos()) {
                    productos.add(p);
                }
            }
        } else {
            categorias = new ArrayList();
        }
        siCategoria = listaItem(categorias);
    }

    public List<SelectItem> siProducto(String id_categoria) {
        List<SelectItem> si = new ArrayList();
        for (Categoria c : categorias) {
            if (c.getId_categoria().equals(id_categoria)) {
                if (c.getProductos() != null) {
                    for (Producto p : c.getProductos()) {
                        si.add(new SelectItem(p.getId_producto(), p.getDdescripcion()));
                    }
                }
            }
        }
        return si;
    }

    private List<SelectItem> listaItem(List<Categoria> lista) {
        List<SelectItem> si = new ArrayList();
        if (lista != null && !lista.isEmpty()) {
            for (Categoria c : lista) {
                si.add(new SelectItem(c.getId_categoria(), c.getDnombre()));
            }
        }
        return si;
    }

    public String descripcionProducto(String codigo) {
        if (UtilCadena.cadenaValido(codigo)) {
            for (Producto p : productos) {
                if (p.getId_producto().equals(codigo)) {
                    return p.getDdescripcion();
                }
            }
        }
        return codigo;
    }

    public String descripcionCategoria(String codigo) {
        if (UtilCadena.cadenaValido(codigo)) {
            for (Categoria c : categorias) {
                if (c.getId_categoria().equals(codigo)) {
                    return c.getDnombre();
                }
            }
        }
        return codigo;
    }

    public IPortalService getPortalService() {
        return portalService;
    }

    public void setPortalService(IPortalService portalService) {
        this.portalService = portalService;
    }

    public List<SelectItem> getSiCategoria() {
        return siCategoria;
    }

}
