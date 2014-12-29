/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.servitec.model.util.converter;

import com.eidetech.servitec.model.domain.entity.Categoria;
import com.eidetech.servitec.model.domain.entity.Producto;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author laptop-w8
 */
public class ConverterCategoriaTest {
    
    @Ignore
    @Test
    public void testObtenerCategorias() {
        System.out.println("obtenerCategorias");
        String nombreArchivo = "/home/laptop-w8/Escritorio/Enlace hacia laptop-w8/Google Drive/STAQ/ServiTec/DATA/DCW_20141104100432_1.csv";
        List<Categoria> result = ConverterCategoria.obtenerCategorias(nombreArchivo);
        assertNotNull(result);
        
        for(Categoria c:result){
            System.out.println(c.getDnombre());
            for(Producto p:c.getProductos()){
                System.out.println("producto:"+p.getId_producto());
            }
        }
    }
    
}
