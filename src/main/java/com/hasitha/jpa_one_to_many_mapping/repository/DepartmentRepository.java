package com.hasitha.jpa_one_to_many_mapping.repository;

import com.hasitha.jpa_one_to_many_mapping.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
