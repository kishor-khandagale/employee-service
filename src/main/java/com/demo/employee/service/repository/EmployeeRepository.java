package com.demo.employee.service.repository;

import com.demo.employee.service.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRepository {

    private List<Employee> employeeList = new ArrayList<Employee>();

    public Employee addEmployee(Employee employee){
        employeeList.add(employee);
        return employee;
    }

    public Employee findById(Long id){
        return employeeList.stream()
                .filter(employee -> employee.id().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Employee> findAll(){
        return employeeList;
    }

    public List<Employee> findByDepartmentId(Long departmentId){
            return employeeList.stream()
                    .filter(employee -> employee.departmentId().equals(departmentId))
                    .toList();
    }
}
