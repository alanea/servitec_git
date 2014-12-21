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
@Table(name = "tp_ubigeo_distrito", schema = "public")
@Proxy(lazy = false)
public class UbigeoDistrito implements Serializable {

    @Id
    @Column(name = "id_dist")
    private String dcodigo;
    @Column(name = "dnm_dist")
    private String dnombre;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_prov", referencedColumnName = "id_prov", nullable = false)
    private UbigeoProvincia provincia;

    public String toString() {
        return "Distrito [id=" + this.dcodigo + " ,nombre=" + this.dnombre+"]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UbigeoDistrito) {
            UbigeoDistrito ubi = (UbigeoDistrito) obj;
            return ubi.getDcodigo().equals(this.dcodigo);
        }
        return false;
    }

    public String getDcodigo() {
        return dcodigo;
    }

    public void setDcodigo(String dcodigo) {
        this.dcodigo = dcodigo;
    }


    public String getDnombre() {
        return dnombre;
    }

    public void setDnombre(String dnombre) {
        this.dnombre = dnombre;
    }

    public UbigeoProvincia getProvincia() {
        return provincia;
    }

    public void setProvincia(UbigeoProvincia provincia) {
        this.provincia = provincia;
    }

}
