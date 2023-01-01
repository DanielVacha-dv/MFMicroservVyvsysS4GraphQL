package com.example.vyvsyss4graphql.repository;

import com.example.vyvsyss4graphql.data.dto.input.DepartmentInput;
import com.example.vyvsyss4graphql.data.entita.DepartmentE;
import com.example.vyvsyss4graphql.data.entita.SubDepartmentE;
import com.example.vyvsyss4graphql.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@DependsOn({"departmentRepository", "subDepartmentRepository"})
public class MyRepositoriesInitializer implements ApplicationRunner {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private SubDepartmentRepository subDepartmentRepository;

    @Autowired
    private DepartmentService departmentService;


    @Override
    public void run(ApplicationArguments args) {
        DepartmentE d1 = new DepartmentE(1L, "Dopravka", "dopr kommentes");
        DepartmentE d2 = new DepartmentE(2L, "Socka", "soc komment");
        List<DepartmentE> repositoryList = Arrays.asList(d1, d2);
        departmentRepository.saveAll(repositoryList);
        List<DepartmentE> l = departmentService.findAllEntities();
        SubDepartmentE sub1 = new SubDepartmentE(1L, l.get(0), "Dopr pasy 1", "sub dopr komment");
        SubDepartmentE sub2 = new SubDepartmentE(2L, l.get(0), "Dopr pasy 2", "sub dopr komment");
        SubDepartmentE sub3 = new SubDepartmentE(3L, l.get(1), "Socka op 1", "sub soc komment");
        SubDepartmentE sub4 = new SubDepartmentE(4L, l.get(1), "Socka op 2", "sub soc komment");
        List<SubDepartmentE> subDepartmentRepositoryList = Arrays.asList(sub1, sub2, sub3, sub4);
        subDepartmentRepository.saveAll(subDepartmentRepositoryList);
        // test
//        departmentService.updateDepartment(getDepartmentInput());
    }

    private DepartmentInput getDepartmentInput() {
        return DepartmentInput.builder()
                .departmentId(1L)
                .comment(" kom update")
                .name("upd name")
                .subDepartmentIds(new ArrayList<>(List.of(2L)))
                .build();
    }
}
