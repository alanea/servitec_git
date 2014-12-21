/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.util;

/**
 *
 * @author laptop-w8
 */
public class UtilUsuario {

    public static final String USUARIO_JEFE_OCAA = "OCAA";
    public static final String USUARIO_JEFE_UB = "BIENESTAR";
    public static final String USUARIO_ADMIN = "ADMIN";
    public static final String CARPETA_USUARIO_JEFE_OCAA = "ocaa";
    public static final String CARPETA_USUARIO_JEFE_UB = "bienestar";
    public static final String CARPETA_USUARIO_ADMIN = "admin";
    public static final String CARPETA_USUARIO_EGRESADO = "egresado";
    public static final String CARPETA_USUARIO_EMPRESA = "empresa";
    public static final String INDEX_USUARIO_JEFE_OCAA = "ocaa/user.xhtml";
    public static final String INDEX_USUARIO_JEFE_UB = "bienestar/user.xhtml";
    public static final String INDEX_USUARIO_ADMIN = "admin/user.xhtml";

    public static String indexUsuario(String usuario) {
        switch (usuario) {
            case USUARIO_JEFE_OCAA:
                return INDEX_USUARIO_JEFE_OCAA;
            case USUARIO_JEFE_UB:
                return INDEX_USUARIO_JEFE_UB;
            case USUARIO_ADMIN:
                return INDEX_USUARIO_ADMIN;
            default:
                return "login.xhtml";
        }
    }
}
