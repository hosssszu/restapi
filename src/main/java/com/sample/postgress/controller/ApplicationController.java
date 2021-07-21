package com.sample.postgress.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.Min;

import com.sample.postgress.dao.EmployeeDao;
import com.sample.postgress.exceptions.EmployeesException;
import com.sample.postgress.repositoryCustom.EmployeeRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.sample.postgress.entity.Employees;
import com.sample.postgress.service.EmployeeService;

@RestController
@RequestMapping("/postgressApp")
@Validated
public class ApplicationController {

    @Resource
    EmployeeService employeeService;

    @Autowired
    EmployeeRepository employeeRepository;

//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        binder.registerCustomEditor(Date.class, "dateOfBirth", new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
//    }

    @GetMapping(value = "/employeeList")
    @ApiOperation(value = "get all employee list",
            notes = "get employee list",
            response = Employees.class)
    public List<Employees> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employees getEmployeeById(@ApiParam(value = "ID value for the employee", required = true)
                                     @PathVariable @Min(2) Long id) {
        return employeeService.findAll().get(0);
    }

    @PostMapping(value = "/createEmp")
    public void createEmployee(@Valid @RequestBody Employees emp) {
//    public void createEmployee(@Valid @RequestBody BindingResult result, Employees emp) { // soap controller
//        if(result.hasError()){
//            return "register";
//        }
        employeeService.insertEmployee(emp);

    }

    @PutMapping(value = "/updateEmp")
    public void updateEmployee(@RequestBody Employees emp) {
        employeeService.updateEmployee(emp);

    }

    @PutMapping(value = "/executeUpdateEmp")
    public void executeUpdateEmployee(@RequestBody Employees emp) {
        employeeService.executeUpdateEmployee(emp);

    }

    @DeleteMapping(value = "/deleteEmpById")
    public void deleteEmployee(@RequestBody Employees emp) {
        employeeService.deleteEmployee(emp);

    }

// ------------------------------------------------------------------

    @GetMapping("/list")
    public ResponseEntity getProductsByRequestParam(@RequestParam("id") Long id) {
        Employees employees = employeeRepository.findById(id).get();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

//    @GetMapping("/list/{id}")
//    public ResponseEntity getProductsByPathVariable(@PathVariable("id") Long id) {
//        Employees employees = employeeRepository.findById(id).get();
//        return new ResponseEntity<>(employees, HttpStatus.OK);
//    }

    @GetMapping("/list/{id}")
    public ResponseEntity login(@PathVariable Long id) throws EmployeesException {
        Optional<Employees> employees = employeeRepository.findById(id);
        if (employees.isPresent()) {
            return new ResponseEntity<>(employees, HttpStatus.OK);
//            return new ResponseEntity<>("here? "+employees.get().getEmployeeName(), HttpStatus.OK);
        } else {
//            return ResponseEntity.status(404).build();
            throw new EmployeesException("invalid");
        }
    }
}