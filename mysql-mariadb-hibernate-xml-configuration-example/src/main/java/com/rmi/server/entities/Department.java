/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rmi.server.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "department")
@NamedQuery(name = "findAllDepartment", query = "from Department")
@NamedNativeQueries({
    @NamedNativeQuery(name = "findAllNativeDepartment", 
            query = "select * from department",
            resultClass = Department.class)
        ,
    @NamedNativeQuery(name = "findAllNativeDepartmentByName",
            query = "select * from department where name like %:name% ",
                    resultClass = Department.class)
}
        
)

public class Department implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name", unique=true)
    private String name;
    private String decription;

    public Department() {
    }
    
    public Department(String name) {
        this.name = name;
    }

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Department(String name, String decription) {
        this.name = name;
        this.decription = decription;
    }
    

    public Department(int id, String name, String decription) {
        this.id = id;
        this.name = name;
        this.decription = decription;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    @Override
    public String toString() {
        return "Department{" + "id=" + id + ", name=" + name + ", decription=" + decription + '}';
    }
    
    

   

   
    
}
