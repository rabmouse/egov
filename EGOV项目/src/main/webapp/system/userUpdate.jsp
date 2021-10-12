<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
    <script charset="UTF-8" type="text/javascript" src="../js/formCheck.js"></script>
    <style type="text/css">
        <!--
        body {
            margin-left: 0px;
            margin-top: 0px;
            margin-right: 0px;
            margin-bottom: 0px;
        }
        .STYLE1 {font-size: 12px}
        .STYLE4 {
            font-size: 12px;
            color: #1F4A65;
            font-weight: bold;
        }

        a:link {
            font-size: 12px;
            color: #06482a;
            text-decoration: none;

        }
        a:visited {
            font-size: 12px;
            color: #06482a;
            text-decoration: none;
        }
        a:hover {
            font-size: 12px;
            color: #FF0000;
            text-decoration: underline;
        }
        a:active {
            font-size: 12px;
            color: #FF0000;
            text-decoration: none;
        }
        .STYLE7 {font-size: 12px}

        -->
    </style>

    <script>
        function doCheck(){
            //进行表单验证
            var ok = isOk();
            if (ok){
           //alert("校验成功")
                alert("当前页："+${pageNum});
                $("form").submit();
            }
        }

        //这是面向过程的js表单验证，开发效率极低
     /*   function isOk() {
            var username = $("#username");
            //alert(username.prop("value"));
            var userpswd = $("#userpswd");
            var userpswdyes = $("#userpswdyes");
            var orgtype = $("#orgtype");

            if (username.prop("value").trim() == ""){
                alert("用户名不能为空");
                username.focus();
                return false;
            }
            if (userpswd.prop("value").trim() == ""){
                alert("用户密码不能为空");
                userpswd.focus();
                return false;
            }
            if (userpswdyes.prop("value") != userpswd.prop("value")){
                alert("用户密码和确认密码不一致");
                userpswd.focus();
                return false;
            }
            if (orgtype.prop("value")== -1){
                alert("请选择您的机构类型");
                return false;
            }
            return true;
        }*/

        //表单验证的第二种方式：面向对象的方式
        function isOk() {
            //创建用户姓名、用户密码、用户密码框、下拉列表框表单对象
            var username = new FormElement("用户姓名","username");
            var userpswd = new FormElement("用户密码","userpswd");
            var userpswdyes = new FormElement("确认密码","userpswdyes");
            var orgtype = new FormElement("机构类型","orgtype");
            //创建表单项数组
            var formElementArray = [username,userpswd,userpswdyes,orgtype]
            //调用表单验证工具类进行验证
            return $$.isNull(formElementArray) && $$.isSame(userpswd,userpswdyes);
        }
    </script>
</head>

