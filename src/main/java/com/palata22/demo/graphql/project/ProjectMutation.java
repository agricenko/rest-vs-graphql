package com.palata22.demo.graphql.project;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.palata22.demo.model.Customer;
import com.palata22.demo.model.Project;
import com.palata22.demo.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProjectMutation implements GraphQLMutationResolver {

    private final ProjectRepository projectRepository;

    public Project newProject(String name) {
        Project project = Project.builder()
                .name(name).build();

        projectRepository.save(project);

        return project;
    }
}
