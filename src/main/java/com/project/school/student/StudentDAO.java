package com.project.school.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seetha_student")
public class StudentDAO {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="fatherName")
    private String fatherName;

    @Column(name= "age")
    private int age;

    public StudentDAO(){}

    public StudentDAO(String id, String name, String fatherName, int age) {
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
