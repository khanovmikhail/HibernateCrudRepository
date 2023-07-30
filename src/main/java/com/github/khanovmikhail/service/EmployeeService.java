package com.github.khanovmikhail.service;

import com.github.khanovmikhail.model.dto.EmployeeDetailDto;
import com.github.khanovmikhail.model.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> findAll();

    EmployeeDetailDto findById(long id);

    List<EmployeeDetailDto> findAllByName(String name);

    EmployeeDetailDto addEmployee(EmployeeDetailDto employee);

    EmployeeDetailDto updateEmployee(long id, EmployeeDetailDto employee);

    void deleteEmployee(long id);
}
