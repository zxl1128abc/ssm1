<%--
  Created by IntelliJ IDEA.
  User: My
  Date: 2018/10/8
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>个人管理中心</title>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
    <meta http-equiv="description" content="this is my page"/>
    <link rel="stylesheet" type="text/css" href="/ssm/back/easyui/themes/black/easyui.css" >
    <link rel="stylesheet" type="text/css" href="/ssm/back/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/ssm/back/easyui/themes/IconExtension.css">
    <link rel="stylesheet" href="/ssm/back/css/login.css" type="text/css"/>
    <script type="text/javascript" src="/ssm/back/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="/ssm/back/easyui/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/ssm/back/easyui/js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="/ssm/back/script/common.js"></script>
    <script type="text/javascript">
        $(function(){
            //点击更改验证码
            $("#verifyCode").click(function () {
                $(this).attr("src",$(this).prop("src")+"?"+"username="+Math.random());
            });
        });
    </script>
    </head>
<body>
<div class="login" style="background-color: #00bbee;">
    <form id="loginForm" action="/ssm/user/login" method="post">
        <table>
            <tbody>
            <tr>
                <th>用户名：</th>
                <td>
                    <input id="name" class="easyui-textbox" type="text" name="username" data-options="required:true"/>
                </td>
            </tr>
            <tr>
                <th>密码：</th>
                <td>
                    <input id="password" name="password" type="text" class="easyui-passwordbox" margin:10px 0px 0px 20px/>
                </td>
            </tr>
            <tr>
                <th>验证码：</th>
                <td>
                    <input type="text" id="code" name="code" class="text captcha" maxlength="4" autocomplete="off">
                    <img src="/ssm/user/code" id="verifyCode" class="captchaImage" title="点击更换验证码"/>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" class="loginButton" class="easyui-linkbutton" value="登录"/>
                    <input type="button" class="homeButton"  value="取消" onclick="location.href='/'">
                </td>
            </tr>
            </tbody>
        </table>
    </form>
    <div class="powered">
        COPYRIGHT  © 2018-3018.张秀黎版权所有
    </div>
    <div class="link" style="background-color: #00ee00;height: 40px;width: 600px;align-content:center;">
        <a href="">前台首页</a>
        <a href="">官方网站</a>
        <a href="">交流论坛</a>
        <a href="">关于我们</a>
        <a href="">联系我们</a>
        <a href="">授权查询</a>
    </div>
</div>
</body>
</html>