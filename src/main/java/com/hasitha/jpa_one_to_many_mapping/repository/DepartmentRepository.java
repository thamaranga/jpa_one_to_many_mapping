package com.hasitha.jpa_one_to_many_mapping.repository;

import com.hasitha.jpa_one_to_many_mapping.bo.StudentDepartmentBO;
import com.hasitha.jpa_one_to_many_mapping.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    /*
    Below is a sample jpql join query*/
    @Query(value = "select new com.hasitha.jpa_one_to_many_mapping.bo.StudentDepartmentBO(s.name as  student_name, d.name as department_name) from Student s join Department d  on s.department.id = d.id")
    public List<StudentDepartmentBO> getStudentDepartmentDetailsWithSQLJoin();
}
