/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.dao;

import com.eidetech.model.domain.ParametroVentaDetallada;
import com.eidetech.model.domain.entity.Comprobante;
import com.eidetech.model.domain.entity.ComprobanteDetalle;
import java.util.List;

/**
 *
 * @author usuario-xp
 */
public interface IComprobanteDao {

    public boolean agregarComprobante(Comprobante comprobante);

    public Comprobante obtenerComprobante(Comprobante comprobante);

    public List<Comprobante> obtenerListaComprobante();

    public List<ComprobanteDetalle> obtenerListaComprobanteDetalles();

    public List<ComprobanteDetalle> obtenerListaComprobanteDetalladoVenta(ParametroVentaDetallada parametro);
}
