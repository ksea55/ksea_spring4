package org.ksea.spring4.framework.jdbc.dao;

import org.ksea.spring4.framework.jdbc.model.Student;

import java.util.List;

/**
 * Created by mexican on 2017/4/1.
 */
public interface StudentDao {

    void insertStudent(Student student);

    void deleteStudentById(Integer sid);

    void updateStudent(Student student);

    String queryStudentNameById(Integer sid);

    List<String> queryStudentNames();

    Student queryStudentById(Integer sid);

    List<Student> queryStudents();
}
