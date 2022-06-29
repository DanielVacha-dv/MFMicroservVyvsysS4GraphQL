package com.example.vyvsyss4graphql.dto;

import com.example.vyvsyss4graphql.entita.SubDepartmentE;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class DepartmentDTO {
    private Long departmentId;
    private String name;
    private String comment;
    private List<SubDepartmentE> subDepartmentL;

}
