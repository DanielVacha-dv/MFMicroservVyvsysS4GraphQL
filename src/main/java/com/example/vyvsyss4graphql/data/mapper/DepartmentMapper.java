package com.example.vyvsyss4graphql.data.mapper;

import com.example.vyvsyss4graphql.data.dto.DepartmentDTO;
import com.example.vyvsyss4graphql.data.dto.input.DepartmentInput;
import com.example.vyvsyss4graphql.data.entita.DepartmentE;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    SubDepartmentMapper mapper = Mappers.getMapper(SubDepartmentMapper.class);

    default DepartmentDTO departmentEToDepartmentDTO(DepartmentE source) {
        return DepartmentDTO
                .builder()
                .departmentId(source.getDepartmentId())
                .name(source.getName())
                .comment(source.getComment())
                .subDepartmentL(source.getSubDepartmentL().stream().map(mapper::SubDepartmentEToSubDepartmentDto).collect(Collectors.toList()))
                .build();
    }

    default DepartmentE departmentDTOToDepartmentE(DepartmentDTO departmentDTO) {
        return DepartmentE.builder().name(departmentDTO.getName()).comment(departmentDTO.getComment()).build();
    }

    default DepartmentE departmentInputToDepartmentE(DepartmentInput departmentInput) {
        return DepartmentE.builder().name(departmentInput.getName()).comment(departmentInput.getComment()).build();
    }
}
