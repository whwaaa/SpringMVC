package com.jumaojiang.pojo;

import java.util.List;

/**
 * SpringMVC_Practice
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/9/17
 */
public class AjaxResultVo<T> {
    private Integer code;   // 返回的状态码
    private String msg;     // 返回的信息(一般是错误信息或异常信息)
    private Object obj;     // 返回的数据可能是对象
    private List<T> list;   // 返回的数据可能是集合

    public AjaxResultVo() {
        this.code = 200;
        this.msg = "ok";
        this.obj = null;
        this.list = null;
    }

    public AjaxResultVo(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public AjaxResultVo(Integer code, String msg, List<T> list) {
        this.code = code;
        this.msg = msg;
        this.list = list;
    }

    public AjaxResultVo(Integer code, String msg, Object obj) {
        this.code = code;
        this.msg = msg;
        this.obj = obj;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
