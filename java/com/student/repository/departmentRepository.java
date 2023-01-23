package com.student.repository;

import com.student.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface departmentRepository extends JpaRepository<Department,Long> {

}
