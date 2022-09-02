package com.project.school.student;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public StudentDTO convertDAOtoDTO(StudentDAO studentDAO){
        return modelMapper.map(studentDAO, StudentDTO.class);
    }

    public StudentDAO convertDTOtoDAO(StudentDTO studentDTO){
        return modelMapper.map(studentDTO, StudentDAO.class);
    }


    public ArrayList<StudentDTO> getStudents(){
        List<StudentDAO> studentsdaolist = studentRepository.findAll();
        ArrayList<StudentDTO> studentsdtolist = (ArrayList<StudentDTO>) studentsdaolist.stream()
                                            .map(this::convertDAOtoDTO)
                                            .collect(Collectors.toList());
        return studentsdtolist;
    }

    public StudentDTO getStudentById(String student_id){
        Optional<StudentDAO> studentDAO = studentRepository.findById(student_id);
        return modelMapper.map(studentDAO, StudentDTO.class);
    }

    public String createStudent(StudentDTO studentDTO){
        StudentDAO studentDAO = modelMapper.map(studentDTO, StudentDAO.class);
        studentRepository.save(studentDAO);
        return "success";
    }


    public void updateStudent(String student_id, StudentDTO studentDTO){
        StudentDAO studentDAO = modelMapper.map(studentDTO, StudentDAO.class);
        studentRepository.save(studentDAO);
    }

    public void deleteStudent(String student_id){
        studentRepository.deleteById(student_id);
    }


}
