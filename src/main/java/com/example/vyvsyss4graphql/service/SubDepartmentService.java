package com.example.vyvsyss4graphql.service;

import com.example.vyvsyss4graphql.data.entita.DepartmentE;
import com.example.vyvsyss4graphql.data.entita.SubDepartmentE;
import com.example.vyvsyss4graphql.data.mapper.SubDepartmentMapper;
import com.example.vyvsyss4graphql.repository.SubDepartmentRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubDepartmentService {

    @Autowired
    private SubDepartmentRepository subDepartmentRepository;


    public List<SubDepartmentE> findAll() {
        List<SubDepartmentE> l = new ArrayList<>();
        subDepartmentRepository.findAll().forEach(l::add);
        return l;
    }

    public List<SubDepartmentE> findAllByIds(List<Long> subDepartmentId) {
        List<SubDepartmentE> l = new ArrayList<>();
        subDepartmentRepository.findAllById(subDepartmentId).forEach(l::add);
        return l;
    }

    public Optional<SubDepartmentE> findById(Long subDepartmentId) {
        return subDepartmentRepository.findById(subDepartmentId);
    }


    public void deleteByIds(List<Long> iDs) {
        subDepartmentRepository.deleteAllById(iDs);
    }
}
