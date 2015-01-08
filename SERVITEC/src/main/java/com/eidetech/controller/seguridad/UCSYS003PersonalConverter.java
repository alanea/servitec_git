/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.controller.seguridad;

import com.eidetech.model.domain.entity.Personal;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author laptop-w8
 */
@FacesConverter(value = "uCSYS003PersonalConverter")
public class UCSYS003PersonalConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.equals("")) {
            return null;
        }
        UCSYS003RegistrarUsuarioPersonalBean cpc = (UCSYS003RegistrarUsuarioPersonalBean) fc.getELContext().getELResolver().getValue(
                fc.getELContext(), null, "registrarUsuarioPersonal");
        return (Personal) cpc.getHmPersonas().get(string);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null) {
            return "";
        }
        if (o instanceof Personal) {
            Personal a = (Personal) o;
            return a.getId_personal();
        } else {
            return "";
        }
    }
}