/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.domain.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author laptop-w8
 */
@Entity
@Table(name = "tp_submenu_conf", schema = "public")
@Proxy(lazy = false)
public class ConfiguracionSubmenu implements Serializable {

    @Id
    @Column(name = "id_submen_conf")
    private String id_submenu;
    @Column(name = "dnm_submen_conf")
    private String dnombre;
    @Column(name = "nord_submen_conf")
    private int norden;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_men_conf", referencedColumnName = "id_men_conf")
    private ConfiguracionMenu menu;
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "submenu")
    private Set<ConfiguracionPermiso> permisos;

    public String getId_submenu() {
        return id_submenu;
    }

    public void setId_submenu(String id_submenu) {
        this.id_submenu = id_submenu;
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

    public ConfiguracionMenu getMenu() {
        return menu;
    }

    public void setMenu(ConfiguracionMenu menu) {
        this.menu = menu;
    }

    public Set<ConfiguracionPermiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(Set<ConfiguracionPermiso> permisos) {
        this.permisos = permisos;
    }

}
