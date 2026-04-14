package com.example.EmployeeCrud.Controller;

import com.example.EmployeeCrud.model.Employee;
import com.example.EmployeeCrud.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {


    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public Employee create(@RequestBody Employee emp) {
        return service.createEmployee(emp);
    }

    @GetMapping
    public List<Employee> getAll() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getOne(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee emp) {
        return service.updateEmployee(id, emp);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteEmployee(id);
        return "Deleted";
    }

    @GetMapping("/department/{dept}")
    public List<Employee> byDept(@PathVariable String dept) {
        return service.getByDepartment(dept);
    }

    @GetMapping("/salary/{value}")
    public List<Employee> bySalary(@PathVariable double value){
        return service.getBySalary(value);
    }
}
