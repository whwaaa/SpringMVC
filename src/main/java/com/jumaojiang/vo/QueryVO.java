package com.jumaojiang.vo;

import com.jumaojiang.pojo.Cat;

import java.util.Arrays;

/**
 * SpringMVC_Practice
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/9/16
 */
public class QueryVO {

    private Cat[] cats;

    @Override
    public String toString() {
        return "QueryVO{" +
                "cats=" + Arrays.toString(cats) +
                '}';
    }

    public QueryVO() {
    }

    public QueryVO(Cat[] cats) {
        this.cats = cats;
    }

    public Cat[] getCats() {
        return cats;
    }

    public void setCats(Cat[] cats) {
        this.cats = cats;
    }
}
