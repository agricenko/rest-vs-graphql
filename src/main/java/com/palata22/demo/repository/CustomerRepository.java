package com.palata22.demo.repository;

import com.palata22.demo.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
//@RestResource(exported = false)
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {


}
