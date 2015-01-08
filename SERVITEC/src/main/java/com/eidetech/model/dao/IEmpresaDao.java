/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.dao;

import com.eidetech.model.domain.entity.Empresa;
import java.util.List;

/**
 *
 * @author usuario-xp
 */
public interface IEmpresaDao{

    public boolean agregarEmpresa(Empresa empresa);
    public Empresa obtenerEmpresa(Empresa empresa);
    public boolean actualizarEmpresa(Empresa empresa);
    public List<Empresa> obtenerListaEmpresa();
}
