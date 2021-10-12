package com.qjx.service;

import com.github.pagehelper.PageInfo;
import com.qjx.pojo.TUser;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface TUserService {
    //新增用户
    Integer addUser(TUser user);

    //点击用户管理进行分页查询
    PageInfo<TUser> pageSplit(Integer pageNo, Integer pageSize);

    //根据主键查询用户
    TUser selectByPrimary(String usercode);

    //修改用户并跳转到当前页
    Integer updateUser(TUser tuser);

    //根据主键删除用户
    Integer deleteUser(String[] str);

    //用户登录查询方法，根据usercode、orgtype、userpswd查询
    TUser login(TUser user);
}
