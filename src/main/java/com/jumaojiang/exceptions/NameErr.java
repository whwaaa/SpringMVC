package com.jumaojiang.exceptions;

/**
 * SpringMVC_Practice
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/9/17
 */
public class NameErr extends Exception{
    public NameErr() {
        super();
    }

    public NameErr(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
