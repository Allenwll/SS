<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="../common/js-container.jsp" %>
    <title>新增</title>
    <style type="text/css">
        html, body {
            margin: 0;
            padding: 0;
            border: 0;
            width: 100%;
            height: 100%;
        }
        span{
            color: red;
        }
    </style>
</head>
<body>
<center>
<form action="${contextPath}/addOrUpdateStudent" method="get">
    <ul class="form-group form-col-double">
        <input name="id" id="stu_id" type="hidden" value="${id}"/>
        <li>
            <label><span class="required">*</span>姓名：</label>
            <input type="text" placeholder="请输入姓名" name="name" required="required" id="stu_name"/>
        </li>
        <li>
            <label><span class="required">*</span>性别：</label>
            <select id="stu_gender" name="sex">
                <option value="男" selected="selected">男</option>
                <option value="女">女</option>
            </select>
        </li>
        <li>
            <label><span class="required">*</span>年龄：</label>
            <input type="text" placeholder="请输入年龄" name="age" pattern="[0-9]{2}" required="required" id="stu_age"/>
        </li>
        <li>
            <label><span class="required">*</span>年级：</label>
            <select id="stu_grade"  name="grade">
            </select>
        </li>
        <li>
            <label><span class="required">*</span>科目：</label>
            <select id="stu_subject" name="subject">
            </select>
        </li>
    </ul>
    <input type="submit" name="submit" value="提交"/>
    <input type="reset" name="reset" value="重置"/>
</form>
</center>
<script src="${contextPath}/resources/js/student/student-edit.js"></script>
</body>
</html>