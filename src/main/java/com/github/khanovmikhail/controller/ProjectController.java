package com.github.khanovmikhail.controller;

import com.github.khanovmikhail.model.dto.ProjectDetailDto;
import com.github.khanovmikhail.model.dto.ProjectDto;
import com.github.khanovmikhail.model.validation.group.ForCreate;
import com.github.khanovmikhail.service.ProjectService;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping
    public List<ProjectDto> showAllProjects() {
        return projectService.findAll();
    }

    @GetMapping("/{id}")
    public ProjectDetailDto showProjectById(@PathVariable long id) {
        return projectService.findById(id);
    }

    @GetMapping("/name/{name}")
    public ProjectDetailDto showProjectByName(@PathVariable String name) {
        return projectService.findByName(name);
    }

    @PostMapping
    public ProjectDto addProject(@Validated({ForCreate.class, Default.class})
                                     @RequestBody ProjectDto project) {
        return projectService.addProject(project);
    }

    @PatchMapping("/{id}")
    public ProjectDetailDto updateProject(@PathVariable long id,
                                          @Valid @RequestBody ProjectDto project) {
        return projectService.updateProject(id, project);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProject(@PathVariable long id) {
        projectService.deleteProject(id);
    }
}