package com.project.school.student;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentHibRepository studentHibRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public StudentDTO convertDAOtoDTO(StudentDAO studentDAO){
        return modelMapper.map(studentDAO, StudentDTO.class);
    }

    public StudentDAO convertDTOtoDAO(StudentDTO studentDTO){
        return modelMapper.map(studentDTO, StudentDAO.class);
    }


    public ArrayList<StudentDTO> getStudents(){
        List<StudentDAO> studentsdaolist = studentHibRepository.findAll();
        ArrayList<StudentDTO> studentsdtolist = (ArrayList<StudentDTO>) studentsdaolist.stream()
                                            .map(this::convertDAOtoDTO)
                                            .collect(Collectors.toList());
        return studentsdtolist;
    }

    public StudentDTO getStudentById(String student_id){
        StudentDAO studentDAO = studentHibRepository.findById(student_id);
        return modelMapper.map(studentDAO, StudentDTO.class);
    }

    @Transactional
    public String createStudent(StudentDTO studentDTO){
        StudentDAO studentDAO = modelMapper.map(studentDTO, StudentDAO.class);
        studentHibRepository.save(studentDAO);
        return "success";
    }

    @Transactional
    public void updateStudent(String student_id, StudentDTO studentDTO){
        StudentDAO studentDAO = modelMapper.map(studentDTO, StudentDAO.class);
        studentHibRepository.update(studentDAO);
    }

    @Transactional
    public void deleteStudent(String student_id){
        studentHibRepository.deleteById(student_id);
    }


}
