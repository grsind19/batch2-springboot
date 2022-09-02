package com.project.school.student;

import javax.persistence.Entity;

public class StudentDTO {
    private String id;
    private String name;
    private String fatherName;
    private int age;

    public StudentDTO(){}

    public StudentDTO(String id, String name, String fatherName, int age) {
        this.id = id;
        this.name = name;
        this.fatherName = fatherName;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}