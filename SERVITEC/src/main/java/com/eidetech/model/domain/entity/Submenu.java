/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.domain.entity;

import com.eidetech.model.util.UtilCadena;
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
@Table(name = "tp_submenu", schema = "public")
@Proxy(lazy = false)
public class Submenu implements Serializable {

    @Id
    @Column(name = "id_submen")
    private String id_submenu;
    @Column(name = "dnm_submen")
    private String dnombre;
    @Column(name = "nord_submen")
    private int norden;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_men", referencedColumnName = "id_men")
    private Menu menu;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "submenu")
    private Set<Permiso> permisos;

    @Override
    public boolean equals(Object obj) {
        System.out.println("entroa l e uqals");
        if (obj != null) {
            if (obj instanceof Submenu) {
                Submenu s = (Submenu) obj;
                if (UtilCadena.cadenaValido(dnombre) && UtilCadena.cadenaValido(s.getDnombre())) {
                    System.out.println("es igual");
                    return dnombre.equals(s.getDnombre());
                }else{
                    System.out.println("no es igual="+s.getDnombre());
                }
            }
        }
        return false;
    }

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

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Set<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(Set<Permiso> permisos) {
        this.permisos = permisos;
    }

}
