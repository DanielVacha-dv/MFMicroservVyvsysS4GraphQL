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

import java.util.ArrayList;
import java.util.Arrays;
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
    public DepartmentDTO getDepartmentById(@Argument Long id) {
        return departmentService.findById(id);
    }

    @MutationMapping
    public Long createDepartment(@Argument DepartmentInput input) {
        return departmentService.createDepartment(input);
    }

    @MutationMapping
    public Long createDepartment2(@Argument String  name,@Argument String comment) {
        List<Long> lo=new ArrayList<>(List.of(2L));
        DepartmentInput build = DepartmentInput.builder()
                .name(name).comment(comment).subDepartmentIds(lo).build();
        return departmentService.createDepartment(build);
    }

    @MutationMapping
    public Long updateDepartment(@Argument DepartmentInput input) {
        return departmentService.updateDepartment(input);
    }

    @MutationMapping
    public Long deleteDepartment(@Argument Long id) {
        return departmentService.deleteDepartment(id);
    }

}
