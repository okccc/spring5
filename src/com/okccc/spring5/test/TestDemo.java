package com.okccc.spring5.test;

import com.okccc.spring5.bean.User;
import com.okccc.spring5.config.Config;
import com.okccc.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * author okccc
 * date 2021/4/27 20:33
 * desc spring入门
 */
public class TestDemo {
    @Test
    public void testIoc() {
        // 加载Spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        // 获取配置中创建的对象
        User user = context.getBean("user", User.class);
        // 调用方法
        user.add();
    }

    @Test
    public void testAnnotation() {
        // 加载Spring配置类
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        // 获取对象
        UserService userService = context.getBean("userService", UserService.class);
        // 调用方法
        userService.add();
    }

    @Test
    public void testAop() {
        // 加载Spring配置类
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        // 获取对象
        User user = context.getBean("user", User.class);
        // 调用方法
        user.add();
    }

}
