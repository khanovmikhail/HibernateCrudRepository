package com.github.khanovmikhail.repository;

import com.github.khanovmikhail.entity.Project;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository{
    @Override
    public List<Project> getAllProjects() {
        return null;
    }

    @Override
    public Project getProjectByName(String name) {
        return null;
    }

    @Override
    public boolean addNewProject(String name) {
        return false;
    }

    @Override
    public boolean changeProjectName(String oldName, String newName) {
        return false;
    }

    @Override
    public boolean deleteProject(String name) {
        return false;
    }
}
