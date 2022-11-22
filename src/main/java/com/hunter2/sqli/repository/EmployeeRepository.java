package com.hunter2.sqli.repository;

import com.hunter2.sqli.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}