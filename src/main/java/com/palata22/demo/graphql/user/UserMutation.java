package com.palata22.demo.graphql.user;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.palata22.demo.model.Department;
import com.palata22.demo.model.User;
import com.palata22.demo.repository.DepartmentRepository;
import com.palata22.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserMutation implements GraphQLMutationResolver {

    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;

    public User newUser(String name, Long departmentId) {
        Department department = departmentRepository.findById(departmentId).get();

        User user = User.builder()
                .name(name)
                .department(department).build();

        userRepository.save(user);

        return user;
    }
}
