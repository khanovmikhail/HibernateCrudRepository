package com.github.khanovmikhail.service.converter.impl;

import com.github.khanovmikhail.model.dto.ProjectDetailDto;
import com.github.khanovmikhail.model.dto.ProjectDto;
import com.github.khanovmikhail.model.entity.Project;
import com.github.khanovmikhail.service.converter.EmployeeConverter;
import com.github.khanovmikhail.service.converter.ProjectConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProjectConverterImpl implements ProjectConverter {
    private final EmployeeConverter employeeConverter;

    @Override
    public ProjectDto convertProjectToProjectDto(Project project) {
        return new ProjectDto(project.getId(), project.getName());
    }

    @Override
    public ProjectDetailDto convertProjectToProjectDetailDto(Project project) {
        return new ProjectDetailDto(
                project.getId(),
                project.getName(),
                project.getEmployees()
                        .stream()
                        .map(employeeConverter::convertEmployeeToEmployeeDto)
                        .toList()
        );
    }
}
