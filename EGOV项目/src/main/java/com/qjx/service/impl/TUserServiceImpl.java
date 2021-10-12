package com.qjx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qjx.mapper.TUserMapper;
import com.qjx.pojo.TUser;
import com.qjx.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TUserServiceImpl implements TUserService {

    @Autowired
    TUserMapper mapper;

    //新增用户
    @Override
    public Integer addUser(TUser user) {
        Integer result = mapper.addUser(user);
        return result;
    }

    //点击用户管理进行分页查询
    @Override
    public PageInfo<TUser> pageSplit(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<TUser> list = mapper.pageSplit();
        PageInfo info = new PageInfo(list);
        return info;
    }

    //根据主键查询用户
    @Override
    public TUser selectByPrimary(String usercode) {
        if (""==usercode||usercode==null){
            throw new NullPointerException("usercode为空");
        }

        return mapper.selectByPrimary(usercode);
    }

    //修改用户并返回当前页
    @Override
    public Integer updateUser(TUser tuser) {

        return mapper.updateUser(tuser);
    }

    //根据主键删除用户
    @Override
    public Integer deleteUser(String[] str) {
        Integer result = mapper.deleteUser(str);
        return  result;
    }

    //用户登录查询方法，根据usercode、orgtype、userpswd查询
    @Override
    public TUser login(TUser user) {
        return mapper.login(user);
    }
}
