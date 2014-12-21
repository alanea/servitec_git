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
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author usuario-xp
 */
@Entity
@Table(name = "tp_personal", schema = "public")
@Proxy(lazy = false)
public class Personal implements Serializable {

    @Id
    @Column(name = "id_per")
    private String id_personal;
    @Column(name = "dnm_per")
    private String dnombres;
    @Column(name = "dappat_per")
    private String dapellidoPaterno;
    @Column(name = "dapmat_per")
    private String dapellidoMaterno;
    @Column(name = "ddni_per")
    private String ddni;
    @Column(name = "druc_per")
    private String druc;
    @Column(name = "dsexo_per")
    private String dsexo;
    @Column(name = "fnac_per")
    private Date fnacimiento;
    @Column(name = "dtipclg_per")
    private String dtipoColegio;
    @Column(name = "dnumclg_per")
    private String dnumColegio;
    @Column(name = "drne_per")
    private String drne;
    @Column(name = "ddir_per")
    private String ddireccion;
    @Column(name = "dubigeo_per")
    private String dubigeo;
    @Column(name = "demail_per")
    private String demail;
    @Column(name = "dfijo_per")
    private String dfijo;
    @Column(name = "dcel_per")
    private String dcelular;
    @Column(name = "dmodcont_per")
    private String dmodalidadContratacion;
    @Column(name = "dec_per")
    private String destadoCivil;
    @Column(name = "dginst_per")
    private String dgradoInstruccion;
    @Column(name = "dprof_per")
    private String dprofesion;
    @Column(name = "darea_per")
    private String darea;
    @Column(name = "dcargo_per")
    private String dcargo;
    @Column(name = "fing_per")
    private Date fingreso;
    @Column(name = "fces_per")
    private Date fcese;
    @Column(name = "dobs_per")
    private String dobservacion;
    @Column(name = "dest_per")
    private String destado;
    @Column(name = "dusercrea_per")
    private String duserCreacion;
    @Column(name = "fusercrea_per")
    private Date fuserCreacion;
    @Column(name = "dusermod_per")
    private String duserModificacion;
    @Column(name = "fusermod_per")
    private Date fuserModificacion;    

    public String toString() {
        return "Personal [id = " + id_personal + ", nombres= " + dnombres + " " + dapellidoPaterno + " " + dapellidoMaterno + "]";
    }

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

    public String getDdni() {
        return ddni;
    }

    public void setDdni(String ddni) {
        this.ddni = ddni;
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

    public String getDrne() {
        return drne;
    }

    public void setDrne(String drne) {
        this.drne = drne;
    }

    public String getDdireccion() {
        return ddireccion;
    }

    public void setDdireccion(String ddireccion) {
        this.ddireccion = ddireccion;
    }

    public String getDubigeo() {
        return dubigeo;
    }

    public void setDubigeo(String dubigeo) {
        this.dubigeo = dubigeo;
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

    public String getDmodalidadContratacion() {
        return dmodalidadContratacion;
    }

    public void setDmodalidadContratacion(String dmodalidadContratacion) {
        this.dmodalidadContratacion = dmodalidadContratacion;
    }

    public String getDestadoCivil() {
        return destadoCivil;
    }

    public void setDestadoCivil(String destadoCivil) {
        this.destadoCivil = destadoCivil;
    }

    public String getDgradoInstruccion() {
        return dgradoInstruccion;
    }

    public void setDgradoInstruccion(String dgradoInstruccion) {
        this.dgradoInstruccion = dgradoInstruccion;
    }

    public String getDprofesion() {
        return dprofesion;
    }

    public void setDprofesion(String dprofesion) {
        this.dprofesion = dprofesion;
    }

    public String getDarea() {
        return darea;
    }

    public void setDarea(String darea) {
        this.darea = darea;
    }

    public String getDcargo() {
        return dcargo;
    }

    public void setDcargo(String dcargo) {
        this.dcargo = dcargo;
    }

    public Date getFingreso() {
        return fingreso;
    }

    public void setFingreso(Date fingreso) {
        this.fingreso = fingreso;
    }

    public Date getFcese() {
        return fcese;
    }

    public void setFcese(Date fcese) {
        this.fcese = fcese;
    }

    public String getDobservacion() {
        return dobservacion;
    }

    public void setDobservacion(String dobservacion) {
        this.dobservacion = dobservacion;
    }

    public String getDtipoColegio() {
        return dtipoColegio;
    }

    public void setDtipoColegio(String dtipoColegio) {
        this.dtipoColegio = dtipoColegio;
    }

    public String getDnumColegio() {
        return dnumColegio;
    }

    public void setDnumColegio(String dnumColegio) {
        this.dnumColegio = dnumColegio;
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
}
