package com.okccc.spring5.proxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Author: okccc
 * Date: 2021/5/12 下午3:03
 * Desc: 增强类
 */

@Component
@Aspect  // 生成代理对象
@Order(2)  // 当有多个增强类时要设置优先级,数字越小优先级越高
public class UserProxy {

    // 将相同切入点抽取出来
    @Pointcut(value = "execution(* com.okccc.spring5.bean.User.add())")
    public void pointCut() {
    }

    // 前置通知
    @Before(value = "execution(* com.okccc.spring5.bean.User.add())")
    public void before() {
        System.out.println("before...");
    }

    // 后置通知(返回通知)
    @AfterReturning(value = "pointCut()")
    public void afterReturning() {
        System.out.println("after returning...");
    }

    // 环绕通知
    @Around(value = "pointCut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前...");
        // 被增强方法执行
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后...");
    }

    // 异常通知
    @AfterThrowing(value = "pointCut()")
    public void afterThrowing() {
        System.out.println("after throwing...");
    }

    // 最终通知
    @After(value = "pointCut()")
    public void after() {
        System.out.println("after...");
    }

}
