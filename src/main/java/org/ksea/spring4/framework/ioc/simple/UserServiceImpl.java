package org.ksea.spring4.framework.ioc.simple;

import org.ksea.spring4.framework.model.User;

/**
 * Created by mexican on 2017/4/2.
 */
public class UserServiceImpl implements UserService {
    public UserServiceImpl() {
        System.out.println("开始初始化....对象");
    }

    public User getUser() {
        return new User(1, "张学友");
    }
}
