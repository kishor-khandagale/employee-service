package com.demo.employee.service.controller;

import com.demo.employee.service.model.Employee;
import com.demo.employee.service.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RefreshScope
@RequestMapping("/employee")
public class EmployeeController {

   public static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        LOGGER.info("addEmployee {}", employee);
        employeeRepository.addEmployee(employee);
        return employee;
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") Long id){
        LOGGER.info("findById {}", id);
        return employeeRepository.findById(id);
    }

    @GetMapping
    public List<Employee> findAll(){
        LOGGER.info("findAll");
        return employeeRepository.findAll();
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findByDepartmentId(@PathVariable("departmentId") Long id){
        return employeeRepository.findByDepartmentId(id);
    }
}
