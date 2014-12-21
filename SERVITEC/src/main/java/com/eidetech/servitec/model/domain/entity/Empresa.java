/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.servitec.model.domain.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author usuario-xp
 */
@Entity
@Table(name = "tp_empresa", schema = "public")
@Proxy(lazy = false)
public class Empresa implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_emp")
    private int id_empresa;
    @Column(name = "druc_emp")
    private String druc;
    @Column(name = "drazsoc_emp")
    private String drazonSocial;
    @Column(name = "dnmcom_emp")
    private String dnombreComercial;
    @Column(name = "dubigeo_emp")
    private String dubigeo;
    @Column(name = "ddir_emp")
    private String ddireccion;
    @Column(name = "dfijo_emp")
    private String dfijo;
    @Column(name = "dcel_emp")
    private String dcelular;
    @Column(name = "demail_emp")
    private String demail;
    @Column(name = "dweb_emp")
    private String dweb;
    @Column(name = "ddesc_emp")
    private String ddescripcion;
    @Column(name = "dest_emp")
    private String destado;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "empresa")
    private Set<Persona> representantes;
    
    public String toString(){
        return "Empresa [ruc="+this.id_empresa+", razon social="+this.drazonSocial+", nombre comercial="+this.dnombreComercial+"]";
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    

    public String getDruc() {
        return druc;
    }

    public void setDruc(String druc) {
        this.druc = druc;
    }

    public String getDrazonSocial() {
        return drazonSocial;
    }

    public void setDrazonSocial(String drazonSocial) {
        this.drazonSocial = drazonSocial;
    }

    public String getDnombreComercial() {
        return dnombreComercial;
    }

    public void setDnombreComercial(String dnombreComercial) {
        this.dnombreComercial = dnombreComercial;
    }

    public String getDubigeo() {
        return dubigeo;
    }

    public void setDubigeo(String dubigeo) {
        this.dubigeo = dubigeo;
    }

    public String getDdireccion() {
        return ddireccion;
    }

    public void setDdireccion(String ddireccion) {
        this.ddireccion = ddireccion;
    }

    public String getDfijo() {
        return dfijo;
    }

    public void setDfijo(String dfijo) {
        this.dfijo = dfijo;
    }

    public String getDcelular() {
        return dcelular;
    }

    public void setDcelular(String dcelular) {
        this.dcelular = dcelular;
    }

    public String getDemail() {
        return demail;
    }

    public void setDemail(String demail) {
        this.demail = demail;
    }

    public String getDweb() {
        return dweb;
    }

    public void setDweb(String dweb) {
        this.dweb = dweb;
    }

    public String getDdescripcion() {
        return ddescripcion;
    }

    public void setDdescripcion(String ddescripcion) {
        this.ddescripcion = ddescripcion;
    }

    public String getDestado() {
        return destado;
    }

    public void setDestado(String destado) {
        this.destado = destado;
    }

    public Set<Persona> getRepresentantes() {
        return representantes;
    }

    public void setRepresentantes(Set<Persona> representantes) {
        this.representantes = representantes;
    }
    
}
