package com.qjx.service;


import com.github.pagehelper.PageInfo;
import com.qjx.pojo.TEnInv;
import com.qjx.pojo.TEnterprise;
import com.qjx.vo.PieVo;
import com.qjx.vo.TEnterpriseVo;

import java.util.List;

public interface TEnterpriseService {

    //根据企业表的主键orgtype查询企业
    TEnterprise selectByPrimaryKey(Integer orgtype);

    //添加企业信息和企业、投资人关系到数据库中的表
    Integer addEntAndEnInv(TEnterprise enterprise, List<TEnInv> list) throws Exception;

    //分页查询外商投资企业，默认查第一页
    PageInfo<TEnterprise> pageQuery(TEnterpriseVo vo, Integer pageNo, Integer pageSize);

    //查询显示饼图的数据
    List<PieVo>  selectForPie(Integer orgcode);


}
