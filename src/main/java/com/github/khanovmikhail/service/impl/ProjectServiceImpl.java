package com.github.khanovmikhail.service.impl;

import com.github.khanovmikhail.dao.ProjectDao;
import com.github.khanovmikhail.model.dto.ProjectDetailDto;
import com.github.khanovmikhail.model.dto.ProjectDto;
import com.github.khanovmikhail.model.entity.Project;
import com.github.khanovmikhail.service.ProjectService;
import com.github.khanovmikhail.service.converter.ProjectConverter;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Optional.ofNullable;
import static org.springframework.util.StringUtils.hasText;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final SessionFactory sessionFactory;
    private final ProjectDao projectDao;
    private final ProjectConverter projectConverter;

    public List<ProjectDto> findAll() {
        List<ProjectDto> projectDtoList;

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            List<Project> projects = projectDao.findAll(session);
            projectDtoList = projects.stream()
                    .map(projectConverter::convertProjectToProjectDto)
                    .toList();

            session.getTransaction().commit();
        }

        return projectDtoList;
    }

    public ProjectDetailDto findById(long id) {
        ProjectDetailDto projectDetailDto;

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            projectDetailDto = projectConverter.convertProjectToProjectDetailDto(projectDao.findById(session, id));

            session.getTransaction().commit();
        }

        return projectDetailDto;
    }

    public ProjectDetailDto findByName(String name) {
        ProjectDetailDto projectDetailDto;

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            projectDetailDto = projectConverter.convertProjectToProjectDetailDto(projectDao.findByName(session, name));

            session.getTransaction().commit();
        }

        return projectDetailDto;
    }

    @Override
    public ProjectDto addProject(ProjectDto project) {
        Session session = null;
        ProjectDto addedProjectDto;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();

            Project addedProject = Project.builder()
                    .name(project.name())
                    .build();
            projectDao.save(session, addedProject);
            addedProjectDto = projectConverter.convertProjectToProjectDto(addedProject);

            session.getTransaction().commit();
        } catch (Exception ex) {
            ofNullable(session).ifPresent(s -> s.getTransaction().rollback());
            throw ex;
        } finally {
            ofNullable(session).ifPresent(Session::close);
        }

        return addedProjectDto;
    }

    @Override
    public ProjectDetailDto updateProject(long id, ProjectDto project) {
        Session session = null;
        ProjectDetailDto updatedProjectDto;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();

            Project oldProject = projectDao.findById(session, id);
            oldProject.setName(hasText(project.name()) ? project.name() : oldProject.getName());
            updatedProjectDto = projectConverter.convertProjectToProjectDetailDto(oldProject);

            session.getTransaction().commit();
        } catch (Exception ex) {
            ofNullable(session).ifPresent(s -> s.getTransaction().rollback());
            throw ex;
        } finally {
            ofNullable(session).ifPresent(Session::close);
        }

        return updatedProjectDto;
    }

    @Override
    public void deleteProject(long id) {
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();

            Project project = projectDao.findById(session, id);
            projectDao.delete(session, project);

            session.getTransaction().commit();
        } catch (Exception ex) {
            ofNullable(session).ifPresent(s -> s.getTransaction().rollback());
            throw ex;
        } finally {
            ofNullable(session).ifPresent(Session::close);
        }
    }
}