/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.dao;

import com.eidetech.model.domain.entity.Cliente;
import com.eidetech.model.domain.entity.HistorialProductoCliente;
import com.eidetech.model.domain.entity.ProductoCliente;
import com.eidetech.model.domain.entity.Reservacion;
import java.util.List;

/**
 *
 * @author laptop-w8
 */
public interface IProductoClienteDao {

    public boolean agregarProducto(ProductoCliente productoCliente);

    public boolean actualizarProducto(ProductoCliente productoCliente);
    
    public ProductoCliente obtenerProducto(Reservacion reservacion);

    public List<ProductoCliente> obtenerListaProducto(Cliente cliente);

    public boolean agregarHistorialProducto(HistorialProductoCliente historialProductoCliente);

    public boolean actualizarHistorialProducto(HistorialProductoCliente historialProductoCliente);
}
