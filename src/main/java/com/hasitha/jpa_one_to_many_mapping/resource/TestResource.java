package com.hasitha.jpa_one_to_many_mapping.resource;

import com.hasitha.jpa_one_to_many_mapping.entity.Department;
import com.hasitha.jpa_one_to_many_mapping.entity.Student;
import com.hasitha.jpa_one_to_many_mapping.repository.DepartmentRepository;
import com.hasitha.jpa_one_to_many_mapping.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TestResource {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    DepartmentRepository departmentRepository;


    @GetMapping("/save")
    public String saveData(){
        Department department= new Department();
        department.setName("Science");

        Student s1= new Student();
        s1.setName("Amal");
        s1.setMobile("0771234567");
        s1.setDepartment(department);

        Student s2= new Student();
        s2.setName("Perera");
        s2.setMobile("0711234567");
        s2.setDepartment(department);

        Department department2= new Department();
        department2.setName("Maths");

        Student s3= new Student();
        s3.setName("Hasitha");
        s3.setMobile("0713757937");
        s3.setDepartment(department2);

        Student s4= new Student();
        s4.setName("Thamaranga");
        s4.setMobile("0713674126");
        s4.setDepartment(department2);

        //saving parent entity
        departmentRepository.save(department);
        departmentRepository.save(department2);

        //saving child entities
       Student stu1= studentRepository.save(s1);
       Student stu2= studentRepository.save(s2);
       Student stu3= studentRepository.save(s3);
       Student stu4= studentRepository.save(s4);

        return stu1.getId()+" "+stu1.getName()+" "+stu1.getMobile()+" "+stu1.getDepartment().getName()+"\n"+
        stu2.getId()+" "+stu2.getName()+" "+stu2.getMobile()+" "+stu2.getDepartment().getName()+"\n"+
        stu3.getId()+" "+stu3.getName()+" "+stu3.getMobile()+" "+stu3.getDepartment().getName()+"\n"+
                stu4.getId()+" "+stu4.getName()+" "+stu4.getMobile()+" "+stu4.getDepartment().getName();
    }

    @GetMapping("/retrieve")
    public String retrieveData(){
        Optional<Student> student=studentRepository.findById(Long.parseLong("3"));
        if(student.isPresent()){
            Student stu=student.get();
            Department dep=stu.getDepartment();
            return stu.getId()+" "+stu.getName()+" "+stu.getMobile()+" "+dep.getId()+" "+dep.getName();
        }else{
            return "No data found";

        }

    }

    @GetMapping("/update")
    public String updateData(){
        Optional<Student> student=studentRepository.findById(Long.parseLong("1"));
        if(student.isPresent()){
            Student stu=student.get();
            Optional<Department> dep=departmentRepository.findById(Long.parseLong("2"));
            stu.setDepartment(dep.get());
            Student updatedStudent=studentRepository.save(stu);
            return updatedStudent.getId()+" "+updatedStudent.getName()+" "+updatedStudent.getMobile()+" "+updatedStudent.getDepartment().getId()+" "+updatedStudent.getDepartment().getName();
        }else{
            return "No data found for update";

        }

    }

    @GetMapping("/delete")
    public String deleteData(){
        Optional<Department> department=departmentRepository.findById(Long.parseLong("2"));
        if(department.isPresent()){
            Department dep= department.get();
            departmentRepository.delete(dep);
            return "Department deleted successfully";
        }else{
            return "No data found for  delete";

        }

    }

}
