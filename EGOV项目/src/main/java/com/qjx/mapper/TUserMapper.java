package com.qjx.mapper;

import com.qjx.pojo.TUser;

import java.util.List;

public interface TUserMapper {
    //新增用户
    Integer addUser(TUser user);

    //分页查询用户
    List<TUser> pageSplit();

    //根据主键usercode查询用户
    TUser selectByPrimary(String usercode);

    //根据主键usercode更新用户
    Integer updateUser(TUser tUser);

    //根据主键删除用户
    Integer deleteUser(String [] str);

    //用户登录查询方法，根据usercode、orgtype、userpswd查询
    TUser login(TUser user);
}
