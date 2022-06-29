package com.example.vyvsyss4graphql.entita;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Setter
@Getter
@Table(name = "department")
public class DepartmentE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "department_ID", unique = true, nullable = false)
    private Long departmentId;

    @NotBlank
    @Column(name = "name")
    private String name;

    @Column(name = "comment")
    private String comment;

    @OneToMany(mappedBy = "department",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<SubDepartmentE> subDepartmentL;

    public DepartmentE() {
    }

    public DepartmentE(Long departmentId, String name, String comment) {
        this.departmentId = departmentId;
        this.name = name;
        this.comment = comment;
    }

    public Long getDepartmentId() {
        return departmentId;
    }
}
