package com.example.vyvsyss4graphql.controller;

import com.example.vyvsyss4graphql.entita.DepartmentE;
import com.example.vyvsyss4graphql.entita.SubDepartmentE;
import com.example.vyvsyss4graphql.service.DepartmentService;
import com.example.vyvsyss4graphql.service.SubDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private SubDepartmentService subDepartmentService;


    @QueryMapping
    public List<DepartmentE> getDepartment() {
        return departmentService.findAll();
    }

    @QueryMapping
    public DepartmentE getDepartmentById(@Argument Integer id) {
        return departmentService.findById(Long.valueOf(id)).get();
    }
}
