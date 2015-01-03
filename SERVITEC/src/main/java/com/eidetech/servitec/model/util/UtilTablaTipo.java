/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.util;

import com.eidetech.servitec.model.domain.entity.TablaTipo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario-xp
 */
public class UtilTablaTipo {

    public static String TABLA = "0";

    public static String TIPO_COLEGIO = "1";
    public static String TIPO_CONTRATO = "2";
    public static String TIPO_ESTADO_REGISTRO = "3";
    public static String TIPO_INSTITUCION = "4";
    public static String TIPO_PRODUCTO = "5";
    public static String TIPO_SUBPRODUCTO = "6";
    public static String TIPO_TURNO = "7";
    public static String TIPO_TIPO_USUARIO = "8";
    public static String TIPO_DOC_IDENTIDAD = "9";
    public static String TIPO_DOC_VENTA = "10";
    public static String TIPO_TIPO_MONEDA = "11";
    public static String TIPO_FORMA_PAGO = "12";
    public static String TIPO_GENERO = "13";
    public static String TIPO_ESTADO_SEGURO = "14";
    public static String TIPO_ESTADO_CIVIL = "15";
    public static String TIPO_MODALIDAD_TRANSPORTE = "16";
    public static String TIPO_MODALIDAD_OPERADOR = "17";
    public static String TIPO_GRADO_INSTRUCCION = "18";
    public static String TIPO_CLASE_LICENCIA = "19";
    public static String TIPO_CATEGORIA_LICENCIA = "20";
    public static String TIPO_PAGO_ESPECIALISTAS = "21";
    public static String TIPO_VAR_PERSONAL = "22";
    public static String TIPO_AREA_TRABAJO = "23";
    public static String TIPO_PROFESION = "24";
    public static String TIPO_MODALIDAD_CONTRATACION = "25";
    public static String TIPO_MODALIDAD_OPERATIVO = "26";
    public static String TIPO_ESTADO_OPERATIVO = "27";
    public static String TIPO_VAR_HIST_PAC = "28";
    public static String TIPO_CARGO = "29";
    public static String TIPO_MARCA_PROCESO = "30";
    public static String TIPO_VAR_EXTRAS = "31";
    public static String TIPO_PARENTESCO = "32";
    public static String TIPO_NIVEL_ESTUDIOS = "33";
    public static String TIPO_CONDICION_LABORAL = "34";
    public static String TIPO_DEN_MON_SOLES = "35";
    public static String TIPO_DEN_MON_DOLARES = "36";
    public static String TIPO_CONDICION_SITUACIONAL = "37";
    public static String TIPO_GRADO_JERARQUICO = "38";
    public static String TIPO_MOTIVO_ANULACION = "39";
    public static String TIPO_MOTIVO_EXTORNACION = "40";
    public static String TIPO_VAR_SHARED_ROUTE = "41";
    public static String TIPO_TIPO_DIAGNOSTICO = "42";
    public static String TIPO_IGV = "43";
    public static String TIPO_GRUPO_ESPECIALIDAD = "44";
    public static String TIPO_ESTADO_USUARIO = "45";
    public static String TIPO_ESTADO_SERVICIO = "46";
    public static String TIPO_LUGAR_SERVICIO = "47";
    public static String TIPO_SINTOMA_SERVICIO = "48";
    public static String TIPO_PROBLEMA_SERVICIO = "49";
    public static String TIPO_SOLUCION_SERVICIO = "50";
    public static String TIPO_MOTIVO_CANCELACION_SERVICIO = "51";
    public static String TIPO_ESTADO_REPARACION = "52";
    
    public static String descripcionTipo(List<TablaTipo> lista, String tabla, String tipo) {
        if (lista != null && tipo != null) {
            for (TablaTipo t : lista) {
                if (t.getDtabla().equals(tabla) && t.getDtipo().equals(tipo)) {
                    return t.getDdescripcion();
                }
            }
        }
        return tipo;
    }

    public static List<TablaTipo> listaTipos(List<TablaTipo> lista, String tabla) {
        List<TablaTipo> l = new ArrayList();
        for (TablaTipo t : lista) {
            if (t.getDtabla().equals(tabla)) {
                l.add(t);
            }
        }
        return l;
    }
}
