package com.github.khanovmikhail.dao;

import com.github.khanovmikhail.model.entity.Position;
import org.hibernate.Session;

public interface PositionDao extends BaseDao<Position> {
    Position findByName(Session session, String name);
}
