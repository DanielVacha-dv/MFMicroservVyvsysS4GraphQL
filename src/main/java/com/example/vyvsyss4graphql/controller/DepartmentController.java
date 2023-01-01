package com.example.vyvsyss4graphql.controller;

import com.example.vyvsyss4graphql.data.dto.DepartmentDTO;
import com.example.vyvsyss4graphql.data.dto.input.DepartmentInput;
import com.example.vyvsyss4graphql.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Slf4j
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @QueryMapping
    public List<DepartmentDTO> getDepartment() {
        List<DepartmentDTO> all = departmentService.findAll();
        log.info("get all department called: " + all.size());
        return all;
    }

    @QueryMapping
    public DepartmentDTO getDepartmentById(@Argument Integer id) {
        return departmentService.findById(Long.valueOf(id));
    }

    @MutationMapping
    public Long createDepartment(@Argument DepartmentInput input) {
        return departmentService.createDepartment(input);
    }

    @MutationMapping
    public Long updateDepartment(@Argument DepartmentInput input) {
        return departmentService.updateDepartment(input);
    }

}
