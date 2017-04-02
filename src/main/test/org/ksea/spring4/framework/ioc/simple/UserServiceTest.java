package org.ksea.spring4.framework.ioc.simple;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ksea.spring4.framework.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by mexican on 2017/4/2.
 */
@RunWith(SpringJUnit4ClassRunner.class) //指明用spring的运行环境
@ContextConfiguration(locations = {"classpath:config/spring-config.xml"}) //说明配置文件
public class UserServiceTest {

    @Test
    public void getUserTest() {

        UserService userService = new UserServiceImpl();
        User user = userService.getUser();
        System.out.println(user); //User{uid=1, userName='张学友'}
        //从这里可以看到这种耦合度，比如当 UserService的实现名称变了，这里就会发生异常
    }

    @Test
    public void getUserTestByDI() {
        //通过spring的ioc中的依赖注入DI来进行解耦测试
        //根据spring的配置文件获取该容器
        ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config.xml");
        //根据上线文获取该实例
        UserService userService = (UserService) context.getBean("userService");
        User user = userService.getUser();
        System.out.println(user); //User{uid=1, userName='张学友'} 这种通过spring容器来进行注入，大大的将其解耦
    }

    /**
     * 作用域prototype测试
     */
    @Test
    public void getUserTestByPrototype() {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config.xml");
        //根据上线文获取该实例
        UserService userService1 = (UserService) context.getBean("userService1");
        UserService userService2 = (UserService) context.getBean("userService1");

        System.out.println(userService1 == userService2);
    }  /**
     * 作用域prototype测试
     */
    @Test
    public void getUserTestBySingleton() {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config.xml");
        //根据上线文获取该实例
        UserService userService1 = (UserService) context.getBean("userService2");
        UserService userService2 = (UserService) context.getBean("userService2");

        System.out.println(userService1 == userService2);
    }
}