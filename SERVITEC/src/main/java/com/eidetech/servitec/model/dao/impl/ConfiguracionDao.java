/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.dao.impl;

import com.eidetech.servitec.model.dao.IConfiguracionDao;
import com.eidetech.servitec.model.domain.entity.ConfiguracionMenu;
import com.eidetech.servitec.model.domain.entity.ConfiguracionPermiso;
import com.eidetech.servitec.model.domain.entity.ConfiguracionPermisoCliente;
import com.eidetech.servitec.model.domain.entity.ConfiguracionSubmenu;
import com.eidetech.servitec.model.util.UtilHibernate;
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
@Repository("ConfiguracionDao")
public class ConfiguracionDao implements IConfiguracionDao, Serializable {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean agregarConfiguracionMenuPersonal(ConfiguracionMenu menu) {
        boolean success = false;
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            String id1 = "" + IConfiguracionDao.PRE_MENU;
            Integer n1 = (Integer) session.createQuery("SELECT MAX(cast(substring(e.id_menu,4,6),int)) FROM ConfiguracionMenu e ").uniqueResult();
            if (n1 == null) {
                n1 = 0;
            }
            n1 = n1 + 1;
            Formatter fmt1 = new Formatter();
            fmt1.format("%06d", n1);
            id1 = id1 + fmt1.toString();
            menu.setId_menu(id1);

            Integer n2 = (Integer) session.createQuery("SELECT MAX(cast(substring(e.id_submenu,4,6),int)) FROM ConfiguracionSubmenu e ").uniqueResult();
            if (n2 == null) {
                n2 = 0;
            }
            if (menu.getSubmenus() != null && !menu.getSubmenus().isEmpty()) {
                for (ConfiguracionSubmenu cs : menu.getSubmenus()) {
                    String id2 = "" + IConfiguracionDao.PRE_SUBMENU;
                    n2 = n2 + 1;
                    Formatter fmt2 = new Formatter();
                    fmt2.format("%06d", n2);
                    id2 = id2 + fmt2.toString();
                    cs.setId_submenu(id2);
                }
            }

            Integer n3 = (Integer) session.createQuery("SELECT MAX(cast(substring(e.id_permiso,4,6),int)) FROM ConfiguracionPermiso e ").uniqueResult();
            if (n3 == null) {
                n3 = 0;
            }
            if (menu.getSubmenus() != null && !menu.getSubmenus().isEmpty()) {
                for (ConfiguracionSubmenu cs : menu.getSubmenus()) {
                    if (cs.getPermisos() != null && !cs.getPermisos().isEmpty()) {
                        for (ConfiguracionPermiso cp : cs.getPermisos()) {
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

            session.persist(menu);
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
    public boolean agregarConfiguracionSubmenuPersonal(ConfiguracionSubmenu submenu) {
        boolean success = false;
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            String id2 = "" + IConfiguracionDao.PRE_SUBMENU;
            Integer n2 = (Integer) session.createQuery("SELECT MAX(cast(substring(e.id_submenu,4,6),int)) FROM ConfiguracionSubmenu e ").uniqueResult();
            if (n2 == null) {
                n2 = 0;
            }
            n2 = n2 + 1;
            Formatter fmt2 = new Formatter();
            fmt2.format("%06d", n2);
            id2 = id2 + fmt2.toString();
            submenu.setId_submenu(id2);

            Integer n3 = (Integer) session.createQuery("SELECT MAX(cast(substring(e.id_permiso,4,6),int)) FROM ConfiguracionPermiso e ").uniqueResult();
            if (n3 == null) {
                n3 = 0;
            }
            if (submenu.getPermisos() != null && !submenu.getPermisos().isEmpty()) {
                for (ConfiguracionPermiso cp : submenu.getPermisos()) {
                    String id3 = "" + IConfiguracionDao.PRE_PERMISO;
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
    public boolean agregarConfiguracionPermisoPersonal(ConfiguracionPermiso permiso) {
        boolean success = false;
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            String id3 = "" + IConfiguracionDao.PRE_PERMISO;
            Integer n3 = (Integer) session.createQuery("SELECT MAX(cast(substring(e.id_permiso,4,6),int)) FROM ConfiguracionPermiso e ").uniqueResult();
            if (n3 == null) {
                n3 = 0;
            }
            n3 = n3 + 1;
            Formatter fmt3 = new Formatter();
            fmt3.format("%06d", n3);
            id3 = id3 + fmt3.toString();
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
    public boolean agregarConfiguracionPermisoCliente(ConfiguracionPermisoCliente permiso) {
        boolean success = false;
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            String id2 = "" + IConfiguracionDao.PRE_PERMISO;
            Integer n2 = (Integer) session.createQuery("SELECT MAX(cast(substring(e.id_permiso,4,6),int)) FROM ConfiguracionPermisoCliente e ").uniqueResult();
            if (n2 == null) {
                n2 = 0;
            }
            n2 = n2 + 1;
            Formatter fmt2 = new Formatter();
            fmt2.format("%06d", n2);
            id2 = id2 + fmt2.toString();
            permiso.setId_permiso(id2);

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
    public ConfiguracionMenu obtenerConfiguracionMenuPersonal(ConfiguracionMenu menu) {
        ConfiguracionMenu e = null;
        Session session = sessionFactory.openSession();

        try {
            session.getTransaction().begin();
            Query q = session.createQuery("FROM ConfiguracionMenu u WHERE u.dnombre= :tipo_menu");
            q.setParameter("tipo_menu", menu.getDnombre());
            e = (ConfiguracionMenu) q.uniqueResult();
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
    public List<ConfiguracionPermisoCliente> obtenerListaConfiguracionPermisoCliente() {
        return UtilHibernate.obtenerListaEntidades(sessionFactory, ConfiguracionPermisoCliente.class);
    }

    @Override
    public boolean actualizarConfiguracionMenuPersonal(ConfiguracionMenu menu) {
        return UtilHibernate.actualizarEntidad(sessionFactory, menu);
    }

    @Override
    public boolean actualizarConfiguracionSubmenuPersonal(ConfiguracionSubmenu submenu) {
        return UtilHibernate.actualizarEntidad(sessionFactory, submenu);
    }

    @Override
    public boolean actualizarConfiguracionPermisoPersonal(ConfiguracionPermiso permiso) {
        return UtilHibernate.actualizarEntidad(sessionFactory, permiso);
    }

    @Override
    public boolean actualizarConfiguracionPermisoCliente(ConfiguracionPermisoCliente permiso) {
        return UtilHibernate.actualizarEntidad(sessionFactory, permiso);
    }

    @Override
    public List<ConfiguracionMenu> obtenerListaConfiguracionMenuPersonal() {
        return UtilHibernate.obtenerListaEntidades(sessionFactory, ConfiguracionMenu.class);
    }

}
