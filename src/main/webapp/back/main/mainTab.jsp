<%--
  Created by IntelliJ IDEA.
  User: My
  Date: 2018/10/8
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>张秀黎个人管理系统主页面</title>
    <link rel="stylesheet" type="text/css" href="/ssm/back/easyui/themes/metro-blue/easyui.css">
    <link rel="stylesheet" type="text/css" href="/ssm/back/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/ssm/back/easyui/themes/IconExtension.css">
    <script type="text/javascript" src="/ssm/back/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="/ssm/back/easyui/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/ssm/back/easyui/js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" >

    </script>

</head>
<body class="easyui-layout">
    <div data-options="region:'north',split:false,href:'/ssm/back/main/head.jsp'" style="height:100px;background-color:greenyellow;"></div>
    <div data-options="region:'south',split:false,href:'/ssm/back/main/footer.jsp'" style="height: 100px;background-color: #3baae3;"> </div>
    <div data-options="region:'west',title:'系统菜单',split:false,iconCls:'icon-home',href:'/ssm/back/main/menu.jsp'" style="width: 200px;"></div>
    <div data-options="region:'center',">
        <%--tabs容器--%>
        <div id="tabs" class="easyui-tabs" data-options="fit:true"></div>
    </div>
</body>
</html>
