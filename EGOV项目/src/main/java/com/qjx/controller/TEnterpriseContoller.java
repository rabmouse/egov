package com.qjx.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.qjx.pojo.TEnInv;
import com.qjx.pojo.TEnterprise;
import com.qjx.service.TEnterpriseService;
import com.qjx.utils.DateUtils;
import com.qjx.utils.StringUtiles;
import com.qjx.vo.PieVo;
import com.qjx.vo.TEnterpriseVo;
import javafx.beans.binding.ObjectExpression;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/enterprise")
public class TEnterpriseContoller {

    @Autowired
    TEnterpriseService service;

    //每页显示的数量
    private static final Integer pageSize = 3;

    //根据企业表的主键orgcode查询企业
    @RequestMapping(value = "/selectByPrimaryKey.action",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    @ResponseBody
    public String selectByPrimaryKey(Integer orgcode, HttpServletRequest request){
        TEnterprise tEnterprise = service.selectByPrimaryKey(orgcode);
        if (tEnterprise==null){
            request.getSession(false).setAttribute("orgcode", orgcode);
            return "";
        }else {
            tEnterprise.setRegcry(StringUtiles.getValue("cty."+tEnterprise.getRegcry()));
            request.getSession(false).setAttribute("tEnterprise", tEnterprise);
            return "投资企业已存在，请重新录入投资企业信息";
        }
    }

    //添加企业信息和企业、投资人关系到数据库中的表
    @RequestMapping(value = "/addEnt_and_t_en_inv.action",method = RequestMethod.POST)
    public String addEntAndEnInv(TEnterprise enterprise,String[] invregnums,String[] regcapItems,String[] scales,HttpServletRequest request){
        enterprise.setUsercode((String) request.getSession(false).getAttribute("usercode"));
        enterprise.setRegdate(DateUtils.getDateFormatYMD());

        //将invregnums、regcapItems、scales封装到tEnInv中，然后将tEnInv到List集合中
        //创建List集合
        List<TEnInv> list = new ArrayList<>();
        //遍历投资人登记编号invregnum
        for (int i=0;i<invregnums.length;i++){
            //创建企业和投资人关系对象
            TEnInv tEnInv = new TEnInv();
            //投资人登记编号
            Integer invregnum = Integer.parseInt(invregnums[i]);
            //注册资本
            Integer regcap = Integer.parseInt(regcapItems[i]);
            //利润比例
            Integer scale = Integer.parseInt(scales[i]);
            //获取组织机构代码
            Integer orgcode = enterprise.getOrgcode();

            tEnInv.setOrgcode(orgcode);
            tEnInv.setInvregnum(invregnum);
            tEnInv.setRegcap(regcap);
            tEnInv.setScale(scale);
            list.add(tEnInv);
            //System.out.println(list.get(i));
        }

        try {
            service.addEntAndEnInv(enterprise,list);
            request.setAttribute("msg","企业信息、企业信息和投资人关系录入系统成功" );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "forward:/foreignExchange/newInputOrg.jsp";
    }

    //多条件分页查询外商投资企业，默认查第一页
    @RequestMapping(value = "/pageQuery.action",method = RequestMethod.POST)
    public String pageQuery(TEnterpriseVo vo, Integer pageNo,HttpServletRequest request){
        //默认查询第一页
        if (pageNo == null||pageNo ==0){
            pageNo = 1;
        }

        PageInfo<TEnterprise> info = service.pageQuery(vo, pageNo, pageSize);
        //将分页对象存放到request域中，进行前端调用
        request.setAttribute("info", info);
        //防止分页查询的时候丢失条件
        request.setAttribute("vo", vo);
        return "forward:/auth/orgcodeSelect.jsp" ;
    }

    //查询显示饼图的数据，饼图所需的数据是：invname、regcap
    @RequestMapping(value = "/selectForPie.action",method = RequestMethod.POST)
    @ResponseBody
    public String selectForPie(Integer orgcode){
        List<PieVo>  list = service.selectForPie(orgcode);

        String json = "";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            json = objectMapper.writeValueAsString(list);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

}
