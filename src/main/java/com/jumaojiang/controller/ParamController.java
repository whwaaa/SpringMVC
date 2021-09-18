package com.jumaojiang.controller;

import com.jumaojiang.pojo.Cat;
import com.jumaojiang.service.CatService;
import com.jumaojiang.utils.DateFormatUtils;
import com.jumaojiang.vo.QueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * SpringMVC_Practice
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/9/16
 */
@Controller
@RequestMapping("param")
public class ParamController {

    @Autowired
    private CatService catService;

    @RequestMapping("add7")
    public ModelAndView add7(@RequestParam("names") List<String> names, QueryVO vo){
        // 1.简单数据类型集合, 直接通过参数名接收
        for (String name : names) {
            System.out.println(name);
        }
        // 2.自定义对象集合
        System.out.println(vo.toString());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "add7");
        modelAndView.addObject("res", "test");
        modelAndView.setViewName("param/index");
        return modelAndView;
    }

    @RequestMapping("add6")
    public ModelAndView add6(String[] name, HttpServletRequest request){
        // 1.通过名称匹配
        for (String name1 : name) {
            System.out.println("1.通过名称匹配" + name1);
        }
        // 2.通过HttpServletRequest
        String[] name2 = request.getParameterValues("name");
        for (String name1 : name2) {
            System.out.println("1.通过HttpServletRequest" + name1);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "add6");
        modelAndView.addObject("res", "test");
        modelAndView.setViewName("param/index");
        return modelAndView;
    }

    @RequestMapping("add5")
    public ModelAndView add5(HttpServletRequest request) throws ParseException {
        int catId = Integer.parseInt(request.getParameter("catId"));
        String name = request.getParameter("name");
        String color = request.getParameter("color");
        String ear = request.getParameter("ear");
        Date birthday = DateFormatUtils.StringToDate(request.getParameter("birthday"));
        Cat cat = new Cat(catId, name, color, ear, birthday);
        boolean res = catService.add(cat);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "add5");
        modelAndView.addObject("res", res?"添加成功":"添加失败");
        modelAndView.setViewName("param/index");
        return modelAndView;
    }

    @RequestMapping(value = {"add4/{catId}/{name}/{color}/{ear}", "add4/{catId}/{name}/{color}/{birthday}"})
    public ModelAndView add4(
            @PathVariable(value = "catId", required = false) Integer catId,
            @PathVariable(value = "name", required = false) String name,
            @PathVariable(value = "color", required = false) String color,
            @PathVariable(value = "ear", required = true) String ear,
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            @PathVariable(value = "birthday", required = false)
            Date birthday
    ){
        Cat cat = new Cat(catId, name, color, ear, birthday);
        boolean res = catService.add(cat);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "add4");
        modelAndView.addObject("res", res?"添加成功":"添加失败");
        modelAndView.setViewName("param/index");
        return modelAndView;
    }

    @RequestMapping("add3")
    public ModelAndView add3(
            @RequestParam(value = "catId", required = false) Integer catId,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "color1", required = true) String color){
        Cat cat = new Cat(catId, name, color, null, null);
        boolean res = catService.add(cat);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "add3");
        modelAndView.addObject("res", res?"添加成功":"添加失败");
        modelAndView.setViewName("param/index");
        return modelAndView;
    }

    @RequestMapping("add2")
    public ModelAndView add2(Cat cat){
        boolean res = catService.add(cat);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "add2");
        modelAndView.addObject("res", res?"添加成功":"添加失败");
        modelAndView.setViewName("param/index");
        return modelAndView;
    }

    @RequestMapping("add1")
    public ModelAndView add1(@DateTimeFormat(pattern = "yyyy-MM-dd")Date birthday){
        System.out.println(birthday.toLocaleString());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "add1");
        modelAndView.setViewName("param/index");
        return modelAndView;
    }

    @RequestMapping("add")
    public ModelAndView add(Integer catId, String name, String color){
        Cat cat = new Cat(catId, name, color, null, null);
        boolean res = catService.add(cat);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "add");
        modelAndView.addObject("res", res?"添加成功":"添加失败");
        modelAndView.setViewName("param/index");
        return modelAndView;
    }
}
