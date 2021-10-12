package com.qjx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qjx.exception.ResultValueException;
import com.qjx.mapper.TEnInvMapper;
import com.qjx.mapper.TEnterpriseMapper;
import com.qjx.pojo.TEnInv;
import com.qjx.pojo.TEnterprise;
import com.qjx.pojo.TEnterpriseExample;
import com.qjx.service.TEnterpriseService;
import com.qjx.vo.PieVo;
import com.qjx.vo.TEnterpriseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TEnterpriseServiceImpl implements TEnterpriseService {

    @Autowired
    TEnterpriseMapper mapper;
    @Autowired
    TEnInvMapper enInvMapper;

    //根据企业表的主键orgcode查询企业
    @Override
    public TEnterprise selectByPrimaryKey(Integer orgcode) {
        return mapper.selectByPrimaryKey(orgcode);
    }

    //添加企业信息和企业、投资人关系到数据库中的表
    @Override
    public Integer addEntAndEnInv(TEnterprise enterprise, List<TEnInv> list) throws ResultValueException {
        //先添加企业信息到t_enterprise表中
        Integer result = mapper.insert(enterprise);

        //遍历存储企业和投资人关系的List集合
        for (TEnInv tEnInv:list){
            //进行添加企业和投资人关系
             result += enInvMapper.insert(tEnInv);
        }
        if (1+list.size() == result){
            return result;
        }else {
            throw new ResultValueException("result的值不对");
        }
    }

    //分页查询外商投资企业，默认查第一页
    @Override
    public PageInfo<TEnterprise> pageQuery(TEnterpriseVo vo, Integer pageNo, Integer pageSize) {
        //设置分页查询的limit( (当前页-1)*pageSize ,pageSize)条件
        PageHelper.startPage(pageNo, pageSize);
        //调用mapper接口进行查询
        List<TEnterprise> list = mapper.pageQuery(vo);
        //分页对象
        PageInfo<TEnterprise> info = null;
        if (list!=null){
            //将list转换为分页对象
            info = new PageInfo<>(list);
        }
        return info;
    }

    //查询显示饼图的数据
    @Override
    public List<PieVo> selectForPie(Integer orgcode) {
        List<PieVo> list = mapper.selectForPie(orgcode);
        if (list!=null){
            return list;
        }else {
            throw new NullPointerException("vo为空");
        }
    }
}
