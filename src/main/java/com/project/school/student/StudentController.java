package com.project.school.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

//Pathvariable  /student/{student_id}
//PathParam /student?name=seetha
//Requestbody


// Repostory - JPA
// Hibernate
// DTO
// DAO

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/student") //Read
    public ArrayList<StudentDTO> getName(){
        return studentService.getStudents();
    }

    @GetMapping("/student/{student_id}") //Read
    public StudentDTO getStudentById(@PathVariable("student_id") String student_id){
        return studentService.getStudentById(student_id);
    }

    @PostMapping("/student") //Create
    public String saveName(@RequestBody StudentDTO studentDTO){
        studentService.createStudent(studentDTO);
        return "success";
    }

    @PutMapping("/student/{student_id}") //Update
    public void updateName(@PathVariable("student_id") String student_id, @RequestBody StudentDTO studentDTO){
        studentService.updateStudent(student_id, studentDTO);
    }

    @DeleteMapping("/student/{student_id}") //delete
    public void deleteName(@PathVariable("student_id") String student_id){
        studentService.deleteStudent(student_id);
    }

}
