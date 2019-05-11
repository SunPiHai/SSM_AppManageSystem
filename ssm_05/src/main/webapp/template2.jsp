<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<%--Created by IntelliJ IDEA.--%>
<%--User: chenyong--%>
<%--Date: 2019/4/22--%>
<%--Time: 0:28--%>
<%--To change this template use File | Settings | File Templates.--%>

<%--公共模板页面--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>App管理系统</title>
    <link rel="stylesheet" href="<%=basePath%>/static/css/layui.css">
</head>

<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">

    <%--引入header.jsp--%>
    <jsp:include page="/jsp/common/header.jsp"/>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">内容主体区域</div>
    </div>
    <jsp:include page="/jsp/common/footer.jsp"/>
</div>

<%--引入js--%>
<script src="<%=basePath%>/static/js/layui.all.js"></script>

<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
</html>


