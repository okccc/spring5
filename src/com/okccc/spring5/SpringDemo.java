package com.okccc.spring5;

/**
 * @author okccc
 * @date 2021/4/27 20:47
 * @desc Spring5入门
 */
public class SpringDemo {
    public static void main(String[] args) {
        /*
         * Spring是轻量级javaee开源框架,包含IOC和AOP两个核心部分,优点是方便解耦/测试/整合其他框架/进行事务操作/降低api开发难度
         *
         * IOC(Inversion of Control)：控制反转,把对象创建和对象之间相互调用的过程交给spring管理,降低代码耦合度
         * IOC底层原理：工厂模式 + xml解析 + 反射
         * IOC容器的两个接口
         * BeanFactory：IOC容器的基本实现,Spring内部使用的接口,不提供开发人员使用,加载配置文件时不会创建对象,获取对象时才会创建
         * ApplicationContext：BeanFactory接口的子接口,提供更多功能供开发人员使用,加载配置文件时就会创建对象
         * ApplicationContext包含两个加载配置文件的实现类：FileSystemXmlApplicationContext和ClassPathXmlApplicationContext
         * IOC基于注解方式操作bean管理
         * 注解是代码的特殊标记,@注解名称(属性名称=属性值),可以作用于类/属性/方法/构造器,使用注解来替代xml配置
         * Spring针对创建bean实例提供了四个注解：@Component/@Service/@Controller/@Repository
         *
         * AOP：切面编程,不修改源代码添加新功能,将业务逻辑各个子模块分离,降低耦合度
         *
         */
    }
}
