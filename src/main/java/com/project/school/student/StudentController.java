package com.project.school.student;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    String name;

    @GetMapping("/student") //Read
    public String getName(){
        return this.name;
    }

    @PostMapping("/student") //Create
    public String saveName(@RequestBody String _name){
        this.name = _name;
        return "success";
    }

    @PutMapping("/student") //Update
    public void updateName(@RequestBody String name){
        this.name = "Hello "+ name;
    }

    @DeleteMapping("/student") //delete
    public void deleteName(){
        this.name = "";
    }

}
