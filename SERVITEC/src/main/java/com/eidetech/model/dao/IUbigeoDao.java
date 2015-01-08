/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.dao;

import com.eidetech.model.domain.entity.UbigeoDepartamento;
import java.util.List;

/**
 *
 * @author usuario-xp
 */
public interface IUbigeoDao {

    public boolean agregarDepartamento(UbigeoDepartamento departamento);

    public boolean agregarTodoDepartamento(List<UbigeoDepartamento> lista);

    public List<UbigeoDepartamento> obtenerTodoDepartamento();
}
