package com.qjx.controller;

import com.github.pagehelper.PageInfo;
import com.qjx.pojo.TInvest;
import com.qjx.pojo.TUser;
import com.qjx.service.TInvestService;
import com.qjx.utils.DateUtils;
import com.qjx.utils.StringUtiles;
import com.qjx.vo.TIvestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/invest")
public class TInvestController {

    @Autowired
    TInvestService service;

    //每页显示的数量，每页显示3页
    public static final Integer pageSize = 3;

    //添加投资人
    @RequestMapping(value="/addInvest.action",method = RequestMethod.POST)
    public String addInvest(TInvest invest, HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (invest!=null){
            invest.setUsercode((String) session.getAttribute("usercode"));
            invest.setRegdate(DateUtils.getDateFormatYMD());
        }
        Integer result = service.addInvenst(invest);
        if (result!=null&&result==1){
            session.setAttribute("msg", "用户添加成功");
            return "redirect:/basicinfo/exoticOrgList.jsp";
        }
        session.setAttribute("msg", "用户添加失败");
        return "redirect:/basicinfo/exoticOrgAdd.jsp";
    }

    //多条件查询投资人信息并分页
    @RequestMapping(value = "/selectByMix.action",method=RequestMethod.POST)
    public String selectByMi(TIvestVo vo,Integer pageNum,HttpServletRequest request,String forward){
        //默认pageNum为1
        if (pageNum == null || pageNum == 0 ){
            pageNum = 1;
        }
        //由于两个orgcodeSelect.jsp和exoticOrgList.jsp同时利用了这个请求地址
        //因此需要一个标记区别请求成功的时候，转发的地址
        String path = forward;
        if (vo!=null){
            PageInfo<TInvest> info = service.selectByMix(vo, pageNum, pageSize);
            if (info !=null){
                request.setAttribute("info", info);
                request.setAttribute("vo", vo);
                request.setAttribute("msg", "查询成功");
                return "forward:"+path;
            }
        }
        request.setAttribute("msg", "查询失败");
        return "forward:/basicinfo/error.jsp";
    }

    //点击投资人登记编号获取投资人详细信息
    @RequestMapping(value = "/selectInvView.action")
    public String selectInvView(Integer invregnum,HttpServletRequest request){
        TInvest invest = service.selectByInvregnum(invregnum);
        if (invest!=null){
            invest.setCty(StringUtiles.getValue(invest.getCty()));
            request.setAttribute("invest",invest );
            return "forward:/basicinfo/exoticOrgView.jsp";
        }
        return "forward:/basicinfo/error.jsp";
    }

}
