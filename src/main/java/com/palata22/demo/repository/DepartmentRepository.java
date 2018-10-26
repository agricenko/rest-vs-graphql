package com.palata22.demo.repository;

import com.palata22.demo.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
//@RestResource(exported = false)
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
