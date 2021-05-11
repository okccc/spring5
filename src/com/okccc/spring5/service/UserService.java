package com.okccc.spring5.service;

import com.okccc.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Author: okccc
 * Date: 2021/5/11 上午11:24
 * Desc: 
 */
@Service  // (userService=UserService)可以省略,默认是将类名称首字母小写
public class UserService {

    @Autowired  // 根据类型注入
//    @Qualifier(value = "userDaoImpl")  // 根据名称注入
    private UserDao userDao;

    public void add() {
        System.out.println("service add...");
        userDao.add();
    }
}
