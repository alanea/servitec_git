/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.util;

import com.eidetech.model.domain.entity.UbigeoDepartamento;
import com.eidetech.model.domain.entity.UbigeoDistrito;
import com.eidetech.model.domain.entity.UbigeoProvincia;
import java.util.List;

/**
 *
 * @author usuario-laptop
 */
public class UtilUbigeo {

    public static UbigeoDepartamento obtenerDepartamento(List<UbigeoDepartamento> l, String clave) {
        if (l != null && clave != null) {
            for (UbigeoDepartamento u : l) {
                if (u.getDcodigo().equals(clave)) {
                    return u;
                }
            }
        }
        return null;
    }

    public static UbigeoProvincia obtenerProvincia(List<UbigeoProvincia> l, String clave) {
        if (l != null && clave != null) {
            for (UbigeoProvincia u : l) {
                if (u.getDcodigo().equals(clave)) {
                    return u;
                }
            }
        }
        return null;
    }

    public static UbigeoDistrito obtenerDistrito(List<UbigeoDistrito> l, String clave) {
        if (l != null && clave != null) {
            for (UbigeoDistrito u : l) {
                if (u.getDcodigo().equals(clave)) {
                    return u;
                }
            }
        }
        return null;
    }

    public static List<UbigeoDistrito> listaDistrito(List<UbigeoDepartamento> ubigeoDepartamentos, String clave) {

        UbigeoDepartamento udep = UtilUbigeo.obtenerDepartamento(ubigeoDepartamentos, valorUbigeoDepartamento(clave));
        if (udep != null) {
            List<UbigeoProvincia> ubigeoProvincias = udep.getListaProvincias();
            if (ubigeoProvincias != null) {
                UbigeoProvincia upr = UtilUbigeo.obtenerProvincia(ubigeoProvincias, valorUbigeoProvincia(clave));
                if (upr != null) {
                    List<UbigeoDistrito> ubigeoDistritos = upr.getListaDistritos();
                    if (ubigeoDistritos != null) {
                        return ubigeoDistritos;
                    }
                }
            }
        }

        return null;
    }

    public static String ubigeoDistrito(List<UbigeoDistrito> l, String nombreDistrito) {
        String d = nombreDistrito.toUpperCase();
        if (l != null && d != null) {
            for (UbigeoDistrito u : l) {
                if (u.getDnombre().equals(d)) {
                    return u.getDcodigo();
                }
            }
        }
        return "";
    }

    public static String descripcionDepartamento(List<UbigeoDepartamento> ubigeoDepartamentos, String id_ubigeo) {
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

    public static String descripcionProvincia(List<UbigeoDepartamento> ubigeoDepartamentos, String id_ubigeo) {
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

    public static String descripcionDistrito(List<UbigeoDepartamento> ubigeoDepartamentos, String id_ubigeo) {
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

    public static String valorUbigeoDepartamento(String valor) {
        if (valor != null && valor.length() >= 2) {
            return valor.substring(0, 2);
        }
        return "";
    }

    public static String valorUbigeoProvincia(String valor) {
        if (valor != null && valor.length() >= 4) {
            return valor.substring(0, 4);
        }
        return "";
    }

    public static boolean esValidoUbigeo(String ubigeo) {
        return UtilCadena.cadenaValido(ubigeo) && ubigeo.length() == 6;
    }

}
