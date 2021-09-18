package com.jumaojiang.controller;

import com.jumaojiang.exceptions.IdErr;
import com.jumaojiang.exceptions.NameErr;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * SpringMVC_Practice
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/9/17
 */
@ControllerAdvice
public class MyGlobalExceptionHandle {
    @ExceptionHandler(value = {Exception.class})
    public ModelAndView globalExceptions(Exception e){
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", e.getMessage());
        mv.setViewName("err/err");
        return mv;
    }

    @ExceptionHandler(value = {IdErr.class})
    public ModelAndView idErr(IdErr e){
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", e.getMessage());
        mv.setViewName("err/err");
        return mv;
    }

    @ExceptionHandler(value = {NameErr.class})
    public ModelAndView nameErr(NameErr e){
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", e.getMessage());
        mv.setViewName("err/err");
        return mv;
    }
}
