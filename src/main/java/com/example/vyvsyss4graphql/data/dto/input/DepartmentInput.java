package com.example.vyvsyss4graphql.data.dto.input;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.util.List;

@Getter
@Setter
@Builder
public class DepartmentInput {

    @Nullable
    private Long departmentId;
    private String name;
    @Nullable
    private String comment;

    @Nullable
    private List<Long> subDepartmentIds;

}
