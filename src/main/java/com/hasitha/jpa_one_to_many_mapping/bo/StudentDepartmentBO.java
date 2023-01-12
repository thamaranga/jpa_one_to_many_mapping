package com.hasitha.jpa_one_to_many_mapping.bo;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.Entity;


public class StudentDepartmentBO {

    private String studentName;
    private String departmentName;

    public String getStudentName() {
        return studentName;
    }

    public StudentDepartmentBO(String studentName, String departmentName) {
        this.studentName = studentName;
        this.departmentName = departmentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "StudentDepartmentBO{" +
                "studentName='" + studentName + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
