package com.hunter2.sqli.service;

import com.hunter2.sqli.model.Admin;
import com.hunter2.sqli.model.Employee;
import com.hunter2.sqli.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public void init(){
        List<Admin> admins = new ArrayList<>();
        admins.add(new Admin("Admin1", "admin1@admin.got", "123-456-789"));
        admins.add(new Admin("Admin2", "admin1@admin.got", "111-222-333"));
        adminRepository.saveAll(admins);
    }
}