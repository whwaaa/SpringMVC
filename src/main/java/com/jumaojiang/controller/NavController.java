package com.jumaojiang.controller;

import com.jumaojiang.pojo.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * SpringMVC_Practice
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/9/17
 */
@Controller
@RequestMapping("nav")
public class NavController {

    // ModelAndView转发到处理器, 通过request直接传参
    @RequestMapping("forwardtohandle")
    public ModelAndView forwardtohandle(){
        ModelAndView modelAndView = new ModelAndView();
        Result result = new Result(200, "通过ModelAndView转发到处理器", null);
        modelAndView.addObject("nav", result);
        modelAndView.setViewName("forward:/nav/converge");
        return modelAndView;
    }

    // Spring转发到处理器, 通过request直接传参
    @RequestMapping("forwardtohandle2")
    public String forwardtohandle2(HttpServletRequest request){
        Result result = new Result(200, "通过ModelAndView转发到处理器2", null);
        request.setAttribute("nav", result);
        return "forward:/nav/converge";
    }

    // ModelAndView重定向到处理器, 通过request直接传参, 但只能传字符串
    @RequestMapping("redirecttohandle")
    public ModelAndView redirecttohandle(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("nav", "通过ModelAndView重定向到处理器,参数只能是字符串");
        modelAndView.setViewName("redirect:/nav/converge");
        return modelAndView;
    }


    @RequestMapping("converge")
    public String converge(HttpServletRequest request){
        // 接收转发参数
        System.out.println("request: " + request.getAttribute("nav"));
        // 接收重定向参数
        String nav2 = request.getParameter("nav");
        System.out.println("request param: " + nav2.toString());
        if(nav2 != null)
            request.setAttribute("nav", nav2);
        return "forward:/jsp/nav/index.jsp";
    }


    @RequestMapping("forwardstring")
    public String string(HttpServletRequest request){
        Result result = new Result(200, "通过String转发", null);
        request.setAttribute("nav", result);
        return "forward:/jsp/nav/index.jsp";
    }

    @RequestMapping("forwardmodelandview")
    public ModelAndView modelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        Result result = new Result(200, "通过ModelAndView转发", null);
        modelAndView.addObject("nav", result);
        modelAndView.setViewName("forward:/jsp/nav/index.jsp");
        return modelAndView;
    }

    @RequestMapping("redirectstring")
    public String redirectstring(HttpServletRequest request){
        request.setAttribute("nav", "通过String重定向");
        return "redirect:/jsp/nav/index.jsp";
    }

    @RequestMapping("redirectmodelandview")
    public ModelAndView redirectmodelandview(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("nav", "通过ModelAndView转重定向");
        modelAndView.setViewName("redirect:/jsp/nav/index.jsp");
        return modelAndView;
    }
}
