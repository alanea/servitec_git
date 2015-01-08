/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.util.validator;

import com.eidetech.model.domain.ParametroReporte;
import com.eidetech.model.domain.Reporte;
import com.eidetech.model.util.UtilFecha;
import com.eidetech.model.util.UtilLista;

/**
 *
 * @author laptop-w8
 */
public class ValidatorReporte {

    public static boolean esValidoParametroReporte(ParametroReporte parametroReporte) {
        if (parametroReporte != null) {
            if (!UtilFecha.esValidoFecha(parametroReporte.getFecha_inicio())
                    || !UtilFecha.esValidoFecha(parametroReporte.getFecha_fin())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static boolean esValidoReporte(Reporte reporte) {
        if (reporte != null) {
            if (!UtilLista.esValidaLista(reporte.getResultados())) {
                return false;
            }
            return true;
        }
        return false;
    }
}
