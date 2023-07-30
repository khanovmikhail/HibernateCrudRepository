package com.github.khanovmikhail.dao.impl;

import com.github.khanovmikhail.dao.PositionDao;
import com.github.khanovmikhail.model.entity.Position;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.github.khanovmikhail.dao.constant.DaoConstants.ID;
import static com.github.khanovmikhail.dao.constant.DaoConstants.NAME;


@Repository
public class PositionDaoImpl implements PositionDao {
    private static final String SELECT_ALL_POSITIONS_HQL = """
            select position from Position position
            """;

    private static final String SELECT_POSITION_BY_ID_HQL = """
            select position from Position position
            left join fetch position.employees
            where position.id = :id
            """;

    private static final String SELECT_POSITION_BY_NAME_HQL = """
            select position from Position position
            left join fetch position.employees
            where position.name = :name
            """;


    @Override
    public List<Position> findAll(Session session) {
        return session.createQuery(SELECT_ALL_POSITIONS_HQL, Position.class)
                .getResultList();
    }

    @Override
    public Position findById(Session session, long id) {
        return session.createQuery(SELECT_POSITION_BY_ID_HQL, Position.class)
                .setParameter(ID, id)
                .getSingleResult();
    }

    @Override
    public Position findByName(Session session, String name) {
        return session.createQuery(SELECT_POSITION_BY_NAME_HQL, Position.class)
                .setParameter(NAME, name)
                .getSingleResult();
    }

    @Override
    public Position save(Session session, Position position) {
        session.persist(position);

        return position;
    }

    @Override
    public Position update(Session session, Position entity) {
        return session.merge(entity);
    }

    @Override
    public void delete(Session session, Position position) {
        session.remove(position);
    }
}
