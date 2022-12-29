package com.example.vyvsyss4graphql.data.dto.input;

import io.micrometer.core.lang.Nullable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentInput {
    @Nullable
    private String name;
    @Nullable
    private String comment;
}
