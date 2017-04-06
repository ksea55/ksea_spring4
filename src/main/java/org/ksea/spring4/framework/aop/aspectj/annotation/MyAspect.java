package org.ksea.spring4.framework.aop.aspectj.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by mexican on 2017/4/6.
 * 自定义切面
 */
@Aspect //声明切面POJO类
public class MyAspect {
    /*
    * 就是对org.ksea.spring4.framework.aop.aspectj.annotation.UserService的getUserById()方法进行前置增强
    * */
    @Before(value = "execution(* *..aop.aspectj..*.getUserById(..))")
    public void doBefore() {
        System.out.println("执行前置通知doBefore()");
    }

    @Before(value = "execution(* *..aop.aspectj..*.getUserById(..))")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("执行前置通知doBefore(JoinPoint joinPoint),并打印joinPoint连接点是:" + joinPoint);
        /*打印结果 执行前置通知doBefore(JoinPoint joinPoint),
          并打印joinPoint连接点是:
          execution(String org.ksea.spring4.framework.aop.aspectj.annotation.UserService.getUserById(Integer))
          从结果我们可以看到joinPoint是切面表达式 execution中具体的某个类或者接口的方法
         */
    }

    //定义后置通知
    @AfterReturning(value = "execution(* *..aop.aspectj..*.updateUserById(..))")
    public void doAfterReturning() {
        System.out.println("执行后置通知 doAfterReturning()!");
    }

    //定义后置通知，并获取返回值
    @AfterReturning(value = "execution(* *..aop.aspectj..*.loadUser(..))", returning = "returnValue")
    public void doAfterReturning(Object returnValue) { //这里的参数的名称需与returning = "returnValue"保持一致
        System.out.println("执行后置通知 doAfterReturning(Object returnValue),并获取其返回值returnValue=" + returnValue);
    }


    //定义环绕通知
    @Around(value = "execution(* *..aop.aspectj..*.removeUserById(..))")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable { //注意这里有一个ProceedingJoinPoint 的参数就相当于在 Spring中的MethodInterceptor中的那实现的方法的参数

        System.out.println("执行doAround()环绕通知之前,开始事务!");

        //执行目标方法
        Object returnValue = proceedingJoinPoint.proceed();

        System.out.println("执行doAround()环绕通知之后,关闭事务!");

        return returnValue;
    }

    //定义异常通知
    @AfterThrowing(value = "execution(* *..aop.aspectj..*.getUsers(..))")
    public void doAfterThrow() {
        System.out.println("执行doAfterThrow()异常通知！");
    }

    //定义异常通知并获取该异常信息
    @AfterThrowing(value = "execution(* *..aop.aspectj..*.getUsers(..))", throwing = "ex")
    public void doAfterThrow(Exception ex) { //这里的异常信息ex参数名称需要与throwing = "ex"保持一致
        System.out.println("执行doAfterThrow()异常通知！并获取到该异常信息内容ex=" + ex.getMessage());
    }

    //定义最终通知 该通知就相当于try..catch中的finally 都会执行
    @After(value = "execution(* *..aop.aspectj..*.getUsers(..))")
    public void doAfter() {
        System.out.println("执行doAfter()最终通知！");
    }


    //定义切入点
    @Pointcut(value = "execution(* *..aop.aspectj..*.removeUserById(..))")
    private void pointcut() {
    }

    //调用切入点
    @Before("pointcut()") //这里直接给切入点的方法签名以及括号也要带上
    public  void doBeforeByPointcut(){
        System.out.println("执行doBeforeByPointcut()切入点！");
    }
}
