/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.util;

import java.util.StringTokenizer;

/**
 *
 * @author laptop-w8
 */
public class UtilCadena {

    public static boolean cadenaValido(String cadena) {
        return cadena != null && !cadena.equals("") && !cadena.equals(" ");
    }

    public static String[] nombres(String token) {
        String[] s = new String[3];
        String nombre, apellido_paterno, apellido_materno;
        StringTokenizer st = new StringTokenizer(token, " ");

        apellido_paterno = st.nextToken();

        if (apellido_paterno.equals("De")) {
            String d = st.nextToken();
            if (d.equals("la")) {
                apellido_paterno += " " + d;
                d = st.nextToken();
            }
            apellido_paterno += " " + d;
        }

        if (apellido_paterno.equals("Cam")) {
            String d = st.nextToken();
            apellido_paterno += " " + d;
        }

        apellido_materno = st.nextToken();
        nombre = st.nextToken();
        while (st.hasMoreTokens()) {
            nombre = nombre + " " + st.nextToken();
        }

        s[0] = apellido_paterno;
        s[1] = apellido_materno;
        s[2] = nombre;

        return s;
    }

    public static void mostrarToken(String token, String delimitador) {
        if (token != null && delimitador != null && token.length() > 0) {
            StringTokenizer lineaToken = new StringTokenizer(token, delimitador);
            int i = 0;
            while (lineaToken.hasMoreTokens()) {
                System.out.println("token[" + i + "]=" + lineaToken.nextToken());
                i++;
            }
        }
    }

//    public static String tokenDepurado(String token1, String delimitador) {
//        String token=token1;
//
//        token = token.replaceAll(", ,", ",,");
//        token = token.replace(',', ';');
//        token = token.replaceAll("; ", ", ");
//
//        String comilla = "\"";
//        String anterior = "";
//        String nuevaLinea = "";
//        String linea = token;
//        if (linea.length() > 0) {
//            linea = linea.replaceAll("\"", "");
//
//            String s = linea.charAt(0) + "";
//            if (s.equals(delimitador)) {
//                linea = " " + linea;
//            }
//            String s1 = linea.charAt(linea.length() - 1) + "";
//            if (s1.equals(delimitador)) {
//                linea = linea + " ";
//            }
//
//            linea = linea.replaceAll(delimitador + delimitador, delimitador + " " + delimitador);
//            linea = linea.replaceAll(delimitador + delimitador, delimitador + " " + delimitador);
//
//        }
//
//        StringTokenizer lineaToken = new StringTokenizer(linea, delimitador);
//        while (lineaToken.hasMoreElements()) {
//            String actual = lineaToken.nextToken();
////            System.out.println("actual=" + actual + "<>anterior=" + anterior);
//            if (anterior.length() < 1 && actual.length() > 0) {
//                anterior = actual;
//                nuevaLinea += actual + delimitador;
//            } else {
//
//                if (anterior.subSequence(0, 1).equals(comilla)) {
//                    if (actual.subSequence(actual.length() - 1, actual.length()).equals(comilla)) {
//                        if (UtilNumero.isEntero(actual) && UtilNumero.isEntero(anterior)) {
//                            nuevaLinea = nuevaLinea.substring(0, nuevaLinea.length() - 1);
//                            nuevaLinea += ",";
//                        }
//                        nuevaLinea += actual + delimitador;
//                        anterior = "";
//                    } else {
//                        anterior += actual;
//                        nuevaLinea += actual + ",";
//                    }
//                } else {
//                    if (actual.subSequence(0, 1).equals(comilla)) {
//                        if (actual.subSequence(actual.length() - 1, actual.length()).equals(comilla)) {
//                            nuevaLinea += actual + delimitador;
//                            anterior = "";
//                        } else {
//                            nuevaLinea += actual + ",";
//                            anterior = actual;
//                        }
//                    } else {
//                        nuevaLinea += actual + delimitador;
//                        anterior = "";
//                    }
//                }
//            }
//
//        }
//
//        if (nuevaLinea.subSequence(nuevaLinea.length() - 1, nuevaLinea.length()).equals(delimitador)) {
//            nuevaLinea = nuevaLinea.substring(0, nuevaLinea.length() - 1);
//        }
//
//        return nuevaLinea;
//    }
    public static String tokenDepurado(String token1, String delimitador) {

        String token = token1;

        token = token.replaceAll(", ,", ",,");
        token = token.replace(',', ';');
        token = token.replaceAll("; ", ", ");
        String linea = token; //"9,789,,89879,,h,"

        if (linea != null && linea.length() > 0) {
            linea = linea.replaceAll("\"", "");

            String s = linea.charAt(0) + "";
            if (s.equals(delimitador)) {
                linea = " " + linea;
            }
            String s1 = linea.charAt(linea.length() - 1) + "";
            if (s1.equals(delimitador)) {
                linea = linea + " ";
            }

            linea = linea.replaceAll(delimitador + delimitador, delimitador + " " + delimitador);
            linea = linea.replaceAll(delimitador + delimitador, delimitador + " " + delimitador);

        }
        return linea;
    }

