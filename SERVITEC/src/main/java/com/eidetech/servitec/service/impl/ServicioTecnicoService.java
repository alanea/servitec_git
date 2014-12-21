/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.servitec.service.impl;

import com.eidetech.servitec.service.IServicioTecnicoService;
import java.io.Serializable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author laptop-w8
 */
@Service("servicioTecnicoService")
@Transactional(readOnly = true)
public class ServicioTecnicoService implements IServicioTecnicoService,Serializable{
    
}
