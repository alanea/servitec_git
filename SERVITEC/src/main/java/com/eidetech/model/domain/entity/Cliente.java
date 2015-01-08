/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.domain.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    @Column(name = "id_cli")
    private String id_cliente;
    @Column(name = "druc_cli")
    private String druc;
    @Column(name = "ddni_cli")
    private String ddni;
    @Column(name = "dtip_cli")
    private String dtipo;    
    @Column(name = "dnm_cli")
    private String dnombre;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
    private Set<Comprobante> comprobantes;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
    private Set<Reservacion> reservaciones;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
    private Set<ProductoCliente> productos;

    public void agregarReservacion(Reservacion reservacion) {
        if (reservaciones == null) {
            reservaciones = new HashSet();
        }
        reservaciones.add(reservacion);
    }

    public void agregarProductoCliente(ProductoCliente productoCliente) {
        if (productos == null) {
            productos = new HashSet();
        }
        productos.add(productoCliente);
    }

    public String toString() {
        return "cliente[id=" + this.id_cliente + ",dtipo=" + this.dtipo + "]";
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getDruc() {
        return druc;
    }

    public void setDruc(String druc) {
        this.druc = druc;
    }

    public String getDdni() {
        return ddni;
    }

    public void setDdni(String ddni) {
        this.ddni = ddni;
    }

    public String getDtipo() {
        return dtipo;
    }

    public void setDtipo(String dtipo) {
        this.dtipo = dtipo;
    }

    public String getDnombre() {
        return dnombre;
    }

    public void setDnombre(String dnombre) {
        this.dnombre = dnombre;
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

    public Set<ProductoCliente> getProductos() {
        return productos;
    }

    public void setProductos(Set<ProductoCliente> productos) {
        this.productos = productos;
    }
}
