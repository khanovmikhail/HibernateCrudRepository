package com.github.khanovmikhail.controller;

import com.github.khanovmikhail.entity.Project;
import com.github.khanovmikhail.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/{name}")
    public Project getProjectByName(@PathVariable String name) {
        return projectService.getProjectByName(name);
    }

    @GetMapping
    public List<Project> getAllProjects() {

        return projectService.getAllProjects();
    }

    @PostMapping
    public ResponseEntity<?> createProject(@RequestParam String name) {
        projectService.addNewProject(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{name}")
    public ResponseEntity<?> modifyProject(@PathVariable String name,
                                     @RequestParam(required = false) String newName) {
        projectService.changeProjectName(name, newName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<?> removeProject(@PathVariable String name) {
        projectService.deleteProject(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
