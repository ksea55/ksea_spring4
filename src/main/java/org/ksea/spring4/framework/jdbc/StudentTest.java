package org.ksea.spring4.framework.jdbc;

import org.junit.Before;
import org.junit.Test;
import org.ksea.spring4.framework.jdbc.model.Student;
import org.ksea.spring4.framework.jdbc.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by mexican on 2017/4/8.
 */
public class StudentTest {

    StudentService studentService;

    @Before
    public void before() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("org/ksea/spring4/framework/jdbc/spring-jdbc-config.xml");

        studentService = (StudentService) applicationContext.getBean("studentService");

    }

    @Test
    public void addStudentTest() {
        studentService.addStudent(new Student("mexican", 21));
    }

    @Test
    public void removeStudentByIdTest() {
        studentService.removeStudentById(2);
    }


    @Test
    public void modifyStudentTest() {
        studentService.modifyStudent(new Student(3, "jacky", 33));
    }

    @Test
    public void findStudentNameByIdTest() {
        String name = studentService.findStudentNameById(3);
        System.out.println(name);
    }

    @Test
    public void findStudentNamesTest() {
        List<String> names = studentService.findStudentNames();
        System.out.println(names);
    }

    @Test
    public void findStudentByIdTest() {
        Student student = studentService.findStudentById(3);
        System.out.println(student);
    }

    @Test
    public void findStudentsTest() {
        List<Student> students = studentService.findStudents();
        System.out.println(students);
    }
}
