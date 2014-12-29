/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.servitec.model.util;

import java.util.StringTokenizer;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author laptop-w8
 */
public class UtilCadenaTest {
    
    @Ignore
    @Test
    public void testTokenDepurado_3args() {
        System.out.println("tokenDepurado");
        String token ="\"accesorios, disp imagenes\",accn5484b001aa,kit de cambio de roller canon para dr-c125[@@@],1,39.20, ,,D,canon";
        String delimitador = "\"";
        String separador = ",";
        String result = UtilCadena.tokenDepurado(token, delimitador, separador);
        assertNotNull(result);
        System.out.println(result);
        
        StringTokenizer lineaToken = new StringTokenizer(result, delimitador);
        int i=1;
        while (lineaToken.hasMoreTokens()) {
            System.out.println("token["+i+"]="+lineaToken.nextToken());
            i++;
        }
    }
    
}
