package com.okccc.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Author: okccc
 * Date: 2021/5/11 下午3:48
 * Desc: 
 */
@Configuration  // 完全注解开发,替代xml配置文件
@ComponentScan(basePackages = {"com.okccc.spring5"})  // 组件扫描的包路径
public class SpringConfig {
}
