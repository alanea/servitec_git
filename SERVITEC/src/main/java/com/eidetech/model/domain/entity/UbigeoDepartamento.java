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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author laptop-w8
 */
@Entity
@Table(name = "tp_ubigeo_departamento", schema = "public")
@Proxy(lazy = false)
public class UbigeoDepartamento implements Serializable {

    @Id
    @Column(name = "id_dep")
    private String dcodigo;
    @Column(name = "dnm_dep")
    private String dnombre;
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "departamento")
    private Set<UbigeoProvincia> provincias;
    @Transient
    private List<UbigeoProvincia> listaProvincias;

    public String toString() {
        return "Departamento [id=" + this.dcodigo + " ,nombre=" + this.dnombre+"]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UbigeoDepartamento) {
            UbigeoDepartamento u1 = (UbigeoDepartamento) obj;
            return u1.getDcodigo().equals(this.dcodigo);
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

    public Set<UbigeoProvincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(Set<UbigeoProvincia> provincias) {
        this.provincias = provincias;
    }

    public List<UbigeoProvincia> getListaProvincias() {
        if(listaProvincias==null ||listaProvincias.isEmpty()){
            listaProvincias=new ArrayList();
            listaProvincias.addAll(provincias);
        }
        return listaProvincias;
    }

    public void setListaProvincias(List<UbigeoProvincia> listaProvincias) {
        this.listaProvincias = listaProvincias;
    }

}
