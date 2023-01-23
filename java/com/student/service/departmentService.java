package com.student.service;

import com.student.dto.DepartmentDto;
import com.student.entities.Department;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface departmentService {

    List<DepartmentDto>getAl();
    DepartmentDto getOneDepartment(long departmentId);
    DepartmentDto save(DepartmentDto departmentDto);
    DepartmentDto updateDepartment(DepartmentDto departmentDto,long departmentId);
    void deleteDepartment(long departmentId);

}
