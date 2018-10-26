package com.palata22.demo.service;

import com.palata22.demo.model.Customer;
import com.palata22.demo.repository.CustomerRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    @GraphQLQuery
    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @GraphQLQuery
    public Optional<Customer> getCustomer(@GraphQLArgument(name = "id") Long id) {
        return customerRepository.findById(id);
    }

    @GraphQLMutation
    public Customer createCustomer(@GraphQLArgument(name = "customer") Customer customer) {
        return customerRepository.save(customer);
    }

    @GraphQLMutation
    public void deleteCustomer(@GraphQLArgument(name = "id") Long id) {
        customerRepository.deleteById(id);
    }
}
