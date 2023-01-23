package com.student.entities;

import javax.persistence.*;

@Entity
@Table(name = "student")

public class Student {
    @Id
    @GeneratedValue
    @Column(name = "studentId")
    private long studentId;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    public Student(String firstName, String lastName, long studentId, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.setDepartment(department);
    }

    public Student() {
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
