package com.jumaojiang.controller;

import com.jumaojiang.pojo.AjaxResultVo;
import com.jumaojiang.pojo.Cat;
import com.jumaojiang.service.RESTfulCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * SpringMVC_Practice
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/9/18
 */
@Controller
@RequestMapping("animal")
public class RESTfulController {

    @Autowired
    private RESTfulCatService service;

    /**
     * 查询所有猫咪信息
     * @return
     */
    @RequestMapping(value = "cats", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResultVo cats(){
        List<Cat> cats = service.queryAll();
        AjaxResultVo<Cat> resultVo = new AjaxResultVo<>();
        resultVo.setList(cats);
        return resultVo;
    }

    /**
     * 查询指定catId的猫咪信息
     * @param catId
     * @return
     */
    @RequestMapping(value = "cat/{catId}", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResultVo catcatId(@PathVariable(value = "catId", required = false) Integer catId){
        Cat cat = service.queryOne(catId);
        AjaxResultVo<Cat> resultVo = new AjaxResultVo<>(200,"ok", cat);
        return resultVo;
    }

    /**
     * 新增猫咪信息
     * @param cat
     * @return
     */
    @RequestMapping(value = "cat", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResultVo catpost(Cat cat){
        boolean add = service.add(cat);
        AjaxResultVo<Object> resultVo;
        if(add)
            resultVo = new AjaxResultVo<>(200, "ok", null);
        else
            resultVo = new AjaxResultVo<>(500, "添加失败", null);
        return resultVo;
    }

    /**
     * 更新一只猫咪的所有信息
     * @param cat
     * @return
     */
    @RequestMapping(value = "cat/{catId}", method = RequestMethod.PUT)
    @ResponseBody
    public AjaxResultVo catput(@PathVariable(value = "catId", required = false) Integer updateCatId, Cat cat){
        boolean update = service.put(updateCatId, cat);
        AjaxResultVo<Cat> resultVo;
        if(update)
            resultVo = new AjaxResultVo<>(200, "ok", null);
        else
            resultVo = new AjaxResultVo<>(500, "更新失败", null);
        return resultVo;
    }


    /**
     * 更新一只猫咪的部分信息
     * @param catId
     * @param name
     * @return
     */
    @RequestMapping(value = "cat/{catId}", method = RequestMethod.PATCH)
    @ResponseBody
    public AjaxResultVo catpatch(@PathVariable(value = "catId", required = false) Integer catId, String name){
        boolean update = service.patch(catId, name);
        AjaxResultVo<Cat> resultVo;
        if(update)
            resultVo = new AjaxResultVo<>(200, "ok", null);
        else
            resultVo = new AjaxResultVo<>(500, "更新失败", null);
        return resultVo;
    }

    /**
     * 删除一只猫咪的信息
     * @param catId
     * @return
     */
    @RequestMapping(value = "cat/{catId}", method = RequestMethod.DELETE)
    @ResponseBody
    public AjaxResultVo catdelete(@PathVariable(value = "catId", required = false) Integer catId){
        boolean delete = service.delete(catId);
        AjaxResultVo<Cat> resultVo;
        if(delete)
            resultVo = new AjaxResultVo<>(200, "ok", null);
        else
            resultVo = new AjaxResultVo<>(200, "删除失败", null);
        return resultVo;
    }
}











