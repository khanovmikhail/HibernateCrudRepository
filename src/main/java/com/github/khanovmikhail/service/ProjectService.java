package com.github.khanovmikhail.service;

import com.github.khanovmikhail.entity.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getAllProjects();
    Project getProjectByName(String name);
    boolean addNewProject(String name);
    boolean changeProjectName(String oldName, String newName);
    boolean deleteProject(String name);
}
