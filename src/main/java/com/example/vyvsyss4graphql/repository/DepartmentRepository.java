package com.example.vyvsyss4graphql.repository;

import com.example.vyvsyss4graphql.data.entita.DepartmentE;
import org.springframework.data.repository.CrudRepository;
import org.springframework.graphql.data.GraphQlRepository;

@GraphQlRepository
public interface DepartmentRepository extends CrudRepository<DepartmentE, Long> {
}
