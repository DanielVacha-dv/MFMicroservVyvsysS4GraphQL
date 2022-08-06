package com.example.vyvsyss4graphql.controller;

import com.example.vyvsyss4graphql.data.entita.SubDepartmentE;
import com.example.vyvsyss4graphql.service.SubDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
