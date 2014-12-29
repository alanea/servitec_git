/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.servitec.model.dao;

import com.eidetech.servitec.model.domain.entity.Cliente;
import com.eidetech.servitec.model.domain.entity.Reservacion;
import java.util.List;

/**
 *
 * @author laptop-w8
 */
public interface IReservacionDao {
    public static final String PRE_RESERVACION = "RSVC";
    public boolean agregarReservacion(Reservacion reservacion);
    public boolean actualizarReservacion(Reservacion reservacion);
    public List<Reservacion> obtenerListaReservacion(Cliente cliente);
    public List<Reservacion> obtenerListaReservacion(Reservacion reservacion);
}
