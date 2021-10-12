package com.qjx.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static Date date = new Date();

    //获取系统当前时间类时分秒
    public static String getDate(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    //获取系统当前时间，年月日
    public static String getDateFormatYMD(){
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
}
