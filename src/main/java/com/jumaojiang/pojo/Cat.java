package com.jumaojiang.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * SpringMVC_Practice
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/9/16
 */
public class Cat {

    private Integer catId;
    private String name;
    private String color;
    private String ear; // long volume
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @Override
    public String toString() {
        return "Cat{" +
                "catId=" + catId +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", ear='" + ear + '\'' +
                ", birthday=" + (birthday==null?null:birthday.toLocaleString()) +
                '}';
    }

    public Cat() {
    }

    public Cat(Integer catId, String name, String color, String ear, Date birthday) {
        this.catId = catId;
        this.name = name;
        this.color = color;
        this.ear = ear;
        this.birthday = birthday;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEar() {
        return ear;
    }

    public void setEar(String ear) {
        this.ear = ear;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
