package org.ksea.spring4.framework.aop.advice;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * Created by ksea on 2017/4/5.
 * 实现MethodInterceptor 接口
 * 在调用目标对象的方法时，就可以实现在调用方法之前、调用方法过程中、调用方法之后对其进行控制。
 * <p>
 * MethodInterceptor 接口可以实现
 * MethodBeforeAdvice接口、
 * AfterReturningAdvice接口、
 * ThrowsAdvice接口这三个接口能够所能够实现的功能，
 * 但是应该谨慎使用MethodInterceptor 接口，
 * 很可能因为一时的疏忽忘记最重要的MethodInvocation而造成对目标对象方法调用失效，或者不能达到预期的设想。
 * 注意这里的MethodInterceptor是位于 org.aopalliance.intercept包
 */
public class MyMethodInterceptor implements MethodInterceptor {


    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod(); //获取到目标方法
        Object[] arguments = invocation.getArguments();  //目标方法的参数列表
        Object returnValue = invocation.proceed(); //
        System.out.println("MethodInterceptor 中的 method name:" + method.getName() + "、参数列表:" + arguments);
        return returnValue;
    }
}
