package com.qjx.controller;

import com.qjx.pojo.TAuth;
import com.qjx.service.TAuthService;
import com.qjx.utils.FileNameUtil;
import com.qjx.utils.StringUtiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
@RequestMapping(value = "/tauth")
public class TAuthController {

    @Autowired
    TAuthService service;

    /**
     * 这是添加核准件信息的方法，包括上传文件和TAuth核准件对象的信息
     * MultipartFile file：file名称要和前端表单<input type=file name = file id = file/>的name和id一样
     * TAuth auth ：用来接收表单中普通的表单项的值
     */
    @RequestMapping(value = "/addAuth.action", method = RequestMethod.POST)
    public String addAuth( MultipartFile file, TAuth auth, HttpServletRequest request) {
        //上传的文件旧名称
        String oldFileName = "";
        //上传的文件新名称
        String newFileName = "";
        //上传文件的保存位置
        String path = "";
        //声明上传文件的对象
        File uploadFile = null;
        //核准件上传成功的标记
        boolean isok = true;
        if (file!=null){
            oldFileName = file.getOriginalFilename();
            newFileName = FileNameUtil.getUUIDFileName()+oldFileName.substring(oldFileName.lastIndexOf("."));
            path = request.getServletContext().getRealPath("/authFile")+File.separator+newFileName;
            try {
                //将上传的文件保存到path路径中
                file.transferTo(new File(path));
                if (auth!=null){
                    auth.setUsercode((String) request.getSession(false).getAttribute("usercode"));
                    auth.setFilename(newFileName);
                    //默认反馈为0，表示为反馈
                    auth.setFeedback("0");
                    isok = service.addAuth(auth);
                    if (isok){
                        //进入if表示上传成功
                        request.getSession(false).setAttribute("msg", "核准件上传成功");
                        Integer.parseInt("abcd");
                        return "redirect:/auth/inputOrg.jsp";
                    }else {
                        //表示上传失败，则删除上传的文件
                        //创建path文件对象
                        uploadFile = new File(path);
                        uploadFile.delete();
                    }
                }
            } catch (Exception e) {
                //创建path文件对象
                uploadFile = new File(path);
                uploadFile.delete();
                e.printStackTrace();
            }
        }
        //代码能带这里表示核准件添加失败
        if (uploadFile!=null){
            uploadFile.delete();
        }
        request.getSession(false).setAttribute("msg", "核准件上传失败");
        return "redirect:/auth/inputOrg.jsp";
    }

    /**
     * 查找核准件明细的方法
     */
    @RequestMapping(value = "/selectByPrimary.action",method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String selectAuth(String authno,HttpServletRequest request){

        if (authno!=null||authno!=""){
            TAuth tAuth = service.selectTauth(authno);
            if (tAuth!=null){
                tAuth.setAuthno(Integer.parseInt(authno));
                tAuth.setRegcry(StringUtiles.getValue("cty."+tAuth.getRegcry()));
                request.getSession(false).setAttribute("tAuth",tAuth );
                return "查找核准件成功";
            }
        }
        return "查找核准件失败";
    }

    /**
     * 反馈核准件
     */
    @RequestMapping(value = "/feedBack.action",method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String feedBack(Integer authno,HttpServletRequest request){
       if (authno!=null&&authno>=0){
           boolean ok = service.feedBack(authno);
           if (ok){
               return "核准件反馈成功";
           }
       }
        return  "核准件反馈失败";
    }
}



