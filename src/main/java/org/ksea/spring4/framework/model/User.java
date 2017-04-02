package org.ksea.spring4.framework.model;

/**
 * Created by mexican on 2017/4/2.
 */
public class User {
    private Integer uid;
    private String userName;

    public User() {

    }

    public User(Integer uid, String userName) {
        this.uid = uid;
        this.userName = userName;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                '}';
    }
}
