package org.ksea.spring4.framework.ioc.simple;

import org.ksea.spring4.framework.model.User;

/**
 * Created by mexican on 2017/4/2.
 */
public class UserServiceImpl implements UserService {
    public User getUser() {
        return new User(1, "张学友");
    }
}
