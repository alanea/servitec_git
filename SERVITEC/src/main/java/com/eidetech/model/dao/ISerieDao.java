/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.dao;

import com.eidetech.model.domain.entity.Serie;
import java.util.List;

/**
 *
 * @author usuario-xp
 */
public interface ISerieDao{

    public boolean agregarSerie(Serie serie);

    public Serie obtenerSerie(Serie serie);

    public List<Serie> obtenerTodoSerie();
}
