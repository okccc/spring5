package com.okccc.spring5.test;

import com.okccc.spring5.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author okccc
 * @date 2021/4/27 20:33
 * @desc
 */
public class TestDemo {
    @Test
    public void test01() {
        // 1.加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        // 2.获取配置中创建的对象
        User user = context.getBean("user", User.class);
        System.out.println(user);
        user.add();
    }

}
