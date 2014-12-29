/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author usuario-xp
 */
@Entity
@Table(name = "tp_categoria", schema = "public")
@Proxy(lazy = false)
public class Categoria implements Serializable {

    @Id
    @Column(name = "id_ctg")
    private String id_categoria;
    @Column(name = "dgrup_ctg")
    private String dgrupo;
    @Column(name = "dnm_ctg")
    private String dnombre;
    @Column(name = "ddesc_ctg")
    private String ddescripcion;
    @Column(name = "dest_ctg")
    private String destado;
    @Column(name = "dusercrea_ctg")
    private String duserCreacion;
    @Column(name = "fusercrea_ctg")
    private Date fuserCreacion;
    @Column(name = "dusermod_ctg")
    private String duserModificacion;
    @Column(name = "fusermod_ctg")
    private Date fuserModificacion;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ctg")
    private Set<Producto> productos;
    @Transient
    private List<Producto> listaProductos;

    public String toString() {
        return "Categoria [id=" + this.id_categoria + ",nombre=" + this.dnombre + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null) {
            if (obj instanceof Categoria) {
                Categoria c1=(Categoria)obj;
                if(this.getDnombre().toUpperCase().equals(c1.getDnombre().toUpperCase())){
                    return true;
                }
            }
        }
        return false;
    }

    public String getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(String id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getDnombre() {
        return dnombre;
    }

    public void setDnombre(String dnombre) {
        this.dnombre = dnombre;
    }

    public String getDgrupo() {
        return dgrupo;
    }

    public void setDgrupo(String dgrupo) {
        this.dgrupo = dgrupo;
    }

    public String getDestado() {
        return destado;
    }

    public void setDestado(String destado) {
        this.destado = destado;
    }

    public String getDdescripcion() {
        return ddescripcion;
    }

    public void setDdescripcion(String ddescripcion) {
        this.ddescripcion = ddescripcion;
    }

    public String getDuserCreacion() {
        return duserCreacion;
    }

    public void setDuserCreacion(String duserCreacion) {
        this.duserCreacion = duserCreacion;
    }

    public Date getFuserCreacion() {
        return fuserCreacion;
    }

    public void setFuserCreacion(Date fuserCreacion) {
        this.fuserCreacion = fuserCreacion;
    }

    public String getDuserModificacion() {
        return duserModificacion;
    }

    public void setDuserModificacion(String duserModificacion) {
        this.duserModificacion = duserModificacion;
    }

    public Date getFuserModificacion() {
        return fuserModificacion;
    }

    public void setFuserModificacion(Date fuserModificacion) {
        this.fuserModificacion = fuserModificacion;
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }

    public List<Producto> getListaProductos() {
        if (listaProductos == null || listaProductos.isEmpty()) {
            listaProductos = new ArrayList();
            listaProductos.addAll(productos);
        }
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

}
