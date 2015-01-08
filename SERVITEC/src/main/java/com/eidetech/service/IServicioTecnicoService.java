/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.service;

import com.eidetech.model.domain.ParametroReporte;
import com.eidetech.model.domain.Reporte;
import com.eidetech.model.domain.entity.Reservacion;
import com.eidetech.model.domain.entity.UsuarioCliente;
import com.eidetech.model.domain.entity.UsuarioPersonal;
import java.util.List;

/**
 *
 * @author laptop-w8
 */
public interface IServicioTecnicoService {

    public boolean registrarNuevoReservacion(UsuarioCliente usuarioCliente, Reservacion reservacion);

    public List<Reservacion> listaPendienteRevisarDomicilio(UsuarioPersonal usuarioPersonal);

    public List<Reservacion> listaPendienteRevisar();
    
    public List<Reservacion> listaPendienteRevisar(UsuarioPersonal usuarioPersonal);

    public List<Reservacion> listaPendienteReparar(UsuarioPersonal usuarioPersonal);

    public List<Reservacion> listaReparados();

    public List<Reservacion> listaNoReparados();

    public boolean registrarPendienteReparar(UsuarioPersonal usuarioPersonal, Reservacion reservacion);

    public boolean registrarNoReparar(UsuarioPersonal usuarioPersonal, Reservacion reservacion);

    public Reporte reporteUsuarioClienteDiario(ParametroReporte parametroReporte);

    public Reporte reporteUsuarioClienteMensual(ParametroReporte parametroReporte);

    public Reporte reporteUsuarioClienteAnual(ParametroReporte parametroReporte);

    public boolean registrarAsignacion(Reservacion reservacion);
}
