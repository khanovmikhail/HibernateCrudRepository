package com.github.khanovmikhail.repository;

import com.github.khanovmikhail.entity.Employee;
import com.github.khanovmikhail.entity.Position;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PositionRepositoryImpl implements PositionRepository{
    @Override
    public List<Position> getAllPositions() {
        List<Position> allPositions;
        Configuration configuration = new Configuration();
        configuration.configure();
        try(SessionFactory sessionFactory = configuration.buildSessionFactory()){
            Session session = sessionFactory.openSession();
            System.out.println("OK");

            Query<Position> distanceQuery = session.createQuery("from Position", Position.class);
            allPositions = distanceQuery.getResultList();
        }
        return allPositions;
        //return null;
    }

    @Override
    public Position getPositionByName(String name) {
        return null;
    }

    @Override
    public boolean addNewPosition(String name) {
        return false;
    }

    @Override
    public boolean changeName(String oldName, String newName) {
        return false;
    }

    @Override
    public boolean deletePosition(String name) {
        return false;
    }
}
