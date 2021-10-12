package com.qjx.mapper;

import com.qjx.pojo.TInvest;
import com.qjx.pojo.TInvestExample;
import com.qjx.vo.TIvestVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TInvestMapper {
    int countByExample(TInvestExample example);

    int deleteByExample(TInvestExample example);

    int deleteByPrimaryKey(Integer invregnum);

    int insert(TInvest record);

    int insertSelective(TInvest record);

    List<TInvest> selectByExample(TInvestExample example);

    TInvest selectByPrimaryKey(Integer invregnum);

    int updateByExampleSelective(@Param("record") TInvest record, @Param("example") TInvestExample example);

    int updateByExample(@Param("record") TInvest record, @Param("example") TInvestExample example);

    int updateByPrimaryKeySelective(TInvest record);

    int updateByPrimaryKey(TInvest record);

    //多条件查询投资人信息
    List<TInvest> selectByMix(TIvestVo ivestVo);
}