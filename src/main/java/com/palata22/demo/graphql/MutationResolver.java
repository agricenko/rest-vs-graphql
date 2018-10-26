package com.palata22.demo.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.palata22.demo.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MutationResolver implements GraphQLMutationResolver {

    private final DepartmentRepository departmentRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final TicketReporsitory ticketReporsitory;
    private final CustomerRepository customerRepository;

}
