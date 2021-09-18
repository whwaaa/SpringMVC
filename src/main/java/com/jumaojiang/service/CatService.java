package com.jumaojiang.service;

import com.jumaojiang.pojo.Cat;
import com.jumaojiang.utils.DateFormatUtils;
import org.springframework.stereotype.Service;
import java.text.ParseException;

/**
 * SpringMVC_Practice
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/9/15
 */
@Service
public class CatService {

    public boolean add(Cat cat){
        System.out.println("service Test: ----  add");
        System.out.println(cat.toString());
        return true;
    }

    public boolean delete(Integer catId){
        System.out.println("The cat of the catId will be delete");
        return true;
    }

    public boolean update(Integer catId, Cat cat){
        System.out.println("The cat of the catId will be update");
        return true;
    }

    public Cat query(Integer carId) throws ParseException {
        Cat cat = new Cat(1, "可可", "白色", "卷耳朵", DateFormatUtils.StringToDate("2021-12-12"));
        return cat;
    }
}
