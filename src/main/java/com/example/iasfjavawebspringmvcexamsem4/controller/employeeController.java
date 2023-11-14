package com.example.iasfjavawebspringmvcexamsem4.controller;

import com.example.iasfjavawebspringmvcexamsem4.entity.Employees;
import com.example.iasfjavawebspringmvcexamsem4.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class employeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/listemployee")
    public String getListEmployee(ModelMap modelMap){
        String view = "employee/listEmployee";
        try {
            List<Employees> employees = employeeService.findbyEmployee();
            modelMap.addAttribute("employees", employees);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return view;
    }

    //Nut add
    @GetMapping("/getFormCreate")
    public String getFormCreate(ModelMap modelMap){
        String view = "employee/create";
        try {
            Employees employee = new Employees();
            modelMap.addAttribute("employee", employee);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return view;
    }

    //Nut Create
    @PostMapping("/create")
    public String saveCreate(@ModelAttribute("employee") Employees employee, ModelMap modelMap){
        String view = "redirect:/employee/listemployee";
        try {
            employeeService.saveEmployee(employee);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return  view;
    }

    //Nut edit
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String getFormUpdate(@PathVariable("id") Integer id , ModelMap modelMap){
        String view = "employee/update";
        try {
            modelMap.addAttribute("employee", employeeService.findbyIdEmployee(id));//  này sẽ đại diện dữ liêu trang view hiển thị vd customer.id
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return  view;
    }

    //Nut update
    @PostMapping("/update")
    public String saveUpdate(@ModelAttribute("employee") Employees employee, ModelMap modelMap){
        String view = "redirect:/employee/listemployee";
        try {
            employeeService.saveEmployee(employee);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return  view;
    }

    @RequestMapping( value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id , ModelMap modelMap){
        String view = "redirect:/student/liststudent";
        try {
            employeeService.deleteEmployeeById(id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return  view;
    }






}
