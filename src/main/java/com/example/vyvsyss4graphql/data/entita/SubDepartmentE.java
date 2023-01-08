package com.example.vyvsyss4graphql.data.entita;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Setter
@Getter
@EqualsAndHashCode
@Table(name = "subdepartment")
@Builder
@AllArgsConstructor
public class SubDepartmentE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subdepartment_ID", unique = true)
    private Long subDepartmentId;

    @NotBlank
    @Column(name = "subdepartment_name")
    private String subDepartmentName;

    @Column(name = "subdepartment_comment")
    private String subDepartmentComment;

    @Column(name = "subdepartment_info")
    private String subDepartmentInfo;

    @ManyToOne
    @JoinColumn(name = "department_ID")

    private DepartmentE department;

    public SubDepartmentE() {

    }

    public SubDepartmentE(Long subDepartmentId, DepartmentE department, String subDepartmentName, String subDepartmentComment) {
        this.subDepartmentId = subDepartmentId;
        this.subDepartmentName = subDepartmentName;
        this.subDepartmentComment = subDepartmentComment;
        this.department = department;
    }

    @Override
    public String toString() {
        if (department != null) {
            return "SubDepartmentE{" +
                    "subDepartmentId=" + subDepartmentId +
                    ", subDepartmentName='" + subDepartmentName + '\'' +
                    ", subDepartmentComment='" + subDepartmentComment + '\'' +
                    ", department=" + department.getName() +
                    '}';
        }
        return "SubDepartmentE{" +
                "subDepartmentId=" + subDepartmentId +
                ", subDepartmentName='" + subDepartmentName + '\'' +
                ", subDepartmentComment='" + subDepartmentComment + '\'' +
                '}';
    }
}
