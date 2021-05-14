package com.okccc.spring5.dao;

import com.okccc.spring5.bean.User;

import java.util.List;

/**
 * Author: okccc
 * Date: 2021/5/11 下午3:19
 * Desc:
 */
public interface UserDao {
    void test();

    void add(User user);

    void update(User user);

    void delete(int id);

    Object query();

    void batchUpdate(List<Object[]> batchArgs);
}
