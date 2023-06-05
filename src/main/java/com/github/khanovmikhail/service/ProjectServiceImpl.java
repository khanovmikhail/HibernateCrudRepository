package com.github.khanovmikhail.service;

import com.github.khanovmikhail.entity.Project;
import com.github.khanovmikhail.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private ProjectRepository projectRepository;

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
