package com.jumaojiang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * SpringMVC_Practice
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/9/15
 */
@Controller
@RequestMapping("hello")
public class DemoController {

    @RequestMapping("test")
    public ModelAndView test(){
        System.out.println("DemoController --- test");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("testParam", "This is DemoController param");
        modelAndView.setViewName("hello");
        return modelAndView;
    }


}
