package com.exuberant.tutorials.javaconcept.customObjects;

import java.io.Serializable;


public class Employee implements Comparable<Employee>, Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int empId;
    private String name;
    private String address;

    public Employee(int empId, String name, String address) {
        super();
        this.empId = empId;
        this.name = name;
        this.address = address;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int compareTo(Employee emp) {
        System.err.println("Inside CmpareTo..." + emp.toString());
        int result = 0;
        if (this.empId > emp.empId) {
            result = -1;
        } else if (this.empId < emp.empId) {
            result = 1;
        }
        return result;
    }

    @Override
    public String toString() {
        return "Employee [empId=" + empId + ", name=" + name + ", address="
                + address + "]";
    }

    @Override
    public int hashCode() {
        return empId;
    }

    @Override
    public boolean equals(Object obj) {
        Employee that = (Employee) obj;
        return this.empId == that.empId && this.name.equals(that.name);
    }
}
