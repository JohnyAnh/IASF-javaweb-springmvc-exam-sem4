package com.example.iasfjavawebspringmvcexamsem4.repository;

import com.example.iasfjavawebspringmvcexamsem4.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employees, Integer> {
}
