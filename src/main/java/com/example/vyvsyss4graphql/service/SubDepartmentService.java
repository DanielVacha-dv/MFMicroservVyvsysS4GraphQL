package com.example.vyvsyss4graphql.service;

import com.example.vyvsyss4graphql.data.dto.input.SubDepartmentInput;
import com.example.vyvsyss4graphql.data.entita.DepartmentE;
import com.example.vyvsyss4graphql.data.entita.SubDepartmentE;
import com.example.vyvsyss4graphql.data.mapper.SubDepartmentMapper;
import com.example.vyvsyss4graphql.repository.SubDepartmentRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubDepartmentService {

    @Autowired
    private SubDepartmentRepository subDepartmentRepository;

    private final SubDepartmentMapper mapper = Mappers.getMapper(SubDepartmentMapper.class);

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

    public List<SubDepartmentE> findAllByDepartmentId(DepartmentE dep) {
        return new ArrayList<>(subDepartmentRepository.findAllByDepartment(dep));
    }

    public Long createSubDepartment(SubDepartmentInput subDepartmentInput, DepartmentE departmentE) {
//        Optional<DepartmentE> depEnt = departmentService.findByIdEnt(subDepartmentInput.getDepartmentID());
        SubDepartmentE dE = mapper.SubDepartmentEToSubDepartmentDto(subDepartmentInput, departmentE);
        dE = subDepartmentRepository.save(dE);
        return dE.getSubDepartmentId();
    }

    public Long createSubDepartment(SubDepartmentE subDepEnt) {
        return subDepartmentRepository.save(subDepEnt).getSubDepartmentId();
    }

    public void deleteByIds(List<Long> iDs) {
        subDepartmentRepository.deleteAllById(iDs);
    }
}
