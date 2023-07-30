package com.github.khanovmikhail.dao;

import com.github.khanovmikhail.model.entity.Project;
import org.hibernate.Session;

public interface ProjectDao extends BaseDao<Project> {
    Project findByName(Session session, String name);
}
