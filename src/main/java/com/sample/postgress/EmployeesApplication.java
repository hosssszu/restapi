package com.sample.postgress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// http://localhost:8080/v2/api-docs
// http://localhost:8080/swagger-ui.html

@SpringBootApplication(scanBasePackages="com.sample")
@EnableSwagger2
public class EmployeesApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeesApplication.class, args);
    }
}