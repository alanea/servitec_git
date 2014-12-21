/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.domain.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author usuario-xp
 */
@Entity
@Table(name = "tp_producto", schema = "public")
@Proxy(lazy = false)
public class Producto implements Serializable {

    @Id
    @Column(name = "id_prod")
    private String id_producto;
    @Column(name = "ddesc_prod")
    private String ddescripcion;
    @Column(name = "dmnd_prod")
    private String dmoneda;
    @Column(name = "mprec_prod")
    private float mprecio;
    @Column(name = "dtip_prod")
    private String dtipo;
    @Column(name = "dest_prod")
    private String destado;
    @Column(name = "dtesp_prod")
    private String dtesp;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_ctg", referencedColumnName = "id_ctg")
    private Categoria categoria;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "producto")
    private Set<ComprobanteDetalle> comprobanteDetalles;

    public String toString() {
        return "producto [id=" + this.id_producto + ",descripcion=" + this.ddescripcion + "]";
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getDdescripcion() {
        return ddescripcion;
    }

    public void setDdescripcion(String ddescripcion) {
        this.ddescripcion = ddescripcion;
    }

    public String getDtipo() {
        return dtipo;
    }

    public void setDtipo(String dtipo) {
        this.dtipo = dtipo;
    }

    public String getDmoneda() {
        return dmoneda;
    }

    public void setDmoneda(String dmoneda) {
        this.dmoneda = dmoneda;
    }

    public float getMprecio() {
        return mprecio;
    }

    public void setMprecio(float mprecio) {
        this.mprecio = mprecio;
    }

    public String getDestado() {
        return destado;
    }

    public void setDestado(String destado) {
        this.destado = destado;
    }

    public String getDtesp() {
        return dtesp;
    }

    public void setDtesp(String dtesp) {
        this.dtesp = dtesp;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Set<ComprobanteDetalle> getComprobanteDetalles() {
        return comprobanteDetalles;
    }

    public void setComprobanteDetalles(Set<ComprobanteDetalle> comprobanteDetalles) {
        this.comprobanteDetalles = comprobanteDetalles;
    }

}
