package com.sample.postgress.service;

import java.util.List;

import com.sample.postgress.entity.Employees;

public interface EmployeeService {
    List<Employees> findAll();

    void insertEmployee(Employees emp);

    void updateEmployee(Employees emp);

    void executeUpdateEmployee(Employees emp);

    void deleteEmployee(Employees emp);


}