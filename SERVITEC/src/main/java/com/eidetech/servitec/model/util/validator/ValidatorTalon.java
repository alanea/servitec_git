/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.util.validator;

import com.eidetech.servitec.model.domain.entity.Talon;
import java.util.List;

/**
 *
 * @author laptop-w8
 */
public class ValidatorTalon {

    public static Talon talonValidado(Talon talon) {

        return talon;
    }

    public static boolean talonPosible(Talon talon, List<Talon> talones) {
        for (Talon t : talones) {
            if (!interseccionVacia(talon, t)) {
//                System.out.println("ini="+t.getNinicial()+";fin="+t.getNfin());
                return false;
            }
        }
        return true;
    }

    public static boolean interseccionVacia(Talon nuevo, Talon n) {
        int nini, nfin, xini, xfin;

        xini = nuevo.getNinicial();
        xfin = nuevo.getNfin();
        if (n.getDestado().equals("0")) {
            nini = n.getNinicial();
            nfin = n.getNcontadoractual();
        } else {
            nini = n.getNinicial();
            nfin = n.getNfin()+1;
        }

        return (nfin <= xini && nfin <= xfin)
                || (nini >= xfin && nini >= xini);
    }
}
