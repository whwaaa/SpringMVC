package com.jumaojiang.controller;

import com.jumaojiang.pojo.Cat;
import com.jumaojiang.service.CatService;
import com.jumaojiang.utils.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;


/**
 * SpringMVC_Practice
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/9/16
 */
@Controller
@RequestMapping("cat")
public class CatController {
    @Autowired
    private CatService catService;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public ModelAndView add() throws ParseException {
        Cat cat = new Cat(1, "可可", "白色", "卷耳朵", DateFormatUtils.StringToDate("2021-12-12"));
        boolean res = catService.add(cat);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("res", res?"添加成功":"添加失败");
        modelAndView.setViewName("catAdd");
        return modelAndView;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ModelAndView update() throws ParseException {
        Cat cat = new Cat(2, "奈奈", "灰色", "长耳朵", DateFormatUtils.StringToDate("2021-11-13"));
        boolean res = catService.update(1, cat);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("res", res?"更新成功":"更新失败");
        modelAndView.setViewName("catUpdate");
        return modelAndView;
    }

    @RequestMapping("delete")
    public ModelAndView delete(){
        boolean res = catService.delete(1);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("res", res?"删除成功":"删除失败");
        modelAndView.setViewName("catDelete");
        return modelAndView;
    }

}
