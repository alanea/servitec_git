/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.servitec.model.domain.entity;

import java.io.Serializable;

/**
 *
 * @author usuario-xp
 */
public class SeriePK implements Serializable{
    protected String id_serie;
    protected String dtipo;

    public SeriePK() {
    }

    public SeriePK(String id_serie, String dtipo) {
        this.id_serie = id_serie;
        this.dtipo = dtipo;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof SeriePK){
            SeriePK s=(SeriePK)obj;
            return this.id_serie.equals(s.id_serie)&&this.dtipo.equals(s.dtipo);
        }else{
            return false;
        }
    }
    
    
}
