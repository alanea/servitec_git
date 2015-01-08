/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.domain.entity;

import com.eidetech.model.util.UtilCadena;
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
@Table(name = "tp_permiso", schema = "public")
@Proxy(lazy = false)
public class Permiso implements Serializable {

    @Id
    @Column(name = "id_perm")
    private String id_permiso;
    @Column(name = "dnm_perm")
    private String dnombre;
    @Column(name = "durl_perm")
    private String durl;
    @Column(name = "nord_perm")
    private int norden;
    @Column(name = "fcrea_perm")
    private Date fcreacion;
    @Column(name = "best_perm")
    private boolean bestado;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_submen", referencedColumnName = "id_submen")
    private Submenu submenu;

    @Override
    public boolean equals(Object obj) {
        if (obj != null) {
            if (obj instanceof Permiso) {
                Permiso p = (Permiso) obj;
                if (UtilCadena.cadenaValido(durl) && UtilCadena.cadenaValido(p.getDurl())) {
                    return durl.equals(p.getDurl());
                }
            }
        }
        return false;
    }

    public String getId_permiso() {
        return id_permiso;
    }

    public void setId_permiso(String id_permiso) {
        this.id_permiso = id_permiso;
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

    public Date getFcreacion() {
        return fcreacion;
    }

    public void setFcreacion(Date fcreacion) {
        this.fcreacion = fcreacion;
    }

    public boolean isBestado() {
        return bestado;
    }

    public void setBestado(boolean bestado) {
        this.bestado = bestado;
    }

    public Submenu getSubmenu() {
        return submenu;
    }

    public void setSubmenu(Submenu submenu) {
        this.submenu = submenu;
    }

}
