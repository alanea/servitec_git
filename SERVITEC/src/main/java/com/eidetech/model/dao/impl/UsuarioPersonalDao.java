/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.dao.impl;

import com.eidetech.model.dao.IConfiguracionDao;
import com.eidetech.model.dao.IUsuarioPersonalDao;
import com.eidetech.model.domain.entity.Permiso;
import com.eidetech.model.domain.entity.Sede;
import com.eidetech.model.domain.entity.Submenu;
import com.eidetech.model.domain.entity.UsuarioPersonal;
import com.eidetech.model.util.UtilHibernate;
import java.io.Serializable;
import java.util.Formatter;
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
@Repository("UsuarioPersonalDao")
public class UsuarioPersonalDao implements IUsuarioPersonalDao, Serializable {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean agregarUsuarioPersonal(UsuarioPersonal usuario) {
        boolean success = false;
        String id = "" + PRE_USUARIO;
        Integer n;

        Session session = sessionFactory.openSession();
        try {
            session.getTransaction().begin();
            Query q = session.createQuery("FROM UsuarioPersonal u WHERE u.dname= :nombre");
            q.setParameter("nombre", usuario.getDname());
            UsuarioPersonal e = (UsuarioPersonal) q.uniqueResult();
            if (e != null) {
                return false;
            }

            String id1 = "" + IConfiguracionDao.PRE_MENU;
            Integer n1 = (Integer) session.createQuery("SELECT MAX(cast(substring(e.id_menu,4,6),int)) FROM Menu e ").uniqueResult();
            if (n1 == null) {
                n1 = 0;
            }
            n1 = n1 + 1;
            Formatter fmt1 = new Formatter();
            fmt1.format("%06d", n1);
            id1 = id1 + fmt1.toString();
            usuario.getMenu().setId_menu(id1);

            Integer n2 = (Integer) session.createQuery("SELECT MAX(cast(substring(e.id_submenu,4,6),int)) FROM Submenu e ").uniqueResult();
            if (n2 == null) {
                n2 = 0;
            }
            if (usuario.getMenu().getSubmenus() != null && !usuario.getMenu().getSubmenus().isEmpty()) {
                for (Submenu cs : usuario.getMenu().getSubmenus()) {
                    String id2 = "" + IConfiguracionDao.PRE_SUBMENU;
                    n2 = n2 + 1;
                    Formatter fmt2 = new Formatter();
                    fmt2.format("%06d", n2);
                    id2 = id2 + fmt2.toString();
                    cs.setId_submenu(id2);
                }
            }

            Integer n3 = (Integer) session.createQuery("SELECT MAX(cast(substring(e.id_permiso,4,6),int)) FROM Permiso e ").uniqueResult();
            if (n3 == null) {
                n3 = 0;
            }
            if (usuario.getMenu().getSubmenus() != null && !usuario.getMenu().getSubmenus().isEmpty()) {
                for (Submenu cs : usuario.getMenu().getSubmenus()) {
                    if (cs.getPermisos() != null && !cs.getPermisos().isEmpty()) {
                        for (Permiso cp : cs.getPermisos()) {
                            String id3 = "" + IConfiguracionDao.PRE_PERMISO;
                            n3 = n3 + 1;
                            Formatter fmt3 = new Formatter();
                            fmt3.format("%06d", n3);
                            id3 = id3 + fmt3.toString();
                            cp.setBestado(true);
                            cp.setId_permiso(id3);
                        }
                    }
                }
            }

            n = (Integer) session.createQuery("SELECT MAX(cast(substring(e.id_usuario,4,6),int))  FROM UsuarioPersonal e ").uniqueResult();
            if (n == null) {
                n = 0;
            }
            n = n + 1;
            Formatter fmt = new Formatter();
            fmt.format("%06d", n);
            id = id + fmt.toString();

            usuario.setId_usuario(id);
            session.persist(usuario);
            session.flush();
            success = true;
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

        return success;
    }

    @Override
    public boolean existeUsuarioPersonal(UsuarioPersonal usuario) {
        UsuarioPersonal e = null;
        Session session = sessionFactory.openSession();

        try {
            session.getTransaction().begin();
            Query q = session.createQuery("FROM UsuarioPersonal u WHERE u.dname= :nombre");
            q.setParameter("nombre", usuario.getDname());
            e = (UsuarioPersonal) q.uniqueResult();
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

        return e != null;
    }

    @Override
    public UsuarioPersonal obtenerUsuarioPersonal(UsuarioPersonal usuario) {
        UsuarioPersonal e = null;
        Session session = sessionFactory.openSession();

        try {
            session.getTransaction().begin();
            Query q = session.createQuery("FROM UsuarioPersonal u WHERE u.dname= :nombre AND u.dpassword= :clave");
            q.setParameter("nombre", usuario.getDname());
            q.setParameter("clave", usuario.getDpassword());
            e = (UsuarioPersonal) q.uniqueResult();
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

        return e;
    }

    @Override
    public boolean actualizarUsuarioPersonal(UsuarioPersonal usuarioPersonal) {
        return UtilHibernate.actualizarEntidad(sessionFactory, usuarioPersonal);
    }

    @Override
    public List<UsuarioPersonal> obtenerListaUsuarioPersonal(Sede sede) {
        List<UsuarioPersonal> l = null;
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            Query q = session.createQuery("FROM UsuarioPersonal u WHERE u.sede.id_sede= :sede_id ORDER BY u.id_usuario ASC");
            q.setParameter("sede_id", sede.getId_sede());

            l = (List<UsuarioPersonal>) q.list();
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
