package com.sample.postgress.repositoryCustom;

import com.sample.postgress.entity.Employees;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employees, Long> {

}
