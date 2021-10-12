<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
  <script type="text/javascript" src="../js/formCheck.js"></script>
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
  function selectAuthByAuthno() {
      //获取核准件编号
      var authno = $("#authno").val().trim();
      if (authno==""){
          alert("核准件编号不能为空")
      } else if(isNaN(parseInt(authno))){
          alert("核准件编号必须是数字")
      }
      $.ajax({
          url:"${pageContext.request.contextPath}/tauth/selectByPrimary.action",
          dataType:"text",
          data:{
              "authno":authno
          },
          type:"post",
          success:function (data) {
              alert(data);
              $("#container").load("${pageContext.request.contextPath}/authresponse/authResponseView.jsp")
          },
      })
  }

  function feedBack(authno) {
      if (window.confirm("您确定核准件是否合法？")){
          $.ajax({
              url:"${pageContext.request.contextPath}/tauth/feedBack.action",
              data:{
                  "authno":authno
              },
              dataType:"text",
              type:"post",
              success:function (data) {
                  alert(data)
              },
          })
      }
  }
</script>
</head>

<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="../images/tab_03.gif" width="15" height="30" /></td>
        <td width="1101" background="../images/tab_05.gif"><img src="../images/311.gif" width="16" height="16" /> <span class="STYLE4">银行核准类信息列表</span></td>
        <td width="281" background="../images/tab_05.gif"><table border="0" align="right" cellpadding="0" cellspacing="0">
            <tr>
              <td width="60"><table width="90%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"></td>
                  </tr>
              </table></td>
            </tr>
        </table></td>
        <td width="14"><img src="../images/tab_07.gif" width="14" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr height="5">
          <td width="9" background="../images/tab_12.gif">&nbsp;</td>
          <td bgcolor="#f3ffe3">&nbsp;</td>
          <td width="9" background="../images/tab_16.gif">&nbsp;</td>
      </tr>
      <tr>
        <td width="9" background="../images/tab_12.gif">&nbsp;</td>
        <td bgcolor="#f3ffe3">
        	<table width="99%" border="0" align="center" cellpadding="0" cellspacing="1">
        	    <tr>
        	       <td width="90"  nowrap class="STYLE1" align="right">核准件编号:</td>
				    <td class="class1_td alignleft" nowrap><input type="text" name="authno" id="authno" style="width:100px; height:20px; border:solid 1px #035551; color:#000000"></td>
        	    </tr>
        	    <tr>
        	        <td class="STYLE1" colspan="5" align="left">&nbsp;&nbsp;</td>
        	        <td nowrap class="STYLE1" align="right"><button type="button" style="width:68px;height:27px;cursor: pointer" onclick="selectAuthByAuthno();" ><img src="../images/query.jpg" /></button>&nbsp;&nbsp;<button type="button" style="cursor: pointer;width:68px;height:27px"><img src="../images/clear.jpg" /></button>&nbsp;&nbsp;</td>
        	    </tr>
        	</table>
        </td>
        <td width="9" background="../images/tab_16.gif">&nbsp;</td>
      </tr>

  </table>
  </tr>
  <tr>
    <td height="29"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="29"><img src="../images/tab_20.gif" width="15" height="29" /></td>
        <td background="../images/tab_21.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="25%" height="29" nowrap="nowrap"></td>
            <td width="75%" valign="top" class="STYLE1"><div align="right">
            </div></td>
          </tr>
        </table></td>
        <td width="14"><img src="../images/tab_22.gif" width="14" height="29" /></td>
      </tr>
    </table></td>
  </tr>
</table>
<div id="container"></div>
</body>
</html>
