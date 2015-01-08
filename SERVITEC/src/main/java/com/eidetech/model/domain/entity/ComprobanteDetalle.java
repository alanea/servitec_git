/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.domain.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author usuario-xp
 */
@Entity
@Table(name = "tp_comprobante_detalle", schema = "public")
@Proxy(lazy = false)
public class ComprobanteDetalle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comprdet")
    private int id_comprobante_detalle;
    @Column(name = "mmonto_comprdet")
    private float mmonto;
    @Column(name = "ncnt_comprdet")
    private int ncantidad;
    @Column(name = "mpgd_comprdet")
    private float mpagado;
    @Column(name = "pdscto_comprdet")
    private float pdescuento;
    @Column(name = "mrstd_comprdet")
    private float mresultado;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_compr", referencedColumnName = "id_compr")
    private Comprobante comprobante;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_prod", referencedColumnName = "id_prod")
    private Producto producto;

    public void actualizarEstado(float igv) {
        mmonto = ncantidad * producto.getMprecio();
        mresultado = mmonto  - pdescuento;
        mresultado =mresultado+ mresultado * igv;
    }

    public int getId_comprobante_detalle() {
        return id_comprobante_detalle;
    }

    public void setId_comprobante_detalle(int id_comprobante_detalle) {
        this.id_comprobante_detalle = id_comprobante_detalle;
    }

    public float getMmonto() {
        return mmonto;
    }

    public void setMmonto(float mmonto) {
        this.mmonto = mmonto;
    }

    public int getNcantidad() {
        return ncantidad;
    }

    public void setNcantidad(int ncantidad) {
        this.ncantidad = ncantidad;
    }

    public float getMpagado() {
        return mpagado;
    }

    public void setMpagado(float mpagado) {
        this.mpagado = mpagado;
    }

    public float getPdescuento() {
        return pdescuento;
    }

    public void setPdescuento(float pdescuento) {
        this.pdescuento = pdescuento;
    }

    public float getMresultado() {
        return mresultado;
    }

    public void setMresultado(float mresultado) {
        this.mresultado = mresultado;
    }

    public Comprobante getComprobante() {
        return comprobante;
    }

    public void setComprobante(Comprobante comprobante) {
        this.comprobante = comprobante;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

}
