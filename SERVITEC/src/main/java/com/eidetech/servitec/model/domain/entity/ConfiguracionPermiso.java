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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "tp_permiso_conf", schema = "public")
@Proxy(lazy = false)
public class ConfiguracionPermiso implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perm_conf")
    private int id_permiso;
    @Column(name = "dnm_perm_conf")
    private String dnombre;
    @Column(name = "nord_perm_conf")
    private int norden;  
    @Column(name = "durl_perm_conf")
    private String durl;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_submen_conf", referencedColumnName = "id_submen_conf")
    private ConfiguracionSubmenu submenu;

    public int getId_permiso() {
        return id_permiso;
    }

    public void setId_permiso(int id_permiso) {
        this.id_permiso = id_permiso;
    }

    public String getDnombre() {
        return dnombre;
    }

    public void setDnombre(String dnombre) {
        this.dnombre = dnombre;
    }

    public int getNorden() {
        return norden;
    }

    public void setNorden(int norden) {
        this.norden = norden;
    }

    public String getDurl() {
        return durl;
    }

    public void setDurl(String durl) {
        this.durl = durl;
    }

    public ConfiguracionSubmenu getSubmenu() {
        return submenu;
    }

    public void setSubmenu(ConfiguracionSubmenu submenu) {
        this.submenu = submenu;
    }
    
}
