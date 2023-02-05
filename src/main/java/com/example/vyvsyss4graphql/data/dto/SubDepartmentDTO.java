package com.example.vyvsyss4graphql.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
@ToString
public class SubDepartmentDTO {

    @JsonProperty("departmentId")
    private Long departmentId;
    @JsonProperty("subDepartmentId")
    private Long subDepartmentId;
    @JsonProperty("subDepartmentName")
    private String subDepartmentName;
    @JsonProperty("subDepartmentComment")
    private String subDepartmentComment;
}
