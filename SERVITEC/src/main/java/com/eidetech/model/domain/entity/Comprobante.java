/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.domain.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "tp_compr", schema = "public")
@Proxy(lazy = false)
public class Comprobante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compr")
    private int id_comprobante;
    @Column(name = "dtipserie_compr")
    private String dtipo;
    @Column(name = "dserie_compr")
    private String dserie;
    @Column(name = "nnroserie_compr")
    private int nnumeroSerie;
    @Column(name = "femi_compr")
    private Date femision;
    @Column(name = "dfmpg_compr")
    private String dformaPago;
    @Column(name = "dmnd_compr")
    private String dmoneda;
    @Column(name = "mtipcb_compr")
    private float mtipoCambio;
    @Column(name = "pigv_compr")
    private float pigv;
    @Column(name = "pdscto_compr")
    private float pdescuento;
    @Column(name = "banld_compr")
    private boolean banulado;
    @Column(name = "dusercrea_compr")
    private String duserCreacion;
    @Column(name = "fusercrea_compr")
    private Date fuserCreacion;
    @Column(name = "dusermod_compr")
    private String duserModificacion;
    @Column(name = "fusermod_compr")
    private Date fuserModificacion;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cli", referencedColumnName = "id_cli")
    private Cliente cliente;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comprobante")
    private Set<ComprobanteDetalle> comprobanteDetalles;

    public int getId_comprobante() {
        return id_comprobante;
    }

    public void setId_comprobante(int id_comprobante) {
        this.id_comprobante = id_comprobante;
    }

    public String getDtipo() {
        return dtipo;
    }

    public void setDtipo(String dtipo) {
        this.dtipo = dtipo;
    }

    public String getDserie() {
        return dserie;
    }

    public void setDserie(String dserie) {
        this.dserie = dserie;
    }

    public int getNnumeroSerie() {
        return nnumeroSerie;
    }

    public void setNnumeroSerie(int nnumeroSerie) {
        this.nnumeroSerie = nnumeroSerie;
    }

    public Date getFemision() {
        return femision;
    }

    public void setFemision(Date femision) {
        this.femision = femision;
    }

    public String getDformaPago() {
        return dformaPago;
    }

    public void setDformaPago(String dformaPago) {
        this.dformaPago = dformaPago;
    }

    public String getDmoneda() {
        return dmoneda;
    }

    public void setDmoneda(String dmoneda) {
        this.dmoneda = dmoneda;
    }

    public float getMtipoCambio() {
        return mtipoCambio;
    }

    public void setMtipoCambio(float mtipoCambio) {
        this.mtipoCambio = mtipoCambio;
    }

    public float getPigv() {
        return pigv;
    }

    public void setPigv(float pigv) {
        this.pigv = pigv;
    }

    public float getPdescuento() {
        return pdescuento;
    }

    public void setPdescuento(float pdescuento) {
        this.pdescuento = pdescuento;
    }

    public boolean isBanulado() {
        return banulado;
    }

    public void setBanulado(boolean banulado) {
        this.banulado = banulado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<ComprobanteDetalle> getComprobanteDetalles() {
        return comprobanteDetalles;
    }

    public void setComprobanteDetalles(Set<ComprobanteDetalle> comprobanteDetalles) {
        this.comprobanteDetalles = comprobanteDetalles;
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

}