    public static String tokenDepurado(String token, String delimitador, String separador) {
        if (token != null && token.length() > 0) {

            String s = token.charAt(0) + "";
            if (s.equals(separador)) {
                token = " " + token;
            }
            String s1 = token.charAt(token.length() - 1) + "";
            if (s1.equals(separador)) {
                token = token + " ";
            }

            token = token.replaceAll(separador + separador, separador + " " + separador);
            token = token.replaceAll(separador + separador, separador + " " + separador);

        }
//        System.out.println("linea::::" + token);
        String resultado = "";

        StringTokenizer lineaToken = new StringTokenizer(token, delimitador);
//        System.out.println("numero de tokens:" + lineaToken.countTokens());
        int numeroTokens = lineaToken.countTokens();
        int i = 1;
        if (numeroTokens == 1) {
            String s = lineaToken.nextToken();
            s = s.replaceAll(separador + separador, separador + " " + separador);
            s = s.replaceAll(separador + separador, separador + " " + separador);
            StringTokenizer lineaToken1 = new StringTokenizer(s, separador);
            while (lineaToken1.hasMoreTokens()) {
                String r = lineaToken1.nextToken();
//                System.out.println(";token[" + i + "]=" + r);
                resultado += "\"" + r + "\"";
                i++;
            }
        } else {
            if (numeroTokens > 1) {
                while (lineaToken.hasMoreTokens()) {
                    String s = lineaToken.nextToken();
                    if (i == 1) {
//                System.out.println("ultima=" + (s.substring(s.length() - 1, s.length()) + ""));
                        if (!(s.substring(s.length() - 1, s.length())).equals(separador)) {
                            resultado += "\"" + s + "\"";
//                            System.out.println("token[" + i + "]=" + s);
                            i++;
                        } else {
                            s = s.replaceAll(separador + separador, separador + " " + separador);
                            s = s.replaceAll(separador + separador, separador + " " + separador);
                            StringTokenizer lineaToken1 = new StringTokenizer(s, separador);
                            while (lineaToken1.hasMoreTokens()) {
                                String r = lineaToken1.nextToken();
//                                System.out.println(";token[" + i + "]=" + r);
                                resultado += "\"" + r + "\"";
                                i++;
                            }
                        }
                        if (lineaToken.hasMoreTokens()) {
                            s = lineaToken.nextToken();
                        }
                    }

                    if (numeroTokens > 1) {
                        if (!s.startsWith(separador)) {
//                    System.out.println("token[" + i + "]=" + s);
                            resultado += "\"" + s + "\"";
                            i++;
                        } else {
                            s = s.replaceAll(separador + separador, separador + " " + separador);
                            s = s.replaceAll(separador + separador, separador + " " + separador);
                            StringTokenizer lineaToken1 = new StringTokenizer(s, separador);
                            while (lineaToken1.hasMoreTokens()) {
                                String t = lineaToken1.nextToken();
//                        System.out.println(";token[" + i + "]=" + t);
                                resultado += "\"" + t + "\"";
                                i++;
                            }
                        }
                    }
                }
            }
        }

        return resultado;
    }

}
