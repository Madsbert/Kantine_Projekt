package org.example.kantine_projekt.Domains;

public class Employee {
    private String name;
    private int EmployeeID;
    private AccessLevels AccessLevel;


    public Employee(String name, int EmployeeID, AccessLevels AccessLevel) {
        this.name = name;
        this.EmployeeID = EmployeeID;
        this.AccessLevel = AccessLevel;
    }

    public String getName() {
        return name;
    }
    public int getEmployeeID() {
        return EmployeeID;
    }
    public AccessLevels getAccessLevel() {
        return AccessLevel;
    }


}

