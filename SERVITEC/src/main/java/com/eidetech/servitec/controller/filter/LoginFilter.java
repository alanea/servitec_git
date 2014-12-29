/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.controller.filter;

import com.eidetech.servitec.controller.acceso.UCSYS001LoginClienteBean;
import com.eidetech.servitec.controller.acceso.UCSYS001LoginPersonalBean;
import com.eidetech.servitec.model.domain.entity.Permiso;
import com.eidetech.servitec.model.domain.entity.PermisoCliente;
import com.eidetech.servitec.model.domain.entity.UsuarioCliente;
import com.eidetech.servitec.model.domain.entity.UsuarioPersonal;
import com.eidetech.servitec.model.util.UtilUsuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author laptop-w8
 */
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public LoginFilter() {
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

//        String url = "http://localhost:8084/Proyecto";
        // Obtengo el bean que representa el usuario desde el scope sesión
        UCSYS001LoginPersonalBean loginPersonal = (UCSYS001LoginPersonalBean) req.getSession().getAttribute("loginPersonal");
        UCSYS001LoginClienteBean loginCliente = (UCSYS001LoginClienteBean) req.getSession().getAttribute("loginCliente");

        boolean bLoginPersonal = loginPersonal != null && loginPersonal.isLogeado();
        boolean bLoginCliente = loginCliente != null && loginCliente.isLogeado();
        String url;

        //Proceso la URL que está requiriendo el cliente
        if (req.getServerPort() == 80) {
            url = req.getScheme() + "://" + req.getServerName() + req.getContextPath();
        } else {
            url = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath();
        }
        String urlStr = req.getRequestURL().toString();
        System.out.println(urlStr);
//        System.out.println(urlStr + " - desprotegido=[" + noProteger + "]");

        //Si no requiere protección continúo normalmente.
        if (noProteger(url, urlStr) && !bLoginPersonal && !bLoginCliente) {
            chain.doFilter(request, response);
            return;
        }

        //El usuario no está logueado
        if (!bLoginPersonal && !bLoginCliente) {
            res.sendRedirect(url + "/index.xhtml");
            return;
        }

        //El recurso requiere protección, pero el usuario ya está logueado.
        if (bLoginPersonal) {
            if (protegerPersonal(loginPersonal.getUsuario(), url, urlStr)) {
                chain.doFilter(request, response);
                return;
            } else {
                res.sendRedirect(req.getContextPath() + "/usuario.xhtml");
                return;
            }
        }
        if (bLoginCliente) {
            if (protegerCliente(loginCliente.getUsuario(), url, urlStr)) {
                chain.doFilter(request, response);
                return;
            } else {
                res.sendRedirect(req.getContextPath() + "/cliente.xhtml");
            }
        }
        chain.doFilter(request, response);
    }

    private boolean protegerPersonal(UsuarioPersonal personal, String url, String urlStr) {
        List<Permiso> permisos = UtilUsuario.listaPermisosPersonal(personal);
        for (Permiso p : permisos) {
            if (urlStr.startsWith(url + "/" + p.getDurl())) {
                return true;
            }
        }
        if (urlStr.startsWith(url + "/usuario.xhtml")) {
            return true;
        }
        return noProtegerRecursos(url, urlStr);
    }

    private boolean protegerCliente(UsuarioCliente cliente, String url, String urlStr) {
        List<PermisoCliente> permisos = UtilUsuario.listaPermisosCliente(cliente);
        for (PermisoCliente p : permisos) {
            if (urlStr.startsWith(url + "/" + p.getDurl())) {
                return true;
            }
        }        
        if (urlStr.startsWith(url + "/cliente.xhtml")) {
            return true;
        }
        return noProtegerRecursos(url, urlStr);
    }

    private boolean noProteger(String url, String urlStr) {

        /*
         * Este es un buen lugar para colocar y programar todos los patrones que
         * creamos convenientes para determinar cuales de los recursos no
         * requieren protección. Sin duda que habría que crear un mecanizmo tal
         * que se obtengan de un archivo de configuración o algo que no requiera
         * compilación.
         */
        if (urlStr.equals(url)) {
            return true;
        }
        if (urlStr.equals(url + "/")) {
            return true;
        }
        if (urlStr.startsWith(url + "/login.xhtml")) {
            return true;
        }
        if (urlStr.startsWith(url + "/login_2.xhtml")) {
            return true;
        }
        if (urlStr.startsWith(url + "/index.xhtml")) {
            return true;
        }
        if (urlStr.startsWith(url + "/registro.xhtml")) {
            return true;
        }
        if (urlStr.startsWith(url + "/acerca.xhtml")) {
            return true;
        }
        if (urlStr.startsWith(url + "/productos.xhtml")) {
            return true;
        }
        if (urlStr.startsWith(url + "/servicios.xhtml")) {
            return true;
        }
        if (urlStr.indexOf("/javax.faces.resource/") != -1) {
            return true;
        }
        if (urlStr.indexOf("/resources/") != -1) {
            return true;
        }
        return false;
    }

    public boolean noProtegerRecursos(String url, String urlStr) {
        if (urlStr.startsWith(url + "/file/")) {
            return true;
        }
        if (urlStr.indexOf("/javax.faces.resource/") != -1) {
            return true;
        }
        if (urlStr.indexOf("/resources/") != -1) {
            return true;
        }
        return false;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }
}
