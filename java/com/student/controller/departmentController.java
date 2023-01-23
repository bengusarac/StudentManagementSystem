package com.student.controller;

import com.student.dto.DepartmentDto;
import com.student.entities.Department;
import com.student.entities.Student;
import com.student.service.departmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class departmentController {

    private departmentService depService;
    @Autowired

    public departmentController(departmentService depService) {
        this.depService = depService;
    }

    @GetMapping("/getAll")
    public List<DepartmentDto> getAll(){

        return depService.getAl();
    }

    @GetMapping("/oneDepartment/{departmentId}")
    public DepartmentDto getOneDepartment(@PathVariable long departmentId){
        return depService.getOneDepartment(departmentId);
    }

    @PostMapping("/create")
    public DepartmentDto createDepartment(@RequestBody DepartmentDto departmentDto){

        return this.depService.save(departmentDto);
    }

    @PutMapping("/update/{departmentId}")
    public DepartmentDto updateDepartment(@RequestBody DepartmentDto departmentDto, @PathVariable("departmentId") long departmentId){
        return this.depService.updateDepartment(departmentDto,departmentId);
    }
    @DeleteMapping("delete/{departmentId}")
    public void deleteDepartment(@PathVariable long departmentId){
        this.depService.deleteDepartment(departmentId);
    }

}
