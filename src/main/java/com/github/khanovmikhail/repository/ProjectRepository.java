package com.github.khanovmikhail.repository;

import com.github.khanovmikhail.entity.Project;

import java.util.List;

public interface ProjectRepository {
    List<Project> getAllProjects();
    Project getProjectByName(String name);
    boolean addNewProject(String name);
    boolean changeProjectName(String oldName, String newName);
    boolean deleteProject(String name);
}
