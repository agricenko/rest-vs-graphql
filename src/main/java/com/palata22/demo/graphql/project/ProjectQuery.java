package com.palata22.demo.graphql.project;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.palata22.demo.model.Customer;
import com.palata22.demo.model.Project;
import com.palata22.demo.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProjectQuery implements GraphQLQueryResolver {

    private final ProjectRepository projectRepository;

    public Project project(Long id) {
        return projectRepository.findById(id).get();
    }

}
