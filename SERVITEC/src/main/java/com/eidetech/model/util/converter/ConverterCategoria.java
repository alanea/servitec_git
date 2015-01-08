/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.util.converter;

import com.eidetech.model.domain.entity.Categoria;
import com.eidetech.model.domain.entity.Producto;
import com.eidetech.model.util.UtilCadena;
import com.eidetech.model.util.UtilLista;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author laptop-w8
 */
public class ConverterCategoria {

    public static List<Categoria> obtenerCategorias(String nombreArchivo) {
        List<Categoria> l = new ArrayList();
        List<CategoriaProductoTemp> ltemp = obtenerDatosCSV(nombreArchivo);
        if (ltemp != null && !ltemp.isEmpty()) {
            for (CategoriaProductoTemp u1 : ltemp) {
                Categoria c = new Categoria();
                c.setDnombre(u1.getDcategoria());
                c.setDuserCreacion("admin");
                c.setFuserCreacion(new Date());
                if (!l.contains(c)) {
                    c.setProductos(new HashSet());
                    l.add(c);
                }
            }
            
            for(CategoriaProductoTemp u1 : ltemp){
                Categoria c1=new Categoria();
                c1.setDnombre(u1.getDcategoria());
                int index=l.indexOf(c1);
                if(index!=-1){
                    Categoria c=l.get(index);
                    Producto p=new Producto();
                    p.setId_producto(u1.getDcodigoproducto());
                    p.setDdescripcion(u1.getDdescripcion());
                    p.setDmarca(u1.getDmarca());
                    p.setCategoria(c);
                    c.getProductos().add(p);
                }
            }
        }
        
        
        return l;
    }

    private static List<CategoriaProductoTemp> obtenerDatosCSV(String nombreArchivo) {
        List<CategoriaProductoTemp> l = new ArrayList();
        List<String> ls = UtilLista.arrayStringArchivo(nombreArchivo);
        StringTokenizer lineaToken;
        String linea;

        if (ls != null && !ls.isEmpty()) {
            for (String s : ls) {
                linea = s;
                if (linea != null && linea.length() > 0) {
                    lineaToken = new StringTokenizer(UtilCadena.tokenDepurado(linea,"\"", ","), "\"");

                    if (lineaToken.countTokens() == 9) {
                        // ,CODIGO,ACCESORIOS,STOCK,PREC DISTRIB US $,PREC S/.,FLETE ,GARAN,MARCA
                        String tk01 = lineaToken.nextToken();
                        String tk02 = lineaToken.nextToken();
                        String tk03 = lineaToken.nextToken();
                        String tk04 = lineaToken.nextToken();
                        String tk05 = lineaToken.nextToken();
                        String tk06 = lineaToken.nextToken();
                        String tk07 = lineaToken.nextToken();
                        String tk08 = lineaToken.nextToken();
                        String tk09 = lineaToken.nextToken();

                        if (tokenValido(tk01) && tokenValido(tk02) && tokenValido(tk03) && tokenValido(tk09)) {
                            CategoriaProductoTemp cpt = new CategoriaProductoTemp();
                            cpt.setDcategoria(tk01);
                            cpt.setDcodigoproducto(tk02);
                            cpt.setDdescripcion(tk03);
                            cpt.setDmarca(tk09);
                            l.add(cpt);
                        } else {
                            System.out.println("linea no valida1: " + linea);
                        }
                    } else {
                        System.out.println("linea no valida2: " + linea);
                        System.out.println("numero de tokens:" + lineaToken.countTokens());
                        int i = 1;
                        while (lineaToken.hasMoreTokens()) {
                            System.out.println("token[" + i + "]=" + lineaToken.nextToken());
                            i++;
                        }
                    }
                }
            }
        }
        return l;
    }

    private static boolean tokenValido(String token) {
        return UtilCadena.cadenaValido(token);
    }
}
