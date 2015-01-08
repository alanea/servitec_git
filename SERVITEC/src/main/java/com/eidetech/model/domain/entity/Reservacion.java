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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author laptop-w8
 */
@Entity
@Table(name = "tp_reservacion", schema = "public")
@Proxy(lazy = false)
public class Reservacion implements Serializable{
    
    @Id
    @Column(name = "id_resrv")
    private String id_reservacion;
    @Column(name = "ffecha_resrv")
    private Date ffecha;
    @Column(name = "dstm_resrv")
    private String dsintoma;
    @Column(name = "dstmdet_resrv")
    private String dsintoma_detallado;
    @Column(name = "dprobl_resrv")
    private String dproblema;
    @Column(name = "dctg_resrv")
    private String dcategoria_producto;
    @Column(name = "dprod_resrv")
    private String dproducto;
    @Column(name = "dmc_resrv")
    private String dmarca;
    @Column(name = "dmdl_resrv")
    private String dmodelo;    
    @Column(name = "dcel_resrv")
    private String dcelular;    
    @Column(name = "dubigeo_resrv")
    private String dubigeo;
    @Column(name = "ddir_resrv")
    private String ddireccion;
    @Column(name = "fcrea_resrv")
    private Date fcreacion;    
    @Column(name = "fmod_resrv")
    private Date fmodificacion;
    @Column(name = "dest_resrv")
    private String destadoReservacion;
    @Column(name = "destsvc_resrv")
    private String destadoServicio;
    @Column(name = "dtiplg_resrv")
    private String dtipoDireccion;
    @Column(name = "duserrev_resrv")
    private String duserRevisor;
    @Column(name = "fuserrev_resrv")
    private Date frevision;    
    @Column(name = "duserrep_resrv")
    private String duserReparador;
    @Column(name = "fuserrep_resrv")
    private Date freparacion;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cli", referencedColumnName = "id_cli")
    private Cliente cliente;

    public String getId_reservacion() {
        return id_reservacion;
    }

    public void setId_reservacion(String id_reservacion) {
        this.id_reservacion = id_reservacion;
    }

    public Date getFfecha() {
        return ffecha;
    }

    public void setFfecha(Date ffecha) {
        this.ffecha = ffecha;
    }

    public String getDsintoma() {
        return dsintoma;
    }

    public void setDsintoma(String dsintoma) {
        this.dsintoma = dsintoma;
    }

    public String getDsintoma_detallado() {
        return dsintoma_detallado;
    }

    public void setDsintoma_detallado(String dsintoma_detallado) {
        this.dsintoma_detallado = dsintoma_detallado;
    }

    public String getDproblema() {
        return dproblema;
    }

    public void setDproblema(String dproblema) {
        this.dproblema = dproblema;
    }

    public String getDcategoria_producto() {
        return dcategoria_producto;
    }

    public void setDcategoria_producto(String dcategoria_producto) {
        this.dcategoria_producto = dcategoria_producto;
    }

    public String getDproducto() {
        return dproducto;
    }

    public void setDproducto(String dproducto) {
        this.dproducto = dproducto;
    }

    public String getDmarca() {
        return dmarca;
    }

    public void setDmarca(String dmarca) {
        this.dmarca = dmarca;
    }

    public String getDmodelo() {
        return dmodelo;
    }

    public void setDmodelo(String dmodelo) {
        this.dmodelo = dmodelo;
    }

    public String getDcelular() {
        return dcelular;
    }

    public void setDcelular(String dcelular) {
        this.dcelular = dcelular;
    }

    public String getDubigeo() {
        return dubigeo;
    }

    public void setDubigeo(String dubigeo) {
        this.dubigeo = dubigeo;
    }

    public String getDdireccion() {
        return ddireccion;
    }

    public void setDdireccion(String ddireccion) {
        this.ddireccion = ddireccion;
    }

    public Date getFcreacion() {
        return fcreacion;
    }

    public void setFcreacion(Date fcreacion) {
        this.fcreacion = fcreacion;
    }

    public Date getFmodificacion() {
        return fmodificacion;
    }

    public void setFmodificacion(Date fmodificacion) {
        this.fmodificacion = fmodificacion;
    }

    public String getDestadoReservacion() {
        return destadoReservacion;
    }

    public void setDestadoReservacion(String destadoReservacion) {
        this.destadoReservacion = destadoReservacion;
    }

    public String getDestadoServicio() {
        return destadoServicio;
    }

    public void setDestadoServicio(String destadoServicio) {
        this.destadoServicio = destadoServicio;
    }

    public String getDtipoDireccion() {
        return dtipoDireccion;
    }

    public void setDtipoDireccion(String dtipoDireccion) {
        this.dtipoDireccion = dtipoDireccion;
    }

    public String getDuserRevisor() {
        return duserRevisor;
    }

    public void setDuserRevisor(String duserRevisor) {
        this.duserRevisor = duserRevisor;
    }

    public Date getFrevision() {
        return frevision;
    }

    public void setFrevision(Date frevision) {
        this.frevision = frevision;
    }

    public String getDuserReparador() {
        return duserReparador;
    }

    public void setDuserReparador(String duserReparador) {
        this.duserReparador = duserReparador;
    }

    public Date getFreparacion() {
        return freparacion;
    }

    public void setFreparacion(Date freparacion) {
        this.freparacion = freparacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
