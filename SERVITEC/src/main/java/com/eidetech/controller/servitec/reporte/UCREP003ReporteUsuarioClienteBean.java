/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.controller.servitec.reporte;

import com.eidetech.controller.seguridad.UCSYS001LoginPersonalBean;
import com.eidetech.model.domain.ParametroReporte;
import com.eidetech.model.domain.Reporte;
import com.eidetech.model.domain.ResultadoTempReporte;
import com.eidetech.model.util.validator.ValidatorReporte;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

/**
 *
 * @author laptop-w8
 */
@ManagedBean(name = "reporteUsuarioCliente")
@ViewScoped
public class UCREP003ReporteUsuarioClienteBean implements Serializable {

    private ParametroReporte parametro;
    private LineChartModel lineModelo;
    @ManagedProperty(value = "#{loginPersonal}")
    private UCSYS001LoginPersonalBean beanUsuario;

    /**
     * Creates a new instance of UCREP003ReporteUsuarioClienteBean
     */
    public UCREP003ReporteUsuarioClienteBean() {
    }

    @PostConstruct
    public void init() {
        parametro = new ParametroReporte();

        lineModelo = new LineChartModel();
        ChartSeries series = new ChartSeries();
        series.setLabel("Clientes");
        series.set("2009", 34);
        lineModelo.addSeries(series);
        lineModelo.setTitle("");
        lineModelo.setLegendPosition("e");
        lineModelo.setShowPointLabels(true);
        Axis yAxis = lineModelo.getAxis(AxisType.Y);
        yAxis.setLabel("Numero de clientes");
        yAxis.setMin(0);
        Axis xAxis=lineModelo.getAxis(AxisType.X);
        xAxis.setLabel("Dias");
        xAxis.setTickAngle(-50);
    }

    public void ejecutarReporteUsuarioClienteDiario() {
        FacesMessage msg;
        boolean exito = false;
        Reporte r = beanUsuario.getServicioTecnicoService().reporteUsuarioClienteDiario(parametro);

        lineModelo = new LineChartModel();
        ChartSeries series = new ChartSeries();
        series.setLabel("Clientes");
        if (ValidatorReporte.esValidoReporte(r)) {
            exito = true;
            for (ResultadoTempReporte rtr : r.getResultados()) {
                series.set(rtr.getObjeto(), rtr.getValor());
            }
        }
        lineModelo.addSeries(series);
        lineModelo.setTitle("");
        lineModelo.setLegendPosition("e");
        lineModelo.setShowPointLabels(true);
        Axis yAxis = lineModelo.getAxis(AxisType.Y);
        yAxis.setLabel("Numero de clientes");
        yAxis.setMin(0);
        Axis xAxis=lineModelo.getAxis(AxisType.X);
        xAxis.setLabel("Dias");
        xAxis.setTickAngle(-50);

        if (exito) {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Se genero nuevo reporte");
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se genero reporte");
        }

        FacesContext.getCurrentInstance().addMessage("growl_reporte", msg);
    }

    public LineChartModel getLineModelo() {
        return lineModelo;
    }

    public UCSYS001LoginPersonalBean getBeanUsuario() {
        return beanUsuario;
    }

    public void setBeanUsuario(UCSYS001LoginPersonalBean beanUsuario) {
        this.beanUsuario = beanUsuario;
    }

    public ParametroReporte getParametro() {
        return parametro;
    }

    public void setParametro(ParametroReporte parametro) {
        this.parametro = parametro;
    }

}
