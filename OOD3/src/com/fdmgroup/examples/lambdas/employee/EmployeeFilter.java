package com.fdmgroup.examples.lambdas.employee;

@FunctionalInterface
public interface EmployeeFilter {
    
    public abstract boolean filterEmployee(Employee employee);

}
