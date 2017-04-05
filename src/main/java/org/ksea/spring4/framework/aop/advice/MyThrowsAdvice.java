package org.ksea.spring4.framework.aop.advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * Created by ksea on 2017/4/5.
 * 自定义异常通知
 * 源码中说明 需要实现其中的一个至少
 * <pre class="code">public void afterThrowing(Exception ex)</pre>
 * <pre class="code">public void afterThrowing(RemoteException)</pre>
 * <pre class="code">public void afterThrowing(Method method, Object[] args, Object target, Exception ex)</pre>
 * <pre class="code">public void afterThrowing(Method method, Object[] args, Object target, ServletException ex)</pre>
 * 顾明思议，就是被代理的原型对象出异常了，就会运行到实现此接口中的一个方法。
 * 这个和AfterReturningAdvice互补哦。
 */
public class MyThrowsAdvice implements ThrowsAdvice {
    public void afterThrowing(Exception ex) {
        System.out.println("ThrowsAdvice 捕获异常信息:" + ex.getMessage());
    }

    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {
        System.out.println("ThrowsAdvice 捕获到方法名:" + method.getName() + "目标对象是:" + target + "的异常信息:" + ex.getMessage());
    }


}
