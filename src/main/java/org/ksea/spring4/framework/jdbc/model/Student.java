package org.ksea.spring4.framework.jdbc.model;

/**
 * Created by mexican on 2017/4/8.
 */
public class Student {
    private Integer sid;
    private String sname;
    private Integer age;

    public Student() {
    }

    public Student(String sname, Integer age) {
        this.sname = sname;
        this.age = age;
    }

    public Student(Integer sid, String sname, Integer age) {
        this.sid = sid;
        this.sname = sname;
        this.age = age;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                '}';
    }
}
