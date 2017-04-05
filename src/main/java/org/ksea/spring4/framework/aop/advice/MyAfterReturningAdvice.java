package org.ksea.spring4.framework.aop.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by ksea on 2017/4/5.
 * 自定义后置通知 在方法正常执行完毕之后返回通知
 */
public class MyAfterReturningAdvice implements AfterReturningAdvice {
    /**
     * @param returnValue 目标方法的返回值
     * @param method      目标方法
     * @param args        目标方法的参数
     * @param target      目标方法
     * @throws Throwable
     */
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("执行AfterReturningAdvice后置监控通知,目标对象的方法名称:" + method.getName() + ",目标对象的返回值:" + returnValue);
    }
}
