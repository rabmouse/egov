<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
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

    <script type="text/javascript">
        //子窗口中动态添加表格行到父窗口中
        function addTableRow(invregnum, invname, cty) {
            //alert(invregnum);
            $("#table").append("<tr id='" + invregnum + "'>\n" +
                " <td width='20%' bgcolor='#FFFFFF' height='20' class='STYLE1'>\n" +
                "<div align='center' style='padding:5px' class='STYLE2 STYLE1'>" + invname +
                "<input type='hidden' name='invregnums' id='invregnum' value='" + invregnum + "'" +
                "</div>\n" +
                "</td>\n" +

                "<td width='20%' bgcolor='#FFFFFF' class='STYLE1'>\n" +
                "<div align='center'  style='padding:2px' class='STYLE2' > <input type='hidden' disabled class='cty' name='cty' value='" + cty + "'>" + cty + "</div>\n" +
                "</td>\n" +

                "<td width='20%' bgcolor='#FFFFFF' class='STYLE1'>\n" +
                "<div align='center' style='padding:5px' class='STYLE2 STYLE1'><input\n" +
                "type='text' class='regcapItem' name='regcapItems' id='regcapItem' onblur='caluRegcap(" + invregnum + ")' \n" +
                "style='width:90px; height:20px; border:solid 1px #035551; color:#000000'><font\n" +
                "color='red'>*</font>\n" +
                "</div>\n" +
                "</td>\n" +

                "<td width='20%' bgcolor='#FFFFFF' class='STYLE1'>\n" +
                "<div align='center' style='padding:2px' class='STYLE2'><input\n" +
                "type='text' class='scale' name='scales' id='scale' readonly \n" +
                "style='width:90px; height:20px; border:solid 1px #035551; color:#000000'><font\n" +
                "color='red'>*</font></div>\n" +
                "</td>\n" +

                "<td width='20%' bgcolor='#FFFFFF' class='STYLE1'>\n" +
                " <div align='center' style='padding:2px' class='STYLE2'><img\n" +
                "src='../images/delete.jpg' style='cursor: pointer' onclick='deleteRow(" + invregnum + ")'/></div>\n" +
                "</td>\n" +

                "</tr>");
        }

        //删除行
        function deleteRow(invregnum) {
            alert(invregnum);
            $("#" + invregnum).remove();
            caluRegcap()
        }

        //计算注册资本投资额、外放投资额、利润比例
        function caluRegcap(invregnum) {
            //获取注册资本出资额对象
            var regcapItems = $(".regcapItem");
            //获取外方注册资本额对象
            var outregcap = $("#outregcap")
            //获取国别对象
            var cty = $(".cty");
            //获取注册资本对象
            var regcap = $("#regcap");
            //获取外方出资比例对象
            var outScale = $("#outScale");
            //获取利润分配比例对象
            var scale = $(".scale");
            //alert(outScale.html())

            //外方出资比例
            var outScaleCount = 0;
            //注册资本出资额
            var regcapCount = 0;
            //外方注册资本出资额
            var outregcapCount = 0

            //遍历regcapItems数组;
            for (var i = 0; i < regcapItems.length; i++) {
                //利润分配比例的值：
                var scaleCount = 0;
                //获取注册资本出资额对象的值
                var regcapItem = regcapItems[i].value;
                if (regcapItem.trim() != "") {

                    if (cty[i].value != "中国") {
                        //alert(i+cty[i].value)
                        outregcapCount += parseInt(regcapItem);
                        outregcap.prop("value", outregcapCount);
                    }
                    //设置注册资本出资额的值
                    regcapCount += parseInt(regcapItem);
                    regcap.prop("value", regcapCount)

                    //设置利润分配比例的值
                    scaleCount = (regcapItem / 10).toFixed(0);
                    //alert(scaleCount)
                    scale[i].value = scaleCount + "";
                }
                //计算外方出资比例
                outScaleCount = (outregcapCount / regcapCount * 100).toFixed(2);
                outScale.html(outScaleCount + "%")
            }
        }

        //添加企业信息和企业、投资人关系表到数据库中
        function addEnterpriseAnd_en_inv() {
            //进行判空处理
            var ok = checkForm();
            //alert(ok)
            if (ok) {
                $("form").submit();
            }
        }

        //判空函数
        function checkForm() {
            var regno = new FormElement("外汇登记证号","regno")
            var cnname = new FormElement("企业中文名称","cnname")
            var regcap = new FormElement("注册资本","regcap")
            var regcry = new FormElement("注册币种","regcry")
            var outregcap = new FormElement("外方注册资本","outregcap")
            //var outregcap = new FormElement("外方注册资本","outregcap")
            var formArray = [regno,cnname,regcap,regcry,outregcap];
            return $$.isNull(formArray)

        }
    </script>
