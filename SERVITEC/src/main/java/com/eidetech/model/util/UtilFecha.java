/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author laptop-w8
 */
public class UtilFecha {

    public static final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día
    public static String FORMATO_YYYY_MM_DD = "YYYY-MM-dd";
    public static String FORMATO_DD_MM_YYYY = "dd/MM/YYYY";
    public static String FORMATO_HH_MM = "HH:mm";

    public static boolean esValidoFecha(Date f) {
        return f != null;
    }

    public static boolean esFechaMayorActual(Date f) {
        Date d = new Date();
        if (esValidoFecha(f)) {
            return d.before(f);
        }
        return false;
    }

    public static boolean esFechasIguales(Date f1, Date f2) {
        int d1, d2, m1, m2, a1, a2;
        d1 = f1.getDay();
        d2 = f2.getDay();
        m1 = f1.getMonth();
        m2 = f2.getMonth();
        a1 = f1.getYear();
        a2 = f2.getYear();
        return d1 == d2 && m1 == m2 && a1 == a2;
    }

    public static boolean esAnioIgual(Date f, String anio) {
        int n1 = f.getYear() + 1900;
        int n2 = Integer.parseInt(anio);
        return n1 == n2;
    }

    public static int anioFecha(Date f) {
        return f.getYear() + 1900;
    }

    public static int diferenciaMesesFecha(Date min, Date max) {
        double d = 0.0;
        if (min.before(max)) {
            d = (max.getTime() - min.getTime()) / (MILLSECS_PER_DAY * 30.0);
        }
        return (int) d;
    }

    public static int diferenciaDiasFecha(Date min, Date max) {
        double d = 0.0;
        if (min.before(max)) {
            d = (max.getTime() - min.getTime()) / (MILLSECS_PER_DAY);
        }
        return (int) d;
    }

    public static Date agregarNhorasFecha(Date d, int horas) {
        if (esValidoFecha(d)) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(d);
            calendar.add(Calendar.HOUR, horas);
            return calendar.getTime();
        }
        return d;
    }

    public static Date agregarNDiasFecha(Date d, int dias) {
        if (esValidoFecha(d)) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(d);
            calendar.add(Calendar.DATE, dias);
            return calendar.getTime();
        }
        return d;
    }

    public static Date agregarNMesesFecha(Date d, int meses) {
        if (esValidoFecha(d)) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(d);
            calendar.add(Calendar.MONTH, meses);
            return calendar.getTime();
        }
        return d;
    }

    public static Date obtenerPrimerDiaMes(Date d) {
        if (esValidoFecha(d)) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(d);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            return calendar.getTime();
        }
        return d;
    }

    public static Date obtenerFechaCvs(String s) {//16/01/2006 17:07
        Date d;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try {
            d = simpleDateFormat.parse(s);
        } catch (ParseException ex) {
            d = null;
        }
        return d;
    }

    public static Date obtenerFechaCvs2(String s) {//16/01/2006
        Date d;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            d = simpleDateFormat.parse(s);
        } catch (ParseException ex) {
            d = null;
        }
        return d;
    }

    public static String mostrarFecha(Date f) {
        if (f != null) {
            if (f instanceof Date) {
                return f.getDate() + "/" + (f.getMonth() + 1) + "/" + (f.getYear() + 1900);
            }
        }
        return "";
    }

    public static String mostrarDiferenciaMeses(Date f1, Date f2) {
        String salida = "";
        int ncantmeses, nanios, nmeses;
        ncantmeses = diferenciaMesesFecha(f1, f2);
        nanios = ncantmeses / 12;

        if (nanios == 0) {
            nmeses = ncantmeses;
            if (nmeses > 1) {
                salida += nmeses + " meses";
            } else {
                if (nmeses == 1) {
                    salida += nmeses + " mes";
                }
                salida += "";
            }
        } else {
            nmeses = ncantmeses - nanios * 12;
            if (nanios > 1) {
                salida += nanios + " años";
            } else {
                salida += nanios + " año";
            }
            if (nmeses > 1) {
                salida += " y " + nmeses + " meses";
            } else {
                if (nmeses == 1) {
                    salida += " y " + nmeses + " mes";
                }
                salida += "";
            }
        }

        return salida;
    }

    public static String formatoFecha(Date fecha) {
        if (UtilFecha.esValidoFecha(fecha)) {
            DateFormat df1 = DateFormat.getDateInstance(DateFormat.LONG);
            return df1.format(fecha);
        }
        return "";
    }

    public static String formatoFechaHora(Date fecha) {
        if (UtilFecha.esValidoFecha(fecha)) {
            DateFormat df1 = DateFormat.getDateInstance(DateFormat.LONG);
            SimpleDateFormat sdf1 = new SimpleDateFormat(FORMATO_HH_MM);
            return df1.format(fecha) + " " + sdf1.format(fecha);
        }
        return "";
    }

    public static String formatoFecha(Date fecha, String formato) {
        if (esValidoFecha(fecha)) {
            SimpleDateFormat sdf = new SimpleDateFormat(formato);
            return sdf.format(fecha);
        }
        return "";
    }

    public static String formatoFechaHora(Date fecha, String formato) {
        if (esValidoFecha(fecha)) {
            SimpleDateFormat sdf = new SimpleDateFormat(formato);
            SimpleDateFormat sdf1 = new SimpleDateFormat(FORMATO_HH_MM);
            return sdf.format(fecha) + " " + sdf1.format(fecha);
        }
        return "";
    }
}
