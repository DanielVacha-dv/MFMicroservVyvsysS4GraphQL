package com.example.vyvsyss4graphql.repository;

import com.example.vyvsyss4graphql.data.entita.SubDepartmentE;
import com.example.vyvsyss4graphql.data.mapper.DepartmentMapper;
import com.example.vyvsyss4graphql.data.entita.DepartmentE;
import com.example.vyvsyss4graphql.service.DepartmentService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

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
        List<DepartmentE> l=departmentService.findAllEntities();
        SubDepartmentE sub1 = new SubDepartmentE(1L, l.get(0), "Dopr pasy", "sub dopr komment");
        SubDepartmentE sub2 = new SubDepartmentE(2L,l.get(1), "Socka op", "sub soc komment");
        List<SubDepartmentE> subDepartmentRepositoryList = Arrays.asList(sub1, sub2);
        subDepartmentRepository.saveAll(subDepartmentRepositoryList);
    }
}
