<%--
  Created by IntelliJ IDEA.
  User: My
  Date: 2018/10/8
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form id="savePersonForm" method="post">
    <div style="text-align: center">
        <div style="margin: 70px 0px 10px 0px">
            用户名：<input name="name" class="easyui-textbox" data-options="iconCls:'icon-man',required:true"/>
        </div>
        <div style="margin:10px 0px 10px 0px">
            年龄：<input name="age" class="easyui-textbox" data-options="iconCls:'icon-star'" />
        </div>
        <div style="margin:10px 0px 10px 0px">
            生日：<input name="bir" class="easyui-datebox" data-options="editable:false"/>
        </div>
    </div>

</form>