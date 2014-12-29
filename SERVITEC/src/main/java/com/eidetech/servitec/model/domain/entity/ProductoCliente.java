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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author laptop-w8
 */
@Entity
@Table(name = "tp_producto_cliente", schema = "public")
@Proxy(lazy = false)
public class ProductoCliente implements Serializable {

    @Id
    @Column(name = "id_prodcli")
    private String id_producto_cliente;
    @Column(name = "dctg_prodcli")
    private String dcategoria;
    @Column(name = "dprod_prodcli")
    private String dproducto;
    @Column(name = "dmc_prodcli")
    private String dmarca;
    @Column(name = "dmdl_prodcli")
    private String dmodelo;
    @Column(name = "dserie_prodcli")
    private String dserie;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cli", referencedColumnName = "id_cli")
    private Cliente cliente;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "producto")
    private Set<HistorialProductoCliente> historiales;

    @Override
    public boolean equals(Object obj) {
        if (obj != null) {
            if (obj instanceof ProductoCliente) {
                ProductoCliente p = (ProductoCliente) obj;
                if (this.getId_producto_cliente().toUpperCase().equals(p.getId_producto_cliente().toUpperCase())) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getId_producto_cliente() {
        return id_producto_cliente;
    }

    public void setId_producto_cliente(String id_producto_cliente) {
        this.id_producto_cliente = id_producto_cliente;
    }

    public String getDcategoria() {
        return dcategoria;
    }

    public void setDcategoria(String dcategoria) {
        this.dcategoria = dcategoria;
    }

    public String getDproducto() {
        return dproducto;
    }

    public void setDproducto(String dproducto) {
        this.dproducto = dproducto;
    }

    public String getDmarca() {
        return dmarca;
    }

    public void setDmarca(String dmarca) {
        this.dmarca = dmarca;
    }

    public String getDmodelo() {
        return dmodelo;
    }

    public void setDmodelo(String dmodelo) {
        this.dmodelo = dmodelo;
    }

    public String getDserie() {
        return dserie;
    }

    public void setDserie(String dserie) {
        this.dserie = dserie;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<HistorialProductoCliente> getHistoriales() {
        return historiales;
    }

    public void setHistoriales(Set<HistorialProductoCliente> historiales) {
        this.historiales = historiales;
    }

}
