/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.domain.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author usuario-xp
 */
@Entity
@Table(name = "tp_sede", schema = "public")
@Proxy(lazy = false)
public class Sede implements Serializable {

    @Id
    @Column(name = "id_sede")
    private String id_sede;
    @Column(name = "dnm_sede")
    private String dnombre;
    @Column(name = "ddir_sede")
    private String ddireccion;
    @Column(name = "dubigeo_sede")
    private String dubigeo;
    @Column(name = "dtfno_sede")
    private String dfijo;
    @Column(name = "dcel_sede")
    private String dcelular;
    @Column(name = "fini_sede")
    private Date finicio;
    @Column(name = "fcese_sede")
    private Date fcese;
    @Column(name = "dweb_sede")
    private String dweb;
    @Column(name = "demail_sede")
    private String demail;    
    @Column(name = "dfb_sede")
    private String dfacebook;
    @Column(name = "dtt_sede")
    private String dtwitter;
    @Column(name = "dest_sede")
    private String destado;
    @Column(name = "dusercrea_sede")
    private String duserCreacion;
    @Column(name = "fusercrea_sede")
    private Date fuserCreacion;
    @Column(name = "dusermod_sede")
    private String duserModificacion;
    @Column(name = "fusermod_sede")
    private Date fuserModificacion;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sede")
    private Set<Serie> series;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sede")
    private Set<UsuarioPersonal> usuarios;

    public String toString() {
        return "Sede [id=" + this.id_sede + ",nombre=" + this.dnombre + "]";
    }

    public String getId_sede() {
        return id_sede;
    }

    public void setId_sede(String id_sede) {
        this.id_sede = id_sede;
    }

    
    public String getDnombre() {
        return dnombre;
    }

    public void setDnombre(String dnombre) {
        this.dnombre = dnombre;
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

    public String getDfijo() {
        return dfijo;
    }

    public void setDfijo(String dfijo) {
        this.dfijo = dfijo;
    }

    public String getDcelular() {
        return dcelular;
    }

    public void setDcelular(String dcelular) {
        this.dcelular = dcelular;
    }

    public String getDweb() {
        return dweb;
    }

    public void setDweb(String dweb) {
        this.dweb = dweb;
    }

    public String getDestado() {
        return destado;
    }

    public void setDestado(String destado) {
        this.destado = destado;
    }

    public Set<Serie> getSeries() {
        return series;
    }

    public void setSeries(Set<Serie> series) {
        this.series = series;
    }

    public Set<UsuarioPersonal> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<UsuarioPersonal> usuarios) {
        this.usuarios = usuarios;
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

    public Date getFinicio() {
        return finicio;
    }

    public void setFinicio(Date finicio) {
        this.finicio = finicio;
    }

    public Date getFcese() {
        return fcese;
    }

    public void setFcese(Date fcese) {
        this.fcese = fcese;
    }

    public String getDemail() {
        return demail;
    }

    public void setDemail(String demail) {
        this.demail = demail;
    }

    public String getDfacebook() {
        return dfacebook;
    }

    public void setDfacebook(String dfacebook) {
        this.dfacebook = dfacebook;
    }

    public String getDtwitter() {
        return dtwitter;
    }

    public void setDtwitter(String dtwitter) {
        this.dtwitter = dtwitter;
    }

}
