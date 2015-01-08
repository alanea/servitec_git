/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.controller.seguridad;

import com.eidetech.model.domain.entity.Permiso;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author laptop-w8
 */
@FacesConverter(value = "uCSYS003PermisoPersonalConverter2")
public class UCSYS003PermisoPersonalConverter2 implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.equals("")) {
            return null;
        }
        UCSYS003RegistrarUsuarioPersonalBean cpc = (UCSYS003RegistrarUsuarioPersonalBean) fc.getELContext().getELResolver().getValue(
                fc.getELContext(), null, "registrarUsuarioPersonal");
        return (Permiso) cpc.getHmPermisoPersonal().get(string);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null) {
            return "";
        }
        if (o instanceof Permiso) {
            Permiso a = (Permiso) o;
            return a.getDurl();
        } else {
            return "";

        }
    }
}
