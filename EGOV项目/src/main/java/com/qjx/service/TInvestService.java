package com.qjx.service;

import com.github.pagehelper.PageInfo;
import com.qjx.pojo.TInvest;
import com.qjx.vo.TIvestVo;

import java.util.List;

public interface TInvestService {

    //添加投资人
    Integer addInvenst(TInvest invest);

    //多条件查询投资人信息并分页
    PageInfo<TInvest> selectByMix(TIvestVo ivestVo, Integer pageNum, Integer pageSize);

    //点击投资人登记编号获取投资人详细信息
    TInvest selectByInvregnum(Integer invregnum);
}
