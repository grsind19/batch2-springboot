package com.project.school.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentHibRepository {

    @Autowired
    private EntityManager entityManager;

    //get all students
    public List<StudentDAO> findAll(){
        TypedQuery<StudentDAO> query = entityManager.createQuery("from StudentDAO", StudentDAO.class);
        List<StudentDAO> students= query.getResultList();
        return students;
    }

    //get student by id
    public StudentDAO findById(String student_id){
        StudentDAO studentDAO = entityManager.find(StudentDAO.class, student_id);
        return studentDAO;
    }
    //create student
    public StudentDAO save(StudentDAO studentDAO){
        entityManager.persist(studentDAO);
        return studentDAO;
    }

    //update student
    public StudentDAO update(StudentDAO studentDAO){
        entityManager.merge(studentDAO);
        return studentDAO;
    }
    //delete stuydent
    public void deleteById(String student_id){
        Query query = entityManager.createQuery("delete from StudentDAO where id=:id");
        query.setParameter("id",student_id); //
        query.executeUpdate();
    }
}
