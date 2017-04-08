package org.ksea.spring4.framework.jdbc.dao;

import org.ksea.spring4.framework.jdbc.model.Student;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * Created by mexican on 2017/4/8.
 * 这里dao层中我们要使用Jdbc的模版需要继承JdbcDaoSupport
 */
public class StudentDaoImpl extends JdbcDaoSupport implements StudentDao {
    /*在spring中jdbc的模版的insert，update，delete都是通过一个方法来实现的update
    *
    * */
    public void insertStudent(Student student) {
        String sql = "insert into student(sname,age)values(?,?)";
        this.getJdbcTemplate().update(sql, student.getSname(), student.getAge());
    }

    public void deleteStudentById(Integer sid) {
        String sql = "delete from student WHERE sid=?";
        this.getJdbcTemplate().update(sql, sid);

    }

    public void updateStudent(Student student) {
        String sql = "update student set sname=?,age=? where sid=?";
        this.getJdbcTemplate().update(sql, student.getSname(), student.getAge(), student.getSid());
    }

    public String queryStudentNameById(Integer sid) {
        String sql = "select sname from student where sid=?";
        return this.getJdbcTemplate().queryForObject(sql, String.class, sid);

    }

    public List<String> queryStudentNames() {
        String sql = "select sname from student";
        return this.getJdbcTemplate().queryForList(sql, String.class);

    }

    public Student queryStudentById(Integer sid) {

        /*当在映射对象的时候，Spring这里会报错需要用到
          org.springframework.jdbc.IncorrectResultSetColumnCountException: Incorrect column count: expected 1, actual 3*/

        String sql = "select sid,sname,age from student where sid=?";
        // return this.getJdbcTemplate().queryForObject(sql, Student.class, sid);

        return this.getJdbcTemplate().queryForObject(sql, new MyRowMapper(), sid);


    }

    public List<Student> queryStudents() {
        String sql = "select * from student";
//        return this.getJdbcTemplate().queryForList(sql, Student.class);

        return this.getJdbcTemplate().query(sql, new MyRowMapper());
    }
}
