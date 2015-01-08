/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.dao;

import com.eidetech.model.domain.entity.Serie;
import com.eidetech.model.domain.entity.Talon;
import com.eidetech.model.domain.entity.UsuarioPersonal;
import java.util.List;

/**
 *
 * @author usuario-xp
 */
public interface ITalonDao {

    public boolean agregarTalon(Talon talon);

    public boolean actualizarTalon(Talon talon);

    public Talon obtenerTalon(Talon talon);

    public List<Talon> obtenerTodoTalon();

    public List<Talon> obtenerTodoTalonSerie(Serie serie);

    public List<Talon> obtenerTodoTalonUsuario(UsuarioPersonal usuario);
}
