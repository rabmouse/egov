<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <title>无标题文档</title>
    <style type="text/css">

        body {
            margin-left: 0px;
            margin-top: 0px;
            margin-right: 0px;
            margin-bottom: 0px;
        }

        .STYLE1 {
            font-size: 12px
        }

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

        .STYLE7 {
            font-size: 12px
        }


    </style>
    <script type="text/javascript">


        //上一页
        function prePage(prePage) {
            if (${info.hasPreviousPage}) {
                window.location = "${pageContext.request.contextPath}/user/pageSplit.action?pageNo=" + prePage;
            }
        }

        //下一页
       function next(nextPage){
           //alert(2222);
           if (${info.hasNextPage}) {
               window.location = "${pageContext.request.contextPath}/user/pageSplit.action?pageNo=" + nextPage;
           }
       }

        //跳转到指定页
        function goToPage() {
            //获取指定页码
            var pageNo = $("#gotopage").val();
            //判断用户输入的页码是否合法
            var ok = checkPage(pageNo);
            if (ok) {
                window.location = "${pageContext.request.contextPath}/user/pageSplit.action?pageNo=" + pageNo;
            }
        }

        //跳转页面的时候判断页码是否合法
        function checkPage(pageNo) {

            //非空判断
            if (pageNo.trim() == "") {
                alert("页码不能为空");
                $("#gotopage").val("")
                $("#gotopage").focus();
                return;
            }
            // alert(!isNaN(pageNo));
            //数字判断
            //将字符串转为数字
            pageNo = parseInt(pageNo);
            if (isNaN(pageNo)) {//isNaN返回fasle表示是数字
                alert("页码必须是数字");
                $("#gotopage").val("")
                $("#gotopage").focus();
                return;
            }
            //页码范围判断
            if (1 > pageNo || pageNo >${info.pages}) {
                alert("页码范围必须是1~" +${info.pages})
                $("#gotopage").val("")
                $("#gotopage").focus();
                return;
            }
            return true;

        }


        //鼠标经过的时候第一页的颜色变了
        function displayfirstPage() {
            var firstPage = $("#firstPage");
            firstPage.css("cursor", "hand");
            firstPage.prop("src", "${pageContext.request.contextPath}/images/firstPage.gif");
        }

        //鼠标经过的时候最后一页的颜色变了
        function displaylastPage() {
            // alert(222);
            var lastPage = $("#lastPage");
            lastPage.css("cursor", "hand");
            lastPage.prop("src", "${pageContext.request.contextPath}/images/lastPage.gif");
        }

        //鼠标经过的时候上一页的颜色变了
        function displayprevPage() {
            // alert(222);
            var prevPage = $("#prevPage");
            prevPage.css("cursor", "hand");
            prevPage.prop("src", "${pageContext.request.contextPath}/images/prevPage.gif");
        }

        //鼠标经过的时候下一页的颜色变了
        function displaynextPage() {
            // alert(222);
            var nextPage = $("#nextPage");
            nextPage.css("cursor", "hand");
            nextPage.prop("src", "${pageContext.request.contextPath}/images/nextPage.gif");
        }

        $(function () {


            //页面加载完毕调用删除和修改联动控制的函数
            displaydelorcancle()

            //当前页不是第一页的是，第一页和上一页的图片变为蓝色
            if (${info.pageNum!=1}) {
                displayfirstPage();
                displayprevPage();
            }
            //当前页不是最后一页的时候，最后一页和下一页的图片变为蓝色
            if (${info.pageNum!=info.pages}) {
                displaylastPage();
                displaynextPage();
            }
        })

        //当点击复选框的时候，选中一个，删除和修改都可用，选中两个的时候，删除可用，修改不可用
        function displaydelorcancle() {

            //获取复选框的被选中的数量
            var checkCount = $("input[name=usercode]:checked").length;
            //获取修改的图片元素
            var updateImg = $("#update");
            //获取删除的图片元素
            var deleteImg = $("#delete");

            //当复选框没被选中的时候，删除和修改都不能用
            if (checkCount == 0) {
                updateImg.prop("disabled", "disabled");
                deleteImg.prop("disabled", "disabled");
                updateImg.prop("src", "${pageContext.request.contextPath}/images/update_disabled.jpg");
                deleteImg.prop("src", "${pageContext.request.contextPath}/images/delete_disabled.jpg");
            }

            //当复选框被选1个的时候，删除和修改都能用
            if (checkCount == 1) {
                updateImg.prop("disabled", "");
                deleteImg.prop("disabled", "");
                updateImg.prop("src", "${pageContext.request.contextPath}/images/update.jpg");
                deleteImg.prop("src", "${pageContext.request.contextPath}/images/delete.jpg");
            }

            //当复选框被选大于1个的时候，删除能用，修改不能用
            if (checkCount > 1) {
                updateImg.prop("disabled", "disabled");
                deleteImg.prop("disabled", "");
                updateImg.prop("src", "${pageContext.request.contextPath}/images/update_disabled.jpg");
                deleteImg.prop("src", "${pageContext.request.contextPath}/images/delete.jpg");
            }
        }


        //全选框
        function selectAll() {
            //获取全选框的选中状态
            var selecAll = $("input[name=checkbox62]").prop("checked");
            //获取所有的复选框
            var selects = $("input[name=usercode]");
            //alert(selecAll.prop("checked"));

            //全选框选中，其余复选框就全选
            selects.each(function () {
                this.checked = selecAll;
            })
            //全选的时候删除和修改也要联动
            displaydelorcancle();
        }

        //非全选框
        function ischecked() {
            //alert(222)
            //获取复选框的数量
            var count = $("input[name=usercode]").length;
            //复选框选中的数量
            var checkeds = $("input[name=usercode]:checked").length
            //当所有复选框选中的时候，全选框才全选
            if (count == checkeds) {
                $("input[name=checkbox62]").prop("checked", true)

            } else {
                $("input[name=checkbox62]").prop("checked", false)
            }
            displaydelorcancle()
        }

        //点击修改页面，跳转到修改页面并回显数据
        function updateDisplay() {
            //获取id为usercode的文本显示内容
            //var usercode = $("input[name=usercode]").text();
            //alert($("input[name=usercode]:selected").val());
            //alert(usercode);
            //将usercode提交给后端
            //document.location = "${pageContext.request.contextPath}/user/userUpdateSelect.action?usercode=" + usercode;
            //提交表单
            $("form").submit();
        }

        //删除用户
        function deleteUser(){
            //获取选中的复选框
            var count = $("input[name=usercode]:checked");
            //拼接字符串
            var str = "";

            //遍历选中的复选框
            count.each(function (index) {
                if (index==count.length-1){
                    str += this.value;
                }else {
                    str += this.value+",";
                }
            })
            if (confirm("是否删除"+count.length+"个用户")) {
                /*$.ajax({
                    url:"${pageContext.request.contextPath}/user/deleteUser.action",
                    data:{
                        "str":str,
                        "pageNum":${info.pageNum}
                    },
                    dataType:"text",
                    success:function (data) {
                        alert(data);
                    },
                })*/
                alert(str);
                $("form").prop("action","${pageContext.request.contextPath}/user/deleteUser.action?str="+str+"&pageNum="+${info.pageNum});

                $("form").submit();
                //$("#table").load("${pageContext.request.contextPath}/system/user.jsp #table")
            }
        }

    </script>

