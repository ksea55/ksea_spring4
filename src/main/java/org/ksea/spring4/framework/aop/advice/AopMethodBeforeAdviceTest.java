package org.ksea.spring4.framework.aop.advice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ksea on 2017/4/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:org/ksea/spring4/framework/aop/advice/spring-advice-config.xml"})
public class AopMethodBeforeAdviceTest {
    @Test
    public void methodBeforeAdviceTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("org/ksea/spring4/framework/aop/advice/spring-advice-config.xml");
        //注意在这里增强之后，返回的是其代理对象，因此在这里我们应该获取的是代理的对象

        UserService userService = (UserService) applicationContext.getBean("proxyUserService");
        userService.queryUser();
        /*运行结果
             queryUser方法被增强,开启事务监控
            查询用户信息queryUser
            执行AfterReturningAdvice后置监控通知,目标对象的方法名称:queryUser,目标对象的返回值:null
        *
        * */


        String user = userService.getUser();
        System.out.println(user);
        /*
        * 运行结果:
            getUser方法被增强,开启事务监控!
            执行AfterReturningAdvice后置监控通知,目标对象的方法名称:getUser,目标对象的返回值:K.sea√
            K.sea√

        * */
    }

    @Test
    public void afterReturningAdiveTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("org/ksea/spring4/framework/aop/advice/spring-advice-config.xml");
        //注意在这里增强之后，返回的是其代理对象，因此在这里我们应该获取的是代理的对象

        UserService userService = (UserService) applicationContext.getBean("proxyUserService");
        String user = userService.getUser();
        System.out.println(user);
        /*
        * 运行结果:
            getUser方法被增强,开启事务监控!
            执行AfterReturningAdvice后置监控通知,目标对象的方法名称:getUser,目标对象的返回值:K.sea√
            K.sea√

        * */
    }


    @Test
    public void throwsAdviceTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("org/ksea/spring4/framework/aop/advice/spring-advice-config.xml");
        //注意在这里增强之后，返回的是其代理对象，因此在这里我们应该获取的是代理的对象

        UserService userService = (UserService) applicationContext.getBean("proxyUserService");
        userService.loadUser();
        /*
        * 运行结果:
        *   loadUser方法被增强,开启事务监控!
            执行了 loadUser方法
            ThrowsAdvice 捕获到方法名:loadUser目标对象是:org.ksea.spring4.framework.aop.advice.UserServiceImpl@7a69b07的异常信息:在loadUser方法中抛出运行时异常!

            java.lang.RuntimeException: 在loadUser方法中抛出运行时异常!
        * */
    }

    @Test
    public void methodInterceptorTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("org/ksea/spring4/framework/aop/advice/spring-advice-config.xml");
        //注意在这里增强之后，返回的是其代理对象，因此在这里我们应该获取的是代理的对象

        UserService userService = (UserService) applicationContext.getBean("proxyUserService");
        String user = userService.deleteUserById(23231);
        System.out.println(user);
        /*
        * 运行结果:
        *   deleteUserById方法被增强,开启事务监控! //执行前置通知
            用户id是：23231的用户被删除了,并返回该用户:jacky 执行目标方法
            MethodInterceptor 中的 method name:deleteUserById、参数列表:[Ljava.lang.Object;@6ca8564a //执行MethodInterceptor方法拦截器
            执行AfterReturningAdvice后置监控通知,目标对象的方法名称:deleteUserById,目标对象的返回值:jacky //执行后置通知
            jacky! //输出最终返回结果
        * */
    }
}
