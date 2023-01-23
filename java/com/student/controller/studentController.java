package com.student.controller;

import com.student.dto.StudentDto;
import com.student.entities.Student;
import com.student.mapper.StudentMapper;
import com.student.service.departmentService;
import com.student.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class studentController {
    private studentService stdService;

    @Autowired
    public studentController(studentService stdService) {
        this.stdService = stdService;
    }

    @GetMapping("/getAll")
    public List<StudentDto> getAll() {
        return stdService.getAll();
    }

    @GetMapping("/oneStudent/{studentId}")
    public StudentDto getOneStudent(@PathVariable long studentId){
        return stdService.getOneStudent(studentId);
    }

    @PostMapping("/create")
    public StudentDto createStudent(@RequestBody StudentDto studentDto){
        return this.stdService.save(studentDto);
    }

    @PutMapping("/update/{studentId}")
    public StudentDto updateStudent(@RequestBody StudentDto studentDto,@PathVariable("studentId") long studentId){
        return this.stdService.updateStudent(studentDto,studentId);
    }

    @DeleteMapping("delete/{studentId}")
    public void deleteStudent(@PathVariable long studentId){
        this.stdService.deleteStudent(studentId);
    }


}
