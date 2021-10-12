<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>外商投资企业选择</title>
    <style type="text/css">
        <!--
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

        -->
    </style>

    <script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="../js/formCheck.js"></script>
    <script src="../charts/highcharts.js"></script>
    <script type="text/javascript">
        $(function () {
            tips();
        })

        //投资人添加提示信息
        function tips() {
            if ("${msg}" != "") {
                alert("${msg}")
            }
        }

        function pageQuey() {
            /*
                  document.all：表示获取整个页面的DOM元素
                  document.all.dataTableBody：表示获取id是dataTableBody的DOM元素
                  document.all.dataTableBody.style：表示设置id是dataTableBody的DOM元素的style属性
                  document.all.dataTableBody.style.display：表示设置id是dataTableBody的DOM元素的display【显示/隐藏】
             */
            //document.all.dataTableBody.style.display='block'
            //alert(222);
            $("form").submit();
        }

        //改变第一页箭头的颜色
        function displayfirstPage() {
            var firstPage = $("#firstPage");
            firstPage.css("cursor", "hand");
            firstPage.prop("src", "${pageContext.request.contextPath}/images/firstPage.gif");
        }

        //改变最后一页箭头的颜色
        function displaylastPage() {
            //alert(1111);
            var lastPage = $("#lastPage");
            lastPage.css("cursor", "hand");
            lastPage.prop("src", "${pageContext.request.contextPath}/images/lastPage.gif");
        }

        //改变上一页的颜色
        function displayprevPage() {
            // alert(222);
            var prevPage = $("#prevPage");
            prevPage.css("cursor", "hand");
            prevPage.prop("src", "${pageContext.request.contextPath}/images/prevPage.gif");
        }

        //改变下一页的颜色
        function displaynextPage() {
            // alert(222);
            var nextPage = $("#nextPage");
            nextPage.css("cursor", "hand");
            nextPage.prop("src", "${pageContext.request.contextPath}/images/nextPage.gif");
        }

        $(function () {
            //当前页不是第一页的时候，第一页和上一页的图片变为蓝色
            if (${info.pageNum!=1 && info.pageNum != null}) {
                displayfirstPage();
                displayprevPage();
            }
            //当前页不是最后一页的时候，最后一页和下一页的图片变为蓝色
            if (${info.pageNum!=info.pages}) {
                //alert(222);
                displaylastPage();
                displaynextPage();
            }
        })
    </script>

    <script type="text/javascript">
        //上一页
        function prePage(prePage) {
            if (${info.hasPreviousPage}) {
                $("form").prop("action", "../enterprise/pageQuery.action?pageNo=" + prePage);
                $("form").submit();
            }
        }

        //下一页
        function next(nextPage) {
            if (${info.hasNextPage}) {
                $("form").prop("action", "../enterprise/pageQuery.action?pageNo=" + nextPage);
                $("form").submit();
            }
        }

        //跳转到指定页
        function goToPage() {
            //获取指定页码
            var pageNo = $("#gotopage").val();
            //判断用户输入的页码是否合法
            var ok = checkPage(pageNo);
            if (ok) {
                $("form").prop("action", "../enterprise/pageQuery.action?pageNo=" + pageNo);
                $("form").submit();
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

        //显示饼状图
        function pie(orgcode) {
            //让装载饼图的div显示
            $("#container").css("display","block");

            //发起ajax请求，获取投资者名称和投资金额
            $.ajax({
                url: "../enterprise/selectForPie.action",
                dataType: "json",
                data: {
                    "orgcode": orgcode
                },
                type: "post",
                success: function (data) {
                    //饼图需要展示的数据格式为：json
                    var data1 = [];
                    var json ;
                    //alert(data1.length);
                    $.each(data,function (index,element) {
                        //将后台传入的数据放到data1中
                        data1.push([element.invname,+element.regcap])
                    })
                    alert(data1);


                    //创建饼图
                    var chart1 = new Highcharts.chart('container', {
                        chart: {
                            plotBackgroundColor: null,
                            plotBorderWidth: null,
                            plotShadow: false,
                            type: 'pie'
                        },
                        title: {
                            text: '投资人投资比例'
                        },
                        tooltip: {
                            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                        },
                        plotOptions: {
                            pie: {
                                allowPointSelect: true,
                                cursor: 'pointer',
                                dataLabels: {
                                    enabled: false
                                },
                                showInLegend: true
                            }
                        },
                        series: [{
                            type: 'pie',
                            name: '投资人投资比例',
                            data: [

                            ]
                        }]
                    });
                    chart1.series[0].setData(data1);
                }
            })
        }

        //鼠标离开不显示饼图
        function noneDisPie() {
            $("#container").css("display","none");
        }


    </script>
    <c:remove var="msg"></c:remove>
</head>

<body>
<form action="../enterprise/pageQuery.action" method="post">
    <%--显示饼图的div--%>
    <div id="container"
         style="width: 600px;height:280px; position: absolute;top: 225px;left: 100px;background: white;opacity: 0.86;display: none"></div>
    <input type="hidden" name="forward" value="/basicinfo/exoticOrgList.jsp">
    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
            <td height="30">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="15" height="30"><img src="../images/tab_03.gif" width="15" height="30"/></td>
                        <td width="1101" background="../images/tab_05.gif"><img src="../images/311.gif" width="16"
                                                                                height="16"/> <span class="STYLE4">外商投资企业列表</span>
                        </td>
                        <td width="281" background="../images/tab_05.gif">
                            <table border="0" align="right" cellpadding="0" cellspacing="0">
                                <tr>
                                    <td width="60">
                                        <table width="90%" border="0" cellpadding="0" cellspacing="0">
                                            <tr>
                                                <td class="STYLE1"></td>
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
                                <td width="120" class="STYLE1">组织机构代码:</td>
                                <td width="140" class="STYLE1"><input type="text" name="orgcode" id="orgcode"
                                                                      value="${vo.orgcode}"
                                                                      style="width:100px; height:20px; border:solid 1px #035551; color:#000000">
                                </td>
                                <td width="90" class="STYLE1">企业中文名称:</td>
                                <td width="130" class="STYLE1"><input type="text" name="cnname" id="cnname"
                                                                      value="${vo.cnname}"
                                                                      style="width:100px; height:20px; border:solid 1px #035551; color:#000000">
                                </td>
                                <td width="60" nowrap class="STYLE1">登记日期:</td>
                                <td class="class1_td alignleft" nowrap>
                                    <input type="text" name="startdate" id="startdate" value="${vo.startdate}"
                                           style="width:75px; height:20px; border:solid 1px #035551; color:#000000"
                                           placeholder="2021-2-3">
                                    ～
                                    <input type="text" name="enddate" id="enddate" value="${vo.enddate}"
                                           style="width:75px; height:20px; border:solid 1px #035551; color:#000000"
                                           placeholder="2021-2-3">

                                </td>
                            </tr>
                            <tr>
                                <td class="STYLE1" colspan="5" align="left">&nbsp;&nbsp;
                                </td>
                                <td nowrap class="STYLE1" align="right"><img src="../images/query.jpg"
                                                                             style="cursor:hand" onclick="pageQuey()"/>
                                    &nbsp;&nbsp;<img
                                            src="../images/clear.jpg" style="cursor:hand"/>&nbsp;&nbsp;
                                </td>
                            </tr>
                        </table>
                    </td>
                    <td width="9" background="../images/tab_16.gif">&nbsp;</td>
                </tr>
                <tr height="10">
                    <td width="9" background="../images/tab_12.gif">&nbsp;</td>
                    <td bgcolor="#f3ffe3">&nbsp;</td>
                    <td width="9" background="../images/tab_16.gif">&nbsp;</td>
                </tr>
            </table>
        </tr>
        <tr>
            <td>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="9" background="../images/tab_12.gif">&nbsp;</td>
                        <td bgcolor="#f3ffe3">
                            <table width="99%" id="dataTable" border="0" align="center" cellpadding="0" cellspacing="1"
                                   bgcolor="#0e6f68">
                                <thead class="class1_thead">
                                <tr>
                                    <td width="8%" height="18" background="../images/tab_14.gif" class="STYLE1">
                                        <div align="center" class="STYLE2 STYLE1">序号</div>
                                    </td>
                                    <td width="20%" height="18" background="../images/tab_14.gif" class="STYLE1">
                                        <div align="center" class="STYLE2 STYLE1">组织机构代码</div>
                                    </td>
                                    <td width="24%" height="18" background="../images/tab_14.gif" class="STYLE1">
                                        <div align="center" class="STYLE2">企业中文名称</div>
                                    </td>
                                    <td width="10%" height="18" background="../images/tab_14.gif" class="STYLE1">
                                        <div align="center" class="STYLE2 STYLE1">登记日期</div>
                                    </td>
                                    <td width="8%" height="18" background="../images/tab_14.gif" class="STYLE1">
                                        <div align="center" class="STYLE2 STYLE1">经办人</div>
                                    </td>
                                    <td width="8%" height="18" background="../images/tab_14.gif" class="STYLE1">
                                        <div align="center" class="STYLE2 STYLE1">投资比例</div>
                                    </td>
                                </tr>
                                </thead>
                                <tbody id="dataTableBody">
                                <c:forEach items="${info.list}" var="enterprise" varStatus="v">
                                    <tr>
                                        <td height="18" bgcolor="#FFFFFF" class="STYLE2">
                                            <div align="center" class="STYLE2 STYLE1">${v.count}</div>
                                        </td>
                                        <td height="18" bgcolor="#FFFFFF">
                                            <div align="center" class="STYLE2 STYLE1" style="cursor:hand"
                                                 onclick="window.opener.document.all.orgcode.value= ${enterprise.orgcode};window.close();">${enterprise.orgcode}
                                            </div>
                                        </td>
                                        <td height="18" bgcolor="#FFFFFF">
                                            <div align="center" class="STYLE2 STYLE1">${enterprise.cnname}</div>
                                        </td>
                                        <td height="18" bgcolor="#FFFFFF">
                                            <div align="center" class="STYLE2 STYLE1">${enterprise.regdate}</div>
                                        </td>
                                        <td height="18" bgcolor="#FFFFFF">
                                            <div align="center" class="STYLE2 STYLE1"
                                                 >${enterprise.username}</div>
                                        </td>
                                        <td height="18" bgcolor="#FFFFFF">
                                            <div align="center" class="STYLE2 STYLE1" style="cursor: pointer" onclick="pie('${enterprise.orgcode}')" onmouseenter="noneDisPie()">详细</div>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
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
                                                        <div align="right"><img id="firstPage"
                                                                                src="../images/firstPageDisabled.gif"
                                                                                onclick="prePage(1)"/>
                                                        </div>
                                                    </td>
                                                    <td width="30" height="22" valign="middle">
                                                        <div align="right"><img id="prevPage"
                                                                                src="../images/prevPageDisabled.gif"
                                                                                onclick="prePage(${info.prePage})"/>
                                                        </div>
                                                    </td>
                                                    <td width="30" height="22" valign="middle">
                                                        <div align="right"><img id="nextPage"
                                                                                src="../images/nextPageDisabled.gif"
                                                                                onclick="next(${info.nextPage})"/></div>
                                                    </td>
                                                    <td width="30" height="22" valign="middle">
                                                        <div align="right"><img id="lastPage"
                                                                                src="../images/lastPageDisabled.gif"
                                                                                onclick="next(${info.pages})"/></div>
                                                    </td>
                                                    <td width="59" height="22" valign="middle">
                                                        <div align="right" class="STYLE2 STYLE1">转到第</div>
                                                    </td>
                                                    <td width="25" height="22" valign="middle"><span class="STYLE7">
                    <input name="textfield" type="text" class="STYLE1" style="height:20px; width:25px;text-align:right"
                           id="gotopage"
                           size="5"/>
                  </span></td>
                                                    <td width="23" height="22" valign="middle" class="STYLE2 STYLE1">页
                                                    </td>
                                                    <td width="30" height="22" valign="middle"><img
                                                            src="../images/go.gif" onclick="goToPage()"
                                                            width="37" height="15"/>
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
</body>
</html>
