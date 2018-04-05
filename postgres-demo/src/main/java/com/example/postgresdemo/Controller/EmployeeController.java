package com.example.postgresdemo.Controller;

import com.example.postgresdemo.com.example.postgresdemo.model.Employee;
import com.example.postgresdemo.Repository.EmployeeJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeJPARepository employeeJPARepository;

    @GetMapping(value = "/all")
    public List<Employee> findAll(){
       return employeeJPARepository.findAll();
    }

    @GetMapping(value = "/{name}")
    public Employee findByName(@PathVariable final String name){
        return employeeJPARepository.findByName(name);
    }

    @PostMapping(value = "/addEmployee")
    public Employee adduser(@RequestBody final Employee employee){
        employeeJPARepository.save(employee);
        return employeeJPARepository.findByName(employee.getName());
    }

    @PostMapping(value = "/updateName/{name}/{newName}")
    public Employee updateEmployeeName(@PathVariable final String name,@PathVariable
                                    final String newName){
        System.out.println("Hit the controller");
        Employee employee = employeeJPARepository.findByName(name);
        if(employee != null){
            employee.setName(newName);
            employeeJPARepository.save(employee);
            return employeeJPARepository.findByName(newName);
        }
        return  null;
    }

    @GetMapping(value = "/delete/{name}")
    public List<Employee> deleteEmployee(@PathVariable final String name){
        System.out.println("Hit the controller");
        Employee employee = employeeJPARepository.findByName(name);
        if(employee != null){
            employeeJPARepository.delete(employee);
        }
        return employeeJPARepository.findAll();
    }
}
