package com.hunter2.sqli;

import com.hunter2.sqli.service.AdminService;
import com.hunter2.sqli.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Throwable {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(EmployeeService employeeService, AdminService adminService) {
        return (args) -> {
            employeeService.init();
            adminService.init();
        };
    }

}