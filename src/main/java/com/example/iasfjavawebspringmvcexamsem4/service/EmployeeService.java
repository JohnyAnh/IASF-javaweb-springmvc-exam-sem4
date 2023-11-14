package com.example.iasfjavawebspringmvcexamsem4.service;


import com.example.iasfjavawebspringmvcexamsem4.entity.Employees;

import java.util.List;

public interface EmployeeService {
    void saveEmployee(Employees employees);

    Employees findbyIdEmployee(Integer id);

    List<Employees> findbyEmployee();

    void deleteEmployeeById(Integer id);

}
