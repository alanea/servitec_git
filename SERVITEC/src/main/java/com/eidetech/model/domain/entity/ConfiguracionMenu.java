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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author laptop-w8
 */
@Entity
@Table(name = "tp_menu_conf", schema = "public")
@Proxy(lazy = false)
public class ConfiguracionMenu implements Serializable {

    @Id
    @Column(name = "id_men_conf")
    private String id_menu;
    @Column(name = "dnm_men_conf")
    private String dnombre;
    @Column(name = "nord_men_conf")
    private int norden;
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "menu")
    private Set<ConfiguracionSubmenu> submenus;

    public String getId_menu() {
        return id_menu;
    }

    public void setId_menu(String id_menu) {
        this.id_menu = id_menu;
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

    public Set<ConfiguracionSubmenu> getSubmenus() {
        return submenus;
    }

    public void setSubmenus(Set<ConfiguracionSubmenu> submenus) {
        this.submenus = submenus;
    }

}
