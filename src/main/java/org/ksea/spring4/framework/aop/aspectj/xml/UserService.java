package org.ksea.spring4.framework.aop.aspectj.xml;

/**
 * Created by mexican on 2017/4/6.
 */
public interface UserService {
    String getUserById(Integer id);

    void updateUserById(Integer id);

    String removeUserById(Integer id);

    String loadUser();

    void getUsers();
}
