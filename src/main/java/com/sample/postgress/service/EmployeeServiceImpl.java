package com.sample.postgress.service;

import java.util.List;

import javax.annotation.Resource;

import com.sample.postgress.repositoryCustom.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sample.postgress.dao.EmployeeDao;
import com.sample.postgress.entity.Employees;

@Component
public class EmployeeServiceImpl implements EmployeeService{

    @Resource
    EmployeeDao employeeDao;

    @Override
    public List<Employees> findAll() {
        return employeeDao.findAll();
    }
    @Override
    public void insertEmployee(Employees emp) {
        employeeDao.insertEmployee(emp);
    }

    @Override
    public void updateEmployee(Employees emp) {
        employeeDao.updateEmployee(emp);
    }

    @Override
    public void executeUpdateEmployee(Employees emp) {
        employeeDao.executeUpdateEmployee(emp);
    }

    @Override
    public void deleteEmployee(Employees emp) {
        employeeDao.deleteEmployee(emp);
    }

}