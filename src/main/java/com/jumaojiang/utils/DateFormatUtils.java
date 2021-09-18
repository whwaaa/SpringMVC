package com.jumaojiang.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SpringMVC_Practice
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/9/15
 */
public class DateFormatUtils {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-DD-mm");

    public static String DateToString(Date date){
        return new SimpleDateFormat().format(date);
    }

    public static Date StringToDate(String date) throws ParseException {
        return simpleDateFormat.parse(date);
    }
}
