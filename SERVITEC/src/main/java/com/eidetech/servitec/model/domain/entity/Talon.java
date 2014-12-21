/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.servitec.model.domain.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author usuario-xp
 */

@Entity
@Table(name = "tp_talon", schema = "public")
@Proxy(lazy = false)
public class Talon implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_talon")
    private int id_talon;    
    @Column(name = "fcrea_talon")
    private Date fcreacion;
    @Column(name = "nini_talon")
    private int ninicial;
    @Column(name = "nfin_talon")
    private int nfin;
    @Column(name = "ncon_talon")
    private int ncontadoractual;
    @Column(name = "dest_talon")
    private String destado;
    @Column(name = "duser_talon")
    private String duser;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
        @JoinColumn(name="id_serie", referencedColumnName="id_serie"),
        @JoinColumn(name="dtip_serie", referencedColumnName="dtip_serie")
    })
    private Serie serie;
    
    public String toString(){
        return "Talon [id="+this.id_talon+", fecha="+this.fcreacion+", ini="+this.ninicial+", fin="+this.nfin+", ncon="+this.ncontadoractual+"]";
    }

    public int getId_talon() {
        return id_talon;
    }

    public void setId_talon(int id_talon) {
        this.id_talon = id_talon;
    }

    public Date getFcreacion() {
        return fcreacion;
    }

    public void setFcreacion(Date fcreacion) {
        this.fcreacion = fcreacion;
    }

    public int getNinicial() {
        return ninicial;
    }

    public void setNinicial(int ninicial) {
        this.ninicial = ninicial;
    }

    public int getNfin() {
        return nfin;
    }

    public void setNfin(int nfin) {
        this.nfin = nfin;
    }

    public int getNcontadoractual() {
        return ncontadoractual;
    }

    public void setNcontadoractual(int ncontadoractual) {
        this.ncontadoractual = ncontadoractual;
    }

    public String getDestado() {
        return destado;
    }

    public void setDestado(String destado) {
        this.destado = destado;
    }

    public String getDuser() {
        return duser;
    }

    public void setDuser(String duser) {
        this.duser = duser;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }
    
}
