package com.jumaojiang.dao;

import com.jumaojiang.pojo.Cat;
import com.jumaojiang.utils.DateFormatUtils;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * SpringMVC_Practice
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/9/18
 */
@Component
public class CatDao {

    private List<Cat> catList;

    public CatDao() throws ParseException {
        Cat cat1 = new Cat(1, "小茶", "白色", "卷耳朵", DateFormatUtils.StringToDate("2021-11-02"));
        Cat cat2 = new Cat(2, "奈奈", "灰色", "长耳朵", DateFormatUtils.StringToDate("2020-06-12"));
        Cat cat3 = new Cat(3, "小爱", "灰白色", "卷耳朵", DateFormatUtils.StringToDate("2020-12-22"));
        ArrayList<Cat> objects = new ArrayList<>();
        objects.add(cat1);
        objects.add(cat2);
        objects.add(cat3);
        this.catList = objects;
    }

    public List<Cat> getCatList() {
        return catList;
    }

    public boolean add(Cat cat){
        return getCatList().add(cat);
    }

    public Cat queryOne(Integer catId){
        for (Cat cat : getCatList()) {
            if(cat.getCatId().equals(catId))
                return cat;
        }
        return null;
    }

    public List<Cat> queryAll(){
        return getCatList();
    }

    public boolean update(Integer catId, Cat cat){
        for(int i=0; i<getCatList().size(); i++){
            if(getCatList().get(i).getCatId().equals(catId)){
                getCatList().remove(i);
            }
        }
        return getCatList().add(cat);
    }

    public boolean delete(Integer catId){
        for(int i=0; i<getCatList().size(); i++){
            if(getCatList().get(i).getCatId().equals(catId)){
                getCatList().remove(i);
                return true;
            }
        }
        return false;
    }
}
