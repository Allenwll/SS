<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="../common/common.jsp" %>

    <title>营养学数据管理页面</title>
</head>
<body>
<table id="nutritionDatagrid" title="营养学数据列表" class="easyui-datagrid"
       fit="true" url="${contextPath}/nutrition-list" toolbar="#nutritionToolbar" data-options="onClickRow:onClickRow"
       pagination="true" rownumbers="true"
       singleSelect="true">
    <thead data-options="frozen:true">
    <tr>
        <th field="nid" width="50" sortable="true">编号<br>ID</th>
        <th field="sportname" width="100" sortable="true">运动员姓名<br>NAME</th>
        <th field="testdate" width="100" sortable="true"
            data-options="formatter: dateTimeFormatter">测试日期<br>TestDate
        </th>
    </tr>
    </thead>
    <thead>
    <tr>
        <th field="height" width="120" sortable="true" align="center">身高<br>height（cm)</th>
        <th field="weight" width="120" sortable="true" align="center">体重<br>weight（kg）</th>
        <th field="bodyfatpercent" width="120" sortable="true">体脂比<br>Bodyfatpercent（%）</th>
        <th field="fat" width="120" sortable="true">脂肪<br>Fat</th>
        <th field="leanweight" width="120" sortable="true">瘦体重<br>Leanweight</th>
        <th field="bodyMoisture" width="120" sortable="true">身体水分<br>BodyMoisture</th>
        <th field="bMI" width="120" sortable="true">体质指数<br>BMI</th>
        <th field="emptyweight" width="120" sortable="true" align="center">空腹体重<br>emptyweight</th>
        <th field="rightarmFat" width="120" sortable="true">右上臂部脂肪厚<br>RUAF Thickness</th>
        <th field="rightFat" width="120" sortable="true">右肩胛角下方脂肪厚<br>FBTRSA thickness</th>
        <th field="bellyfat" width="120" sortable="true">腹部脂肪厚<br>BF thickness</th>
        <th field="bMD" width="120" sortable="true">骨密度<br>boneDensity(g/cm2)</th>
        <th field="boneMineralContent" width="120" sortable="true">骨矿盐含量<br>BMS(g)</th>
        <th field="conclusion" width="120" sortable="true">结论评价<br>Conclusion</th>
        <th field="teachername" width="100" sortable="true">教练账号<br>teachNo</th>
    </tr>
    </thead>
</table>

<div id="nutritionToolbar">
    &nbsp;&nbsp;&nbsp;&nbsp;<a data-cmd="importNutrition" href="javascript:void(0)" class="easyui-linkbutton " iconCls="icon-add" plain="true">批量导入 </a>
    &nbsp;&nbsp;&nbsp;&nbsp;<a data-cmd="addNutrition" href="javascript:void(0)" class="easyui-linkbutton " iconCls="icon-add" plain="true">添加</a>
    &nbsp;&nbsp;&nbsp;&nbsp;<a data-cmd="editNutrition" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true">编辑</a>
    &nbsp;&nbsp;&nbsp;&nbsp;<a data-cmd="deleteNutrition" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>


    <form id="searchNutritionForm">
        姓名:<input name="sportsmanName" size="10"/>
        测试日期：从<input name="beginDate" class="easyui-datebox" size="12"/>
        到<input name="endDate" class="easyui-datebox" size="12"/>
        <a data-cmd="searchNutrition" href="javascript:void(0)"
           class="easyui-linkbutton" iconCls="icon-search" plain="true">查询</a>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <a data-cmd="exportNutrition" href="javascript:void(0)" class="easyui-linkbutton"
           iconCls="icon-search" plain="true">导出</a>
        <!-- <a data-cmd="search" class="easyui-linkbutton" iconCls="icon-search" plain="true" >高级查询</a> -->
    </form>
</div>

<div id="importDialog" class="easyui-dialog" style="width: 550px"
     closed="true" buttons="#importDlgButtons">
    <form id="importForm" action="${contextPath}/nutrition/import" method="post" name="form1" enctype="multipart/form-data">

        <div align="center">
            <table width="95%" border="1" cellspacing="1" cellpadding="3"
                   style="border-collapse: collapse" bordercolor="#F3F3F3">
                <tr bgcolor="#7E99E7">
                    <td background="../resources/images/admin_bg_1.gif">
                        <div align="left">
                            <font color="#FFFFFF"><b><font color="#000000">○
                            </font>
                            </b><font color="#000000">（基本信息管理 ）</font><b><font color="#000000">
                            </font>
                            </b>
                            </font>
                        </div>
                    </td>
                </tr>

                <td width="100%" bgcolor="#D6DFF7" height="125" align="center">
                    <table border="0" width="96%" cellspacing="0" cellpadding="0" align="center">
                        <td>
                            <div align="center">
                                <table width="100%" class="table001" border="0" cellpadding="0"
                                       cellspacing="0" style="border: 1PX SOLID #428EFF;">
                                    <tr class="title">
                                        <td height="22" align="center" valign="middle"
                                            class="table003">
                                            <b>营养学信息导入</b>
                                        </td>
                                    </tr>
                                    <td align="center" height="150" valign="middle">
                                        <table width="100%" border="0" cellpadding="0"
                                               cellspacing="0">
                                            <tr>
                                                <td height="60" colspan="3"
                                                    style="padding-left: 100px; line-height: 25px; color: red;">
                                                    请选择Excel文件所在位置:
                                                    <input id="uploadFile" type="file" name="uploadFile"/>
                                                    <br>
                                                    <span style="color: red;">(注意：新导入的用户数据记录不会覆盖之前已经录入的数据记录)</span>
                                                </td>
                                            <tr align="center">
                                                <td height="40" colspan="3">
                                                    <input name="submit" type=submit value="导入数据" onclick="return checkData()"
                                                           style="width: 80px; height: 30px; background-color: #4E6A81; border-top: 2px solid #DDDDDD; border-left: 2px solid #DDDDDD; border-right: 2px solid #000000; border-bottom: 2px solid #000000; font-size: 14px; font-weight: bold; color: #FFF;">

                                                </td>

                                            </tr>
                                        </table>
                                </table>
                            </div>

                        </td>

                    </table>
                </td>
                </tr>
            </table>

        </div>
    </form>
