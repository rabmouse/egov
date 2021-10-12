<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
  <script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
  <script type="text/javascript" src="../js/formCheck.js"></script>
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

  $(function () {
      tips();
  })

  //投资人添加提示信息
  function tips() {
      if ("${msg}"!=""){
          alert("${msg}")
      }
  }

  //添加投资人的方法
  function addInv(){
      //先进行必须填写的表单项验证
      var ok = checkForm();
      if (ok){
          $("form").submit();
      }
  }

  function checkForm() {
      //创建投资人名称、所属国家地区表党项
      var invname = new FormElement("投资人名称","invname");
      var cty = new FormElement("所属国家/地区","cty");
      //创建表单项数组
      var formArray = [invname,cty];
      //进行判空处理
      return $$.isNull(formArray);
  }

</script>
  <c:remove var="msg"></c:remove>
</head>

<body>
<form action="../invest/addInvest.action" method="post">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="../images/tab_03.gif" width="15" height="30" /></td>
        <td width="1101" background="../images/tab_05.gif"><img src="../images/311.gif" width="16" height="16" /> <span class="STYLE4">新增投资人信息</span></td>
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
        <td bgcolor="#f3ffe3"><table width="99%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#0e6f68">
          <tr height="26"></tr>
          <tr>
            <td width="200" bgcolor="#FFFFFF" height="26" class="STYLE1"><div align="right" style="padding:5px" class="STYLE2 STYLE1">投资人名称:</div></td>
            <td bgcolor="#FFFFFF" class="STYLE1" colspan="3"><div align="left" style="padding:2px" class="STYLE2"><input type="text" name="invname" id="invname" style="width:100px; height:20px; border:solid 1px #035551; color:#000000">&nbsp;<font color='red'>*</font></div></td>
          </tr>
          <tr>
            <td width="200" bgcolor="#FFFFFF" height="26" class="STYLE1"><div align="right" style="padding:5px" class="STYLE2 STYLE1">所属国家/地区:</div></td>
            <td bgcolor="#FFFFFF" class="STYLE1" colspan="3"><div align="left" style="padding:2px" class="STYLE2">

			<select name="cty" id="cty" style="width:105px; height:20px; border:solid 1px #035551; color:#000000">
		        <option value="-1">选择国家/地区</option>
		        <option value="000">中国</option>
		        <option value="001">美国</option>
		        <option value="002">英国</option>
		        <option value="003">日本</option>
		    </select>&nbsp;<font color='red'>*</font>
            </div></td>
          </tr>
          <tr>
            <td width="200" bgcolor="#FFFFFF" height="26" class="STYLE1"><div align="right" style="padding:5px" class="STYLE2 STYLE1">组织机构代码:</div></td>
            <td bgcolor="#FFFFFF" class="STYLE1" colspan="3"><div align="left" style="padding:2px" class="STYLE2"><input type="text" name="orgcode" style="width:100px; height:20px; border:solid 1px #035551; color:#000000">&nbsp;</div></td>
          </tr>
          <tr>
            <td width="200" bgcolor="#FFFFFF" height="26" class="STYLE1" ><div align="right" style="padding:5px" class="STYLE2 STYLE1">联系人:</div></td>
            <td bgcolor="#FFFFFF" class="STYLE1" colspan="3"><div align="left" style="padding:2px" class="STYLE2"><input type="text" name="contactman" style="width:100px; height:20px; border:solid 1px #035551; color:#000000"></div></td>
          </tr>
          <tr>
            <td width="200" bgcolor="#FFFFFF" height="26" class="STYLE1"><div align="right" style="padding:5px" class="STYLE2 STYLE1">联系电话:</div></td>
            <td bgcolor="#FFFFFF" class="STYLE1"><div align="left" style="padding:2px" class="STYLE2"><input type="text" name="contacttel" style="width:100px; height:20px; border:solid 1px #035551; color:#000000"></div></td>
            <td width="200" bgcolor="#FFFFFF" height="26" class="STYLE1"><div align="right" style="padding:5px" class="STYLE2 STYLE1">电子信箱:</div></td>
            <td bgcolor="#FFFFFF" class="STYLE1"><div align="left" style="padding:2px" class="STYLE2"><input type="text" name="email" style="width:100px; height:20px; border:solid 1px #035551; color:#000000"></div></td>
          </tr>
          <tr>
            <td width="200" bgcolor="#FFFFFF" height="26" class="STYLE1"><div align="right" style="padding:5px" class="STYLE2 STYLE1">备注:</div></td>
            <td bgcolor="#FFFFFF" class="STYLE1" colspan="3"><div align="left" style="padding:2px" class="STYLE2"><textarea name="remark" style="width:490px; height:50px; border:solid 1px #035551; color:#000000" ></textarea></div></td>
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
          <tr height="26"><td bgcolor="#FFFFFF" height="26" class="STYLE1" colspan="2" style="padding-top:5px;padding-left:200px"><img src="../images/save.jpg" style="cursor:pointer" onclick="addInv()" />&nbsp;&nbsp;<img src="../images/clear.jpg" style="cursor:pointer" />&nbsp;&nbsp;<img src="../images/back.jpg" style="cursor:pointer" onclick="history.go(-1)" /></td></tr>
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
