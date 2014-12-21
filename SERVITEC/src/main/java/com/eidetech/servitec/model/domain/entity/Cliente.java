/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.domain.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author usuario-xp
 */
@Entity
@Table(name = "tp_cliente", schema = "public")
@Proxy(lazy = false)
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cli")
    private int id_cliente;
    @Column(name = "dtip_cli")
    private String dtipo;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
    private Set<Comprobante> comprobantes;    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
    private Set<Reservacion> reservaciones;

    public String toString() {
        return "cliente[id=" + this.id_cliente + ",dtipo=" + this.dtipo + "]";
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getDtipo() {
        return dtipo;
    }

    public void setDtipo(String dtipo) {
        this.dtipo = dtipo;
    }

    public Set<Comprobante> getComprobantes() {
        return comprobantes;
    }

    public void setComprobantes(Set<Comprobante> comprobantes) {
        this.comprobantes = comprobantes;
    }

    public Set<Reservacion> getReservaciones() {
        return reservaciones;
    }

    public void setReservaciones(Set<Reservacion> reservaciones) {
        this.reservaciones = reservaciones;
    }
}
