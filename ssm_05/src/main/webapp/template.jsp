<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

  <%--Created by IntelliJ IDEA.--%>
  <%--User: chenyong--%>
  <%--Date: 2019/4/22--%>
  <%--Time: 0:28--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--公共模板页面--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>App管理系统</title>
    <link rel="stylesheet" href="<%=basePath%>/static/css/layui.css">
</head>
<body>
<%--js--%>
<script src="<%=basePath%>/static/js/layui.all.js"></script>
</body>
</html>
