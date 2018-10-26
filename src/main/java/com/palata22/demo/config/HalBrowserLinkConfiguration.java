package com.palata22.demo.config;

import com.palata22.demo.rest.DepartmentRestController;
import com.palata22.demo.rest.ProjectRestController;
import com.palata22.demo.rest.UserRestController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.RepositoryLinksResource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

@Slf4j
@Configuration
public class HalBrowserLinkConfiguration {

    @Bean
    public ResourceProcessor<RepositoryLinksResource> halBroserLinks() {

        return resource -> {
            resource.add(ControllerLinkBuilder.linkTo(ProjectRestController.class).withRel("projects2"));
            resource.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(ProjectRestController.class).getProjectUsers(null)).withRel("projects2/{id}/users"));

            resource.add(ControllerLinkBuilder.linkTo(DepartmentRestController.class).withRel("departments2"));
            resource.add(ControllerLinkBuilder.linkTo(UserRestController.class).withRel("users2"));
            return resource;
        };
    }
}
