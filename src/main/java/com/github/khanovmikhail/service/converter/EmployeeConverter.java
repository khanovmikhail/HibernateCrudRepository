package com.github.khanovmikhail.service.converter;

import com.github.khanovmikhail.dao.PositionDao;
import com.github.khanovmikhail.dao.ProjectDao;
import com.github.khanovmikhail.model.dto.EmployeeDetailDto;
import com.github.khanovmikhail.model.dto.EmployeeDto;
import com.github.khanovmikhail.model.entity.Employee;
import org.hibernate.Session;

public interface EmployeeConverter {
    EmployeeDto convertEmployeeToEmployeeDto(Employee employee);

    EmployeeDetailDto convertEmployeeToEmployeeDetailDto(Employee employee);

    Employee convertEmployeeDetailDtoToEmployee(EmployeeDetailDto employee, Session session,
                                                ProjectDao projectDao, PositionDao positionDao);
}
