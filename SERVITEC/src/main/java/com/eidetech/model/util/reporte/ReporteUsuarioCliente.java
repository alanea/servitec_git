/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.util.reporte;

import com.eidetech.model.domain.ParametroReporte;
import com.eidetech.model.domain.Reporte;
import com.eidetech.model.domain.ResultadoTempReporte;
import com.eidetech.model.util.UtilFecha;
import java.util.Date;
import java.util.List;

/**
 *
 * @author laptop-w8
 */
public class ReporteUsuarioCliente {
    
    public static Reporte obtenerReporteUsuarioDia(ParametroReporte parametroReporte, List<Date> lista) {
        Reporte r = new Reporte();
        Date fi = parametroReporte.getFecha_inicio();
        Date ff = parametroReporte.getFecha_fin();
        
        if (fi.before(ff)) {
            int n = UtilFecha.diferenciaDiasFecha(fi, ff);
            for (int i = 0; i <= n; i++) {
                Date d = UtilFecha.agregarNDiasFecha(fi, i);
                ResultadoTempReporte rtr = new ResultadoTempReporte();
                rtr.setObjeto(UtilFecha.formatoFecha(d, UtilFecha.FORMATO_YYYY_MM_DD));
                rtr.setValor(0);
                r.getResultados().add(rtr);
            }
            
            for (Date d : lista) {
                String fecha = UtilFecha.formatoFecha(d, UtilFecha.FORMATO_YYYY_MM_DD);                
                ResultadoTempReporte rtr = new ResultadoTempReporte();
                rtr.setObjeto(fecha);
                
                if (r.getResultados().contains(rtr)) {
                    int index = r.getResultados().indexOf(rtr);
                    ResultadoTempReporte rtr1 = r.getResultados().get(index);
                    rtr1.setValor(rtr1.getValor() + 1);
                }
            }
        }
        
        r.setDtitulo("Reporte diario de usuarios nuevos al sistema");
        r.setFinicio(parametroReporte.getFecha_inicio());
        r.setFfin(parametroReporte.getFecha_fin());
        return r;
    }
}
