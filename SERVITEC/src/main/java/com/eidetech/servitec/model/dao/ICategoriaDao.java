/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.dao;

import com.eidetech.servitec.model.domain.entity.Categoria;
import java.util.List;

/**
 *
 * @author usuario-xp
 */
public interface ICategoriaDao {

    public static final String PRE_ESPECIALIDAD = "CTG";

    public boolean agregarCategoria(Categoria categoria);

    public boolean agregarTodoCategoria(List<Categoria> lista);

    public boolean existeCategoria(Categoria categoria);

    public boolean actualizarCategoria(Categoria categoria);

    public Categoria obtenerCategoria(Categoria categoria);

    public List<Categoria> obtenerTodoCategoria();

}
