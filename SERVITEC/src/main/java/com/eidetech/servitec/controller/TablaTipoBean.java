/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.controller;

import com.eidetech.servitec.model.domain.entity.TablaTipo;
import com.eidetech.servitec.model.util.UtilTablaTipo;
import com.eidetech.servitec.service.IPortalService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;

/**
 *
 * @author usuario-xp
 */
//@ManagedBean(name = "tablaTipoBean", eager = true)
@ManagedBean(name = "tablaTipoBean")
@ApplicationScoped
public class TablaTipoBean implements Serializable {

    private List<TablaTipo> tablatipos;
    private List<TablaTipo> tipoColegio;
    private List<TablaTipo> tipoProfesion;
    private List<TablaTipo> tipoGradoInstruccion;
    private List<TablaTipo> tipoAreaTrabajo;
    private List<TablaTipo> tipoModalidadContratacion;
    private List<TablaTipo> tipoEstadoCivil;
    private List<TablaTipo> tipoEstadoRegistro;
    private List<TablaTipo> tipoCargo;
    private List<TablaTipo> tipoSexo;
    private List<TablaTipo> tipoDocVenta;
    private List<TablaTipo> tipoMoneda;
    private List<TablaTipo> tipoContrato;
    private List<TablaTipo> tipoGrupoEspecialidad;
    private List<TablaTipo> tipoProducto;
    private List<TablaTipo> tipoSubproducto;
    private List<TablaTipo> tipoInstitucion;
    private List<TablaTipo> tipoFormaPago;

    private List<SelectItem> siSexo;
    private List<SelectItem> siTipoColegio;
    private List<SelectItem> siModalidadContratacion;
    private List<SelectItem> siEstadoRegistro;
    private List<SelectItem> siEstadoCivil;
    private List<SelectItem> siGradoInstruccion;
    private List<SelectItem> siProfesion;
    private List<SelectItem> siAreaTrabajo;
    private List<SelectItem> siCargo;
    private List<SelectItem> siDocVenta;
    private List<SelectItem> siMoneda;
    private List<SelectItem> siTipoContrato;
    private List<SelectItem> siGrupoEspecialidad;
    private List<SelectItem> siProducto;
    private List<SelectItem> siSubproducto;
    private List<SelectItem> siInstitucion;
    private List<SelectItem> siFormaPago;

    private String igv;

    @ManagedProperty(value = "#{portalService}")
    IPortalService portalService;

    public TablaTipoBean() {
    }

