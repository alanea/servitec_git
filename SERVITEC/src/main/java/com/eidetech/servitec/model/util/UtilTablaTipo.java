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
    
    public static String TIPO_GRADO_INSTRUCCION = "18";
    public static String TIPO_CARGO = "29";
    public static String TIPO_AREA_TRABAJO = "23";
    public static String TIPO_MODALIDAD_CONTRATACION = "25";
    public static String TIPO_PROFESION = "24";
    public static String TIPO_COLEGIO = "1";
    public static String TIPO_ESTADO_CIVIL = "15";
    public static String TIPO_ESTADO_REGISTRO = "3";    
    public static String TIPO_SEXO = "13";
    public static String TIPO_IGV = "43";
    public static String TIPO_DOC_VENTA= "10";
    public static String TIPO_MONEDA= "11";
    public static String TIPO_CONTRATO= "2";
    public static String TIPO_GRUPO_ESPECIALIDAD= "44";
    public static String TIPO_PRODUCTO= "5";
    public static String TIPO_SUBPRODUCTO= "6";
    public static String TIPO_INSTITUCION= "4";
    public static String TIPO_FORMA_PAGO= "12";

    public static String descripcionTipo(List<TablaTipo> lista, String tabla, String tipo) {
        if (tipo != null) {
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
