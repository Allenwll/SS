<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    //context path
    final String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    request.setAttribute("contextPath", contextPath);
    //js and css version
    final String version = "1.0.1";
    String pageSize = null;
    String sizeList = null;
    request.setAttribute("version", version);
    pageSize = session.getAttribute("pageSize") + "";
    sizeList = session.getAttribute("sizeList") + "";
%>

<script>
    var contextPath = '${contextPath}';
    var pageSize = '${pageSize}';
    var sizeList = '${sizeList}';
</script>
