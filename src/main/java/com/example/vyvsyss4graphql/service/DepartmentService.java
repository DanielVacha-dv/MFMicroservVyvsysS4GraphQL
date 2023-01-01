package com.example.vyvsyss4graphql.service;

import com.example.vyvsyss4graphql.data.dto.DepartmentDTO;
import com.example.vyvsyss4graphql.data.dto.input.DepartmentInput;
import com.example.vyvsyss4graphql.data.dto.input.SubDepartmentInput;
import com.example.vyvsyss4graphql.data.entita.DepartmentE;
import com.example.vyvsyss4graphql.data.entita.SubDepartmentE;
import com.example.vyvsyss4graphql.data.mapper.DepartmentMapper;
import com.example.vyvsyss4graphql.data.mapper.SubDepartmentMapper;
import com.example.vyvsyss4graphql.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Contain also sub-department by entity
 */
@Service
@Slf4j
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private SubDepartmentService subDepartmentService;

    private final DepartmentMapper mapper = Mappers.getMapper(DepartmentMapper.class);
    private final SubDepartmentMapper mapperSDM = Mappers.getMapper(SubDepartmentMapper.class);

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
        List<SubDepartmentE> subDepEntL = subDepartmentService.findAllByIds(DepartmentInput.getSubDepartmentIds());
        DepartmentE dE = mapper.departmentInputToDepartmentE(DepartmentInput, subDepEntL);
        dE = departmentRepository.save(dE);
        return dE.getDepartmentId();
    }

    @Transactional
    public Long updateDepartment(DepartmentInput DepartmentInput) {
        List<SubDepartmentE> subDepEntL = subDepartmentService.findAllByIds(DepartmentInput.getSubDepartmentIds());
        DepartmentE dE = mapper.departmentInputToDepartmentE(DepartmentInput, subDepEntL);
        Optional<DepartmentE> dEr = departmentRepository.findById(dE.getDepartmentId());
        if (dEr.isPresent()) {
            DepartmentE depE = dEr.get();
            depE.setName(dE.getName());
            depE.setComment(dE.getComment());
            List<SubDepartmentE> lsub = depE.getSubDepartmentL();
            log.info(" remove subdepartment " + lsub);
            List<SubDepartmentE> finSubDep = lsub.stream().filter(el -> !DepartmentInput.getSubDepartmentIds().contains(el.getSubDepartmentId())).toList();
            depE.removeSubDepartment(finSubDep);
            departmentRepository.save(depE);
        }
        return dE.getDepartmentId();
    }

    public Long createSubDepartment(SubDepartmentInput subDepartmentInput) {
        assert subDepartmentInput.getDepartmentID() != null;
        Optional<DepartmentE> dEr = departmentRepository.findById(subDepartmentInput.getDepartmentID());
        if (dEr.isPresent()) {
            DepartmentE depE = dEr.get();
            SubDepartmentE dE = mapperSDM.subDepartmentInputToSubDepartmentDto(subDepartmentInput, depE);
            depE.addSubDepartment(dE);
            log.info(" add sub-department " + dE);
            DepartmentE savedDepE=  departmentRepository.save(depE);
            return savedDepE.getDepartmentId();
        }
        return -1L;
    }

    public Long deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
        return id;
    }
}
