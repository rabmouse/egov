package com.qjx.controller;

import com.github.pagehelper.PageInfo;
import com.qjx.pojo.TUser;
import com.qjx.service.TUserService;
import com.qjx.utils.DateUtils;
import com.qjx.utils.StringUtiles;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class TUserController {


    public static final int PAGE_SIZE = 4;

    @Autowired
    TUserService tUserService;

    //添加用户
    @RequestMapping(value = "/addUser.action", method = RequestMethod.POST)
    public ModelAndView addUser(TUser user) {
        //添加之前需要根据用户代码进行查询是否出现重复的用户代码
        String usercode = user.getUsercode();

        //true：表示用户代码重复，false表示用户代码没有重复
        boolean isExists = false;
        TUser tuser = tUserService.selectByPrimary(usercode);
        if (tuser != null) {
            String tuserCode = tuser.getUsercode();
            isExists = tuserCode.equals(usercode) ? true : false;
        }

        ModelAndView mv = new ModelAndView();
        if (user != null && !isExists) {
            user.setRegdate(DateUtils.getDate());
            Integer result = tUserService.addUser(user);
            if (result != null && result == 1) {
                mv.setViewName("forward:/user/pageSplit.action");
            }
        } else {
            mv.addObject("msg1", "用户代码重复");
            mv.setViewName("forward:/system/userAdd.jsp");
        }
        return mv;
    }

    //ajax添加用户同时进行判断用户代码是否重复
    //添加用户
    @RequestMapping(value = "/addUserAjax.action", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String addUserByAjax(TUser user, HttpServletRequest request) {
        //添加之前需要根据用户代码进行查询是否出现重复的用户代码
        String usercode = user.getUsercode();

        //true：表示用户代码重复，false表示用户代码没有重复
        boolean isExists = false;
        TUser tuser = tUserService.selectByPrimary(usercode);
        if (tuser != null) {
            String tuserCode = tuser.getUsercode();
            isExists = tuserCode.equals(usercode) ? true : false;
        }
        if (!isExists) {
            return "";
        }
        return "用户代码重复";
    }


    //点击用户管理实现分页查询,默认查第一页
    @RequestMapping(value = "/pageSplit.action")
    public String pageSplit(Integer pageNo, HttpServletRequest request) {
        if (pageNo == null || 0 >= pageNo) {
            pageNo = 1;
        }
        ModelAndView mv = new ModelAndView();
        PageInfo info = tUserService.pageSplit(pageNo, PAGE_SIZE);
        if (info != null) {
            request.setAttribute("info", info);
            return "forward:/system/user.jsp";
        } else {
            return "error";
        }
    }

    //根据主键查询用户
    @RequestMapping(value = "/userUpdateSelect.action")
    public String selectByPrimary(String usercode, Integer pageNum, HttpServletRequest request) {
        TUser user = tUserService.selectByPrimary(usercode);
        if (null == user) {
            //return "forward:/user/pageSplit.action?pageNo="+pageNum;
            throw new NullPointerException("user为空");
        }
        //获取orgtype=1对应的银行
        String back = StringUtiles.getValue("1");
        //获取orgtype=0对应的外汇管理局
        String outside = StringUtiles.getValue("0");

        List<String> list = new ArrayList<>();
        list.add(outside);
        list.add(back);

        request.setAttribute("user", user);
        request.setAttribute("list", list);
        request.getSession().setAttribute("pageNum", pageNum);

        return "forward:/system/userUpdate.jsp";
    }

    //更新用户并返回到当前页面
    @RequestMapping(value = "/update.action")
    public String updateUser(TUser tUser, HttpServletRequest request) {
        Integer result = 0;
        if (tUser != null) {
            result = tUserService.updateUser(tUser);
            if (result != null || result == 1) {
                return "forward:/user/pageSplit.action?pageNo=" + request.getSession().getAttribute("pageNum");
            }
        }
        return "error";
    }

    //删除用户
    @RequestMapping(value = "/deleteUser.action")
    public String deleteUser(String[] str, Integer pageNum, HttpServletRequest request) {
        if (str == null) {
            throw new NullPointerException("str数组为空");
        }
        Integer result = tUserService.deleteUser(str);
        if (result != null || result > 0) {
            request.setAttribute("msg", "用户删除成功");
            return "forward:/user/pageSplit.action?pageNo=" + pageNum;
        }
        request.setAttribute("msg", "用户删除失败");
        return "error";

    }

    //用户登录
    @RequestMapping(value = "/login.action")
    public String login(TUser user, HttpServletRequest request) {
        HttpSession session = request.getSession();
        TUser tUser = tUserService.login(user);
        String orgtype = StringUtiles.getValue(user.getOrgtype());
        if (tUser != null) {
            session.setAttribute("loginMsg", "登录成功");
            session.setAttribute("username",tUser.getUsername());
            session.setAttribute("usercode",user.getUsercode());
            session.setAttribute("orgtype", orgtype);
            return "redirect:/main.jsp";
        }
        session.setAttribute("loginMsg", "登录失败，请重新登录");
        return "redirect:/login.jsp";
    }

    //用户退出
    @RequestMapping(value = "/logout.action")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        session.invalidate();
        return "redirect:/login.jsp";
    }

}