</head>

<body>
<form action="${pageContext.request.contextPath}/user/userUpdateSelect.action?pageNum=${info.pageNum}" method="post"><!-- 传页码，再在userUpdate用 -->
    <table id="table" width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
            <td height="30">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="15" height="30"><img src="../images/tab_03.gif" width="15" height="30"/></td>
                        <td width="1101" background="../images/tab_05.gif"><img src="../images/311.gif" width="16"
                                                                                height="16"/> <span
                                class="STYLE4">系统用户列表</span></td>
                        <td width="281" background="../images/tab_05.gif">
                            <table border="0" align="right" cellpadding="0" cellspacing="0">
                                <tr>
                                    <td width="60">
                                        <table width="90%" border="0" cellpadding="0" cellspacing="0">
                                            <tr>
                                                <td class="STYLE1">
                                                    <div align="center"><img src="../images/add.jpg" style="cursor:hand"
                                                                             onclick="document.location='${pageContext.request.contextPath}/system/userAdd.jsp'"/>
                                                    </div>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                    <td width="60">
                                        <table width="90%" border="0" cellpadding="0" cellspacing="0">
                                            <tr>
                                                <td class="STYLE1">
                                                    <div align="center"><input type="image" disabled="disabled"
                                                                               src="../images/update_disabled.jpg"
                                                                               id="update"
                                                                               onclick="updateDisplay()">
                                                        <%-- <img disabled="true"
                                                          src="../images/update_disabled.jpg"
                                                          id="update" style="cursor: hand"
                                                          onclick="document.location='${pageContext.request.contextPath}/system/userUpdate.html'"/>--%>
                                                    </div>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                    <td width="60">
                                        <table width="90%" border="0" cellpadding="0" cellspacing="0">
                                            <tr>
                                                <td class="STYLE1">
                                                    <div align="center"><input type="image" disabled="disabled"
                                                                               src="../images/delete_disabled.jpg"
                                                                               id="delete"
                                                                               onclick="deleteUser()">
                                                        <%-- <img disabled="true" src="../images/delete_disabled.jpg"
                                                                              id="delete" style="cursor: hand"
                                                                              onclick="javascript:void(0)"/>--%>
                                                    </div>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                        </td>
                        <td width="14"><img src="../images/tab_07.gif" width="14" height="30"/></td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="9" background="../images/tab_12.gif">&nbsp;</td>
                        <td bgcolor="#f3ffe3">
                            <table width="99%" border="0" align="center" cellpadding="0" cellspacing="1"
                                   bgcolor="#0e6f68">
                                <tr>
                                    <td width="6%" height="26" background="../images/tab_14.gif" class="STYLE1">
                                        <div align="center" class="STYLE2 STYLE1"><input type="checkbox"
                                                                                         name="checkbox62"
                                                                                         value="checkbox"
                                                                                         onclick="selectAll()"/></div>
                                        <!--全选框-->
                                    </td>
                                    <td width="8%" height="18" background="../images/tab_14.gif" class="STYLE1">
                                        <div align="center" class="STYLE2 STYLE1">序号</div>
                                    </td>
                                    <td width="12%" height="18" background="../images/tab_14.gif" class="STYLE1">
                                        <div align="center" class="STYLE2 STYLE1">用户代码</div>
                                    </td>
                                    <td width="24%" height="18" background="../images/tab_14.gif" class="STYLE1">
                                        <div align="center" class="STYLE2">用户姓名</div>
                                    </td>
                                    <td width="38%" height="18" background="../images/tab_14.gif" class="STYLE1">
                                        <div align="center" class="STYLE2 STYLE1">机构类型</div>
                                    </td>
                                </tr>

                                <c:forEach items="${info.list}" var="user" varStatus="v">
                                    <tr>
                                        <td height="18" bgcolor="#FFFFFF">
                                            <div align="center" class="STYLE1">
                                                <input name="usercode" type="checkbox" class="STYLE2"
                                                       value="${user.usercode}"
                                                       onclick="ischecked()"/> <!-- 复选框 -->
                                            </div>
                                        </td>
                                        <td height="18" bgcolor="#FFFFFF" class="STYLE2">
                                            <div align="center" class="STYLE2 STYLE1">${v.count}</div>
                                        </td>
                                        <td height="18" bgcolor="#FFFFFF">
                                            <div align="center" class="STYLE2 STYLE1"
                                            >${user.usercode}</div>
                                        </td>
                                        <td height="18" bgcolor="#FFFFFF">
                                            <div align="center" class="STYLE2 STYLE1">${user.username}</div>
                                        </td>
                                        <td height="18" bgcolor="#FFFFFF">
                                            <div align="center"><a href="#">
                                                <c:choose>
                                                    <c:when test="${user.orgtype==0}">外汇管理局 </c:when>
                                                    <c:when test="${user.orgtype==1}">银行</c:when>
                                                </c:choose>
                                            </a></div>
                                        </td>
                                    </tr>
                                </c:forEach>

                            </table>
                        </td>
                        <td width="9" background="../images/tab_16.gif">&nbsp;</td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td height="29">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="15" height="29"><img src="../images/tab_20.gif" width="15" height="29"/></td>
                        <td background="../images/tab_21.gif">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="25%" height="29" nowrap="nowrap"><span
                                            class="STYLE1">共${info.total}条纪录，当前第${info.pageNum}/${info.pages}页，每页3条纪录</span>
                                    </td>
                                    <td width="75%" valign="top" class="STYLE1">
                                        <div align="right">
                                            <table width="352" height="20" border="0" cellpadding="0" cellspacing="0">
                                                <tr>
                                                    <td width="30" height="22" valign="middle">
                                                        <div align="right"><img src="../images/firstPageDisabled.gif"
                                                                                id="firstPage"
                                                                                onclick="prePage(1)"/>
                                                        </div>
                                                    </td>
                                                    <td width="30" height="22" valign="middle">
                                                        <div align="right"><img src="../images/prevPageDisabled.gif"
                                                                                id="prevPage"
                                                                                onclick="prePage(${info.prePage})"/>
                                                        </div>
                                                    </td>
                                                    <td width="30" height="22" valign="middle">
                                                        <div align="right"><img src="../images/nextPageDisabled.gif"
                                                                                id="nextPage"
                                                                                onclick="next(${info.nextPage})"/>
                                                        </div>
                                                    </td>
                                                    <td width="30" height="22" valign="middle">
                                                        <div align="right"><img src="../images/lastPageDisabled.gif"
                                                                                id="lastPage"
                                                                                onclick="next(${info.pages})"/>
                                                        </div>
                                                    </td>
                                                    <td width="59" height="22" valign="middle">
                                                        <div align="right">转到第</div>
                                                    </td>
                                                    <td width="25" height="22" valign="middle"><span class="STYLE7">
                    <input name="textfield" type="text" class="STYLE1" id="gotopage"
                           style="height:14px; width:25px;text-align:right"
                           size="5"/>
                  </span></td>
                                                    <td width="23" height="22" valign="middle">页</td>
                                                    <td width="30" height="22" valign="middle"><img
                                                            src="../images/go.gif"
                                                            style="cursor:hand"
                                                            width="37" height="15"
                                                            onclick="goToPage()"/>
                                                    </td>
                                                </tr>
                                            </table>
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </td>
                        <td width="14"><img src="../images/tab_22.gif" width="14" height="29"/></td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</form>
<script type="text/javascript">

</script>
</body>
</html>

