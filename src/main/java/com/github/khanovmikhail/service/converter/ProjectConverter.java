package com.github.khanovmikhail.service.converter;


import com.github.khanovmikhail.model.dto.ProjectDetailDto;
import com.github.khanovmikhail.model.dto.ProjectDto;
import com.github.khanovmikhail.model.entity.Project;

public interface ProjectConverter {
    ProjectDto convertProjectToProjectDto(Project project);

    ProjectDetailDto convertProjectToProjectDetailDto(Project project);
}
