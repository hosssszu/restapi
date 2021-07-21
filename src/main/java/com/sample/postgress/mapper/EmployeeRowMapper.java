package com.sample.postgress.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sample.postgress.entity.Employees;

public class EmployeeRowMapper implements RowMapper<Employees> {

    @Override
    public Employees mapRow(ResultSet rs, int arg1) throws SQLException {
        Employees emp = new Employees();
        emp.setEmployeeId(rs.getLong("employeeId"));
        emp.setEmployeeName(rs.getString("employeeName"));
        emp.setEmployeeEmail(rs.getString("employeeEmail"));
        emp.setEmployeeAddress(rs.getString("employeeAddress"));

        return emp;
    }


}