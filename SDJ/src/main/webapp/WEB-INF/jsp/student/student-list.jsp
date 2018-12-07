<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="../common/js-container.jsp" %>
    <title>学生列表</title>
    <style type="text/css">
        html, body {
            margin: 0;
            padding: 0;
            border: 0;
            width: 100%;
            height: 100%;
        }
        span{color:#00F;text-decoration:underline;cursor:pointer}
        label{margin-left: 15px}
    </style>
</head>
<body>
<div class="search-div">
    <label>姓名:</label><input class="search-btn" type="text" id="stu_name">
    <label>性别:</label><select id="stu_gender" class="search-btn">
    <option value="全部">全部</option>
    <option value="男">男</option>
    <option value="女">女</option>
</select>
    <label>年级:</label>
    <select id="stu_grade" class="search-btn">
    </select>
    <button type="button" class="search-btn" id="stu_search">搜索</button>
</div>
<table class="hovertable" id="student_tab">
    <tr>
        <td>序号</td>
        <td>学号</td>
        <td>姓名</td>
        <td>性别</td>
        <td>年龄</td>
        <td>年级</td>
        <td>科目</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${students}" var="s" varStatus="st">
        <tr>
            <td>${st.index+1}</td>
            <td>${s.student.id}</td>
            <td>${s.student.name}</td>
            <td>${s.student.sex}</td>
            <td>${s.student.age}</td>
            <td>${s.grade}</td>
            <td>${s.subject}</td>
            <td>
                <span class="add" >新增</span>&emsp;&emsp;
                <span class="edit" data-id="${s.id}" >编辑</span>&emsp;&emsp;
                <span class="del" data-id="${s.id}" >删除</span>
            </td>
        </tr>
    </c:forEach>
</table>
<script src="${contextPath}/resources/js/student/student-list.js"></script>
</body>
</html>