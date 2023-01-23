package com.student.dto;

import com.student.entities.Department;
import com.student.entities.Student;
import com.student.mapper.StudentMapper;

import java.util.List;

public class DepartmentDto {

    private long departmentId;
    private String name;
    private List<StudentDto> students;

    public DepartmentDto(Builder builder) {
        this.departmentId = builder.departmentId;
        this.name = builder.name;
        this.students = builder.students;
    }

    public DepartmentDto() {
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudentDto> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDto> students) {
        this.students = students;
    }

    public static class Builder{

        private long departmentId;
        private String name;
        private List<StudentDto> students;

        public Builder(){}

        public static Builder DepartmentBuilderWith(){
            return new Builder();
        }
        public Builder departmentId(long departmentId){
            this.departmentId = departmentId;
            return this;
        }
        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder students(List<Student> studentList){
          
            StudentMapper stdMapper = new StudentMapper();
            if(studentList != null){
                this.students = stdMapper.mapList(studentList);
            }
            else{
                this.students = null;
            }
            return this;
        }
        public DepartmentDto build(){
            return new DepartmentDto(this);
        }

    }
}
