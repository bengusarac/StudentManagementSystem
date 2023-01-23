package com.student.service.impl;
import com.student.dto.DepartmentDto;
import com.student.entities.Department;
import com.student.entities.Student;
import com.student.mapper.DepartmentMapper;
import com.student.repository.departmentRepository;
import com.student.service.departmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class departmentServiceImpl implements departmentService {

    private departmentRepository depRepository;
    private DepartmentMapper departmentMapper;

    @Autowired
    public departmentServiceImpl(departmentRepository depRepository, DepartmentMapper departmentMapper) {
        this.depRepository = depRepository;
        this.departmentMapper = departmentMapper;
    }
    @Override
    public List<DepartmentDto> getAl() {

        return departmentMapper.mapList(depRepository.findAll());
    }

    @Override
    public DepartmentDto getOneDepartment(long departmentId) {
        return departmentMapper.map(depRepository.getReferenceById(departmentId));
    }

    @Override
    public DepartmentDto save(DepartmentDto departmentDto) {
        
        Department department = depRepository.save(departmentMapper.convert(departmentDto));
        return departmentMapper.map(department);
    }

    @Override
    public DepartmentDto updateDepartment(DepartmentDto departmentDto, long departmentId) {

        Optional<Department> department1 = this.depRepository.findById(departmentId);
        if(department1.isPresent()){
            Department foundDepartment = department1.get();
            foundDepartment.setName(departmentDto.getName());
            this.depRepository.save(foundDepartment);

            return departmentMapper.map(depRepository.save(department1.get()));
        }
        else{
            return null;
        }
    }

    @Override
    public void deleteDepartment(long departmentId) {
        depRepository.deleteById(departmentId);
    }

}
