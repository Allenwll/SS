<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 默认的主题样式 -->
<%@include file="./app-variables.jsp" %>
<!--
	如果配置了appPath要加上下文路径 ${pageContext.request.contextPath}
<link rel="stylesheet" type="text/css" href="/resources/js/easyui/themes/default/easyui.css">    -->
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/3rd-js/easyui/themes/default/easyui.css">
<!-- EasyUI用到的图标 -->
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/3rd-js/easyui/themes/icon.css">
<!--  EasyUI用到的颜色样式 -->
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/3rd-js/easyui/themes/color.css">
<!-- 引入的jQuery -->
<script type="text/javascript" src="${contextPath}/resources/3rd-js/jquery/jquery.min.js"></script>
<!-- easyui的核心js -->
<script type="text/javascript" src="${contextPath}/resources/3rd-js/easyui/script/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${contextPath}/resources/3rd-js/jquery/jquery.serializejson.js"></script>
<link rel="stylesheet" href="${contextPath}/resources/css/common.css">
<!--头尾和全局样式-->
<link rel="stylesheet" href="${contextPath}/resources/css/content.css">
<!--内容页样式-->