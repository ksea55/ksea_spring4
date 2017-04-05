package org.ksea.spring4.framework.aop.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by ksea on 2017/4/5.
 */
public class MyMethodBeforeAdvice implements MethodBeforeAdvice {
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(method.getName()+"方法被增强,开启事务监控!");
    }
}
