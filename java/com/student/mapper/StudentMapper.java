package com.student.mapper;

import com.student.dto.DepartmentDto;
import com.student.dto.StudentDto;
import com.student.entities.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class StudentMapper {

    public Student convert(StudentDto studentDto){

        Student student = new Student();
        student.setStudentId(studentDto.getStudentId());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());

        DepartmentMapper mapper = new DepartmentMapper();
        student.setDepartment(mapper.convert(studentDto.getDepartmentDto()));

        return student;
    }

    public  StudentDto map(Student student){

        return StudentDto.Builder.StudentBuilderWith()
                .studentId(student.getStudentId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .department(student.getDepartment())
                .build();
    }

    public List<StudentDto> mapList(List<Student> studentList){
        List<StudentDto> returnList = new ArrayList<>();
        for (Student student:studentList) {
            returnList.add(map(student));
        }
        return returnList;
    }

}
