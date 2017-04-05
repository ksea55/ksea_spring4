package org.ksea.spring4.framework.aop.advice;

import org.springframework.stereotype.Service;

/**
 * Created by ksea on 2017/4/5.
 */
@Service
public class UserServiceImpl implements UserService {
    public void queryUser() {
        System.out.println("查询用户信息queryUser");
    }
}
