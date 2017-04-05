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
        /*
        * 运行结果:
        * queryUser方法被增强,开启事务监控!
            查询用户信息queryUser

           我们可以看到在这里在执行queryUser()方法之前，before的拦截代理对其进行了增强
        * */
    }
}
