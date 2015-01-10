/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
import javax.persistence.Transient;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author laptop-w8
 */
@Entity
@Table(name = "tp_ubigeo_provincia", schema = "public")
@Proxy(lazy = false)
public class UbigeoProvincia implements Serializable {

    @Id
    @Column(name = "id_prov")
    private String dcodigo;
    @Column(name = "dnm_prov")
    private String dnombre;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dep", referencedColumnName = "id_dep")
    private UbigeoDepartamento departamento;
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "provincia")
    private Set<UbigeoDistrito> distritos;
    @Transient
    private List<UbigeoDistrito> listaDistritos;

    public String toString() {
        return "Provincia [id=" + this.dcodigo + " ,nombre=" + this.dnombre + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UbigeoProvincia) {
            UbigeoProvincia up = (UbigeoProvincia) obj;
            return up.getDcodigo().equals(this.dcodigo);
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

    public UbigeoDepartamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(UbigeoDepartamento departamento) {
        this.departamento = departamento;
    }

    public Set<UbigeoDistrito> getDistritos() {
        return distritos;
    }

    public void setDistritos(Set<UbigeoDistrito> distritos) {
        this.distritos = distritos;
    }

    public List<UbigeoDistrito> getListaDistritos() {
        if (listaDistritos == null || listaDistritos.isEmpty()) {
            listaDistritos = new ArrayList();
            listaDistritos.addAll(distritos);
        }
        return listaDistritos;
    }

    public void setListaDistritos(List<UbigeoDistrito> listaDistritos) {
        this.listaDistritos = listaDistritos;
    }

}
