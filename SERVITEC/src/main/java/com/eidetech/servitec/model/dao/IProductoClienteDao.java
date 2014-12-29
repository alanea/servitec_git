/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.dao;

import com.eidetech.servitec.model.domain.entity.Cliente;
import com.eidetech.servitec.model.domain.entity.HistorialProductoCliente;
import com.eidetech.servitec.model.domain.entity.ProductoCliente;
import java.util.List;

/**
 *
 * @author laptop-w8
 */
public interface IProductoClienteDao {

    public boolean agregarProducto(ProductoCliente productoCliente);

    public boolean actualizarProducto(ProductoCliente productoCliente);

    public List<ProductoCliente> obtenerListaProducto(Cliente cliente);

    public boolean agregarHistorialProducto(HistorialProductoCliente historialProductoCliente);

    public boolean actualizarHistorialProducto(HistorialProductoCliente historialProductoCliente);
}
