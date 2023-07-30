package com.github.khanovmikhail.service.converter.impl;

import com.github.khanovmikhail.dao.PositionDao;
import com.github.khanovmikhail.dao.ProjectDao;
import com.github.khanovmikhail.model.dto.EmployeeDetailDto;
import com.github.khanovmikhail.model.dto.EmployeeDto;
import com.github.khanovmikhail.model.entity.Employee;
import com.github.khanovmikhail.model.entity.Project;
import com.github.khanovmikhail.service.converter.EmployeeConverter;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Component
@RequiredArgsConstructor
public class EmployeeConverterImpl implements EmployeeConverter {
    @Override
    public EmployeeDto convertEmployeeToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName()
        );
    }

    @Override
    public EmployeeDetailDto convertEmployeeToEmployeeDetailDto(Employee employee) {
        return new EmployeeDetailDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getPosition().getName(),
                employee.getProjects()
                        .stream()
                        .map(Project::getName)
                        .collect(Collectors.toSet())
        );
    }

    @Override
    public Employee convertEmployeeDetailDtoToEmployee(EmployeeDetailDto employee, Session session,
                                                       ProjectDao projectDao, PositionDao positionDao) {
        return Employee.builder()
                .firstName(employee.firstName())
                .lastName(employee.lastName())
                .position(positionDao.findByName(session, employee.position()))
                .projects(ofNullable(employee.projects())
                        .map(names -> names.stream()
                                .map(name -> projectDao.findByName(session, name))
                                .toList())
                        .orElseGet(ArrayList::new))
                .build();
    }
}