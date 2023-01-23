package com.student.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")

public class Department {

    @Id
    @GeneratedValue
    @Column(name = "department_id")
    private long departmentId;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "department",fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    private List<Student> students;

    public Department(long departmentId, String name,List<Student> students) {
        this.departmentId = departmentId;
        this.name = name;
        this.students = students;
    }

    public Department() {
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
