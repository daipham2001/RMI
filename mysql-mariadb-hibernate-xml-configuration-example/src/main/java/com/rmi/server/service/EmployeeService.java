/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rmi.server.service;

import com.rmi.server.HibernateUtil;
import com.rmi.server.dao.IDao;
import com.rmi.server.entities.Department;
import com.rmi.server.entities.Employee;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Objects;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ADMIN
 */
public class EmployeeService extends UnicastRemoteObject implements IDao<Employee> {

    public EmployeeService() throws RemoteException {
        super();
    }
    
    @Override
    public boolean create(Employee o) throws RemoteException {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            session.save(o);
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
    public boolean update(Employee o) throws RemoteException {
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
    public boolean delete(Employee o) throws RemoteException {
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
    public Employee findById(int id) throws RemoteException {
        Session session = null;
        Transaction tx = null;
        Employee employee = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            employee = (Employee) session.get(Employee.class, id);
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
        return employee;
    }

    @Override
    public List<Employee> findAll() throws RemoteException {
        Session session = null;
        Transaction tx = null;
        List<Employee> employees = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            employees = session.getNamedQuery("findAllNativeEmployee").list();
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
        return employees;
    }

    public List<Employee> findByName(String string) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Employee findByNameNotLike(String name) throws RemoteException {
        return null;
    }


    public List<Employee> findByMultiple(String name, String home, int id) throws RemoteException {
        Session session = null;
        Transaction tx = null;
        List<Employee> employee = null;
        List<Objects> obj = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            String query = "FROM Employee as e";
            if (!name.isEmpty()) {
                query = query + " where e.name LIKE :name";
                if (!home.isEmpty()) {
                    query = query + " and e.homeTown LIKE :home";
                    Query qry = session.createQuery(query);
                    qry.setParameter("name", "%" + name + "%");
                    qry.setParameter("home", "%" + home + "%");
                    employee = qry.list();
                } else {
                    Query qry = session.createQuery(query);
                    qry.setParameter("name", "%" + name + "%");
                    employee = qry.list();
                }


            } else {
                if (!home.isEmpty()) {
                    query = query + " where e.homeTown LIKE :home";
                    Query qry = session.createQuery(query);
                    qry.setParameter("home", "%" + home + "%");
                    employee = qry.list();

                } else {
                    Query qry = session.createQuery(query);
                    employee = qry.list();
                }
            }
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return employee;
    }
    
    
    
    
}
