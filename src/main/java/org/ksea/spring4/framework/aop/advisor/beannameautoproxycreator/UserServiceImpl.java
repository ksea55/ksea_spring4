package org.ksea.spring4.framework.aop.advisor.beannameautoproxycreator;

import org.springframework.stereotype.Service;

/**
 * Created by ksea on 2017/4/5.
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * 查询用户功能
     */
    public void queryUser() {
        System.out.println("查询用户信息queryUser");
    }

    /**
     * 获取用户信息
     *
     * @return 返回用户信息
     */
    public String getUser() {
        return "K.sea√";
    }

    /**
     * 加载user 用于配合ThrowsAdvice
     */
    public void loadUser() {
        System.out.println("执行了 loadUser方法");
        throw new RuntimeException("在loadUser方法中抛出运行时异常!");
    }

    /**
     * 根据id删除用户信息 用户配合MethodInterceptor
     *
     * @param id
     * @return
     */
    public String deleteUserById(Integer id) {
        System.out.println("用户id是：" + id + "的用户被删除了,并返回该用户:jacky");
        return "jacky";
    }
}
