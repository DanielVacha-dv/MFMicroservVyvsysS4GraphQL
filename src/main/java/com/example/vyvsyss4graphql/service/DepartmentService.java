package com.example.vyvsyss4graphql.service;

import com.example.vyvsyss4graphql.data.dto.input.DepartmentInput;
import com.example.vyvsyss4graphql.data.mapper.DepartmentMapper;
import com.example.vyvsyss4graphql.data.dto.DepartmentDTO;
import com.example.vyvsyss4graphql.data.entita.DepartmentE;
import com.example.vyvsyss4graphql.repository.DepartmentRepository;
import com.example.vyvsyss4graphql.repository.SubDepartmentRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Contain also sub-department by entity
 */
@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private SubDepartmentRepository subDepartmentRepository;

    private final DepartmentMapper mapper = Mappers.getMapper(DepartmentMapper.class);

    public List<DepartmentDTO> findAll() {
        List<DepartmentE> allDepa = StreamSupport.stream(departmentRepository.findAll().spliterator(), false).toList();
        List<DepartmentDTO> allDTO = new ArrayList<>();
        for (DepartmentE elem : allDepa) {
            allDTO.add(mapper.departmentEToDepartmentDTO(elem));
        }
        return allDTO;
    }
    public List<DepartmentE> findAllEntities() {
      return StreamSupport.stream(departmentRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public DepartmentDTO findById(Long id) {
        Optional<DepartmentE> byId = departmentRepository.findById(id);
        return byId.map(mapper::departmentEToDepartmentDTO).orElse(null);
    }
    public Optional<DepartmentE> findByIdEnt(Long id) {
        return departmentRepository.findById(id);
    }

    public Long createDepartment(DepartmentInput DepartmentInput) {
        DepartmentE dE=  mapper.departmentInputToDepartmentE(DepartmentInput);
        dE= departmentRepository.save(dE);
        return dE.getDepartmentId();
    }
}
