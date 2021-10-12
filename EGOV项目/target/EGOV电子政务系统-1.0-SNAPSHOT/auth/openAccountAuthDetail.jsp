<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
  <script type="text/javascript"  src="${pageContext.request.contextPath}/js/formCheck.js"></script>
<title>无标题文档</title>
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

<script type="text/javascript">
  function saveAuth() {
      //alert(2222);
      //进行表单验证
      var ok = checkForm();
      //alert(ok);
      if (ok){
          $("form").submit();
      }
  }

  //表单验证
  function checkForm(){
      var contactman = new FormElement("联系人","contactman");
      var contacttel = new FormElement("联系电话","contacttel");
      var formArray = [contactman,contacttel];
      //非空验证
      return $$.isNull(formArray);
  }
</script>
</head>

<body>
<form action="../tauth/addAuth.action" method="post" enctype="multipart/form-data">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="../images/tab_03.gif" width="15" height="30" /></td>
        <td width="1101" background="../images/tab_05.gif"><img src="../images/311.gif" width="16" height="16" /> <span class="STYLE4">资本金账户开户核准-录入</span></td>
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
          <tr>
            <td width="100" height="26" class="STYLE1" colspan="4"><div align="center" style="padding:5px" class="STYLE2 STYLE1"><font color="#FFFFFF"><B>资本金账户开户核准信息</B></font></div></td>
          </tr>
          <tr>
            <td width="100" bgcolor="#FFFFFF" height="26" class="STYLE1"><div align="right" style="padding:5px" class="STYLE2 STYLE1">组织机构代码:</div></td>
            <td width="250" bgcolor="#FFFFFF" class="STYLE1"><div align="left" style="padding:2px" class="STYLE2" id="orgcode"><input type="hidden" name="orgcode" value="${tEnterprise.orgcode}"/>${tEnterprise.orgcode}</div></td>
            <td width="100" bgcolor="#FFFFFF" height="26" class="STYLE1"><div align="right" style="padding:5px" class="STYLE2 STYLE1"  id="cnname">企业中文名称:</div></td>
            <td bgcolor="#FFFFFF" class="STYLE1"><div align="left" style="padding:2px" class="STYLE2">${tEnterprise.cnname}</div></td>
          </tr>
          <tr>
            <td width="100" bgcolor="#FFFFFF" height="26" class="STYLE1" ><div align="right" style="padding:5px" class="STYLE2 STYLE1" id="regcry" >限额币种:</div></td>
            <td bgcolor="#FFFFFF" class="STYLE1"><div align="left" style="padding:2px" class="STYLE2">${tEnterprise.regcry}</div></td>
            <td width="100" bgcolor="#FFFFFF" height="26" class="STYLE1" ><div align="right" style="padding:5px" class="STYLE2 STYLE1" id="regcap" >账户限额:</div></td>
            <td bgcolor="#FFFFFF" class="STYLE1"><div align="left" style="padding:2px" class="STYLE2">${tEnterprise.regcap}</div></td>
          </tr>
          <tr>
            <td width="100" height="26" class="STYLE1" colspan="4"><div align="center" style="padding:5px" class="STYLE2 STYLE1"><font color="#FFFFFF"><B>核准件其他信息</B></font></div></td>
          </tr>          
          <tr>
            <td width="100" bgcolor="#FFFFFF" height="26" class="STYLE1"><div align="right" style="padding:5px" class="STYLE2 STYLE1">联系人:</div></td>
            <td width="250" bgcolor="#FFFFFF" class="STYLE1"><div align="left" style="padding:2px" class="STYLE2"><input type="text" id="contactman" name="contactman" style="width:150px; height:20px; border:solid 1px #035551; color:#000000"><font color="red">*</font></div></td>
            <td width="100" bgcolor="#FFFFFF" height="26" class="STYLE1"><div align="right" style="padding:5px" class="STYLE2 STYLE1">联系电话:</div></td>
            <td bgcolor="#FFFFFF" class="STYLE1"><div align="left" style="padding:2px" class="STYLE2"><input type="text" id="contacttel" name="contacttel" style="width:150px; height:20px; border:solid 1px #035551; color:#000000"><font color="red">*</font></div></td>
          </tr>
          <tr>
            <td width="100" bgcolor="#FFFFFF" height="26" class="STYLE1"><div align="right" style="padding:5px" class="STYLE2 STYLE1">备注:</div></td>
            <td bgcolor="#FFFFFF" class="STYLE1" colspan="3"><div align="left" style="padding:2px" class="STYLE2"><textarea name="remark" id="remark" style="width:500px; height:50px; border:solid 1px #035551; color:#000000" ></textarea></div></td>
          </tr>
          <tr>
            <td width="100" height="26" class="STYLE1" colspan="4"><div align="center" style="padding:5px" class="STYLE2 STYLE1"><font color="#FFFFFF"><B>文件信息</B></font></div></td>
          </tr>          
          <tr>
            <td width="100" bgcolor="#FFFFFF" height="26" class="STYLE1"><div align="right" style="padding:5px" class="STYLE2 STYLE1">验资文件:</div></td>
            <td bgcolor="#FFFFFF" class="STYLE1" colspan="3"><div align="left" style="padding:2px" class="STYLE2"><input name="file" id="file" type="file" style="width:500px; height:20px; border:solid 1px #035551; color:#000000" /></div></td>
          </tr>
          <tr>
            <td width="100" bgcolor="#FFFFFF" height="26" class="STYLE1"><div align="right" style="padding:5px" class="STYLE2 STYLE1">备注:</div></td>
            <td bgcolor="#FFFFFF" class="STYLE1" colspan="3"><div align="left" style="padding:2px" class="STYLE2"><textarea name="fileremark" id="fileremark" style="width:500px; height:50px; border:solid 1px #035551; color:#000000" ></textarea></div></td>
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
          <tr height="30">
            <td bgcolor="#FFFFFF" height="30" class="STYLE1" colspan="2" align="center">
              <button type="button" style="padding-left:0px;padding-top:0px;width:68px;height:27px;cursor:pointer" onclick="saveAuth()" >
                <img src="../images/ok.jpg" />
              </button>&nbsp;&nbsp;
              <button  type="button" style="padding-left:0px;padding-top:0px;width:68px;height:27px;cursor:pointer" onclick="" >
                <img src="../images/back.jpg"/>
              </button></td></tr>
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
