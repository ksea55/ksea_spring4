package org.ksea.spring4.framework.jdbc.dao;

import org.ksea.spring4.framework.jdbc.model.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mexican on 2017/4/8.
 */
public class MyRowMapper implements RowMapper<Student> {


    public Student mapRow(ResultSet resultSet, int rowNo) throws SQLException {
        Student student = new Student();
        student.setSid(resultSet.getInt("sid"));
        student.setSname(resultSet.getString("sname"));
        student.setAge(resultSet.getInt("age"));

        return student;
    }
}
