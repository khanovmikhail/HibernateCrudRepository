package com.github.khanovmikhail.service;

import com.github.khanovmikhail.model.dto.ProjectDetailDto;
import com.github.khanovmikhail.model.dto.ProjectDto;

import java.util.List;

public interface ProjectService {
    List<ProjectDto> findAll();

    ProjectDetailDto findById(long id);

    ProjectDetailDto findByName(String name);

    ProjectDto addProject(ProjectDto project);

    ProjectDetailDto updateProject(long id, ProjectDto project);

    void deleteProject(long id);
}
