package com.palata22.demo.rest;

import com.palata22.demo.model.Department;
import com.palata22.demo.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/departments")
@AllArgsConstructor
public class DepartmentRestController {

    private final DepartmentRepository departmentRepository;

    @GetMapping
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

}
