<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div style="padding: 15px;">
            <form class="layui-form" action="${pageContext.request.contextPath}/app/add.do" method="post"><br>

                    <div class="layui-form-item">
                        <label class="layui-form-label">软件名称</label>
                        <div class="layui-input-inline">
                            <input type="text" name="softwareName" lay-verify="title" autocomplete="off" placeholder="请输入软件名称" class="layui-input">
                        </div>
                        <label class="layui-form-label">apk名称</label>
                        <div class="layui-input-inline">
                            <input type="text" name="apkName" lay-verify="title" autocomplete="off" placeholder="请输入apk名称" class="layui-input">
                        </div>
                        <label class="layui-form-label">支持ROM</label>
                        <div class="layui-input-inline">
                            <input type="text" name="supportRom" lay-verify="title" autocomplete="off" placeholder="请输入ROM名称" class="layui-input">
                        </div>
                        <label class="layui-form-label">界面语言</label>
                        <div class="layui-input-inline">
                            <input type="text" name="interfaceLanguage" lay-verify="title" autocomplete="off" placeholder="请输入界面语言" class="layui-input">
                        </div>
                    </div>

                <div class="layui-form-item">

                    <label class="layui-form-label">软件大小</label>
                    <div class="layui-input-inline">
                        <input type="text" name="softwareSize" lay-verify="title" autocomplete="off" placeholder="请输入软件大小" class="layui-input">
                    </div>
                    <label class="layui-form-label">应用简介</label>
                    <div class="layui-input-inline">
                        <input type="text" name="appInfo" lay-verify="title" autocomplete="off" placeholder="请输入应用简介" class="layui-input">
                    </div>
                    <%--状态--%>
                    <label class="layui-form-label">APP状态</label>
                    <div class="layui-input-inline">
                        <select name="status" lay-filter="status">
                            <option value="">-请选择-</option>
                            <c:forEach items="${appStatuses}" var="obj">
                                <%--<option value="${obj.id}">${obj.valueName}</option>--%>
                                <option value="${obj.valueId}" >${obj.valueName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <%--平台--%>
                    <label class="layui-form-label">所属平台</label>
                    <div class="layui-input-inline">
                        <select name="flatform.valueId" lay-filter="flatform.valueId">
                            <option value="">-请选择-</option>
                            <c:forEach items="${appFlatforms}" var="obj">
                                <option value="${obj.valueId}">${obj.valueName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="layui-form-item">
                    <%--一级分类--%>
                        <label class="layui-form-label">一级分类</label>
                        <div class="layui-input-inline">
                            <select name="categoryLevel1.id" id="levelOne" lay-filter="levelOne">
                                <option value="">-请选择-</option>
                                <c:forEach items="${levelOne}" var="obj">
                                    <option value="${obj.id}">${obj.categoryName}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <%--二级分类--%>
                        <label class="layui-form-label">二级分类</label>
                        <div class="layui-input-inline">
                            <select name="categoryLevel2.id" lay-filter="levelTwo" id="levelTwo">
                                <option value="">-请选择-</option>
                            </select>
                        </div>
                        <label class="layui-form-label">三级分类</label>
                        <div class="layui-input-inline">
                            <select name="categoryLevel3.id" lay-filter="levelThree" id="levelThree">
                                <option value="">-请选择-</option>
                            </select>
                        </div>
                </div>

                  <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-fiter="formDemo">立即提交</button>
                </div>
                  </div>
            </form>
    <jsp:include page="/jsp/common/footer.jsp"/>
        </div>

        <%--引入js--%>
        <script src="<%=basePath%>/static/js/layui.all.js"></script>

<script>
    //JavaScript代码区域
    layui.use(['element','form','jquery'], function(){
        var element = layui.element;
        var form=layui.form;
        var $=layui.jquery;
        form.render();

        // 二级分类start=========================================================
        form.on('select(levelOne)',function () {
            //获取id
            var levelOneId = $('#levelOne').val();
            if (levelOneId == ''){
                //清空
                var html ='<option value="">-请选择-</option>';
                $('#levelTwo').html(html);
                form.render();
                return ;
            }else {
                // alert(levelOneId);
                $.ajax({
                    url: '/category/queryLevelTwoByLevelOne/'+levelOneId+'.do',
                    type: 'get',

                    success:function(data){
                        var html ='<option value="">-请选择-</option>';
                        var len=data.length;
                        for (var i=0;i<len;i++){

                            html+='<option value="'+data[i].id+'">'+data[i].categoryName+'</option>';

                        }
                        //选择level2更新
                        $('#levelTwo').html(html);
                        form.render();
                    }
                })
            }
        });
        // 二级分类end=========================================================

        // 三级分类start=========================================================
        form.on('select(levelTwo)',function () {
            //获取id
            var levelTwoId = $('#levelTwo').val();
            if (levelTwoId == ''){
                //清空
                var html ='<option value="">-请选择-</option>';
                $('#levelThree').html(html);
                form.render();
                return ;
            }else {
                // alert(levelOneId);
                $.ajax({
                    url: '/category/queryLevelThreeByLevelTwo/'+levelTwoId+'.do',
                    type: 'get',

                    success:function(data){
                        var html ='<option value="">-请选择-</option>';
                        var len=data.length;
                        for (var i=0;i<len;i++){

                            html+='<option value="'+data[i].id+'">'+data[i].categoryName+'</option>';
                        }
                        //选择level2更新
                        $('#levelThree').html(html);
                        form.render();
                    }
                })
            }
        });
        // 三级分类end=========================================================

    });
</script>
</body>
</html>
