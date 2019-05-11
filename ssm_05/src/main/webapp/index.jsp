<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<%--
  Created by IntelliJ IDEA.
  User: chenyong
  Date: 2019/4/21
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%--首页显示--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>APP管理系统</title>
</head>
<body>
<a href="<%=basePath%>/backend/index.do">后台管理系统入口</a>
<br>
<a href="<%=basePath%>/dev/toLogin.do">开发者平台入口</a>

</body>
</html>
