/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.domain.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "tp_usuario_cliente", schema = "public")
@Proxy(lazy = false)
public class UsuarioCliente implements Serializable {

    @Id
    @Column(name = "id_usercli")
    private String id_usuario;
    @Column(name = "dnm_usercli")
    private String dname;
    @Column(name = "dpass_usercli")
    private String dpassword;
    @Column(name = "dtip_usercli")
    private String dtipo;
    @Column(name = "dusercrea_usercli")
    private String duserCreacion;
    @Column(name = "fusercrea_usercli")
    private Date fuserCreacion;
    @Column(name = "dusermod_usercli")
    private String duserModificacion;
    @Column(name = "fusermod_usercli")
    private Date fuserModificacion;
    @Column(name = "dest_usercli")
    private String destado;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ddni_psn")
    private Personal personal;

    public UsuarioCliente(String dname, String dpassword) {
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

}
