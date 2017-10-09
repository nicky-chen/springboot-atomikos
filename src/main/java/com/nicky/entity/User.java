package com.nicky.entity;

import java.io.Serializable;

/**
 * @author Nicky_chin  --Created on 2017-10-08
 */
public class User implements Serializable {

    private Integer id;

    private Integer age;

    private String name;


    /**
     * default constructor
     */
    public User() {
    }

    /**
     * full constructor
     */
    public User(Integer age, String name) {
        this.age = age;
        this.name = name;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
