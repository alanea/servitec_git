/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.domain.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
@IdClass(SeriePK.class)
@Table(name = "tp_serie", schema = "public")
@Proxy(lazy = false)
public class Serie implements Serializable {

    @Id
    @Column(name = "id_serie")
    private String id_serie;
    @Id
    @Column(name = "dtip_serie")
    private String dtipo;
    @Column(name = "dest_serie")
    private String destado;
    @Column(name = "dusercrea_serie")
    private String duserCreacion;
    @Column(name = "fusercrea_serie")
    private Date fuserCreacion;
    @Column(name = "dusermod_serie")
    private String duserModificacion;
    @Column(name = "fusermod_serie")
    private Date fuserModificacion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sede")
    private Sede sede;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "serie")
    private Set<Talon> talones;
    
    public String toString() {
        return "Serie [numero=" + this.id_serie + ",tipo=" + this.dtipo + "]";
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

    public String getDestado() {
        return destado;
    }

    public void setDestado(String destado) {
        this.destado = destado;
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

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public Set<Talon> getTalones() {
        return talones;
    }

    public void setTalones(Set<Talon> talones) {
        this.talones = talones;
    }

}
