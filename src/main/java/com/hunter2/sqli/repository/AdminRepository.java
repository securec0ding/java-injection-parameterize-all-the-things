package com.hunter2.sqli.repository;

import com.hunter2.sqli.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String> {
}