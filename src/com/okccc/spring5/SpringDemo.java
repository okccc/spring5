package com.okccc.spring5;

import com.okccc.spring5.bean.User;
import com.okccc.spring5.config.Config;
import com.okccc.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * author okccc
 * date 2021/4/27 20:33
 * desc spring入门
 */
public class SpringDemo {
    /*
     * Spring是轻量级javaee开源框架,包含IOC和AOP两个核心部分,优点是方便解耦/测试/整合其他框架/进行事务操作/降低api开发难度
     *
     * IOC(Inversion of Control): 控制反转,把对象创建和对象之间相互调用的过程交给Spring管理,降低耦合度
     * IOC底层原理: 工厂模式 + xml解析 + 反射
     * IOC操作bean管理的两种方式: 1.xml配置文件 2.配置类+注解(推荐)
     * BeanFactory - ApplicationContext - ClassPathXmlApplicationContext/AnnotationConfigApplicationContext(推荐)
     * 注解是代码的特殊标记,@注解名称(属性名称=属性值),可以作用于类/属性/方法/构造器,使用注解替代xml配置以简化开发
     * Spring针对创建bean实例提供了四个注解: @Component/@Service/@Controller/@Repository
     *
     * AOP(Aspect Oriented Programming): 切面编程,不修改源代码增强功能,将业务逻辑各个子模块分离,降低耦合度
     * Spring框架使用AspectJ实现AOP操作,推荐使用注解方式
     * 动态代理: 在运行时动态的生成目标对象的代理对象,在代理对象中对目标对象的方法进行增强
     * AOP底层是通过动态代理实现的,有接口就创建接口的实现类的代理对象来增强类的方法,没有接口就创建子类的代理对象来增强类的方法
     * 常用术语
     * 连接点: 类里面可以被增强的方法
     * 切入点: 类里面实际被增强的方法,通过切入点表达式指定,execution([权限修饰符][返回类型][类全路径][方法名称]([参数列表]))
     * execution(* com.okccc.dao.*.* (..))       对指定包的所有类的所有方法进行增强
     * execution(* com.okccc.dao.BookDao.* (..)) 对指定包的指定类的所有方法进行增强
     * execution(* com.okccc.dao.BookDao.add(..))对指定包的指定类的指定方法进行增强
     * 通知: 类里面实际被增强的逻辑部分,包括前置通知/后置通知/环绕通知/异常通知/最终通知
     * 切面: 把通知应用到切入点的过程
     *
     * JdbcTemplate: Spring将jdbc进行封装,方便对数据库做crud操作
     * Config配置类创建数据源 - UserService - UserDao - UserDaoImpl - JdbcTemplate
     *
     * 事务: 就是对表的更新操作(insert/delete/update),使数据从一种状态变换到另一种状态,有acid四大特性,通常放在javaee三层架构的Service层
     * Spring主要使用声明式事务管理: 1.基于xml配置文件  2.基于注解(推荐)
     * Config配置类创建事务管理器 - UserService添加事务注解 - UserDao - UserDaoImpl - JdbcTemplate
     * propagation：传播行为,默认REQUIRED
     * isolation：隔离级别,默认REPEATABLE_READ
     * timeout：超时时间,默认-1,事务要在一定时间内提交,不然会回滚
     * readOnly：默认false可以增删改,true表示只能查询
     * (no)rollbackFor：设置出现哪些异常进行/不进行事务回滚
     *
     */

    @Test
    public void testIoc() {
        // 加载Spring配置文件: ApplicationContext是BeanFactory接口的子接口,提供更多功能给开发人员使用,加载配置文件时就会创建
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        // 获取bean对象: BeanFactory是IOC容器的基本实现,Spring内部使用接口,不提供开发人员使用,加载配置文件时不会创建,获取对象时才会创建
        User user = context.getBean("user", User.class);
        // 调用方法
        user.test();
    }

    @Test
    public void testAnnotation() {
        // 加载Spring配置类
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        // 获取bean对象
        UserService userService = context.getBean("userService", UserService.class);
        // 调用方法
        userService.test();
    }

    @Test
    public void testAop() {
        // 加载Spring配置类
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        // 获取bean对象
        User user = context.getBean("user", User.class);
        // 调用方法
        user.test();
    }

    @Test
    public void testJdbcTemplate() {
        // 加载Spring配置文件
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        // 获取bean对象
        User user = context.getBean("user", User.class);
        UserService userService = context.getBean("userService", UserService.class);
        user.setId(2);
        user.setName("fly");
        user.setAge(19);
        // crud操作
//        userService.add(user);
//        userService.update(user);
//        userService.delete(1);
//        System.out.println(userService.query());
        // 批量操作
        Object[] o1 = {3, "aaa", 19};
        Object[] o2 = {4, "bbb", 21};
        Object[] o3 = {20, 1};
        Object[] o4 = {3};
        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(o4);
        userService.batchUpdate(batchArgs);
    }

    @Test
    public void testTX() {
        // 加载Spring配置类
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        // 获取bean对象
        UserService userService = context.getBean("userService", UserService.class);
        // 调用方法
        userService.account();
    }

}
