<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>外汇业务信息系统管理平台</title>
  <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
  <script type="text/javascript">
    function tips(){
        if ("${loginMsg}"!=""){
            alert("${loginMsg}");
        }
    }
    $(function () {
        tips();
    })

  </script>
  <c:remove var="loginMsg"></c:remove>
</head>

<frameset rows="90,*,30" cols="*" framespacing="0" frameborder="no" border="0">
  <frame src="top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" />
  <frame src="center.html" name="mainFrame" id="mainFrame" />
  <frame src="down.html" name="bottomFrame" scrolling="No" noresize="noresize" id="bottomFrame" />
</frameset>
<noframes><body>
</body>
</noframes></html>
