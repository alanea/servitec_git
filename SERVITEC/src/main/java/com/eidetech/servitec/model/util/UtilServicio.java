/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.util;

import com.eidetech.servitec.model.domain.entity.Reservacion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author laptop-w8
 */
public class UtilServicio {

    public static String TIPO_RESERVACION_ESTADO_1 = "PENDIENTE_REVISAR";
    public static String TIPO_RESERVACION_ESTADO_2 = "PENDIENTE_REPARAR";
    public static String TIPO_RESERVACION_ESTADO_3 = "REPARADO";
    public static String TIPO_RESERVACION_ESTADO_4 = "NO_REPARADO";

    public static List<Reservacion> reservacionPendienteRevisar(List<Reservacion> lista) {
        List<Reservacion> l = new ArrayList();
        if (lista != null) {
            for (Reservacion r : lista) {
                if (UtilCadena.cadenaValido(r.getDestado()) && r.getDestado().equals(TIPO_RESERVACION_ESTADO_1)) {
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
                if (UtilCadena.cadenaValido(r.getDestado()) && r.getDestado().equals(TIPO_RESERVACION_ESTADO_2)) {
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
                if (UtilCadena.cadenaValido(r.getDestado()) && r.getDestado().equals(TIPO_RESERVACION_ESTADO_3)) {
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
                if (UtilCadena.cadenaValido(r.getDestado()) && r.getDestado().equals(TIPO_RESERVACION_ESTADO_4)) {
                    l.add(r);
                }
            }
        }
        return l;
    }
}
