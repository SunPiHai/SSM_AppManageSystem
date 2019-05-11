<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<%--
  Created by IntelliJ IDEA.
  User: chenyong
  Date: 2019/4/22
  Time: 0:28
  To change this template use File | Settings | File Templates. 模板页面
--%>

<%--开发者登录页面--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>开发者登录</title>
    <link rel="stylesheet" href="<%=basePath%>/static/css/layui.css">
    <style>
        form{
            width: 210px;
            margin: auto;
            margin-top: 27%;
        }
    </style>
</head>
<body>
     ${errMsg}

   <div class="layui-container">
       <form action="/dev/Login.do" method="post" class="layui-form">
           <div class="layui-form-item">
               <div class="layui-input-inline">
                   <input type="text" name="devCode" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
               </div>
           </div>
           <div class="layui-form-item">
               <div class="layui-input-inline">
                   <input type="password" name="devPassword" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
               </div>
           </div>
           <div class="layui-form-item">
               <div class="layui-input-inline">
                   <button class="layui-btn" lay-submit lay-filter="formDemo">登录</button>
                   <button type="reset" class="layui-btn layui-btn-primary">重置</button>
               </div>
           </div>
       </form>
   </div>
     <%--js--%>
     <script src="<%=basePath%>/static/js/layui.all.js"></script>
</body>
</html>
