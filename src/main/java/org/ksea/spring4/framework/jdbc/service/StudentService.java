package org.ksea.spring4.framework.jdbc.service;

import org.ksea.spring4.framework.jdbc.model.Student;

import java.util.List;

/**
 * Created by mexican on 2017/4/8.
 */
public interface StudentService {
    void addStudent(Student student);

    void removeStudentById(Integer sid);

    void modifyStudent(Student student);

    String findStudentNameById(Integer sid);

    List<String> findStudentNames();

    Student findStudentById(Integer sid);

    List<Student> findStudents();
}
