package com.github.khanovmikhail.service;

import com.github.khanovmikhail.entity.Employee;
import com.github.khanovmikhail.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> emps = new ArrayList<>();
        Employee e = Employee.builder().id(1L).name("Misha").build();
        emps.add(e);
        Employee e1 = Employee.builder().id(2L).name("Mikhail").build();
        emps.add(e1);

        return employeeRepository.getAllEmployees();

        //return emps; //employeeRepository.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return null;
    }

    @Override
    public boolean addNewEmployee(String name) {
        return false;
    }

    @Override
    public boolean changeName(int id, String newName) {
        return false;
    }

    @Override
    public boolean deleteEmployee(int id) {
        return false;
    }

    @Override
    public boolean assignToPosition(int employeeId, String positionName) {
        return false;
    }

    @Override
    public boolean assignToProject(int employeeId, String projectName) {
        return false;
    }

    @Override
    public boolean removeFromProject(int employeeId, String projectName) {
        return false;
    }
}
