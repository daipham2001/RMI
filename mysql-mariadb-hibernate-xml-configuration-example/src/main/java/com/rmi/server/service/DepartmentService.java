/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rmi.server.service;

import com.rmi.server.HibernateUtil;
import com.rmi.server.dao.IDao;
import com.rmi.server.entities.Department;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;

/**
 *
 * @author ADMIN
 */
public class DepartmentService extends UnicastRemoteObject implements IDao<Department>{
    
      public DepartmentService() throws RemoteException {
        super();
    }

    @Override
    public boolean create(Department o) throws RemoteException {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            etat = true;
        }
        catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                etat = false;
            }
        }
        catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
                etat = false;
            }

        }
        finally {
            if (session != null) {
                session.close();
            }
        }
        return etat;
    }

    @Override
    public boolean update(Department o) throws RemoteException {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            etat = true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                etat = false;
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return etat;
    }

    @Override
    public boolean delete(Department o) throws RemoteException {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            etat = true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                etat = false;
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return etat;
    }

    @Override
    public Department findById(int id) throws RemoteException {
        Session session = null;
        Transaction tx = null;
        Department department = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            department = (Department) session.get(Department.class, id);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return department;
    }

    @Override
    public List<Department> findAll() throws RemoteException {
        Session session = null;
        Transaction tx = null;
        List<Department> departments = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            departments = session.getNamedQuery("findAllNativeDepartment").list();
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return departments;
    }

    public List<Department> findByName(String name) throws RemoteException {
       Session session = null;
        Transaction tx = null;
        List<Department> department = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            String query = "FROM Department as d where d.name LIKE :name";
            department = session.createQuery(query).setString("name", "%" + name + "%").list();
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return department;
    }

    @Override
    public Department findByNameNotLike(String name) throws RemoteException {
        Session session = null;
        Transaction tx = null;
        List<Department> department = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            String query = "FROM Department as d where d.name = :name";
            department = session.createQuery(query).setString("name",  name).list();
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return department.get(0);
    }

    public List<Department> findByMultiple(String name, String home, int id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



    
}
