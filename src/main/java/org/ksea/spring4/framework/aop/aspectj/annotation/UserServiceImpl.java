package org.ksea.spring4.framework.aop.aspectj.annotation;

/**
 * Created by mexican on 2017/4/6.
 */
public class UserServiceImpl implements UserService {
    public String getUserById(Integer id) {
        System.out.println("getUserById-->根据id获取用户信息!");
        return "mexican";
    }

    public void updateUserById(Integer id) {
        System.out.println("updateUserById-->根据id更新用户信息!");
    }

    public String removeUserById(Integer id) {
        System.out.println("removeUserById-->根据id移除用户信息！并返回该删除的用户!");
        return "mexican";
    }

    public String loadUser() {
        System.out.println("loadUser-->加载用户信息!");
        return "k.sea√ is good man！";
    }

    /*该方法用于测试异常通知*/
    public void getUsers() {
        System.out.println("getUsers-->加载所有用户信息");
        throw new RuntimeException("加载用户信息列表异常!");
    }

}
