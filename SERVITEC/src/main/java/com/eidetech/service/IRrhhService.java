/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.service;

import com.eidetech.model.domain.entity.Personal;
import java.util.List;

/**
 *
 * @author laptop-w8
 */
public interface IRrhhService {

    public boolean registrarNuevoPersonal(Personal personal);

    public List<Personal> listaPersonal();

    public boolean modificarPersonal(Personal personal);
}
