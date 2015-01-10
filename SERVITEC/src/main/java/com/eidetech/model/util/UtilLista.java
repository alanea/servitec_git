/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author laptop-w8
 */
public class UtilLista {

    public static <T> boolean esValidaLista(List<T> l) {
        if (l != null) {
            return !l.isEmpty();
        }
        return false;
    }

    public static <T> boolean esValidoConjunto(Set<T> s) {
        if (s != null) {
            return !s.isEmpty();
        }
        return false;
    }

    public static List<String> cadenaDistintos(List<String> l) {
        List<String> k = new ArrayList();
        for (String p1 : l) {
            if (!k.contains(p1)) {
                k.add(p1);
            }
        }
        return k;
    }

    public static List<String> arrayStringIS(InputStream is) {
        List<String> l = new ArrayList();
        BufferedReader bufferEntrada;
        FileInputStream input;
        String linea;

        try {

//            input = new FileInputStream(rutaArchivo);
            bufferEntrada = new BufferedReader(new InputStreamReader(is));//, "utf-8"
            linea = bufferEntrada.readLine();//cabecera del archivo
            linea = bufferEntrada.readLine();

            while (linea != null && linea.length() > 0) {
                System.out.println("linea:" + linea);
                l.add(linea);
                linea = bufferEntrada.readLine();
            }

            bufferEntrada.close();
//            input.close();
        } catch (FileNotFoundException ex) {
//            System.out.println("Archivo " + rutaArchivo + " no encontrado");
        } catch (IOException ex) {
//            System.out.println("Error de E/S archivo " + rutaArchivo);
        }

        return l;
    }

    public static List<String> arrayStringArchivo(String rutaArchivo) {
        List<String> l = new ArrayList();
        BufferedReader bufferEntrada;
        FileInputStream input;
        String linea;

        try {

            input = new FileInputStream(rutaArchivo);
            bufferEntrada = new BufferedReader(new InputStreamReader(input, "utf-8"));//, "utf-8"
            linea = bufferEntrada.readLine();//cabecera del archivo
            linea = bufferEntrada.readLine();

            while (linea != null && linea.length() > 0) {
//                System.out.println("linea:" + linea);
                l.add(linea);
                linea = bufferEntrada.readLine();
            }

            bufferEntrada.close();
            input.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo " + rutaArchivo + " no encontrado");
        } catch (IOException ex) {
            System.out.println("Error de E/S archivo " + rutaArchivo);
        }

        return l;
    }

}
