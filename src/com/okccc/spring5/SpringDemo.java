package com.okccc.spring5;

/**
 * @author okccc
 * @date 2021/4/27 20:47
 * @desc
 */
public class SpringDemo {
    public static void main(String[] args) {
        /*
         * Spring是轻量级的javaee开源框架
         *
         * Spring包含IOC和AOP两个核心部分
         * IOC(Inversion of Control)：控制反转,把对象创建和对象之间相互调用的过程交给spring管理,目的是为了降低耦合度
         * IOC底层原理：工厂模式 + xml解析 + 反射
         * Spring提供了实现IOC容器的两个接口
         * BeanFactory：IOC容器的基本实现,Spring内部使用的接口,不提供开发人员使用,加载配置文件时不会创建对象,获取对象时才会创建
         * ApplicationContext：BeanFactory接口的子接口,提供更多功能供开发人员使用,加载配置文件时就会创建对象
         * ApplicationContext包含两个加载配置文件的实现类：FileSystemXmlApplicationContext和ClassPathXmlApplicationContext
         *
         *
         * AOP：切面编程,不修改源代码增强功能
         *
         * Spring优点
         * 方便解耦,方便测试,方便整合其他框架,方便进行事务操作,降低api开发难度
         *
         */
    }
}