</div>

<div id="nutritionDialog" class="easyui-dialog" style="width: 400px"
     closed="true" buttons="#nutritionDlgButtons">
    <form id="nutritionForm" method="post" novalidate
          style="margin: 0; padding: 20px 50px">
        <input type="hidden" name="id">
        <div
                style="margin-bottom: 20px; font-size: 14px; border-bottom: 1px solid #ccc">
            营养学信息列表
        </div>
        <table>
            <tr>
                <td>运动员姓名:</td>
                <td><input class="easyui-validatebox" name="sportname"
                           data-options="required:true"></input></td>
            </tr>
            <tr>
                <td>测试日期:</td>
                <td><input class="easyui-validatebox" name="testdate"
                           data-options="required:true"></input></td>
            </tr>
        </table>
    </form>
</div>


<script type="text/javascript">
    /**
     *    将Form对象转换成为json对象，使用方式    var fo = $("#searchForm").serializeJson();    console.info(fo);
     */
    $.fn.serializeJson = function () {
        var serializeObj = {};
        var array = this.serializeArray();
        $(array).each(function () {
            if (serializeObj[this.name]) {
                if ($.isArray(serializeObj[this.name])) {
                    serializeObj[this.name].push(this.value);
                } else {
                    serializeObj[this.name] = [serializeObj[this.name], this.value];
                }
            } else {
                serializeObj[this.name] = this.value;
            }
        });
        return serializeObj;
    };

    function genderFormatter(value, row, index) {
        return value == 1 ? "男" : "女";
    }

    $(function () {
        var nutritionDatagrid = $('#nutritionDatagrid');
        var nutritionDialog = $('#nutritionDialog');
        var importDialog = $('#importDialog');
        var nutritionForm = $('#nutritionForm');
        var searchNutritionForm = $('#searchNutritionForm');
        var cmdObject = {
            searchNutrition: function () {
                debugger;
                var param=$("#searchNutritionForm").serializeJSON();

                var propertyMap= {};
                $("#searchNutritionForm").find("input").each(function(){
                    if(this.name!=""){
                        propertyMap[this.name]=this.value;
                    }
                });

                nutritionDatagrid.datagrid('load',param);
            },
            exportNutrition: function () {
                //$("#nutritionNutrition").dialog("open");
                searchNutritionForm.form('submit', {
                    url: "/CyclingSSSME/nutrition/export",
                    onSubmit: function () {
                        return $(this).form('validate');
                    },
                    success: function (result) {
                        alert(result);

                        //var result =result.
                        //	var result = typeof result=='string'?JSON.parse(result):result;
                        if (result.success) {
                            nutritionDialog.dialog('close');
                            nutritionDatagrid.datagrid('reload');
                        } else {
                            $.messager.alert('错误提示', result.message, 'error');
                        }
                    }
                });
            }
        }

        $("a").click(function () {
            var cmd = $(this).data("cmd");
            if (cmd && !$(this).hasClass("l-btn-disabled")) {
                cmdObject[cmd]();
            }
        });

    });
    function onClickRow(index, row) {
        if (row.state == -1) {

        } else {

        }
    }
    function dateTimeFormatter(value) {
        if (value == undefined) {
            return "";
        }

        var date = new Date(value);
        var y = date.getFullYear();
        var m = date.getMonth() + 1;
        m = m < 10 ? ('0' + m) : m;
        var d = date.getDate();
        d = d < 10 ? ('0' + d) : d;
        // var h = date.getHours();
        // h = h < 10 ? ('0' + h) : h;
        // var minute = date.getMinutes();
        // var second = date.getSeconds();
        // minute = minute < 10 ? ('0' + minute) : minute;
        // second = second < 10 ? ('0' + second) : second;
        // return y + '-' + m + '-' + d+' '+h+':'+minute+':'+second;
        return y + '-' + m + '-' + d;
    }
</script>
</body>
</html>