/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.servitec.model.domain.entity;

import java.io.Serializable;
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
@Table(name = "tp_permiso_cliente", schema = "public")
@Proxy(lazy = false)
public class PermisoCliente implements Serializable{
    @Id
    @Column(name = "id_perm_cli")
    private String id_permiso_cli;
    @Column(name = "dnm_perm_cli")
    private String dnombre;
    @Column(name = "durl_perm_cli")
    private String durl;
    @Column(name = "nord_perm_cli")
    private int norden;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usercli", referencedColumnName = "id_usercli")
    private UsuarioCliente cliente;

    public String getId_permiso_cli() {
        return id_permiso_cli;
    }

    public void setId_permiso_cli(String id_permiso_cli) {
        this.id_permiso_cli = id_permiso_cli;
    }

    public String getDnombre() {
        return dnombre;
    }

    public void setDnombre(String dnombre) {
        this.dnombre = dnombre;
    }

    public String getDurl() {
        return durl;
    }

    public void setDurl(String durl) {
        this.durl = durl;
    }

    public int getNorden() {
        return norden;
    }

    public void setNorden(int norden) {
        this.norden = norden;
    }

    public UsuarioCliente getCliente() {
        return cliente;
    }

    public void setCliente(UsuarioCliente cliente) {
        this.cliente = cliente;
    }
    
    
}
