/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.domain.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author laptop-w8
 */
@Entity
@Table(name = "tp_nota_credito", schema = "public")
@Proxy(lazy = false)
public class NotaCredito implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notcred")
    private long id_nota_credito;
    @Column(name = "dserie_notcred")
    private String id_serie;
    @Column(name = "dtipserie_notcred")
    private String dtipo;
    @Column(name = "nnroserie_notcred")
    private int nnumero;
    @Column(name = "femi_notcred")
    private Date femision;
    @Column(name = "dusercrea_notcred")
    private String duserCreacion;
    @Column(name = "fusercrea_notcred")
    private Date fuserCreacion;
    @Column(name = "dusermod_notcred")
    private String duserModificacion;
    @Column(name = "fusermod_notcred")
    private Date fuserModificacion;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_compr")
    private Comprobante comprobante;

    public long getId_nota_credito() {
        return id_nota_credito;
    }

    public void setId_nota_credito(long id_nota_credito) {
        this.id_nota_credito = id_nota_credito;
    }

    public String getId_serie() {
        return id_serie;
    }

    public void setId_serie(String id_serie) {
        this.id_serie = id_serie;
    }

    public String getDtipo() {
        return dtipo;
    }

    public void setDtipo(String dtipo) {
        this.dtipo = dtipo;
    }

    public int getNnumero() {
        return nnumero;
    }

    public void setNnumero(int nnumero) {
        this.nnumero = nnumero;
    }

    public Date getFemision() {
        return femision;
    }

    public void setFemision(Date femision) {
        this.femision = femision;
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

    public Comprobante getComprobante() {
        return comprobante;
    }

    public void setComprobante(Comprobante comprobante) {
        this.comprobante = comprobante;
    }

}
