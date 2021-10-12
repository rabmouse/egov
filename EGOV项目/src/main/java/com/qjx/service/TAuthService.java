package com.qjx.service;


import com.qjx.pojo.TAuth;


public interface TAuthService {

    //添加核准件
    boolean addAuth(TAuth auth);

    //查找核准件
    TAuth selectTauth(String authno);

    //反馈核准件
    boolean feedBack(Integer authno);
}
