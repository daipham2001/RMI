package com.rmi.server;

import com.rmi.server.entities.Department;
import com.rmi.server.entities.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

    public static void main (String...args){
        
        Department d = new Department();
        Employee e = new Employee();
         insertData4();     
    }
       
    public static void insertData4(){
         Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        Department d1 = new Department();
        d1.setName("IT");
        d1.setDecription("phong cong nghe thong tin");


        session.save(d1);
        tx.commit();

        session.close();
        HibernateUtil.shutdown();
        
    }
    
    public static void insertData5(){
         Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        Employee d1 = new Employee();
        d1.setDateOfBirth("07/09/2023");
       
        d1.setName("dai");
        d1.setPosition("Truong phong");
        d1.setHomeTown("Thanh Hoa");
        d1.setDepartment(new Department(1,"IT","phong cong nghe thong tin"));


        session.save(d1);
        tx.commit();

        session.close();
        HibernateUtil.shutdown();
        
    }
     
}
