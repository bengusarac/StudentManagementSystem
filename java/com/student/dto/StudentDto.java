package com.student.dto;

import com.student.entities.Department;
import com.student.mapper.DepartmentMapper;

public class StudentDto {

    private long studentId;
    private String firstName;
    private String lastName;
    private DepartmentDto departmentDto;

    public StudentDto(){}

    public StudentDto(Builder builder) {
        this.studentId = builder.studentId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.departmentDto = builder.departmentDto;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public DepartmentDto getDepartmentDto() {
        return departmentDto;
    }

    public void setDepartmentDto(DepartmentDto departmentDto) {
        this.departmentDto = departmentDto;
    }

    public static class Builder{

        private long studentId;
        private String firstName;
        private String lastName;
        private DepartmentDto departmentDto;

        public Builder(){

        }

        public static Builder StudentBuilderWith(){
            return new Builder();
        }

        public Builder studentId(long studentId){
            this.studentId = studentId;
            return this;
        }
        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }
        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }
        public Builder department(Department department){
            DepartmentMapper dMapper = new DepartmentMapper();
            if(department!=null)
                this.departmentDto = dMapper.mapV1(department);
            else
                this.departmentDto = null;
            return this;
        }
        public StudentDto build(){
            return new StudentDto(this);
        }
    }
}

