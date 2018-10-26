package com.palata22.demo.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.palata22.demo.model.*;
import com.palata22.demo.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class QueryResolver implements GraphQLQueryResolver{

    private final DepartmentRepository departmentRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final TicketReporsitory ticketReporsitory;
    private final CustomerRepository customerRepository;

    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }

    public List<Project> findAllProjects() {
        return projectRepository.findAll();
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public List<Ticket> findAllTickets() {
        return ticketReporsitory.findAll();
    }

    public Iterable<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }
}
