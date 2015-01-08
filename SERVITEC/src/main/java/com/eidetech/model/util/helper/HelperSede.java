/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.model.util.helper;

import com.eidetech.model.domain.entity.Sede;

/**
 *
 * @author laptop-w8
 */
public class HelperSede {
    
    public static Sede copiarSede(Sede sede) {
        Sede s = new Sede();
        s.setId_sede(sede.getId_sede());
        s.setDcelular(sede.getDcelular());
        s.setDdireccion(sede.getDdireccion());
        s.setDemail(sede.getDemail());
        s.setDestado(sede.getDestado());
        s.setDfacebook(sede.getDfacebook());
        s.setDfijo(sede.getDfijo());
        s.setDnombre(sede.getDnombre());
        s.setDtwitter(sede.getDtwitter());
        s.setDubigeo(sede.getDubigeo());
        s.setDuserCreacion(sede.getDuserCreacion());
        s.setDuserModificacion(sede.getDuserCreacion());
        s.setDweb(sede.getDweb());
        s.setFcese(sede.getFcese());
        s.setFinicio(sede.getFinicio());
        s.setFuserCreacion(sede.getFuserCreacion());
        s.setFuserModificacion(sede.getFuserModificacion());
        s.setSeries(sede.getSeries());
        s.setUsuarios(sede.getUsuarios());
        return s;
    }
}
