/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.dao;

import com.eidetech.servitec.model.domain.entity.Producto;
import java.util.List;

/**
 *
 * @author usuario-xp
 */
public interface IProductoDao {

    public static final String PRE_PRODUCTO = "PRO";

    public boolean agregarProducto(Producto producto);

    public boolean agregarTodoProducto(List<Producto> lista);

    public boolean existeProducto(Producto producto);

    public boolean actualizarProducto(Producto producto);

    public Producto obtenerProducto(Producto producto);

    public List<Producto> obtenerTodoProducto();

}
