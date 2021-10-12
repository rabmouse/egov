package com.qjx.mapper;

import com.qjx.pojo.TAuth;
import com.qjx.pojo.TAuthExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TAuthMapper {
    int countByExample(TAuthExample example);

    int deleteByExample(TAuthExample example);

    int deleteByPrimaryKey(Integer authno);

    int insert(TAuth record);

    int insertSelective(TAuth record);

    List<TAuth> selectByExample(TAuthExample example);

    TAuth selectByPrimaryKey(Integer authno);

    int updateByExampleSelective(@Param("record") TAuth record, @Param("example") TAuthExample example);

    int updateByExample(@Param("record") TAuth record, @Param("example") TAuthExample example);

    int updateByPrimaryKeySelective(TAuth record);

    int updateByPrimaryKey(TAuth record);

    //查找核准件明细
    TAuth selectTauth(Integer authono);

    //反馈核准件
    Integer feedBack(Integer authno);
}