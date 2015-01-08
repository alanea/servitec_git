/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.dao.impl;

import com.eidetech.model.dao.IConfiguracionDao;
import com.eidetech.model.dao.IMenuPersonalDao;
import com.eidetech.model.domain.entity.Menu;
import com.eidetech.model.domain.entity.Permiso;
import com.eidetech.model.domain.entity.Submenu;
import com.eidetech.model.util.UtilCadena;
import com.eidetech.model.util.UtilHibernate;
import java.io.Serializable;
import java.util.Formatter;
import org.hibernate.HibernateException;
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
@Repository("MenuPersonalDao")
public class MenuPersonalDao implements IMenuPersonalDao, Serializable {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean agregarMenuPersonal(Menu menu) {
        boolean success = false;
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            String id1 = "" + IConfiguracionDao.PRE_MENU;
            Integer n1 = (Integer) session.createQuery("SELECT MAX(cast(substring(e.id_menu,4,6),int)) FROM Menu e ").uniqueResult();
            if (n1 == null) {
                n1 = 0;
            }
            n1 = n1 + 1;
            Formatter fmt1 = new Formatter();
            fmt1.format("%06d", n1);
            id1 = id1 + fmt1.toString();
            if (!UtilCadena.cadenaValido(menu.getId_menu())) {
                menu.setId_menu(id1);
            }

            Integer n2 = (Integer) session.createQuery("SELECT MAX(cast(substring(e.id_submenu,4,6),int)) FROM Submenu e ").uniqueResult();
            if (n2 == null) {
                n2 = 0;
            }
            if (menu.getSubmenus() != null && !menu.getSubmenus().isEmpty()) {
                for (Submenu cs : menu.getSubmenus()) {
                    if (!UtilCadena.cadenaValido(cs.getId_submenu())) {
                        String id2 = "" + IConfiguracionDao.PRE_SUBMENU;
                        n2 = n2 + 1;
                        Formatter fmt2 = new Formatter();
                        fmt2.format("%06d", n2);
                        id2 = id2 + fmt2.toString();
                        cs.setId_submenu(id2);
                    }
                }
            }

            Integer n3 = (Integer) session.createQuery("SELECT MAX(cast(substring(e.id_permiso,4,6),int)) FROM Permiso e ").uniqueResult();
            if (n3 == null) {
                n3 = 0;
            }
            if (menu.getSubmenus() != null && !menu.getSubmenus().isEmpty()) {
                for (Submenu cs : menu.getSubmenus()) {
                    if (cs.getPermisos() != null && !cs.getPermisos().isEmpty()) {
                        for (Permiso cp : cs.getPermisos()) {
                            if (!UtilCadena.cadenaValido(cp.getId_permiso())) {
                                String id3 = "" + IConfiguracionDao.PRE_PERMISO;
                                n3 = n3 + 1;
                                Formatter fmt3 = new Formatter();
                                fmt3.format("%06d", n3);
                                id3 = id3 + fmt3.toString();
                                cp.setId_permiso(id3);
                            }
                        }
                    }
                }
            }

            session.saveOrUpdate(menu);
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
    public boolean agregarSubmenuPersonal(Submenu submenu) {
        boolean success = false;
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            String id2 = "" + IConfiguracionDao.PRE_SUBMENU;
            Integer n2 = (Integer) session.createQuery("SELECT MAX(cast(substring(e.id_submenu,4,6),int)) FROM Submenu e ").uniqueResult();
            if (n2 == null) {
                n2 = 0;
            }
            n2 = n2 + 1;
            Formatter fmt2 = new Formatter();
            fmt2.format("%06d", n2);
            id2 = id2 + fmt2.toString();
            submenu.setId_submenu(id2);

            String id3 = "" + IConfiguracionDao.PRE_PERMISO;
            Integer n3 = (Integer) session.createQuery("SELECT MAX(cast(substring(e.id_permiso,4,6),int)) FROM Permiso e ").uniqueResult();
            if (n3 == null) {
                n3 = 0;
            }
            if (submenu.getPermisos() != null && !submenu.getPermisos().isEmpty()) {
                for (Permiso cp : submenu.getPermisos()) {
                    n3 = n3 + 1;
                    Formatter fmt3 = new Formatter();
                    fmt3.format("%06d", n3);
                    id3 = id3 + fmt3.toString();
                    cp.setId_permiso(id3);
                }
            }

            session.persist(submenu);
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
    public boolean agregarPermisoPersonal(Permiso permiso) {
        boolean success = false;
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            String id3 = "" + IConfiguracionDao.PRE_PERMISO;
            Integer n3 = (Integer) session.createQuery("SELECT MAX(cast(substring(e.id_permiso,4,6),int)) FROM Permiso e ").uniqueResult();
            if (n3 == null) {
                n3 = 0;
            }
            n3 = n3 + 1;
            Formatter fmt3 = new Formatter();
            fmt3.format("%06d", n3);
            id3 = id3 + fmt3.toString();
            permiso.setBestado(true);
            permiso.setId_permiso(id3);

            session.persist(permiso);
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
    public boolean eliminarSubmenuPersonal(Submenu submenu) {
        return UtilHibernate.eliminarEntidad(sessionFactory, submenu);
    }

    @Override
    public boolean eliminarPermisoPersonal(Permiso permiso) {
        return UtilHibernate.eliminarEntidad(sessionFactory, permiso);
    }
}
