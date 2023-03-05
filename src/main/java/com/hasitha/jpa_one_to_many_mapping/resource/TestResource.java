package com.hasitha.jpa_one_to_many_mapping.resource;

import com.hasitha.jpa_one_to_many_mapping.bo.StudentDepartmentBO;
import com.hasitha.jpa_one_to_many_mapping.entity.Department;
import com.hasitha.jpa_one_to_many_mapping.entity.Student;
import com.hasitha.jpa_one_to_many_mapping.repository.DepartmentRepository;
import com.hasitha.jpa_one_to_many_mapping.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
        department.setName("Accounting");

        Student s1= new Student();
        s1.setName("Amal");
        s1.setMobile("0771111111");
        s1.setDepartment(department);

        Student s2= new Student();
        s2.setName("Wajira");
        s2.setMobile("0712222222");
        s2.setDepartment(department);

        department.getStudent().add(s1);
        department.getStudent().add(s2);

        Department department2= new Department();
        department2.setName("Biology");

        Student s3= new Student();
        s3.setName("Hasitha");
        s3.setMobile("0713333333");
        s3.setDepartment(department2);

        Student s4= new Student();
        s4.setName("Thamaranga");
        s4.setMobile("0714444444");
        s4.setDepartment(department2);

        department2.getStudent().add(s3);
        department2.getStudent().add(s4);

        //saving parent entity (This will automatically save child data also)
        Department saved1=departmentRepository.save(department);
        Department saved2=departmentRepository.save(department2);

        return saved1.toString()+"\n"+saved2.toString();

    }
    /*
     * Since I have mapped bi-directionaly, when query for child entity I get parent
     * entity data also.
     * */
    @GetMapping("/retrieveStd")
    public String retrieveData(){
        Optional<Student> student=studentRepository.findById(Long.parseLong("9"));
        if(student.isPresent()){
            Student stu=student.get();
            Department dep=stu.getDepartment();
            return stu.getId()+" "+stu.getName()+" "+stu.getMobile()+" "+dep.getId()+" "+dep.getName();
        }else{
            return "No data found";

        }

    }

    @GetMapping("/retrieveDept")
    public String retrieveDeptData(){
        Optional<Department> department=departmentRepository.findById(Long.parseLong("5"));
        if(department.isPresent()){
            return department.get().toString();
        }else{
            return "No data found";

        }

    }

    @GetMapping("/update")
    public String updateData(){
        Optional<Student> student=studentRepository.findById(Long.parseLong("11"));
        if(student.isPresent()){
            Student stu=student.get();
            Optional<Department> dep=departmentRepository.findById(Long.parseLong("5"));
            stu.setDepartment(dep.get());
            Student updatedStudent=studentRepository.save(stu);
            return updatedStudent.getId()+" "+updatedStudent.getName()+" "+updatedStudent.getMobile()+" "+updatedStudent.getDepartment().getId()+" "+updatedStudent.getDepartment().getName();
        }else{
            return "No data found for update";

        }

    }

    @GetMapping("/delete")
    public String deleteData(){
        Optional<Department> department=departmentRepository.findById(Long.parseLong("6"));
        if(department.isPresent()){
            Department dep= department.get();
            departmentRepository.delete(dep);
            return "Department deleted successfully";
        }else{
            return "No data found for  delete";

        }

    }
    /*Here only child entity data will be deleted. Since I haven't provided CascadeType
    * inside child entity.*/
    @GetMapping("/deleteStd")
    public String deleteStudentData(){
        Optional<Student> student=studentRepository.findById(Long.parseLong("2"));
        if(student.isPresent()){
            Student std= student.get();
            studentRepository.delete(std);
            return "Student deleted successfully";
        }else{
            return "No data found for  delete";

        }

    }
    @GetMapping("/joinTest")
    public List<StudentDepartmentBO> getStudentDepartmentDetails(){
        return departmentRepository.getStudentDepartmentDetailsWithSQLJoin();
    }

}
