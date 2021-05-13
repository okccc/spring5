package com.okccc.spring5.dao;

import org.springframework.stereotype.Component;

/**
 * Author: okccc
 * Date: 2021/5/11 下午3:21
 * Desc: 
 */
@Component
public class UserDaoImpl implements UserDao{
    @Override
    public void test() {
        System.out.println("dao test...");
    }
}
