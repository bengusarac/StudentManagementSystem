package com.student.mapper;

import com.student.dto.DepartmentDto;
import com.student.dto.StudentDto;
import com.student.entities.Department;
import com.student.entities.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class DepartmentMapper {

    public Department convert(DepartmentDto departmentDto){

        Department department = new Department();
        department.setDepartmentId(departmentDto.getDepartmentId());
        department.setName(departmentDto.getName());
        return department;
    }

    public  DepartmentDto map(Department department){

        StudentMapper sMapper = new StudentMapper();
        return DepartmentDto.Builder.DepartmentBuilderWith()
                .departmentId(department.getDepartmentId())
                .name(department.getName())
                .students(department.getStudents())         
                .build();
    }

    public DepartmentDto mapV1(Department department){

        return DepartmentDto.Builder.DepartmentBuilderWith()
                .departmentId(department.getDepartmentId())
                .name(department.getName())
                .build();
    }

    public List<DepartmentDto> mapList(List<Department> departmentList){
        List<DepartmentDto> returnList = new ArrayList<>();
        for (Department department : departmentList) {
            returnList.add(map(department));
        }
        return returnList;
    }
}
