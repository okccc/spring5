package com.okccc.spring5.proxy;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Author: okccc
 * Date: 2021/5/12 下午4:00
 * Desc: 增强类
 */

@Component
@Aspect
@Order(1)
public class PersonProxy {

    @Before(value = "execution(* com.okccc.spring5.bean.User.test())")
    public void before() {
        System.out.println("person before...");
    }
}
