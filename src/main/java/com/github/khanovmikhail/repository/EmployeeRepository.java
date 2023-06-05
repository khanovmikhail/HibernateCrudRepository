package com.github.khanovmikhail.repository;

import com.github.khanovmikhail.entity.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    boolean addNewEmployee(String name);
    boolean changeName(int id, String newName);
    boolean deleteEmployee(int id);
    boolean assignToPosition(int employeeId, String positionName);
    boolean assignToProject(int employeeId, String projectName);
    boolean removeFromProject(int employeeId, String projectName);
}
