package com.jumaojiang.service;

import com.jumaojiang.dao.CatDao;
import com.jumaojiang.pojo.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SpringMVC_Practice
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/9/18
 */
@Service
public class RESTfulCatService {

    @Autowired
    private CatDao catDao;

    public boolean add(Cat cat){
        return catDao.add(cat);
    }

    public Cat queryOne(Integer catId){
        return catDao.queryOne(catId);
    }

    public List<Cat> queryAll(){
        return catDao.queryAll();
    }

    public boolean patch(Integer catId, String name){
        Cat cat = catDao.queryOne(catId);
        if(cat != null){
            cat.setName(name);
            return catDao.update(catId, cat);
        }
        return false;
    }

    public boolean put(Integer catId, Cat cat){
        return catDao.update(catId, cat);
    }

    public boolean delete(Integer catId){
        return catDao.delete(catId);
    }


}
