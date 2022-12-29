package com.example.vyvsyss4graphql.controller;

import com.example.vyvsyss4graphql.data.dto.input.SubDepartmentInput;
import com.example.vyvsyss4graphql.data.entita.SubDepartmentE;
import com.example.vyvsyss4graphql.service.SubDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SubDepartmentController {

    @Autowired
    private SubDepartmentService subDepartmentService;


    @QueryMapping
    public List<SubDepartmentE> getSubDepartment() {
        return subDepartmentService.findAll();
    }

    @MutationMapping
    public Long createSubDepartment(@Argument SubDepartmentInput input) {
        return subDepartmentService.createSubDepartment(input);
    }
}
