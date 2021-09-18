package com.jumaojiang.controller;

import com.jumaojiang.pojo.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * SpringMVC_Practice
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/9/17
 */
@Controller
@RequestMapping("return")
public class ReturnController {

    // 返回ModelAndView类型
    @RequestMapping("modelandview")
    public ModelAndView modelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        // 跳转页面
        modelAndView.setViewName("result/index");
        // 携带数据
        modelAndView.addObject("result", new Result(200, "经过ModelAndView返回", null));
        return modelAndView;
    }

    // 返回字符串类型
    @RequestMapping("string")
    public String string(HttpServletRequest request){
        Result result = new Result(200, "经过String返回", null);
        // 携带数据
        request.setAttribute("result", result);
        // 跳转页面
        return "result/index";
    }

    // 返回对象类型, 不进行页面跳转
    @ResponseBody
    @RequestMapping("obj")
    public Object obj(){
        Result result = new Result(200, "经过Object返回", null);
        // 直接返回数据
        return result;
    }
}




















