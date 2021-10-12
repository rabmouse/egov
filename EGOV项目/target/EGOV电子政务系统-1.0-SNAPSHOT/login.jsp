<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%
		String basePath = request.getScheme()+"://"+request.getServerName()+":"
				+request.getLocalPort()+ request.getContextPath()+"/";
		System.out.println(basePath);
	%>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>外汇业务信息管理平台_用户登录</title>
	<style type="text/css">
		<!--
		body {
			margin-left: 0px;
			margin-top: 0px;
			margin-right: 0px;
			margin-bottom: 0px;
			overflow:hidden;
		}
		.STYLE1 {
			font-size: 12px;
			color: #a1c8c6;
		}
		.STYLE4 {color: #FFFFFF; font-size: 12px; }
		-->
	</style>
	<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
	<script type="text/javascript" src="js/formCheck.js"></script>
	<script type="text/javascript">

		//提示信息
        function tips(){
            if ("${loginMsg}"!=""){
                alert("${loginMsg}");
            }
        }
        $(function () {
            tips();
        })

		//按回车键登录
        function goToLogin(event){
            if (event.keyCode == 13){
                login();
			}
		}

        function login() {
            //用户登录之前要先进行表单验证
            var ok = checkForm();
            if (ok){
                $("form").submit();
            }
        }

        //表单验证
        function checkForm() {
            //创建登录页面的表单向
            var orgtype = new FormElement("机构类型","orgtype");
            var usercode = new FormElement("用户代码","usercode");
            var userpswd = new FormElement("用户密码","userpswd");
            //创建表单项数组
            var formArra = [orgtype,usercode,userpswd];
            //进行判空
            return $$.isNull(formArra);
        }

	</script>
	<c:remove var="loginMsg"></c:remove>
</head>
<body>
<form action="user/login.action" method="post">
	<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
		<tr><td bgcolor="035551">&nbsp;</td></tr>
		<tr>
			<td height="311" background="img/login_03.gif">
				<table width="758" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr><td height="210" background="img/login1.jpg">&nbsp;</td></tr>
					<tr>
						<td height="101">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="446" height="101" background="img/login_06.jpg">&nbsp;</td>
									<td width="156">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td width="40%" height="22"><span class="STYLE4">机构类型</span></td>
												<td width="71" height="22">
													<select name="orgtype" id="orgtype" style="width:100px; height:20px; border:solid 1px #035551; color:#000000">
														<option value="-1">请选择机构</option>
														<option value="0" selected>外汇管理局</option>
														<option value="1">银行</option>
													</select>
												</td>
											</tr>
											<tr>
												<td height="22"><span class="STYLE4">用户代码</span></td>
												<td width="71" height="22"><input type="text" name="usercode" id="usercode" value="zhangsan" style="width:100px; height:20px; border:solid 1px #035551; color:#000000"></td>
											</tr>
											<tr>
												<td height="22"><span class="STYLE4">用户密码</span></td>
												<td height="22"><input type="password" name="userpswd" id="userpswd" value="123" style="width:100px; height:22px; border:solid 1px #035551; color:#000000"></td>
											</tr>
											<tr>
												<td height="25">&nbsp;</td>
												<td height="25"><button type="button" style="width:40px;height:25px;cursor: pointer" onclick="login()"  onkeydown="goToLogin(event)"><img src="img/dl.gif" width="37" height="19" border="0"></button><button type="button" style="width:40px;height:25px;cursor:pointer"><img src="img/qx.gif" width="37" height="19"></button></td>
											</tr>
										</table>
									</td>
									<td width="156" background="img/login_09.gif">&nbsp;</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td bgcolor="1f7d78">&nbsp;</td>
		</tr>
		<tr>
			<td bgcolor="1f7d78"><div align="center"><span class="STYLE1">-- 外汇业务信息管理平台 --</span></div></td>
		</tr>
	</table>
</form>
</body>
</html>