</head>

<body>
<form action="../enterprise/addEnt_and_t_en_inv.action" method="post">
    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
            <td height="30">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="15" height="30"><img src="../images/tab_03.gif" width="15" height="30"/></td>
                        <td width="1101" background="../images/tab_05.gif"><img src="../images/311.gif" width="16"
                                                                                height="16"/> <span class="STYLE4">新设外商企业登记-录入</span>
                        </td>
                        <td width="281" background="../images/tab_05.gif">
                            <table border="0" align="right" cellpadding="0" cellspacing="0">
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
                                    <td width="100" height="26" class="STYLE1" colspan="4">
                                        <div align="center" style="padding:5px" class="STYLE2 STYLE1"><font
                                                color="#FFFFFF"><B>企业基本信息</B></font>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td width="100" bgcolor="#FFFFFF" height="26" class="STYLE1">
                                        <div align="right" style="padding:5px" class="STYLE2 STYLE1">组织机构代码:</div>
                                    </td>
                                    <td width="250" bgcolor="#FFFFFF" class="STYLE1">
                                        <div align="left" style="padding:2px" class="STYLE2">${orgcode}<input
                                                type="hidden"
                                                name="orgcode"
                                                id="orgcode"
                                                value="${orgcode}">
                                        </div>
                                    </td>
                                    <td width="100" bgcolor="#FFFFFF" height="26" class="STYLE1">
                                        <div align="right" style="padding:5px" class="STYLE2 STYLE1">外汇登记证号:</div>
                                    </td>
                                    <td bgcolor="#FFFFFF" class="STYLE1">
                                        <div align="left" style="padding:2px" class="STYLE2"><input type="text"
                                                                                                    name="regno"
                                                                                                    id="regno"
                                                                                                    style="width:150px; height:20px; border:solid 1px #035551; color:#000000"><font
                                                color="red">*</font></div>
                                    </td>
                                </tr>
                                <tr>
                                    <td width="100" bgcolor="#FFFFFF" height="26" class="STYLE1">
                                        <div align="right" style="padding:5px" class="STYLE2 STYLE1">企业中文名称:</div>
                                    </td>
                                    <td width="250" bgcolor="#FFFFFF" class="STYLE1">
                                        <div align="left" style="padding:2px" class="STYLE2"><input type="text"
                                                                                                    name="cnname"
                                                                                                    id="cnname"
                                                                                                    style="width:150px; height:20px; border:solid 1px #035551; color:#000000"><font
                                                color="red">*</font></div>
                                    </td>
                                    <td width="100" bgcolor="#FFFFFF" height="26" class="STYLE1">
                                        <div align="right" style="padding:5px" class="STYLE2 STYLE1">企业英文名称:</div>
                                    </td>
                                    <td bgcolor="#FFFFFF" class="STYLE1">
                                        <div align="left" style="padding:2px" class="STYLE2"><input type="text"
                                                                                                    name="enname"
                                                                                                    id="enname"
                                                                                                    style="width:150px; height:20px; border:solid 1px #035551; color:#000000">
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td width="100" bgcolor="#FFFFFF" height="26" class="STYLE1">
                                        <div align="right" style="padding:5px" class="STYLE2 STYLE1">联系人:</div>
                                    </td>
                                    <td width="250" bgcolor="#FFFFFF" class="STYLE1">
                                        <div align="left" style="padding:2px" class="STYLE2"><input type="text"
                                                                                                    name="contactman"
                                                                                                    id="contactman"
                                                                                                    style="width:150px; height:20px; border:solid 1px #035551; color:#000000">
                                        </div>
                                    </td>
                                    <td width="100" bgcolor="#FFFFFF" height="26" class="STYLE1">
                                        <div align="right" style="padding:5px" class="STYLE2 STYLE1">联系电话:</div>
                                    </td>
                                    <td bgcolor="#FFFFFF" class="STYLE1">
                                        <div align="left" style="padding:2px" class="STYLE2"><input type="text"
                                                                                                    name="contacttel"
                                                                                                    id="contacttel"
                                                                                                    style="width:150px; height:20px; border:solid 1px #035551; color:#000000">
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td width="100" height="26" class="STYLE1" colspan="4">
                                        <div align="center" width="100%" style="padding:5px" class="STYLE2 STYLE1"><font
                                                color="#FFFFFF"><B>企业资金情况信息</B></font></div>
                                    </td>
                                </tr>
                                <tr>
                                    <td width="100" bgcolor="#FFFFFF" height="26" class="STYLE1">
                                        <div align="right" style="padding:5px" class="STYLE2 STYLE1">注册资本:</div>
                                    </td>
                                    <td width="250" bgcolor="#FFFFFF" class="STYLE1">
                                        <div align="left" style="padding:2px" class="STYLE2"><input type="text"
                                                                                                    name="regcap"
                                                                                                    id="regcap" readonly
                                                                                                    style="width:150px; height:20px; border:solid 1px #035551; color:#000000"><font
                                                color="red">*</font></div>
                                    </td>
                                    <td width="100" bgcolor="#FFFFFF" height="26" class="STYLE1">
                                        <div align="right" style="padding:5px" class="STYLE2 STYLE1">注册币种:</div>
                                    </td>
                                    <td bgcolor="#FFFFFF" class="STYLE1">
                                        <div align="left" style="padding:2px" class="STYLE2">
                                            <select name="regcry" style="WIDTH:100px" id="regcry">
                                                <option value="-1">请选择币种</option>
                                                <option value="000">人民币</option>
                                                <option value="001">美元</option>
                                                <option value="002">英镑</option>
                                                <option value="003">日元</option>
                                            </select> <font color="red">*</font></div>
                                    </td>
                                </tr>
                                <tr>
                                    <td width="100" bgcolor="#FFFFFF" height="26" class="STYLE1">
                                        <div align="right" style="padding:5px" class="STYLE2 STYLE1">外方注册资本:</div>
                                    </td>
                                    <td width="250" bgcolor="#FFFFFF" class="STYLE1">
                                        <div align="left" style="padding:2px" class="STYLE2"><input type="text"
                                                                                                    name="outregcap"
                                                                                                    id="outregcap"
                                                                                                    readonly
                                                                                                    style="width:150px; height:20px; border:solid 1px #035551; color:#000000"><font
                                                color="red">*</font></div>
                                    </td>
                                    <td width="100" bgcolor="#FFFFFF" height="26" class="STYLE1">
                                        <div align="right" style="padding:5px" class="STYLE2 STYLE1">外方出资比例:</div>
                                    </td>
                                    <td bgcolor="#FFFFFF" class="STYLE1">
                                        <div align="left" style="padding:2px" class="STYLE2" id="outScale">0%</div>
                                    </td>
                                </tr>
                                <tr>
                                    <td width="100" height="26" class="STYLE1" colspan="4">
                                        <div align="center" style="padding:5px" class="STYLE2 STYLE1"><font
                                                color="#FFFFFF"><B>投资者资金及利润分配</B></font>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td width="100%" bgcolor="#FFFFFF" class="STYLE1" colspan="4">
                                        <table border="0" width="100%" height="100%" cellpadding="0" cellspacing="1"
                                               id="table"
                                               bgcolor="#0e6f68">
                                            <tr>
                                                <td width="20%" bgcolor="#CCCCCC" height="20" class="STYLE1">
                                                    <div align="center" style="padding:5px" class="STYLE2 STYLE1">投资者名称
                                                    </div>
                                                </td><!--以下信息是要存到投资人和企业的关系表中的-->
                                                <td width="20%" bgcolor="#CCCCCC" class="STYLE1">
                                                    <div align="center" style="padding:2px" class="STYLE2">国别</div>
                                                </td>
                                                <td width="20%" bgcolor="#CCCCCC" class="STYLE1">
                                                    <div align="center" style="padding:5px" class="STYLE2 STYLE1">
                                                        注册资本出资额
                                                    </div>
                                                </td>
                                                <td width="20%" bgcolor="#CCCCCC" class="STYLE1">
                                                    <div align="center" style="padding:2px" class="STYLE2">利润分配比例</div>
                                                </td>
                                                <td width="20%" bgcolor="#CCCCCC" class="STYLE1">
                                                    <div align="center" style="padding:2px;cursor: pointer"
                                                         class="STYLE2">
                                                        <img
                                                                src="../images/query.jpg"
                                                                onclick="window.open('orgcodeSelect.jsp', '选择组织机构代码', 'width=720, height=400, scrollbars=no')"/>
                                                    </div>
                                                </td>
                                            </tr>
                                            <!-- 这里需要动态的增加表格 -->
                                            <%--<tr>
                                                <td width="20%" bgcolor="#FFFFFF" height="20" class="STYLE1">
                                                    <div align="center" style="padding:5px" class="STYLE2 STYLE1">IBM</div>
                                                </td>
                                                <td width="20%" bgcolor="#FFFFFF" class="STYLE1">
                                                    <div align="center" style="padding:2px" class="STYLE2">美国</div>
                                                </td>
                                                <td width="20%" bgcolor="#FFFFFF" class="STYLE1">
                                                    <div align="center" style="padding:5px" class="STYLE2 STYLE1"><input
                                                            type="text" name="regcapItem" id="regcapItem"
                                                            style="width:90px; height:20px; border:solid 1px #035551; color:#000000"><font
                                                            color="red">*</font>
                                                    </div>
                                                </td>
                                                <td width="20%" bgcolor="#FFFFFF" class="STYLE1">
                                                    <div align="center" style="padding:2px" class="STYLE2"><input
                                                            type="text" name="scale" id="scale"
                                                            style="width:90px; height:20px; border:solid 1px #035551; color:#000000"><font
                                                            color="red">*</font></div>
                                                </td>
                                                <td width="20%" bgcolor="#FFFFFF" class="STYLE1">
                                                    <div align="center" style="padding:2px" class="STYLE2"><img
                                                            src="../images/delete.jpg"/></div>
                                                </td>
                                            </tr>--%>

                                        </table>
                                    </td>
                                </tr>
                            </table>
                        </td>
                        <td width="9" background="../images/tab_16.gif">&nbsp;</td>

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
                                <tr height="30">
                                    <td bgcolor="#FFFFFF" height="30" class="STYLE1" colspan="2" align="center"><img
                                            style="cursor: pointer"
                                            src="../images/ok.jpg" onclick="addEnterpriseAnd_en_inv()"/>&nbsp;&nbsp;<img
                                            style="cursor: pointer"
                                            src="../images/back.jpg" onclick="document.location='newInputOrg.jsp'"/>
                                    </td>
                                </tr>
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
                                    <td width="75%" valign="top" class="STYLE1">
                                        <div align="left">
                                            <table width="352" height="20" border="0" cellpadding="0" cellspacing="0">
                                                <tr>
                                                    <td width="62" height="22" valign="middle"></td>
                                                    <td width="50" height="22" valign="middle"></td>
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
