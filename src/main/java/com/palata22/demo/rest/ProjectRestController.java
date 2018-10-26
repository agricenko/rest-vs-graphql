package com.palata22.demo.rest;

import com.palata22.demo.model.Project;
import com.palata22.demo.model.User;
import com.palata22.demo.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/rest/projects")
@AllArgsConstructor
public class ProjectRestController {

    private final ProjectRepository projectRepository;

    @RequestMapping
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    @RequestMapping("{id}/users")
    public List<User> getProjectUsers(@PathVariable("id") Long id) {
        return projectRepository.getOne(id).getUsers();
    }
}
