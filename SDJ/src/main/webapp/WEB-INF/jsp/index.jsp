<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="./common/js-container.jsp" %>
    <title>Index</title>

    <script type="text/javascript">
        $(function () {
            $("#into_student").click(function () {
                window.location.href = "${contextPath}/listStudent";
            });
        });
    </script>
</head>
<body>
<h1> 现在时间是: ${now}</h1>
<button type="button" id="into_student" class="search-btn">点击进入学生列表</button>
</body>

</html>