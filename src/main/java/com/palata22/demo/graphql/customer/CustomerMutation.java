package com.palata22.demo.graphql.customer;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.palata22.demo.model.Customer;
import com.palata22.demo.repository.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
public class CustomerMutation implements GraphQLMutationResolver {

    private final CustomerRepository customerRepository;

    public CustomerMutation(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer newCustomer(String firstName, String lastName) {
        Customer customer = Customer.builder()
                .firstName(firstName)
                .lastName(lastName).build();

        customerRepository.save(customer);

        return customer;
    }

}
