package com.jumaojiang.interceptor;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.MappingMatch;
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
public class FileInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String[] fileType = {".md",".exe",".zip",".txt"};
        boolean flag = false;
        // 判断是否是文件上传请求
        if(request instanceof MultipartHttpServletRequest){
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            Map<String, MultipartFile> fileMap = multiRequest.getFileMap();
            // 遍历所有的上传的文件
            Set<String> fileSet = fileMap.keySet();
            Iterator<String> iterator = fileSet.iterator();
            while(iterator.hasNext()){
                String next = iterator.next();
                MultipartFile multipartFile = fileMap.get(next);
                for (String s : fileType) {
                    // 是指定类型之一
                    if( multipartFile.getOriginalFilename().endsWith(s) ){
                        flag = true;
                        break;
                    }
                }
            }
        }
        // 不存在指定类型之一, 抛出异常
        if( !flag )
            throw new Exception("文件类型只能是 .md .exe .zip .txt 之一");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
