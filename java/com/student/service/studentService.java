package com.student.service;

import com.student.dto.StudentDto;
import com.student.entities.Student;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface studentService {

    List<StudentDto>getAll();
    StudentDto getOneStudent(long studentId);
    StudentDto save(StudentDto student);
    StudentDto updateStudent(StudentDto student,long studentId);
    void deleteStudent(long studentId);

}
