/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.dao;

import com.eidetech.model.domain.entity.Persona;
import java.util.List;

/**
 *
 * @author laptop-w8
 */
public interface IPersonaDao {

    public static final String PRE_PERSONA = "PER";

    public boolean agregarPersona(Persona persona);

    public boolean actualizarPersona(Persona persona);
    
    public boolean existePersona(Persona persona);

    public Persona obtenerPersona(Persona persona);

    public List<Persona> obtenerTodoPersona();

    public boolean agregarListaPersona(List<Persona> lista);
}
