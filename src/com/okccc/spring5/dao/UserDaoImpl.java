package com.okccc.spring5.dao;

import com.okccc.spring5.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: okccc
 * Date: 2021/5/11 下午3:21
 * Desc: 
 */
@Component
public class UserDaoImpl implements UserDao{

    // 注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void test() {
        System.out.println("dao test...");
    }

    @Override
    public void add(User user) {
        String sql = "insert into t_user values(?,?,?)";
        Object[] args = {user.getId(), user.getName(), user.getAge()};
        jdbcTemplate.update(sql, args);
    }

    @Override
    public void update(User user) {
        String sql = "update t_user set name=?,age=? where id=?";
        Object[] args = {user.getName(), user.getAge(), user.getId()};
        jdbcTemplate.update(sql,args);
    }

    @Override
    public void delete(int id) {
        String sql = "delete from t_user where id=?";
        jdbcTemplate.update(sql,1);
    }

    @Override
    public Object query() {
        // 查询返回某个值
        String sql01 = "select count(*) from t_user";
        Integer cnt = jdbcTemplate.queryForObject(sql01, Integer.class);
        // 查询返回对象
        String sql02 = "select * from t_user where id=?";
        User user = jdbcTemplate.queryForObject(sql02, new BeanPropertyRowMapper<>(User.class), 1);
        // 查询返回对象集合
        String sql03 = "select * from t_user";
        List<User> users = jdbcTemplate.query(sql03, new BeanPropertyRowMapper<>(User.class));
        return users;
    }

    @Override
    public void batchUpdate(List<Object[]> batchArgs) {
        // 批量添加
        String sql01 = "insert into t_user values(?,?,?)";
        // 批量修改
        String sql02 = "update t_user set age=? where id>?";
        // 批量删除
        String sql03 = "delete from t_user where id>?";
        jdbcTemplate.batchUpdate(sql03, batchArgs);
    }
}
