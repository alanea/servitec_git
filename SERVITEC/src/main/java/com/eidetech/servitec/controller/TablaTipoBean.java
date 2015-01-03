/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.controller;

import com.eidetech.servitec.model.domain.entity.TablaTipo;
import com.eidetech.servitec.model.util.UtilCadena;
import com.eidetech.servitec.model.util.UtilFecha;
import com.eidetech.servitec.model.util.UtilTablaTipo;
import com.eidetech.servitec.service.IPortalService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
    private List<TablaTipo> tipoContrato;
    private List<TablaTipo> tipoEstadoRegistro;
    private List<TablaTipo> tipoInstitucion;
    private List<TablaTipo> tipoProducto;
    private List<TablaTipo> tipoSubproducto;
    private List<TablaTipo> tipoTurno;
    private List<TablaTipo> tipoTipoUsuario;
    private List<TablaTipo> tipoDocIdentidad;
    private List<TablaTipo> tipoDocVenta;
    private List<TablaTipo> tipoTipoMoneda;
    private List<TablaTipo> tipoFormaPago;
    private List<TablaTipo> tipoGenero;
    private List<TablaTipo> tipoEstadoSeguro;
    private List<TablaTipo> tipoEstadoCivil;
    private List<TablaTipo> tipoGradoInstruccion;
    private List<TablaTipo> tipoAreaTrabajo;
    private List<TablaTipo> tipoProfesion;
    private List<TablaTipo> tipoModalidadContratacion;
    private List<TablaTipo> tipoModalidadOperativo;
    private List<TablaTipo> tipoEstadoOperativo;
    private List<TablaTipo> tipoCargo;
    private List<TablaTipo> tipoNivelEstudios;
    private List<TablaTipo> tipoCondicionLaboral;
    private List<TablaTipo> tipoCondicionSituacional;
    private List<TablaTipo> tipoGradoJerarquico;
    private List<TablaTipo> tipoMotivoAnulacion;
    private List<TablaTipo> tipoMotivoExtornacion;
    private List<TablaTipo> tipoTipoDiagnostico;
    private List<TablaTipo> tipoIgv;
    private List<TablaTipo> tipoGrupoEspecialidad;

    private List<TablaTipo> tipoCategoria;
    private List<TablaTipo> tipoCategoriaImagenSonido;
    private List<TablaTipo> tipoCategoriaMovile;
    private List<TablaTipo> tipoCategoriaLaptop;
    private List<TablaTipo> tipoCategoriaWifi;
    private List<TablaTipo> tipoSintomaTelevisores;
    private List<TablaTipo> tipoSintomaVideo;
    private List<TablaTipo> tipoSintomaEquipoSonido;
    private List<TablaTipo> tipoSintomaAutoradio;
    private List<TablaTipo> tipoSintomaCelulares;
    private List<TablaTipo> tipoSintomaMonitores;
    private List<TablaTipo> tipoSintomaAlmacenamientoOptico;

    private List<SelectItem> siColegio;
    private List<SelectItem> siContrato;
    private List<SelectItem> siEstadoRegistro;
    private List<SelectItem> siInstitucion;
    private List<SelectItem> siProducto;
    private List<SelectItem> siSubproducto;
    private List<SelectItem> siTurno;
    private List<SelectItem> siTipoUsuario;
    private List<SelectItem> siDocIdentidad;
    private List<SelectItem> siDocVenta;
    private List<SelectItem> siTipoMoneda;
    private List<SelectItem> siFormaPago;
    private List<SelectItem> siGenero;
    private List<SelectItem> siEstadoSeguro;
    private List<SelectItem> siEstadoCivil;
    private List<SelectItem> siGradoInstruccion;
    private List<SelectItem> siAreaTrabajo;
    private List<SelectItem> siProfesion;
    private List<SelectItem> siModalidadContratacion;
    private List<SelectItem> siModalidadOperativo;
    private List<SelectItem> siEstadoOperativo;
    private List<SelectItem> siCargo;
    private List<SelectItem> siNivelEstudios;
    private List<SelectItem> siCondicionLaboral;
    private List<SelectItem> siCondicionSituacional;
    private List<SelectItem> siGradoJerarquico;
    private List<SelectItem> siMotivoAnulacion;
    private List<SelectItem> siMotivoExtornacion;
    private List<SelectItem> siTipoDiagnostico;
    private List<SelectItem> siIgv;
    private List<SelectItem> siGrupoEspecialidad;

    private List<SelectItem> siCategoria;
    private List<SelectItem> siCategoriaImagenSonido;
    private List<SelectItem> siCategoriaMovile;
    private List<SelectItem> siCategoriaLaptop;
    private List<SelectItem> siCategoriaWifi;
    private List<SelectItem> siSintomaTelevisores;
    private List<SelectItem> siSintomaVideo;
    private List<SelectItem> siSintomaEquipoSonido;
    private List<SelectItem> siSintomaAutoradio;
    private List<SelectItem> siSintomaCelulares;
    private List<SelectItem> siSintomaMonitores;
    private List<SelectItem> siSintomaAlmacenamientoOptico;

    @ManagedProperty(value = "#{portalService}")
    IPortalService portalService;

    public TablaTipoBean() {
    }

    @PostConstruct
    public void init() {
        inicializarValores();
    }

    public void actualizarValores() {
        inicializarValores();
    }

    private void inicializarValores() {
        tablatipos = portalService.obtenerTablaTipos();

        tipoColegio = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_COLEGIO);
        tipoContrato = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_CONTRATO);
        tipoEstadoRegistro = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_ESTADO_REGISTRO);
        tipoInstitucion = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_INSTITUCION);
        tipoProducto = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_PRODUCTO);
        tipoSubproducto = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_SUBPRODUCTO);
        tipoTurno = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_TURNO);
        tipoTipoUsuario = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_TIPO_USUARIO);
        tipoDocIdentidad = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_DOC_IDENTIDAD);
        tipoDocVenta = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_DOC_VENTA);
        tipoTipoMoneda = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_TIPO_MONEDA);
        tipoFormaPago = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_FORMA_PAGO);
        tipoGenero = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_GENERO);
        tipoEstadoSeguro = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_ESTADO_SEGURO);
        tipoEstadoCivil = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_ESTADO_CIVIL);
        tipoGradoInstruccion = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_GRADO_INSTRUCCION);
        tipoAreaTrabajo = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_AREA_TRABAJO);
        tipoProfesion = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_PROFESION);
        tipoModalidadContratacion = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_MODALIDAD_CONTRATACION);
        tipoModalidadOperativo = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_MODALIDAD_OPERATIVO);
        tipoEstadoOperativo = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_ESTADO_OPERATIVO);
        tipoCargo = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_CARGO);
        tipoNivelEstudios = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_NIVEL_ESTUDIOS);
        tipoCondicionLaboral = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_CONDICION_LABORAL);
        tipoCondicionSituacional = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_CONDICION_SITUACIONAL);
        tipoGradoJerarquico = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_GRADO_JERARQUICO);
        tipoMotivoAnulacion = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_MOTIVO_ANULACION);
        tipoMotivoExtornacion = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_MOTIVO_EXTORNACION);
        tipoTipoDiagnostico = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_TIPO_DIAGNOSTICO);
        tipoIgv = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_IGV);
        tipoGrupoEspecialidad = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_GRUPO_ESPECIALIDAD);

        tipoCategoria = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_CATEGORIA);
        tipoCategoriaImagenSonido = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_CATEGORIA_IMAGEN_SONIDO);
        tipoCategoriaMovile = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_CATEGORIA_MOVILE);
        tipoCategoriaLaptop = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_CATEGORIA_LAPTOP);
        tipoSintomaEquipoSonido = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_SINTOMA_EQUIPO_SONIDO);
        tipoSintomaTelevisores = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_SINTOMA_TELEVISORES);
        tipoSintomaVideo = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_SINTOMA_VIDEO);
        tipoSintomaCelulares = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_SINTOMA_CELULARES);
        tipoSintomaMonitores = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_SINTOMA_MONITORES);
        tipoSintomaAutoradio = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_SINTOMA_AUTORADIO);
        tipoSintomaAlmacenamientoOptico = UtilTablaTipo.listaTipos(tablatipos, UtilTablaTipo.TIPO_SINTOMA_ALMACENAMIENTO_OPTICO);

        siColegio = listaItem(tipoColegio);
        siContrato = listaItem(tipoContrato);
        siEstadoRegistro = listaItem(tipoEstadoRegistro);
        siInstitucion = listaItem(tipoInstitucion);
        siProducto = listaItem(tipoProducto);
        siSubproducto = listaItem(tipoSubproducto);
        siTurno = listaItem(tipoTurno);
        siTipoUsuario = listaItem(tipoTipoUsuario);
        siDocIdentidad = listaItem(tipoDocIdentidad);
        siDocVenta = listaItem(tipoDocVenta);
        siTipoMoneda = listaItem(tipoTipoMoneda);
        siFormaPago = listaItem(tipoFormaPago);
        siGenero = listaItem(tipoGenero);
        siEstadoSeguro = listaItem(tipoEstadoSeguro);
        siEstadoCivil = listaItem(tipoEstadoCivil);
        siGradoInstruccion = listaItem(tipoGradoInstruccion);
        siAreaTrabajo = listaItem(tipoAreaTrabajo);
        siProfesion = listaItem(tipoProfesion);
        siModalidadContratacion = listaItem(tipoModalidadContratacion);
        siModalidadOperativo = listaItem(tipoModalidadOperativo);
        siEstadoOperativo = listaItem(tipoEstadoOperativo);
        siCargo = listaItem(tipoCargo);
        siNivelEstudios = listaItem(tipoNivelEstudios);
        siCondicionLaboral = listaItem(tipoCondicionLaboral);
        siCondicionSituacional = listaItem(tipoCondicionSituacional);
        siGradoJerarquico = listaItem(tipoGradoJerarquico);
        siMotivoAnulacion = listaItem(tipoMotivoAnulacion);
        siMotivoExtornacion = listaItem(tipoMotivoExtornacion);
        siTipoDiagnostico = listaItem(tipoTipoDiagnostico);
        siIgv = listaItem(tipoIgv);
        siGrupoEspecialidad = listaItem(tipoGrupoEspecialidad);

        siCategoria = listaItem(tipoCategoria);
        siCategoriaImagenSonido = listaItem(tipoCategoriaImagenSonido);
        siCategoriaMovile = listaItem(tipoCategoriaMovile);
        siCategoriaLaptop = listaItem(tipoCategoriaLaptop);
        siCategoriaWifi = listaItem(tipoCategoriaWifi);
        siSintomaTelevisores = listaItem(tipoSintomaTelevisores);
        siSintomaAutoradio = listaItem(tipoSintomaAutoradio);
        siSintomaCelulares = listaItem(tipoSintomaCelulares);
        siSintomaMonitores = listaItem(tipoSintomaMonitores);
        siSintomaEquipoSonido = listaItem(tipoSintomaEquipoSonido);
        siSintomaVideo = listaItem(tipoSintomaVideo);
        siSintomaAlmacenamientoOptico = listaItem(tipoSintomaAlmacenamientoOptico);
    }

    public String formatoFecha(Date fecha) {
        return UtilFecha.formatoFecha(fecha);
    }

    public String formatoFechaHora(Date fecha) {
        return UtilFecha.formatoFechaHora(fecha);
    }

    public String datoRegistrado(String descripcion) {
        if (UtilCadena.cadenaValido(descripcion)) {
            return descripcion;
        }
        return "NO REGISTRADO";
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

    public List<SelectItem> siProducto(String descripcion) {
        System.out.println("descripcion del producto:" + descripcion);
        List<SelectItem> si = new ArrayList();
        if (descripcion.equals("2")) {
            return siCategoriaLaptop;
        }
        if (descripcion.equals("4")) {
            return siCategoriaWifi;
        }
        if (descripcion.equals("3")) {
            return siCategoriaImagenSonido;
        }
        if (descripcion.equals("1")) {
            return siCategoriaMovile;
        }
        return si;
    }

    public List<SelectItem> siSintoma(String descripcion) {
        List<SelectItem> si = new ArrayList();
        if (descripcion.equals("L1")) {
            return siSintomaMonitores;
        }
        if (descripcion.equals("L2")) {
            return siSintomaAlmacenamientoOptico;
        }
        if (descripcion.equals("A1")) {
            return siSintomaTelevisores;
        }
        if (descripcion.equals("A2")) {
            return siSintomaVideo;
        }
        if (descripcion.equals("A4")) {
            return siSintomaAutoradio;
        }
        if (descripcion.equals("A3")) {
            return siSintomaEquipoSonido;
        }
        if (descripcion.equals("M1")) {
            return siSintomaCelulares;
        }
        return si;
    }

    public String descripcionColegio(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoColegio, UtilTablaTipo.TIPO_COLEGIO, tipo);
    }

    public String descripcionContrato(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoContrato, UtilTablaTipo.TIPO_CONTRATO, tipo);
    }

    public String descripcionEstadoRegistro(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoEstadoRegistro, UtilTablaTipo.TIPO_ESTADO_REGISTRO, tipo);
    }

    public String descripcionInstitucion(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoInstitucion, UtilTablaTipo.TIPO_INSTITUCION, tipo);
    }

    public String descripcionProducto(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoProducto, UtilTablaTipo.TIPO_PRODUCTO, tipo);
    }

    public String descripcionSubproducto(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoSubproducto, UtilTablaTipo.TIPO_SUBPRODUCTO, tipo);
    }

    public String descripcionTurno(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoTurno, UtilTablaTipo.TIPO_TURNO, tipo);
    }

    public String descripcionTipoUsuario(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoTipoUsuario, UtilTablaTipo.TIPO_TIPO_USUARIO, tipo);
    }

    public String descripcionDocIdentidad(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoDocIdentidad, UtilTablaTipo.TIPO_DOC_IDENTIDAD, tipo);
    }

    public String descripcionDocVenta(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoDocVenta, UtilTablaTipo.TIPO_DOC_VENTA, tipo);
    }

    public String descripcionTipoMoneda(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoTipoMoneda, UtilTablaTipo.TIPO_TIPO_MONEDA, tipo);
    }

    public String descripcionFormaPago(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoFormaPago, UtilTablaTipo.TIPO_FORMA_PAGO, tipo);
    }

    public String descripcionGenero(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoGenero, UtilTablaTipo.TIPO_GENERO, tipo);
    }

    public String descripcionEstadoSeguro(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoEstadoSeguro, UtilTablaTipo.TIPO_ESTADO_SEGURO, tipo);
    }

    public String descripcionEstadoCivil(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoEstadoCivil, UtilTablaTipo.TIPO_ESTADO_CIVIL, tipo);
    }

    public String descripcionGradoInstruccion(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoGradoInstruccion, UtilTablaTipo.TIPO_GRADO_INSTRUCCION, tipo);
    }

    public String descripcionAreaTrabajo(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoAreaTrabajo, UtilTablaTipo.TIPO_AREA_TRABAJO, tipo);
    }

    public String descripcionProfesion(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoProfesion, UtilTablaTipo.TIPO_PROFESION, tipo);
    }

    public String descripcionModalidadContratacion(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoModalidadContratacion, UtilTablaTipo.TIPO_MODALIDAD_CONTRATACION, tipo);
    }

    public String descripcionModalidadOperativo(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoModalidadOperativo, UtilTablaTipo.TIPO_MODALIDAD_OPERATIVO, tipo);
    }

    public String descripcionEstadoOperativo(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoEstadoOperativo, UtilTablaTipo.TIPO_ESTADO_OPERATIVO, tipo);
    }

    public String descripcionCargo(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoCargo, UtilTablaTipo.TIPO_CARGO, tipo);
    }

    public String descripcionNivelEstudios(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoNivelEstudios, UtilTablaTipo.TIPO_NIVEL_ESTUDIOS, tipo);
    }

    public String descripcionCondicionLaboral(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoCondicionLaboral, UtilTablaTipo.TIPO_CONDICION_LABORAL, tipo);
    }

    public String descripcionCondicionSituacion(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoCondicionSituacional, UtilTablaTipo.TIPO_CONDICION_SITUACIONAL, tipo);
    }

    public String descripcionGradoJerarquico(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoGradoJerarquico, UtilTablaTipo.TIPO_GRADO_JERARQUICO, tipo);
    }

    public String descripcionMotivoAnulacion(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoMotivoAnulacion, UtilTablaTipo.TIPO_MOTIVO_ANULACION, tipo);
    }

    public String descripcionMotivoExtornacion(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoMotivoExtornacion, UtilTablaTipo.TIPO_MOTIVO_EXTORNACION, tipo);
    }

    public String descripcionTipoDiagnostico(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoTipoDiagnostico, UtilTablaTipo.TIPO_TIPO_DIAGNOSTICO, tipo);
    }

    public String descripcionIgv(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoIgv, UtilTablaTipo.TIPO_IGV, tipo);
    }

    public String descripcionGrupoEspecialidad(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoGrupoEspecialidad, UtilTablaTipo.TIPO_GRUPO_ESPECIALIDAD, tipo);
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

    public List<SelectItem> getSiColegio() {
        return siColegio;
    }

    public List<SelectItem> getSiContrato() {
        return siContrato;
    }

    public List<SelectItem> getSiEstadoRegistro() {
        return siEstadoRegistro;
    }

    public List<SelectItem> getSiInstitucion() {
        return siInstitucion;
    }

    public List<SelectItem> getSiProducto() {
        return siProducto;
    }

    public List<SelectItem> getSiSubproducto() {
        return siSubproducto;
    }

    public List<SelectItem> getSiTurno() {
        return siTurno;
    }

    public List<SelectItem> getSiTipoUsuario() {
        return siTipoUsuario;
    }

    public List<SelectItem> getSiDocIdentidad() {
        return siDocIdentidad;
    }

    public List<SelectItem> getSiDocVenta() {
        return siDocVenta;
    }

    public List<SelectItem> getSiTipoMoneda() {
        return siTipoMoneda;
    }

    public List<SelectItem> getSiFormaPago() {
        return siFormaPago;
    }

    public List<SelectItem> getSiGenero() {
        return siGenero;
    }

    public List<SelectItem> getSiEstadoSeguro() {
        return siEstadoSeguro;
    }

    public List<SelectItem> getSiEstadoCivil() {
        return siEstadoCivil;
    }

    public List<SelectItem> getSiGradoInstruccion() {
        return siGradoInstruccion;
    }

    public List<SelectItem> getSiAreaTrabajo() {
        return siAreaTrabajo;
    }

    public List<SelectItem> getSiProfesion() {
        return siProfesion;
    }

    public List<SelectItem> getSiModalidadContratacion() {
        return siModalidadContratacion;
    }

    public List<SelectItem> getSiModalidadOperativo() {
        return siModalidadOperativo;
    }

    public List<SelectItem> getSiEstadoOperativo() {
        return siEstadoOperativo;
    }

    public List<SelectItem> getSiCargo() {
        return siCargo;
    }

    public List<SelectItem> getSiNivelEstudios() {
        return siNivelEstudios;
    }

    public List<SelectItem> getSiCondicionLaboral() {
        return siCondicionLaboral;
    }

    public List<SelectItem> getSiCondicionSituacional() {
        return siCondicionSituacional;
    }

    public List<SelectItem> getSiGradoJerarquico() {
        return siGradoJerarquico;
    }

    public List<SelectItem> getSiMotivoAnulacion() {
        return siMotivoAnulacion;
    }

    public List<SelectItem> getSiMotivoExtornacion() {
        return siMotivoExtornacion;
    }

    public List<SelectItem> getSiTipoDiagnostico() {
        return siTipoDiagnostico;
    }

    public List<SelectItem> getSiIgv() {
        return siIgv;
    }

    public List<SelectItem> getSiGrupoEspecialidad() {
        return siGrupoEspecialidad;
    }

    public List<SelectItem> getSiCategoria() {
        return siCategoria;
    }

    public List<SelectItem> getSiCategoriaImagenSonido() {
        return siCategoriaImagenSonido;
    }

    public List<SelectItem> getSiCategoriaMovile() {
        return siCategoriaMovile;
    }

    public List<SelectItem> getSiCategoriaLaptop() {
        return siCategoriaLaptop;
    }

    public List<SelectItem> getSiCategoriaWifi() {
        return siCategoriaWifi;
    }

    public List<SelectItem> getSiSintomaTelevisores() {
        return siSintomaTelevisores;
    }

    public List<SelectItem> getSiSintomaVideo() {
        return siSintomaVideo;
    }

    public List<SelectItem> getSiSintomaEquipoSonido() {
        return siSintomaEquipoSonido;
    }

    public List<SelectItem> getSiSintomaAutoradio() {
        return siSintomaAutoradio;
    }

    public List<SelectItem> getSiSintomaCelulares() {
        return siSintomaCelulares;
    }

    public List<SelectItem> getSiSintomaMonitores() {
        return siSintomaMonitores;
    }

    public List<SelectItem> getSiSintomaAlmacenamientoOptico() {
        return siSintomaAlmacenamientoOptico;
    }

}
