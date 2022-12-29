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
//        allDepa.forEach(el -> allDTO.add(mapper.departmentEToDepartmentDTO(el)));
        return allDTO;
    }
    public List<DepartmentE> findAllEntities() {
      return StreamSupport.stream(departmentRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public DepartmentDTO findById(Long id) {
        Optional<DepartmentE> byId = departmentRepository.findById(id);
        return byId.map(departmentE -> mapper.departmentEToDepartmentDTO(departmentE)).orElse(null);
    }

    public Long createDepartment(DepartmentInput DepartmentInput) {
        DepartmentE dE=  mapper.departmentInputToDepartmentE(DepartmentInput);
        dE= departmentRepository.save(dE);
        return dE.getDepartmentId();
    }
    public Long createDepartmentName(String name, String comment ) {
        DepartmentE dE=  mapper.departmentDTOToDepartmentE(DepartmentDTO.builder().name(name).comment(comment
        ).build());
        dE= departmentRepository.save(dE);
        return dE.getDepartmentId();
    }
}
