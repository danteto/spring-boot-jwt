package com.dan.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties
public class EmployeeDto implements Serializable {
    private long ID;
    private String Firstname;
    private String Lastname;
    private int Age;
    private String Org;

    public EmployeeDto() {
    }

    public EmployeeDto(long ID, String firstname, String lastname, int age, String org) {
        this.ID = ID;
        Firstname = firstname;
        Lastname = lastname;
        Age = age;
        Org = org;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getOrg() {
        return Org;
    }

    public void setOrg(String org) {
        Org = org;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "ID=" + ID +
                ", Firstname='" + Firstname + '\'' +
                ", Lastname='" + Lastname + '\'' +
                ", Age=" + Age +
                ", Org='" + Org + '\'' +
                '}';
    }
}
