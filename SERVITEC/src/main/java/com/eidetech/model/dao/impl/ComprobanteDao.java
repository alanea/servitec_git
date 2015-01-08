/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.dao.impl;

import com.eidetech.model.dao.IComprobanteDao;
import com.eidetech.model.domain.ParametroVentaDetallada;
import com.eidetech.model.domain.entity.Comprobante;
import com.eidetech.model.domain.entity.ComprobanteDetalle;
import com.eidetech.model.util.UtilCadena;
import com.eidetech.model.util.UtilFecha;
import com.eidetech.model.util.UtilHibernate;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.TransactionException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 *
 * @author laptop-w8
 */
@Repository("ComprobanteDao")
public class ComprobanteDao implements IComprobanteDao, Serializable {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public boolean agregarComprobante(Comprobante comprobante) {
        return UtilHibernate.agregarEntidad(sessionFactory, comprobante);
    }
    
    @Override
    public Comprobante obtenerComprobante(Comprobante comprobante) {
        Comprobante c = null;
        Session session = sessionFactory.openSession();
        
        try {
            session.getTransaction().begin();
            Query q = session.createQuery("FROM Comprobante u WHERE u.dtipo= :tipo AND u.dserie= :serie AND u.nnumeroSerie= :numero");
            q.setParameter("tipo", comprobante.getDtipo());
            q.setParameter("serie", comprobante.getDserie());
            q.setParameter("numero", comprobante.getNnumeroSerie());
            c = (Comprobante) q.uniqueResult();
        } catch (ConstraintViolationException he) {
            System.out.println("excepcion01: " + he);
            session.getTransaction().rollback();
        } catch (TransactionException he) {
            System.out.println("excepcion02: " + he);
            session.getTransaction().rollback();
        } catch (HibernateException he) {
            System.out.println("excepcion03: " + he);
            session.getTransaction().rollback();
        } finally {
            session.getTransaction().commit();
            session.close();
        }
        return c;
    }
    
    @Override
    public List<Comprobante> obtenerListaComprobante() {
        return UtilHibernate.obtenerListaEntidades(sessionFactory, Comprobante.class);
    }
    
    @Override
    public List<ComprobanteDetalle> obtenerListaComprobanteDetalles() {
        return UtilHibernate.obtenerListaEntidades(sessionFactory, ComprobanteDetalle.class);
    }
    
    @Override
    public List<ComprobanteDetalle> obtenerListaComprobanteDetalladoVenta(ParametroVentaDetallada parametro) {
        List<ComprobanteDetalle> l = null;
        Session session = sessionFactory.openSession();
        
        String sql = "SELECT cd FROM ComprobanteDetalle cd"
                + " inner join fetch cd.producto as prod"
                + " inner join fetch prod.especialidad esp"
                + " inner join fetch cd.comprobante as comp"
                + " left outer join fetch comp.cliente ";
        String sql_where = " WHERE ";
        int i = 0;
        
        if (parametro != null) {
            if (UtilCadena.cadenaValido(parametro.getMoneda())) {
                i++;
                sql_where += " comp.dmoneda= :moneda";
            }
            if (UtilCadena.cadenaValido(parametro.getFormaPago())) {
                i++;
                if (i > 1) {
                    sql_where += " AND comp.dformaPago= :formapago";
                } else {
                    sql_where += " comp.dformaPago= :formapago";
                }
            }
            if (UtilCadena.cadenaValido(parametro.getComprobanteVenta())) {
                i++;
                if (i > 1) {
                    sql_where += " AND comp.dtipo= :comprobanteventa";
                } else {
                    sql_where += " comp.dtipo= :comprobanteventa";
                }
            }
            if (UtilCadena.cadenaValido(parametro.getEspecialidadVenta())) {
                i++;
                if (i > 1) {
                    sql_where += " AND esp.dnombre= :especialidadventa";
                } else {
                    sql_where += " esp.dnombre= :especialidadventa";
                }
            }
            if (UtilCadena.cadenaValido(parametro.getUsuarioFiltrado())) {
                i++;
                if (i > 1) {
                    sql_where += " AND comp.duserCreacion= :usuario";
                } else {
                    sql_where += " comp.duserCreacion= :usuario";
                }
            }
           if (UtilFecha.esValidoFecha(parametro.getFrom()) && UtilFecha.esValidoFecha(parametro.getTo())&& parametro.getFrom().before(parametro.getTo())) {
                i++;
                if (i > 1) {
                    sql_where += " AND comp.fuserCreacion> :desde AND comp.fuserCreacion< :hasta";
                } else {
                    sql_where += " comp.fuserCreacion> :desde AND comp.fuserCreacion< :hasta";
                }
            }
        }
        
        if (!sql_where.equals(" WHERE ")) {
            sql += sql_where;
        }
        System.out.println("consulta::::"+sql);
        
        try {
            session.getTransaction().begin();
            Query q = session.createQuery(sql);
            if (parametro != null) {
                if (UtilCadena.cadenaValido(parametro.getMoneda())) {
                    q.setParameter("moneda", parametro.getMoneda());
                }
                if (UtilCadena.cadenaValido(parametro.getFormaPago())) {
                    q.setParameter("formapago", parametro.getFormaPago());
                }
                if (UtilCadena.cadenaValido(parametro.getComprobanteVenta())) {
                    q.setParameter("comprobanteventa", parametro.getComprobanteVenta());
                }
                if (UtilCadena.cadenaValido(parametro.getEspecialidadVenta())) {
                    q.setParameter("especialidadventa", parametro.getEspecialidadVenta());
                }
                if (UtilCadena.cadenaValido(parametro.getUsuarioFiltrado())) {
                    q.setParameter("usuario", parametro.getUsuarioFiltrado());
                }
                if (UtilFecha.esValidoFecha(parametro.getFrom()) && UtilFecha.esValidoFecha(parametro.getTo()) && parametro.getFrom().before(parametro.getTo())) {
                    q.setParameter("desde", parametro.getFrom());
                    q.setParameter("hasta", parametro.getTo());
                }
            }
            l = (List<ComprobanteDetalle>) q.list();
        } catch (ConstraintViolationException he) {
            System.out.println("excepcion01: " + he);
            session.getTransaction().rollback();
        } catch (TransactionException he) {
            System.out.println("excepcion02: " + he);
            session.getTransaction().rollback();
        } catch (HibernateException he) {
            System.out.println("excepcion03: " + he);
            session.getTransaction().rollback();
        } finally {
            session.getTransaction().commit();
            session.close();
        }
        return l;
    }
    
}
