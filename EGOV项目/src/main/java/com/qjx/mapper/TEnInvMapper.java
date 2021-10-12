package com.qjx.mapper;

import com.qjx.pojo.TEnInv;
import com.qjx.pojo.TEnInvExample;
import com.qjx.pojo.TEnInvKey;
import com.qjx.pojo.TEnterprise;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TEnInvMapper {
    int countByExample(TEnInvExample example);

    int deleteByExample(TEnInvExample example);

    int deleteByPrimaryKey(TEnInvKey key);

    int insert(TEnInv record);

    int insertSelective(TEnInv record);

    List<TEnInv> selectByExample(TEnInvExample example);

    TEnInv selectByPrimaryKey(TEnInvKey key);

    int updateByExampleSelective(@Param("record") TEnInv record, @Param("example") TEnInvExample example);

    int updateByExample(@Param("record") TEnInv record, @Param("example") TEnInvExample example);

    int updateByPrimaryKeySelective(TEnInv record);

    int updateByPrimaryKey(TEnInv record);


}