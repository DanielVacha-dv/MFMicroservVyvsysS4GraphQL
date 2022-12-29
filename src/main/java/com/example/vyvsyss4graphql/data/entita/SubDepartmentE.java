package com.example.vyvsyss4graphql.data.entita;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Setter
@Getter
@Table(name = "subdepartment")
@Builder
@AllArgsConstructor
public class SubDepartmentE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "subdepartment_ID", unique = true, nullable = false)
    private Long subDepartmentId;

    @NotBlank
    @Column(name = "subdepartment_name")
    private String subDepartmentName;

    @Column(name = "subdepartment_comment")
    private String subDepartmentComment;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "department_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubDepartmentE that = (SubDepartmentE) o;

        if (subDepartmentId != null ? !subDepartmentId.equals(that.subDepartmentId) : that.subDepartmentId != null)
            return false;
        if (subDepartmentName != null ? !subDepartmentName.equals(that.subDepartmentName) : that.subDepartmentName != null)
            return false;
        return subDepartmentComment != null ? subDepartmentComment.equals(that.subDepartmentComment) : that.subDepartmentComment == null;
    }

    @Override
    public int hashCode() {
        int result = subDepartmentId != null ? subDepartmentId.hashCode() : 0;
        result = 31 * result + (subDepartmentName != null ? subDepartmentName.hashCode() : 0);
        result = 31 * result + (subDepartmentComment != null ? subDepartmentComment.hashCode() : 0);
        return result;
    }
}
