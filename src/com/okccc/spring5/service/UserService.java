package com.okccc.spring5.service;

import com.okccc.spring5.bean.User;
import com.okccc.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void test() {
        System.out.println("service test...");
        userDao.test();
    }

    // 添加操作
    public void add(User user) {
        userDao.add(user);
    }

    // 修改操作
    public void update(User user) {
        userDao.update(user);
    }

    // 删除操作
    public void delete(int id) {
        userDao.delete(id);
    }

    // 查询操作
    public Object query() {
        return userDao.query();
    }

    // 批量更新
    public void batchUpdate(List<Object[]> batchArgs) {
        userDao.batchUpdate(batchArgs);
    }
}
