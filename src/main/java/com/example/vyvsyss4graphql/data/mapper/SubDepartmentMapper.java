package com.example.vyvsyss4graphql.data.mapper;

import com.example.vyvsyss4graphql.data.dto.SubDepartmentDTO;
import com.example.vyvsyss4graphql.data.dto.input.SubDepartmentInput;
import com.example.vyvsyss4graphql.data.entita.DepartmentE;
import com.example.vyvsyss4graphql.data.entita.SubDepartmentE;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubDepartmentMapper {
    default SubDepartmentE subDepartmentInputToSubDepartmentDto(SubDepartmentInput subDepartmentInput, DepartmentE departmentE) {
        return SubDepartmentE.builder()
                .department(departmentE)
                .subDepartmentName(subDepartmentInput.getSubDepartmentName())
                .subDepartmentComment(subDepartmentInput.getSubDepartmentComment()).build();
    }

    default SubDepartmentDTO subDepartmentEToSubDepartmentDto(SubDepartmentE subDepartmentE) {
        return SubDepartmentDTO.builder()
                .subDepartmentId(subDepartmentE.getSubDepartmentId())
                .subDepartmentName(subDepartmentE.getSubDepartmentName())
                .subDepartmentComment(subDepartmentE.getSubDepartmentComment())
                .build();
    }
}
