package com.github.khanovmikhail.dao;

import com.github.khanovmikhail.model.entity.Employee;
import org.hibernate.Session;

import java.util.List;

public interface EmployeeDao extends BaseDao<Employee> {
    List<Employee> findByName(Session session, String name);
}