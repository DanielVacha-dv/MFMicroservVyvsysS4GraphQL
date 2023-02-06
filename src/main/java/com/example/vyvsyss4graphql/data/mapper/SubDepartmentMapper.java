package com.example.vyvsyss4graphql.data.mapper;

import com.example.vyvsyss4graphql.data.dto.SubDepartmentDTO;
import com.example.vyvsyss4graphql.data.dto.input.SubDepartmentInput;
import com.example.vyvsyss4graphql.data.entita.DepartmentE;
import com.example.vyvsyss4graphql.data.entita.SubDepartmentE;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class SubDepartmentMapper {

    public SubDepartmentE subDepartmentInputToSubDepartmentDto(SubDepartmentInput subDepartmentInput, DepartmentE departmentE) {
        return SubDepartmentE.builder()
                .department(departmentE)
                .subDepartmentName(subDepartmentInput.getSubDepartmentName())
                .subDepartmentComment(subDepartmentInput.getSubDepartmentComment()).build();
    }

    @Mapping(target="departmentId", source = "subDepartmentE.department.departmentId")
    public abstract SubDepartmentDTO subDepartmentEToSubDepartmentDto(SubDepartmentE subDepartmentE);

}
