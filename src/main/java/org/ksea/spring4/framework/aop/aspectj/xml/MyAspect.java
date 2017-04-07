package org.ksea.spring4.framework.aop.aspectj.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by mexican on 2017/4/6.
 * 定义Aspect切面POJO类
 */
public class MyAspect {

    public void doBefore() {
        System.out.println("执行前置通知doBefore()");
    }


    public void doBefore(JoinPoint joinPoint) {
        System.out.println("执行前置通知doBefore(JoinPoint joinPoint),并打印joinPoint连接点是:" + joinPoint);
    }

    //定义后置通知
    public void doAfterReturning() {
        System.out.println("执行后置通知 doAfterReturning()!");
    }

    //定义后置通知，并获取返回值
    public void doAfterReturning(Object returnValue) { //这里的参数的名称需与returning = "returnValue"保持一致
        System.out.println("执行后置通知 doAfterReturning(Object returnValue),并获取其返回值returnValue=" + returnValue);
    }


    //定义环绕通知
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable { //注意这里有一个ProceedingJoinPoint 的参数就相当于在 Spring中的MethodInterceptor中的那实现的方法的参数

        System.out.println("执行doAround()环绕通知之前,开始事务!");

        //执行目标方法
        Object returnValue = proceedingJoinPoint.proceed();

        System.out.println("执行doAround()环绕通知之后,关闭事务!");

        return returnValue;
    }

    //定义最终通知
    public void doAfter(){
        System.out.println("执行doAfter()最终通知!");
    }

    //定义异常通知
    public void doAfterThrow() {
        System.out.println("执行doAfterThrow()异常通知！");
    }

    //定义异常通知并获取该异常信息
    public void doAfterThrow(Exception ex) { //这里的异常信息ex参数名称需要与throwing = "ex"保持一致
        System.out.println("执行doAfterThrow()异常通知！并获取到该异常信息内容ex=" + ex.getMessage());
    }


}
