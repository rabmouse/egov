package com.qjx.mapper;

import com.qjx.pojo.TEnterprise;
import com.qjx.pojo.TEnterpriseExample;
import com.qjx.vo.PieVo;
import com.qjx.vo.TEnterpriseVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TEnterpriseMapper {
    int countByExample(TEnterpriseExample example);

    int deleteByExample(TEnterpriseExample example);

    int deleteByPrimaryKey(Integer orgcode);

    int insert(TEnterprise record);

    int insertSelective(TEnterprise record);

    List<TEnterprise> selectByExample(TEnterpriseExample example);

    TEnterprise selectByPrimaryKey(Integer orgcode);

    int updateByExampleSelective(@Param("record") TEnterprise record, @Param("example") TEnterpriseExample example);

    int updateByExample(@Param("record") TEnterprise record, @Param("example") TEnterpriseExample example);

    int updateByPrimaryKeySelective(TEnterprise record);

    int updateByPrimaryKey(TEnterprise record);

    //  <!--分页查询外商投资企业，默认查第一页-->
    List<TEnterprise> pageQuery(TEnterpriseVo vo);

    //查询显示饼图的数据
    List<PieVo> selectForPie(Integer orgcode);
}