/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.domain.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author laptop-w8
 */
@Entity
@Table(name = "tp_usuario_personal", schema = "public")
@Proxy(lazy = false)
public class UsuarioPersonal implements Serializable {

    @Id
    @Column(name = "id_user")
    private String id_usuario;
    @Column(name = "dnm_user")
    private String dname;
    @Column(name = "dpass_user")
    private String dpassword;    
    @Column(name = "dtip_user")
    private String dtipo;
    @Column(name = "dusercrea_user")
    private String duserCreacion;
    @Column(name = "fusercrea_user")
    private Date fuserCreacion;
    @Column(name = "dusermod_user")
    private String duserModificacion;
    @Column(name = "fusermod_user")
    private Date fuserModificacion;
    @Column(name = "darea_user")
    private String darea;
    @Column(name = "dest_user")
    private String destado;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_per")
    private Personal personal;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_sede")
    private Sede sede;    
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_men")
    private Menu menu;

    public UsuarioPersonal() {
    }

    public UsuarioPersonal(String dname, String dpassword) {
        this.dname = dname;
        this.dpassword = dpassword;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDpassword() {
        return dpassword;
    }

    public void setDpassword(String dpassword) {
        this.dpassword = dpassword;
    }

    public String getDtipo() {
        return dtipo;
    }

    public void setDtipo(String dtipo) {
        this.dtipo = dtipo;
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

    public String getDarea() {
        return darea;
    }

    public void setDarea(String darea) {
        this.darea = darea;
    }

    public String getDestado() {
        return destado;
    }

    public void setDestado(String destado) {
        this.destado = destado;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