    @PostConstruct
    public void init() {
        tablatipos = portalService.obtenerTablaTipos();
        tipoColegio = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_COLEGIO);
        tipoProfesion = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_PROFESION);
        tipoGradoInstruccion = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_GRADO_INSTRUCCION);
        tipoAreaTrabajo = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_AREA_TRABAJO);
        tipoModalidadContratacion = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_MODALIDAD_CONTRATACION);
        tipoEstadoRegistro = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_ESTADO_REGISTRO);
        tipoCargo = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_CARGO);
        tipoEstadoCivil = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_ESTADO_CIVIL);
        tipoSexo = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_SEXO);
        tipoDocVenta = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_DOC_VENTA);
        tipoMoneda = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_MONEDA);
        tipoContrato = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_CONTRATO);
        tipoGrupoEspecialidad = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_GRUPO_ESPECIALIDAD);
        tipoProducto = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_PRODUCTO);
        tipoSubproducto = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_SUBPRODUCTO);
        tipoInstitucion = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_INSTITUCION);
        tipoFormaPago = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_FORMA_PAGO);

        List<TablaTipo> tipoIgv = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_IGV);
        igv = tipoIgv.get(0).getDdescripcion();

        siCargo = listaItem(tipoCargo);
        siAreaTrabajo = listaItem(tipoAreaTrabajo);
        siModalidadContratacion = listaItem(tipoModalidadContratacion);
        siProfesion = listaItem(tipoProfesion);
        siGradoInstruccion = listaItem(tipoGradoInstruccion);
        siTipoColegio = listaItem(tipoColegio);
        siEstadoRegistro = listaItem(tipoEstadoRegistro);
        siEstadoCivil = listaItem(tipoEstadoCivil);
        siSexo = listaItem(tipoSexo);
        siDocVenta = listaItem(tipoDocVenta);
        siMoneda = listaItem(tipoMoneda);
        siTipoContrato = listaItem(tipoContrato);
        siGrupoEspecialidad = listaItem(tipoGrupoEspecialidad);
        siProducto = listaItem(tipoProducto);
        siSubproducto = listaItem(tipoSubproducto);
        siInstitucion = listaItem(tipoInstitucion);
        siFormaPago = listaItem(tipoFormaPago);
    }

    private List<SelectItem> listaItem(List<TablaTipo> tabla) {
        List<SelectItem> si = new ArrayList();
        if (tabla != null && tabla.size() > 0) {
            for (TablaTipo t : tabla) {
                si.add(new SelectItem(t.getDtipo(), t.getDdescripcion()));
            }
        }
        return si;
    }

    public String descripcionEstadoRegistro(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoEstadoRegistro, UtilTablaTipo.TIPO_ESTADO_REGISTRO, tipo);
    }

    public String descripcionModoRelacion(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoContrato, UtilTablaTipo.TIPO_CONTRATO, tipo);
    }

    public String descripcionGrupoEspecialidad(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoGrupoEspecialidad, UtilTablaTipo.TIPO_GRUPO_ESPECIALIDAD, tipo);
    }

    public String descripcionProducto(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoProducto, UtilTablaTipo.TIPO_PRODUCTO, tipo);
    }

    public String descripcionSubproducto(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoSubproducto, UtilTablaTipo.TIPO_SUBPRODUCTO, tipo);
    }

    public String descripcionDocumentoVenta(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoDocVenta, UtilTablaTipo.TIPO_DOC_VENTA, tipo);
    }

    public String descripcionInstitucion(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoInstitucion, UtilTablaTipo.TIPO_INSTITUCION, tipo);
    }

    public String descripcionEstadoCivil(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoEstadoCivil, UtilTablaTipo.TIPO_ESTADO_CIVIL, tipo);
    }

    public String descripcionSexo(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoSexo, UtilTablaTipo.TIPO_SEXO, tipo);
    }

    public String descripcionAreaTrabajo(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoAreaTrabajo, UtilTablaTipo.TIPO_AREA_TRABAJO, tipo);
    }
    
    public String descripcionFormaPago(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoFormaPago, UtilTablaTipo.TIPO_FORMA_PAGO, tipo);
    }
    
    public List<TablaTipo> getTablatipos() {
        return tablatipos;
    }

    public IPortalService getPortalService() {
        return portalService;
    }

    public void setPortalService(IPortalService portalService) {
        this.portalService = portalService;
    }

    public List<SelectItem> getSiSexo() {
        return siSexo;
    }

    public List<SelectItem> getSiTipoColegio() {
        return siTipoColegio;
    }

    public List<SelectItem> getSiModalidadContratacion() {
        return siModalidadContratacion;
    }

    public List<SelectItem> getSiEstadoCivil() {
        return siEstadoCivil;
    }

    public List<SelectItem> getSiGradoInstruccion() {
        return siGradoInstruccion;
    }

    public List<SelectItem> getSiProfesion() {
        return siProfesion;
    }

    public List<SelectItem> getSiAreaTrabajo() {
        return siAreaTrabajo;
    }

    public List<SelectItem> getSiCargo() {
        return siCargo;
    }

    public List<SelectItem> getSiDocVenta() {
        return siDocVenta;
    }

    public List<SelectItem> getSiMoneda() {
        return siMoneda;
    }

    public String getIgv() {
        return igv;
    }

    public List<SelectItem> getSiTipoContrato() {
        return siTipoContrato;
    }

    public List<SelectItem> getSiEstadoRegistro() {
        return siEstadoRegistro;
    }

    public List<SelectItem> getSiGrupoEspecialidad() {
        return siGrupoEspecialidad;
    }

    public List<SelectItem> getSiProducto() {
        return siProducto;
    }

    public List<SelectItem> getSiSubproducto() {
        return siSubproducto;
    }

    public List<SelectItem> getSiInstitucion() {
        return siInstitucion;
    }

    public List<SelectItem> getSiFormaPago() {
        return siFormaPago;
    }

    public List<TablaTipo> getTipoEstadoRegistro() {
        return tipoEstadoRegistro;
    }


}
