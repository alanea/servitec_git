/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.dao;

import com.eidetech.servitec.model.domain.entity.Empresa;

/**
 *
 * @author usuario-xp
 */
public interface IEmpresaDao{

    public boolean agregarEmpresa(Empresa empresa);
    public Empresa obtenerEmpresa(Empresa empresa);
}
