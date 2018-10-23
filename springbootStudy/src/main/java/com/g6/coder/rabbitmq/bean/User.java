package com.g6.coder.rabbitmq.bean;

import java.io.Serializable;

/**
 * Created by huixiaolv on 23/10/2018.
 */
public class User implements Serializable{

    private String name;
    private String address;
    private Integer age;

    public User(String name,String address,Integer age){
        this.name = name;
        this.address = address;
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name+" "+this.address+" "+this.age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
