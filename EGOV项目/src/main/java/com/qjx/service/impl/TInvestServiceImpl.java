package com.qjx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qjx.mapper.TInvestMapper;
import com.qjx.pojo.TInvest;
import com.qjx.service.TInvestService;
import com.qjx.utils.StringUtiles;
import com.qjx.vo.TIvestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TInvestServiceImpl implements TInvestService {

    @Autowired
    TInvestMapper mapper;

    //添加投资人
    @Override
    public Integer addInvenst(TInvest invest) {
        return mapper.insert(invest);
    }

    //多条件查询投资人信息并分页
    @Override
    public PageInfo<TInvest> selectByMix(TIvestVo ivestVo, Integer pageNum, Integer pageSize) {
        //在查询之前要设置分页信息
        PageHelper.startPage(pageNum,pageSize );
        //调用mapper的方法进行按多条件查询投资人
        List<TInvest> lists = mapper.selectByMix(ivestVo);
        for(TInvest invest : lists){
            invest.setCty(StringUtiles.getValue(invest.getCty()));
        }
        if (lists!=null) {
            //将查询到的存储TInvest信息的lists集合转为分页信息对象PageInfo
            PageInfo<TInvest> info = new PageInfo<>(lists);
            return info;
        }else {
            throw new NullPointerException("lists为空");
        }
    }

    //点击投资人登记编号获取投资人详细信息
    @Override
    public TInvest selectByInvregnum(Integer invregnum) {
        return mapper.selectByPrimaryKey(invregnum);
    }
}
