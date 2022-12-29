package com.example.vyvsyss4graphql.data.dto.input;

import io.micrometer.core.lang.Nullable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubDepartmentInput {
    @Nullable
    private Long departmentID;
    @Nullable
    private String subDepartmentName;
    @Nullable
    private String subDepartmentComment;
}