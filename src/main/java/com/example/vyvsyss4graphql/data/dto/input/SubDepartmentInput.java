package com.example.vyvsyss4graphql.data.dto.input;

import org.springframework.lang.Nullable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubDepartmentInput {

    @Nullable
    private Long subDepartmentId;
    @Nullable
    private Long departmentID;
    @Nullable
    private String subDepartmentName;
    @Nullable
    private String subDepartmentComment;
}