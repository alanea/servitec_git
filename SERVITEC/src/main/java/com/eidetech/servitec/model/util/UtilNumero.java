/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author laptop-w8
 */
public class UtilNumero {

    public static float redondear(float numero, int digitos) {
        BigDecimal big = new BigDecimal(numero);
        big = big.setScale(digitos, RoundingMode.HALF_UP);
        return big.floatValue();
    }

    public static float getFloat(String s) {
        s = s.replaceAll(",", ".");
        return Float.parseFloat(s);
    }

    public static boolean isEntero(String s) {
        s = s.replaceAll("\"", "");
        boolean exito;
        try {
            exito = true;
            Integer n = Integer.parseInt(s);
        } catch (NumberFormatException ex) {
            exito = false;
        }
        return exito;
    }

    public static int getEntero(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int n;
        try {
            n = Integer.parseInt(s);
        } catch (NumberFormatException ex) {
            n = 0;
        }
        return n;
    }
}
