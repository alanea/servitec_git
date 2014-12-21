/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.servitec.model.domain.entity;

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
@Table(name = "tp_persona", schema = "public")
@Proxy(lazy = false)
public class Persona implements Serializable{
    @Id
    @Column(name = "ddni_psn")
    private String id_personal;
    @Column(name = "druc_psn")
    private String druc;
    @Column(name = "dnm_psn")
    private String dnombres;
    @Column(name = "dappat_psn")
    private String dapellidoPaterno;
    @Column(name = "dapmat_psn")
    private String dapellidoMaterno;
    @Column(name = "dsexo_psn")
    private String dsexo;
    @Column(name = "fnac_psn")
    private Date fnacimiento;
    @Column(name = "dubigeo_psn")
    private String dubigeo;
    @Column(name = "ddir_psn")
    private String ddireccion;
    @Column(name = "demail_psn")
    private String demail;
    @Column(name = "dfijo_psn")
    private String dfijo;
    @Column(name = "dcel_psn")
    private String dcelular;
    @Column(name = "dest_psn")
    private String destado;
    @Column(name = "dusercrea_psn")
    private String duserCreacion;
    @Column(name = "fusercrea_psn")
    private Date fuserCreacion;
    @Column(name = "dusermod_psn")
    private String duserModificacion;
    @Column(name = "fusermod_psn")
    private Date fuserModificacion;   
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_emp", referencedColumnName = "id_emp")
    private Empresa empresa;

    public String getId_personal() {
        return id_personal;
    }

    public void setId_personal(String id_personal) {
        this.id_personal = id_personal;
    }

    public String getDnombres() {
        return dnombres;
    }

    public void setDnombres(String dnombres) {
        this.dnombres = dnombres;
    }

    public String getDapellidoPaterno() {
        return dapellidoPaterno;
    }

    public void setDapellidoPaterno(String dapellidoPaterno) {
        this.dapellidoPaterno = dapellidoPaterno;
    }

    public String getDapellidoMaterno() {
        return dapellidoMaterno;
    }

    public void setDapellidoMaterno(String dapellidoMaterno) {
        this.dapellidoMaterno = dapellidoMaterno;
    }

    public String getDruc() {
        return druc;
    }

    public void setDruc(String druc) {
        this.druc = druc;
    }

    public String getDsexo() {
        return dsexo;
    }

    public void setDsexo(String dsexo) {
        this.dsexo = dsexo;
    }

    public Date getFnacimiento() {
        return fnacimiento;
    }

    public void setFnacimiento(Date fnacimiento) {
        this.fnacimiento = fnacimiento;
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

    public String getDemail() {
        return demail;
    }

    public void setDemail(String demail) {
        this.demail = demail;
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

    public String getDestado() {
        return destado;
    }

    public void setDestado(String destado) {
        this.destado = destado;
    }

    public String getDuserCreacion() {
        return duserCreacion;
    }

    public void setDuserCreacion(String duserCreacion) {
        this.duserCreacion = duserCreacion;
    }

    public Date getFuserCreacion() {
        return fuserCreacion;
    }

    public void setFuserCreacion(Date fuserCreacion) {
        this.fuserCreacion = fuserCreacion;
    }

    public String getDuserModificacion() {
        return duserModificacion;
    }

    public void setDuserModificacion(String duserModificacion) {
        this.duserModificacion = duserModificacion;
    }

    public Date getFuserModificacion() {
        return fuserModificacion;
    }

    public void setFuserModificacion(Date fuserModificacion) {
        this.fuserModificacion = fuserModificacion;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
}
