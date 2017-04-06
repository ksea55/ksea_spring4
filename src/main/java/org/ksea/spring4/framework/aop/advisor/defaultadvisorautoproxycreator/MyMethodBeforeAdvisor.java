package org.ksea.spring4.framework.aop.advisor.defaultadvisorautoproxycreator;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by ksea on 2017/4/5.
 * 自定义前置通知
 */
public class MyMethodBeforeAdvisor implements MethodBeforeAdvice {
    /**
     * @param method  目标方法
     * @param objects 目标方法的参数列表
     * @param o       目标对象
     * @throws Throwable
     */
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(method.getName() + "方法被增强,开启事务监控!");
    }
}
