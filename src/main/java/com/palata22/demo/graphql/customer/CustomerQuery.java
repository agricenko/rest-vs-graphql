package com.palata22.demo.graphql.customer;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.palata22.demo.model.Customer;
import com.palata22.demo.model.Department;
import com.palata22.demo.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CustomerQuery implements GraphQLQueryResolver {

    private final CustomerRepository customerRepository;

    public Customer findCustomer(Long id) {
        return customerRepository.findById(id).get();
    }

    public long countCustomers() {
        return customerRepository.count();
    }
}
