package org.ksea.spring4.framework.jdbc.service;

import org.ksea.spring4.framework.jdbc.dao.StudentDao;
import org.ksea.spring4.framework.jdbc.model.Student;


import java.util.List;

/**
 * Created by mexican on 2017/4/8.
 *
 */
public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void addStudent(Student student) {
        studentDao.insertStudent(student);

    }

    public void removeStudentById(Integer sid) {
        studentDao.deleteStudentById(sid);
    }

    public void modifyStudent(Student student) {
        studentDao.updateStudent(student);
    }

    public String findStudentNameById(Integer sid) {
        return studentDao.queryStudentNameById(sid);
    }

    public List<String> findStudentNames() {
        return studentDao.queryStudentNames();
    }

    public Student findStudentById(Integer sid) {
        return studentDao.queryStudentById(sid);
    }

    public List<Student> findStudents() {
        return studentDao.queryStudents();
    }
}
