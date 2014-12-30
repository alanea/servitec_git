/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.service;

import com.eidetech.servitec.model.domain.entity.Reservacion;
import com.eidetech.servitec.model.domain.entity.UsuarioCliente;
import java.util.List;

/**
 *
 * @author laptop-w8
 */
public interface IServicioTecnicoService {

    public boolean registrarNuevoReservacion(UsuarioCliente usuarioCliente, Reservacion reservacion);

    public List<Reservacion> listaPendienteRevisarDomicilio();

    public List<Reservacion> listaPendienteRevisar();

    public List<Reservacion> listaPendienteReparar();

    public List<Reservacion> listaReparados();

    public List<Reservacion> listaNoReparados();

    public boolean registrarPendienteReparar(Reservacion reservacion);

    public boolean registrarNoReparar(Reservacion reservacion);

}
