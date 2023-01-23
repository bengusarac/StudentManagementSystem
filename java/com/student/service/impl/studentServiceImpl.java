package com.student.service.impl;

import com.student.dto.StudentDto;
import com.student.entities.Student;
import com.student.mapper.StudentMapper;
import com.student.repository.studentRepository;
import com.student.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class studentServiceImpl implements studentService {

    private studentRepository stdRepository;
    private StudentMapper studentMapper;

    @Autowired
    public studentServiceImpl(studentRepository stdRepository, StudentMapper studentMapper) {
        this.stdRepository = stdRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public List<StudentDto> getAll() {
        return studentMapper.mapList(stdRepository.findAll());
    }

    @Override
    public StudentDto getOneStudent(long studentId) {

        return studentMapper.map(stdRepository.getReferenceById(studentId));
    }

    @Override
    public StudentDto save(StudentDto studentDto) {

        Student student = stdRepository.save(studentMapper.convert(studentDto));
        return studentMapper.map(student);
    }

    @Override
    public StudentDto updateStudent(StudentDto studentDto, long studentId) {

        Optional<Student> student1 = stdRepository.findById(studentId);
        if(student1.isPresent()){
            Student foundStudent = student1.get();
            foundStudent.setFirstName(studentDto.getFirstName());
            foundStudent.setLastName(studentDto.getLastName());
            stdRepository.save(foundStudent);

            return studentMapper.map(stdRepository.save(student1.get()));
        }
        else{
            return null;
        }
    }

    @Override
    public void deleteStudent(long studentId) {

        stdRepository.deleteById(studentId);
    }

}

