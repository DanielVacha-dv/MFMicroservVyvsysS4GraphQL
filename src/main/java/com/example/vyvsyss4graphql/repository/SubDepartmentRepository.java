package com.example.vyvsyss4graphql.repository;

import com.example.vyvsyss4graphql.data.entita.SubDepartmentE;
import com.example.vyvsyss4graphql.entita.DepartmentE;
import org.springframework.data.repository.CrudRepository;
import org.springframework.graphql.data.GraphQlRepository;

import java.util.List;

@GraphQlRepository
public interface SubDepartmentRepository extends CrudRepository<SubDepartmentE, Long> {
    List<SubDepartmentE> findAllByDepartment(DepartmentE departmentID);
}
