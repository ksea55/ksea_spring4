package org.ksea.spring4.framework.aop.aspectj.annotation;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by mexican on 2017/4/6.
 */

public class AspectTest {
    @Test
    public void aspectTest() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("org/ksea/spring4/framework/aop/aspectj/annotation/spring-aspectj-config.xml");

        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.getUserById(212);
        /*
        * 运行结果:
        * 执行前置通知doBefore()
            getUserById-->根据id获取用户信息!
        * */
        System.out.println("-----------------------------------");

        //这里是测试执行后置通知的情况
        userService.updateUserById(3232);
        /*运行结果:
                updateUserById-->根据id更新用户信息!
                执行后置通知 doAfterReturning()!*/

        System.out.println("-----------------------------------");

        //这里测试执行后置通知，并获取该方法的返回值
        userService.loadUser();
        /*
        * 运行结果:
        * loadUser-->加载用户信息!
            执行后置通知 doAfterReturning(Object returnValue),并获取其返回值returnValue=k.sea√ is good man！
        * */

        System.out.println("-----------------------------------");

        //此处测试执行环绕通知的用例
        String user = userService.removeUserById(2322);
        System.out.println(user);
        /*
        *   执行doAround()环绕通知之前,开始事务!
                 removeUserById-->根据id移除用户信息！并返回该删除的用户! //此处执行目标方法 removeUserById
            执行doAround()环绕通知之后,关闭事务!
            mexican 获取返回值

        * */

        System.out.println("-----------------------------------");
        //此处用于测试异常通知
        userService.getUsers();
        /*
        * 运行结果:
        * getUsers-->加载所有用户信息
        java.lang.RuntimeException: 加载用户信息列表异常!


        getUsers-->加载所有用户信息
        执行doAfter()最终通知！
        执行doAfterThrow()异常通知！并获取到该异常信息内容ex=加载用户信息列表异常!
        执行doAfterThrow()异常通知！

        * */


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
