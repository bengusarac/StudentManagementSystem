package com.student.repository;

import com.student.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface studentRepository extends JpaRepository<Student,Long> {
}
