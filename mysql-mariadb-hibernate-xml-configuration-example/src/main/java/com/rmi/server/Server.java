/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rmi.server;


import com.rmi.server.dao.IDao;
import com.rmi.server.entities.Department;
import com.rmi.server.entities.Employee;
import com.rmi.server.service.DepartmentService;
import com.rmi.server.service.EmployeeService;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ADMIN
 */
public class Server {
    
    public static void main(String[] args) {
        try {
            
            IDao<Employee> daoEmployee = new EmployeeService();
            IDao<Department> daoDepartment = new DepartmentService();
            
            LocateRegistry.createRegistry(0)
            System.out.println("Start sever RMI remote function !");
        } catch (RemoteException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AlreadyBoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
