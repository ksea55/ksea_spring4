package org.ksea.spring4.framework.aop.advisor;

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
@ContextConfiguration(locations = {"classpath:org/ksea/spring4/framework/aop/advisor/spring-advisor-config.xml"})
public class AopNameMatchMethodPointcutAdvisorTest {
    @Test
    public void methodBeforeAdviceTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("org/ksea/spring4/framework/aop/advisor/spring-advisor-config.xml");


        UserService userService = (UserService) applicationContext.getBean("proxyUserService");
        userService.queryUser();

        String user = userService.getUser();
        System.out.println(user);

       // userService.loadUser();

        userService.deleteUserById(2321);

        /**
         * queryUser方法被增强,开启事务监控!
            查询用户信息queryUser

         getUser方法被增强,开启事务监控!
         K.sea√

         loadUser方法被增强,开启事务监控!
         执行了 loadUser方法

         从运行结果 我们就可以看出 Advisor顾问可以，给某个具体的方法进行明确的切入增强，对不必要的方法就可以不必增强
         */
    }


}
