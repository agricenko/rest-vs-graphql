package com.palata22.demo.graphql.user;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.palata22.demo.model.User;
import com.palata22.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserQuery implements GraphQLQueryResolver {

    private final UserRepository userRepository;

    public User findUser(Long id) {
        return userRepository.findById(id).get();
    }
}
