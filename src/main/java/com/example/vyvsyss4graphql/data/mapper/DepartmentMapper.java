package com.example.vyvsyss4graphql.data.mapper;

import com.example.vyvsyss4graphql.data.dto.DepartmentDTO;
import com.example.vyvsyss4graphql.data.entita.DepartmentE;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

     default DepartmentDTO departmentEToDepartmentDTO(DepartmentE source) {
        return DepartmentDTO
                .builder()
                .departmentId(source.getDepartmentId())
                .name(source.getName())
                .comment(source.getComment()).subDepartmentL(source.getSubDepartmentL())
                .build();
    }

     DepartmentE departmentDTOToDepartmentE(DepartmentDTO destination);
}
