package com.sample.postgress.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employees")
public class Employees {

    @Id
    @ApiModelProperty(notes = "unique id of the employee")
    @Column(name = "EMPLOYEEID")
    private Long employeeId;

    @Size(min = 4, message = "{employee.name.cannot.be.less.than.four.characters}")
    @ApiModelProperty(notes = "the employee's name")
    @Column(name = "EMPLOYEENAME")
    private String employeeName;

    @NotNull(message = "Email cannot be left empty")
    @ApiModelProperty(notes = "the employee's email")
    @Email
    @Column(name = "EMPLOYEEEMAIL")
    private String employeeEmail;

    @NotEmpty(message = "Address cannot be empty")
    @ApiModelProperty(notes = "the employee's address")
    @Column(name = "EMPLOYEEADDRESS")
    private String employeeAddress;

//    @Pattern(regexp = "((?=.*[A-Z]).{6,10})", message = "Password must have one uppercase and one lowercase and should between 6 and 10 characters")
//    String password;

//    @Enumerated(EnumType.STRING)
//    private String gender;

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }


}