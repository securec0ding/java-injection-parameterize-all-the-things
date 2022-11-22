package com.hunter2.sqli;

import com.hunter2.sqli.exception.QueryException;
import com.hunter2.sqli.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@Controller
public class HomeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public String serveHome(Model model) {
        model.addAttribute("employees", Collections.emptyList());
        return "home";
    }

    @PostMapping("/")
    public String search(@RequestParam String query, Model model) {
        model.addAttribute("employees", employeeService.getEmployeesByName(query));
        return "home";

    }

    @ExceptionHandler(QueryException.class)
    public ResponseEntity<?> handleStorageFileNotFound(QueryException exc) {
        return ResponseEntity.notFound().build();
    }

}