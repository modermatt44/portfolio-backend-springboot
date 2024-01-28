package ch.portfolio.portfoliobackend.controller;

import ch.portfolio.portfoliobackend.model.Project;
import ch.portfolio.portfoliobackend.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/get_project")
    public List<Project> getProject() {
        // Return all projects from the database as a JSON array
        return projectRepository.findAll();
    }

    @PostMapping("/post_project")
    public Project postProject(@RequestBody Project project) {
        // Create a new project object and save it to the database
        projectRepository.save(project);
        return project;
    }
}
