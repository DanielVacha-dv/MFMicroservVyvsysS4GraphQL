package com.example.vyvsyss4graphql.service;

import com.example.vyvsyss4graphql.data.entita.SubDepartmentE;
import com.example.vyvsyss4graphql.entita.DepartmentE;
import com.example.vyvsyss4graphql.repository.SubDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubDepartmentService {
    @Autowired
    private SubDepartmentRepository subDepartmentRepository;

    public List<SubDepartmentE> findAll() {
        List<SubDepartmentE> l = new ArrayList<>();
        subDepartmentRepository.findAll().forEach(l::add);
        return l;
    }

    public List<SubDepartmentE> findAllByDepartmentId(DepartmentE dep) {
        List<SubDepartmentE> l = new ArrayList<>();
        subDepartmentRepository.findAllByDepartment(dep).forEach(l::add);
        return l;
    }
}
