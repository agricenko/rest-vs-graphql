package com.palata22.demo;

import com.palata22.demo.model.Department;
import com.palata22.demo.model.Project;
import com.palata22.demo.model.User;
import com.palata22.demo.repository.DepartmentRepository;
import com.palata22.demo.repository.ProjectRepository;
import com.palata22.demo.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.swing.text.DateFormatter;
import java.util.*;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    ApplicationRunner demo(UserRepository userRepository, DepartmentRepository departmentRepository,
                          ProjectRepository projectRepository) {
        return args -> {
			Department department = Department.builder().description("Development").build();
			departmentRepository.save(department);

            Project project = Project.builder().name("CLM").users(new ArrayList<>()).build();

            Stream.of("Sasha", "Lesha", "Artem", "Alexey", "Sanya", "Ilyuha", "Nikita")
                    .forEach(name -> {
                        User user = User.builder()
                                .name(name)
                                .department(department)
                                .projects(Arrays.asList(project)).build();
                        project.getUsers().add(user);

                        userRepository.save(user);
                    });

            projectRepository.save(project);

        };
    }
}

