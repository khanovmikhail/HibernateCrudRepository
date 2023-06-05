package com.github.khanovmikhail.controller;

import com.github.khanovmikhail.entity.Employee;
import com.github.khanovmikhail.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(value = "/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestParam String name) {
        employeeService.addNewEmployee(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> modifyEmployee(@PathVariable int id,
                                      @RequestParam(required = false) String name) {
        employeeService.changeName(id, name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/position/{id}")
    public ResponseEntity<?> assignEmployeeToPosition(@PathVariable int id,
                                                      @RequestParam String position) {
        employeeService.assignToPosition(id, position);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/project/{id}")
    public ResponseEntity<?> assignEmployeeToProject(@PathVariable int id,
                                                     @RequestParam String project) {
        employeeService.assignToProject(id, project);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/project/{id}")
    public ResponseEntity<?> removeEmployeeFromProject(@PathVariable int id,
                                                       @RequestParam String project) {
        employeeService.removeFromProject(id, project);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
