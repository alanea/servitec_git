/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.util;

import com.eidetech.model.domain.entity.Reservacion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author laptop-w8
 */
public class UtilServicio {

    public static String TIPO_REPARACION_PENDIENTE_REVISAR = "1";
    public static String TIPO_REPARACION_PENDIENTE_REPARAR = "2";
    public static String TIPO_REPARACION_EN_REPARACION = "3";
    public static String TIPO_REPARACION_REPARADO = "4";
    public static String TIPO_REPARACION_NO_REPARADO = "5";
    public static String TIPO_SERVICIO_PENDIENTE = "1";
    public static String TIPO_SERVICIO_ACEPTADO = "2";
    public static String TIPO_SERVICIO_CANCELADO = "3";
    public static String TIPO_LUGAR_SERVICIO_LOCAL = "1";
    public static String TIPO_LUGAR_SERVICIO_FUERA = "2";

    public static List<Reservacion> reservacionPendienteRevisar(List<Reservacion> lista) {
        List<Reservacion> l = new ArrayList();
        if (lista != null) {
            for (Reservacion r : lista) {
                if (UtilCadena.cadenaValido(r.getDestadoReservacion())
                        && UtilCadena.cadenaValido(r.getDestadoServicio())
                        && r.getDestadoReservacion().equals(TIPO_REPARACION_PENDIENTE_REVISAR)
                        && r.getDestadoServicio().equals(TIPO_SERVICIO_PENDIENTE)) {
                    l.add(r);
                }
            }
        }
        return l;
    }

    public static List<Reservacion> reservacionPendienteRevisarDomicilio(List<Reservacion> lista) {
        List<Reservacion> l = new ArrayList();
        if (lista != null) {
            for (Reservacion r : lista) {
                if (UtilCadena.cadenaValido(r.getDestadoReservacion())
                        && UtilCadena.cadenaValido(r.getDestadoServicio())
                        &&UtilCadena.cadenaValido(r.getDtipoDireccion())
                        && r.getDestadoReservacion().equals(TIPO_REPARACION_PENDIENTE_REVISAR)
                        && r.getDestadoServicio().equals(TIPO_SERVICIO_PENDIENTE)
                        && r.getDtipoDireccion().equals(TIPO_LUGAR_SERVICIO_FUERA)) {
                    l.add(r);
                }
            }
        }
        return l;
    }

    public static List<Reservacion> reservacionPendienteReparar(List<Reservacion> lista) {
        List<Reservacion> l = new ArrayList();
        if (lista != null) {
            for (Reservacion r : lista) {
                if (UtilCadena.cadenaValido(r.getDestadoReservacion())
                        && UtilCadena.cadenaValido(r.getDestadoServicio())
                        && r.getDestadoReservacion().equals(TIPO_REPARACION_PENDIENTE_REPARAR)
                        && r.getDestadoServicio().equals(TIPO_SERVICIO_ACEPTADO)) {
                    l.add(r);
                }
            }
        }
        return l;
    }

    public static List<Reservacion> reservacionReparados(List<Reservacion> lista) {
        List<Reservacion> l = new ArrayList();
        if (lista != null) {
            for (Reservacion r : lista) {
                if (UtilCadena.cadenaValido(r.getDestadoReservacion())
                        && UtilCadena.cadenaValido(r.getDestadoServicio())
                        && r.getDestadoReservacion().equals(TIPO_REPARACION_REPARADO)
                        && r.getDestadoServicio().equals(TIPO_SERVICIO_ACEPTADO)) {
                    l.add(r);
                }
            }
        }
        return l;
    }

    public static List<Reservacion> reservacionNoReparados(List<Reservacion> lista) {
        List<Reservacion> l = new ArrayList();
        if (lista != null) {
            for (Reservacion r : lista) {
                if (UtilCadena.cadenaValido(r.getDestadoReservacion())
                        && UtilCadena.cadenaValido(r.getDestadoServicio())
                        && r.getDestadoReservacion().equals(TIPO_REPARACION_NO_REPARADO)){
                    l.add(r);
                }
            }
        }
        return l;
    }
}
