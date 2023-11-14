package com.example.iasfjavawebspringmvcexamsem4.service.impl;

import com.example.iasfjavawebspringmvcexamsem4.entity.Employees;
import com.example.iasfjavawebspringmvcexamsem4.repository.EmployeeRepository;
import com.example.iasfjavawebspringmvcexamsem4.service.EmployeeService;
import com.example.iasfjavawebspringmvcexamsem4.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository studentRepository;

    @Override
    //Vừa create vừa update
    public void saveEmployee(Employees employees) {
        try {
            studentRepository.save(employees);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Employees findbyIdEmployee(Integer id) {
        try {
            Optional<Employees> optionalCustomer = studentRepository.findById(id);
            return optionalCustomer.orElse(null);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Employees> findbyEmployee() {
        try {
            return studentRepository.findAll();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        try {
            studentRepository.delete(findbyIdEmployee(id));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
