/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rmi.server.entities;

import java.io.Serializable;


/**
 *
 * @author ADMIN
 */

public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String position;
    private String dateOfBirth;
    private String homeTown;
    private Department department;

    public Employee() {
    }

    public Employee(int id, String name, String position, String dateOfBirth, String homeTown, Department department) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.dateOfBirth = dateOfBirth;
        this.homeTown = homeTown;
        this.department = department;
    }

    public Employee(String name, String position, String dateOfBirth, String homeTown, Department department) {
        this.name = name;
        this.position = position;
        this.dateOfBirth = dateOfBirth;
        this.homeTown = homeTown;
        this.department = department;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", position=" + position + ", dateOfBirth=" + dateOfBirth + ", homeTown=" + homeTown + ", department=" + department + '}';
    }
   
    
}
