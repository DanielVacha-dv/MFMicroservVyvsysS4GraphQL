package com.example.vyvsyss4graphql.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Builder
@Data
@ToString
public class DepartmentDTO {
    @JsonProperty("departmentId")
    private Long departmentId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("comment")
    private String comment;
    @JsonProperty("subDepartmentL")
    private List<SubDepartmentDTO> subDepartmentL;

}
