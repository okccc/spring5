package com.okccc.spring5.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Author: okccc
 * Date: 2021/5/11 下午3:48
 * Desc: 使用配置类代替xml配置文件
 */
@Configuration  // 完全基于注解开发
@ComponentScan(basePackages = {"com.okccc.spring5"})  // 开启组件扫描的包路径
@EnableAspectJAutoProxy(proxyTargetClass = true)  // 开启代理
@EnableTransactionManagement  // 开启事务管理
public class Config {

    @Bean
    public DruidDataSource getDruidDataSource() {
        // 创建数据库连接池
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/javaee");
        dataSource.setUsername("root");
        dataSource.setPassword("root@123");
        return dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        // 创建JdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        // 注入dataSource,到ioc容器中根据类型找到dataSource
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource) {
        // 创建事务管理器
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        // 注入dataSource
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }
}
