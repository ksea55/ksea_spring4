package org.ksea.spring4.framework.aop.advisor.beannameautoproxycreator;

/**
 * Created by ksea on 2017/4/5.
 */
public interface UserService {
    void queryUser();

    String getUser();

    void loadUser();

    String deleteUserById(Integer id);

}
