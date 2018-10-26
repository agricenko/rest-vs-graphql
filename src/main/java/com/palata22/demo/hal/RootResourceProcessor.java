package com.palata22.demo.hal;

import com.palata22.demo.repository.DepartmentRepository;
import com.palata22.demo.rest.DepartmentRestController;
import com.palata22.demo.rest.ProjectRestController;
import org.springframework.data.rest.webmvc.RepositoryLinksResource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

public class RootResourceProcessor implements ResourceProcessor<RepositoryLinksResource> {

    @Override
    public RepositoryLinksResource process(RepositoryLinksResource resource) {
        resource.add(ControllerLinkBuilder.linkTo(ProjectRestController.class).withRel("projects2"));
        return resource;
    }
}
