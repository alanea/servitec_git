/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.controller;

import com.eidetech.servitec.model.domain.entity.UbigeoDepartamento;
import com.eidetech.servitec.model.domain.entity.UbigeoDistrito;
import com.eidetech.servitec.model.domain.entity.UbigeoProvincia;
import com.eidetech.servitec.model.util.UtilCadena;
import com.eidetech.servitec.model.util.UtilUbigeo;
import com.eidetech.servitec.service.IPortalService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;

/**
 *
 * @author usuario-xp
 */
@ManagedBean(name = "ubigeo")
@ApplicationScoped
public class UbigeoBean implements Serializable {

    private List<UbigeoDepartamento> ubigeoDepartamentos;
    private List<SelectItem> siDepartamentos;
    @ManagedProperty(value = "#{portalService}")
    IPortalService portalService;

    public UbigeoBean() {
    }

    @PostConstruct
    public void init() {
        ubigeoDepartamentos = portalService.obtenerUbigeos();
        siDepartamentos = new ArrayList();
        for (UbigeoDepartamento k : ubigeoDepartamentos) {
            siDepartamentos.add(new SelectItem(k.getDcodigo(), k.getDnombre()));
        }
    }

    public List<SelectItem> siProvincias(String departamento) {
        List<SelectItem> si = new ArrayList(0);
        String depSeleccionado = departamento;
        if (depSeleccionado != null && !depSeleccionado.equals("")) {
            List<UbigeoProvincia> ubigeoProvincias = UtilUbigeo.obtenerDepartamento(ubigeoDepartamentos, depSeleccionado).getListaProvincias();
            for (UbigeoProvincia a1 : ubigeoProvincias) {
                si.add(new SelectItem(a1.getDcodigo(), a1.getDnombre()));
            }
        }
        return si;
    }

    public List<SelectItem> siDistritos(String departamento, String provincia) {
        List<SelectItem> si = new ArrayList();
        String depSeleccionado = departamento;
        String provSeleccionado = provincia;
        if (depSeleccionado != null && !depSeleccionado.equals("") && provSeleccionado != null && !provSeleccionado.equals("")) {
            List<UbigeoProvincia> ubigeoProvincias = UtilUbigeo.obtenerDepartamento(ubigeoDepartamentos, depSeleccionado).getListaProvincias();
            List<UbigeoDistrito> ubigeoDistritos = UtilUbigeo.obtenerProvincia(ubigeoProvincias, provSeleccionado).getListaDistritos();
            for (UbigeoDistrito a1 : ubigeoDistritos) {
                si.add(new SelectItem(a1.getDcodigo(), a1.getDnombre()));
            }
        }
        return si;
    }

    public String descripcionDepartamento(String id_ubigeo) {
        if (id_ubigeo != null && id_ubigeo.length() == 6) {
            UbigeoDepartamento u = UtilUbigeo.obtenerDepartamento(ubigeoDepartamentos, id_ubigeo.substring(0, 2));
            if (u == null) {
                return id_ubigeo;
            } else {
                return u.getDnombre();
            }
        } else {
            return id_ubigeo;
        }

    }

    public String descripcionProvincia(String id_ubigeo) {
        if (id_ubigeo != null && id_ubigeo.length() == 6) {
            UbigeoDepartamento u = UtilUbigeo.obtenerDepartamento(ubigeoDepartamentos, id_ubigeo.substring(0, 2));
            UbigeoProvincia u1 = UtilUbigeo.obtenerProvincia(u.getListaProvincias(), id_ubigeo.substring(0, 4));
            if (u1 == null) {
                return id_ubigeo;
            } else {
                return u1.getDnombre();
            }
        } else {
            return id_ubigeo;
        }
    }

    public String descripcionDistrito(String id_ubigeo) {
        if (id_ubigeo != null && id_ubigeo.length() == 6) {
            UbigeoDepartamento u = UtilUbigeo.obtenerDepartamento(ubigeoDepartamentos, id_ubigeo.substring(0, 2));
            UbigeoProvincia u1 = UtilUbigeo.obtenerProvincia(u.getListaProvincias(), id_ubigeo.substring(0, 4));
            UbigeoDistrito u2 = UtilUbigeo.obtenerDistrito(u1.getListaDistritos(), id_ubigeo);
            if (u2 == null) {
                return id_ubigeo;
            } else {
                return u2.getDnombre();
            }
        } else {
            return id_ubigeo;
        }

    }
    
    public String descripcionUbigeo(String ubigeo) {
        if (UtilCadena.cadenaValido(ubigeo) && ubigeo.length() == 6) {
            return descripcionDepartamento(ubigeo) + " / " + descripcionProvincia(ubigeo) + " / " + descripcionDistrito(ubigeo);
        }
        return "";
    }

    public List<UbigeoDepartamento> getUbigeoDepartamentos() {
        return ubigeoDepartamentos;
    }

    public List<SelectItem> getSiDepartamentos() {
        return siDepartamentos;
    }

    public IPortalService getPortalService() {
        return portalService;
    }

    public void setPortalService(IPortalService portalService) {
        this.portalService = portalService;
    }

}
