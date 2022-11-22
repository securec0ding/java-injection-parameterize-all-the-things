package com.hunter2.sqli.service;

import com.hunter2.sqli.model.Employee;
import com.hunter2.sqli.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

   public void init(){
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Jon Snow", "jon@snow.got", "King of the north", "999-999-999", "50000"));
        employees.add(new Employee("Tyrian Lannister", "tyrion@lannister.got", "Hand of the queen", "888-888-888", "100000"));
        employees.add(new Employee("Arya Stark", "arya@stark.got", "No-one", "777-888-888", "22000"));
        this.save(employees);
        List<Employee> returns = repository.findAll();
        System.out.print(returns.size());
    }

    public List<Employee> getEmployeesByName(String name) {

        String queryStr = "select name, email, headline, phone_no from employee where lower(name) like '%" + name.toLowerCase() + "%'";
        try {
            Query query = entityManager.createNativeQuery(queryStr);
            List results = query.getResultList();
            return (List<Employee>) results.stream().map(o -> Employee.fromDO((Object[]) o)).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public List<Employee> save(List<Employee> employeeList) {
        return repository.saveAll(employeeList);
    }
}