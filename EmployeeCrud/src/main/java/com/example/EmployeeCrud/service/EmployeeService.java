package com.example.EmployeeCrud.service;

import com.example.EmployeeCrud.model.Employee;
import com.example.EmployeeCrud.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {


    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }


    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }


    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }


    public Employee getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }


    public Employee updateEmployee(Long id, Employee emp) {
        Employee e = getEmployeeById(id);

        e.setFirstName(emp.getFirstName());
        e.setLastName(emp.getLastName());
        e.setEmail(emp.getEmail());
        e.setDepartment(emp.getDepartment());
        e.setSalary(emp.getSalary());

        return repository.save(e);
    }


    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }


    public List<Employee> getByDepartment(String department) {
        return repository.findByDepartment(department);
    }
}
