package com.okccc.spring5.bean;

import org.springframework.stereotype.Component;

/**
 * @author okccc
 * @date 2021/4/27 20:28
 * @desc
 */
@Component
public class User {

    private int id;
    private String name;
    private double age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void test() {
        System.out.println("test...");
    }
}
