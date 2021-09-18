package com.jumaojiang.exceptions;

/**
 * SpringMVC_Practice
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/9/17
 */
public class IdErr extends Exception{
    public IdErr() {
        super();
    }

    public IdErr(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
