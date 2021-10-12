package com.qjx.utils;

import java.util.ResourceBundle;

//读取属性配置文件的类
public class StringUtiles {

    //私有构造器
    private StringUtiles(){}

    //类加载的时候绑定属性配置文件
    private static ResourceBundle bundle = ResourceBundle.getBundle("com/qjx/properties/orgtype");

    //根据key获取属性文件的value
    public static String getValue(String key){
        return bundle.getString(key);
    }

}
