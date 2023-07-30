package com.github.khanovmikhail.dao.impl;

import com.github.khanovmikhail.dao.ProjectDao;
import com.github.khanovmikhail.model.entity.Project;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;


import java.util.List;

import static com.github.khanovmikhail.dao.constant.DaoConstants.ID;
import static com.github.khanovmikhail.dao.constant.DaoConstants.NAME;

@Repository
public class ProjectDaoImpl implements ProjectDao {
    private static final String SELECT_ALL_PROJECTS_HQL = """
            select project from Project project
            """;

    private static final String SELECT_PROJECT_BY_ID_HQL = """
            select project from Project project
            left join fetch project.employees
            where project.id = :id
            """;

    private static final String SELECT_PROJECT_BY_NAME_HQL = """
            select project from Project project
            left join fetch project.employees
            where project.name = :name
            """;

    @Override
    public List<Project> findAll(Session session) {
        return session.createQuery(SELECT_ALL_PROJECTS_HQL, Project.class)
                .getResultList();
    }

    @Override
    public Project findById(Session session, long id) {
        return session.createQuery(SELECT_PROJECT_BY_ID_HQL, Project.class)
                .setParameter(ID, id)
                .getSingleResult();
    }

    @Override
    public Project findByName(Session session, String name) {
        return session.createQuery(SELECT_PROJECT_BY_NAME_HQL, Project.class)
                .setParameter(NAME, name)
                .getSingleResult();
    }

    @Override
    public Project save(Session session, Project project) {
        session.persist(project);

        return project;
    }

    @Override
    public Project update(Session session, Project project) {
        return session.merge(project);
    }

    @Override
    public void delete(Session session, Project project) {
        session.remove(project);
    }
}