<body>
<form action="${pageContext.request.contextPath}/user/update.action" method="post">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="15" height="30"><img src="../images/tab_03.gif" width="15" height="30" /></td>
                <td width="1101" background="../images/tab_05.gif"><img src="../images/311.gif" width="16" height="16" /> <span class="STYLE4">修改系统用户</span></td>
                <td width="281" background="../images/tab_05.gif"><table border="0" align="right" cellpadding="0" cellspacing="0">
                </table></td>
                <td width="14"><img src="../images/tab_07.gif" width="14" height="30" /></td>
            </tr>
        </table></td>
    </tr>
    <tr>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="9" background="../images/tab_12.gif">&nbsp;</td>
                <td bgcolor="#f3ffe3"><table width="99%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#0e6f68" >
                    <tr height="26"></tr>
                    <tr>
                        <td width="200" bgcolor="#FFFFFF" height="26" class="STYLE1"><div align="right" style="padding:5px" class="STYLE2 STYLE1">用户代码</div></td>
                        <td bgcolor="#FFFFFF" class="STYLE1"><div align="left" style="padding:2px" class="STYLE2">${user.usercode}<input type="text" name="usercode" value="${user.usercode}" hidden></div></td>
                    </tr>
                    <tr>
                        <td width="200" bgcolor="#FFFFFF" height="26" class="STYLE1"><div align="right" style="padding:5px" class="STYLE2 STYLE1">用户姓名</div></td>
                        <td bgcolor="#FFFFFF" class="STYLE1"><div align="left" style="padding:2px" class="STYLE2"><input type="text" name="username" id="username" value="${user.username}" style="width:100px; height:20px; border:solid 1px #035551; color:#000000">&nbsp;<font color='red'>*</font></div></td>
                    </tr>
                    <tr>
                        <td width="200" bgcolor="#FFFFFF" height="26" class="STYLE1"><div align="right" style="padding:5px" class="STYLE2 STYLE1">用户密码</div></td>
                        <td bgcolor="#FFFFFF" class="STYLE1"><div align="left" style="padding:2px" class="STYLE2"><input type="password" name="userpswd" id="userpswd" value="${user.userpswd}" style="width:100px; height:20px; border:solid 1px #035551; color:#000000">&nbsp;<font color='red'>*</font></div></td>
                    </tr>
                    <tr>
                        <td width="200" bgcolor="#FFFFFF" height="26" class="STYLE1"><div align="right" style="padding:5px" class="STYLE2 STYLE1">确认密码</div></td>
                        <td bgcolor="#FFFFFF" class="STYLE1"><div align="left" style="padding:2px" class="STYLE2"><input type="password" name="checkpswd" id="userpswdyes" value="${user.userpswd}" style="width:100px; height:20px; border:solid 1px #035551; color:#000000">&nbsp;<font color='red'>*</font></div></td>
                    </tr>
                    <tr>
                        <td width="200" bgcolor="#FFFFFF" height="26" class="STYLE1"><div align="right" style="padding:5px" class="STYLE2 STYLE1">机构类型</div></td><!--需要进行表单的验证，利用js的面向对象的方法-->
                        <td bgcolor="#FFFFFF" class="STYLE1"><div align="left" style="padding:2px" class="STYLE2">
                            <select name="orgtype" style="width:105px; height:20px; border:solid 1px #035551; color:#000000" id="orgtype">
                                <option value ="-1">请选择机构类型</option>
                               <c:forEach items="${list}"  var="org" varStatus="v">
                                   <option value="${user.orgtype}"
                                        <c:if test="${v.index==user.orgtype}">
                                            selected = "selected"
                                         </c:if>
                                   >${org}</option>
                                   <%--<option>银行</option>--%>
                               </c:forEach>
                            </select>&nbsp;<font color='red'>*</font></div></td>
                    </tr>
                </table></td>
                <td width="9" background="../images/tab_16.gif">&nbsp;</td>
            </tr>
        </table></td>
    </tr>
    <tr>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="9" background="../images/tab_12.gif">&nbsp;</td>
                <td bgcolor="#f3ffe3"><table width="99%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#0e6f68">
                    <tr height="26"><td bgcolor="#FFFFFF" height="26" class="STYLE1" colspan="2" style="padding-top:5px;padding-left:200px"><img src="../images/save.jpg" style="cursor:hand" onclick="doCheck()" />&nbsp;&nbsp;<img src="../images/clear.jpg" style="cursor:hand" /></td></tr>
                </table></td>
                <td width="9" background="../images/tab_16.gif">&nbsp;</td>
            </tr>
        </table></td>
    </tr>
    <tr>
        <td height="29"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="15" height="29"><img src="../images/tab_20.gif" width="15" height="29" /></td>
                <td background="../images/tab_21.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="75%" valign="top" class="STYLE1"><div align="left">
                            <table width="352" height="20" border="0" cellpadding="0" cellspacing="0">
                                <tr>
                                    <td width="62" height="22" valign="middle"></td>
                                    <td width="50" height="22" valign="middle"></td>
                                </tr>
                            </table>
                        </div></td>
                    </tr>
                </table></td>
                <td width="14"><img src="../images/tab_22.gif" width="14" height="29" /></td>
            </tr>
        </table></td>
    </tr>
</table>
</form>
</body>
</html>
