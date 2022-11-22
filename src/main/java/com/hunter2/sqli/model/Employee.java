package com.hunter2.sqli.model;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    private String name;

    private String email;

    private String headline;
    private String phoneNo;
    private String salary;

    public Employee() {
    }

    public Employee(String name, String email, String headline, String phoneNo) {
        this.name = name;
        this.email = email;
        this.headline = headline;
        this.phoneNo = phoneNo;
    }

    public Employee(String name, String email, String headline, String phoneNo, String salary) {
        this.name = name;
        this.email = email;
        this.headline = headline;
        this.phoneNo = phoneNo;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public static Employee fromDO(Object[] employeeDO){
        return new Employee((String)employeeDO[0], (String) employeeDO[1], (String) employeeDO[2], (String) employeeDO[3]);
    }
}