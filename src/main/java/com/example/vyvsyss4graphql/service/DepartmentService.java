package com.example.vyvsyss4graphql.service;

import com.example.vyvsyss4graphql.dto.DepartmentDTO;
import com.example.vyvsyss4graphql.entita.DepartmentE;
import com.example.vyvsyss4graphql.repository.DepartmentRepository;
import com.example.vyvsyss4graphql.repository.SubDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Contain alsou subdepartment by entity
 */
@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private SubDepartmentRepository subDepartmentRepository;

    public List<DepartmentE> findAll() {
        List<DepartmentE> allDepa = StreamSupport.stream(departmentRepository.findAll().spliterator(), false).collect(Collectors.toList());
        return allDepa;
    }

    public Optional<DepartmentE> findById(Long id) {
        Optional<DepartmentE> res = departmentRepository.findById(id);
        return res;
    }
}
