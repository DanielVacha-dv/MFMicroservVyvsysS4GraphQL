package com.example.vyvsyss4graphql.data.entita;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Table(name = "subdepartment")
@Builder
@AllArgsConstructor
public class SubDepartmentE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
    @Column(name = "subdepartment_ID", unique = true)
    private Long subDepartmentId;

    @NotBlank
    @Column(name = "subdepartment_name")
    private String subDepartmentName;

    @Column(name = "subdepartment_comment")
    private String subDepartmentComment;

    @ManyToOne//(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "department_ID")
    // in DepartmentE is mappedBy right this entity
    private DepartmentE department;

    public SubDepartmentE() {

    }

    public SubDepartmentE(Long subDepartmentId, DepartmentE department, String subDepartmentName, String subDepartmentComment) {
        this.subDepartmentId = subDepartmentId;
        this.subDepartmentName = subDepartmentName;
        this.subDepartmentComment = subDepartmentComment;
        this.department = department;
    }

}
