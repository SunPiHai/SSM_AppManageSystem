<%--
  Created by IntelliJ IDEA.
  User: chenyong
  Date: 2019/4/23
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%--抽取导航和侧边栏--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="layui-header">
    <div class="layui-logo">APP BMS</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <%--<ul class="layui-nav layui-layout-left">--%>
        <%--<li class="layui-nav-item"><a href="">控制台</a></li>--%>
        <%--<li class="layui-nav-item"><a href="">管理</a></li>--%>
        <%--<li class="layui-nav-item"><a href="">用户</a></li>--%>
        <%--<li class="layui-nav-item">--%>
            <%--<a href="https://www.layui.com/demo/admin.html">帮助</a>--%>
        <%--</li>--%>
    <%--</ul>--%>
    <ul class="layui-nav layui-layout-right">
        <li class="layui-nav-item">
            <a href="javascript:;">
                <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                陈勇
            </a>
            <dl class="layui-nav-child">
                <dd><a href="">基本资料</a></dd>
                <dd><a href="">安全设置</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item"><a href="/dev/logout.do">退出登录</a></li>
    </ul>
</div>

<div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
        <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
        <ul class="layui-nav layui-nav-tree"  lay-filter="test">
            <li class="layui-nav-item layui-nav-itemed">
                <br>
                <a class="" href="javascript:;">App账户管理</a>
                <%--<dl class="layui-nav-child">--%>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;">列表一</a></dd>
                    <dd><a href="javascript:;">列表二</a></dd>
                    <dd><a href="javascript:;">列表三</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:">App应用管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="/app/index/devId/${sessionScope.devUser.id}.do">App维护</a></dd>
                </dl>
            </li>
        </ul>
    </div>
</div>
