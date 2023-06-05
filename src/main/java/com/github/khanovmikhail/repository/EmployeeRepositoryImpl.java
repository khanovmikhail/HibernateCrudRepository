package com.github.khanovmikhail.repository;

import com.github.khanovmikhail.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{

    //@Autowired
    //@PersistenceContext
    //private EntityManager entityManager;

//    @Autowired
//    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmployees() {
        //Session session = entityManager.unwrap(Session.class);
//        Session session = sessionFactory.openSession();
//        Query<Employee> distanceQuery = session.createQuery("from employees", Employee.class);
//        List<Employee> allEmployees = distanceQuery.getResultList();
        //return null; //allEmployees;

        List<Employee> allEmployees = new ArrayList<>();
        Configuration configuration = new Configuration();
        configuration.configure();
        try(SessionFactory sessionFactory = configuration.buildSessionFactory()){
            Session session = sessionFactory.openSession();
            System.out.println("OK");

            Query<Employee> distanceQuery = session.createQuery("from Employee", Employee.class);
            allEmployees = distanceQuery.getResultList();
        }
        return allEmployees;
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
