package org.ksea.spring4.framework.aop.aspectj.xml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by mexican on 2017/4/6.
 */

public class AspectTest {
    @Test
    public void aspectTest() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("org/ksea/spring4/framework/aop/aspectj/xml/spring-aspectj-config.xml");

        UserService userService = (UserService) applicationContext.getBean("userService");
        String user = userService.getUserById(212);
        System.out.println("打印返回值:" + user);

        System.out.println("--------------------------------");

        userService.getUsers();
    }


    @Test
    public void pointcutTest() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("org/ksea/spring4/framework/aop/aspectj/annotation/spring-aspectj-config.xml");

        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.removeUserById(212);
        /*
        * 执行doAround()环绕通知之前,开始事务!
        执行doBeforeByPointcut()切入点！
        removeUserById-->根据id移除用户信息！并返回该删除的用户!
        执行doAround()环绕通知之后,关闭事务!
        * */
    }

}
