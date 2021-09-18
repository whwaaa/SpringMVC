package com.jumaojiang.controller;

import com.jumaojiang.exceptions.IdErr;
import com.jumaojiang.exceptions.NameErr;
import com.jumaojiang.pojo.Cat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * SpringMVC_Practice
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/9/17
 */
@Controller
@RequestMapping("err")
public class ExceptionController {

// 全局异常
@RequestMapping("err")
public String err(Integer num){
    System.out.println(1/num);
    return "err/ok";
}

// 自定义id异常
@RequestMapping("iderr")
public String iderr(Integer id) throws IdErr {
    if(id < 10)
        throw new IdErr("id不能小于10");
    return "err/ok";
}

// 自定义name异常
@RequestMapping("nameerr")
public String nameerr(String name) throws IdErr, NameErr {
    if("".equals(name))
        throw new NameErr("name不能为空串");
    return "err/ok";
}
}
