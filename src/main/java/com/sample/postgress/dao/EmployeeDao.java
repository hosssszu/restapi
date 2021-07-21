package com.sample.postgress.dao;

import java.util.List;

import com.sample.postgress.entity.Employees;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface EmployeeDao {

    List<Employees> findAll();

    void insertEmployee(Employees emp);

    void updateEmployee(Employees emp);

    void executeUpdateEmployee(Employees emp);

    public void deleteEmployee(Employees emp);

}