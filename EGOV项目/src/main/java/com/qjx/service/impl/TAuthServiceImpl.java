package com.qjx.service.impl;


import com.qjx.mapper.TAuthMapper;
import com.qjx.pojo.TAuth;
import com.qjx.service.TAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TAuthServiceImpl implements TAuthService {


    @Autowired
    TAuthMapper mapper;

    @Override
    public boolean addAuth(TAuth auth) {
        return mapper.insertSelective(auth) == 1;
    }

    //查找核准件
    @Override
    public TAuth selectTauth(String authno){
        authno = authno.replaceAll("\\s","" );
        System.out.println(authno);
        TAuth auth = mapper.selectTauth(Integer.parseInt(authno));
        return auth;
    }

    //反馈核准件
    @Override
    public boolean feedBack(Integer authno){
        return mapper.feedBack(authno) == 1;
    }
}
