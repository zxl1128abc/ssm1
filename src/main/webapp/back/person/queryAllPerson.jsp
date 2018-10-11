<%--
  Created by IntelliJ IDEA.
  User: My
  Date: 2018/10/8
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    //获取所有省份
  /*  function getProvinceCode(){
        $("#provinceCode").combobox({
            valueFiled:'code',
            textField:'name',
            url:'/ssm/province/queryAll',
            method:'get'
        });
    }
    //根据省的编号获取城市
    function getCityCode(){
        var provinceCode = $("#provinceCode").combobox("getValue");
        $("#cityCode").combobox({
            valueField:'code',
            textField:'name',
            url:'/ssm/city/queryByProvinceCode?provinceCode='+provinceCode,
            method:'get',
        });
    }
    //获取该城市下的县区
    function getAreaCode(){
        var cityCode = $("#cityCode").combobox("getValue");
        $("#areaCode").combobox({
            valueField:'code',
            textField:'name',
            url:'/ssm/area/queryByCityCode?cityCode='+cityCode,
            method:'get',
        });
    }
*/
    $(function () {
        $dg = $("#dg");
        //创建datagrid
        $dg.datagrid({
            url:"/ssm/person/queryAll",
            remoteSort:false,//关闭远程排序
            fitColumns:true,//自适应datagrid容器
            fit:true,//自适应父容器
            columns:[[
                {title:"cks",field:"cks",checkbox:true},
                {title:"编号",field:"id",width:180,align:'center',halign:'left',sortable:true},
                {title:"姓名",field:"name",width:120,align:'center',editor:{
                    type:"textbox",
                    options:{required:true,validType:"uname",}
                },resizable:false,fixed:true},
                {title:"年龄",field:"age",width:120,align:"center",
                    formatter:function (value, row, index) {
                        if(value <=30){
                            return "<font color='green'>"+value+"</font>";
                        }
                        return "<font color='red'>"+value+"</font>";
                    },
                    editor:{
                        type:'textbox',
                        options:{required:true,validType:"uname",}
                    }
                },
                {title:"生日",field:"bir",width:200,align:"center",sortable:true,
                    editor:{type:"datebox",}
                },
                {title:"所在省份",field:"provinceName",width:200,align:"center",
                    editor:{type:"textbox",
                    options:{required:true,validType:"uname",}
                }},
                {title:"所在城市",field:"cityName",width:100,align:"center",editor:{type:"textbox",options:{required:true,validType:"uname",}}},
                {title:"所在县区",field:"areaName",width:100,align:"center",editor:{type:"textbox",options:{required:true,validType:"uname",}}},
                {title:"操作",field:"options",width:300,
                    formatter:function(value,row,index){
                        return "<a href='javascript:;' onclick=\"delRow('"+row.id+"');\" class='del'>删除 </a>"+
                                "<a href='javascript:;' onclick=\"addRow('"+index+"',this);\" class='save' style='display: none' class='easyui-linkbutton'>保存</a>"+
                                "<a href='javascript:;' onclick=\"editRow('"+index+"',this);\" class='upd' class='easyui-linkbutton'>修改</a>";
                    }
                }]],
            onLoadSuccess:function(){
                //数据加载完成渲染删除和修改按钮
                $(".del").linkbutton({plain:true,iconCls:'icon-remove'});
                $(".upd").linkbutton({plain:true,iconCls:'icon-edit'});
                $(".save").linkbutton({plain:true,iconCls:'icon-save'});
            },
            toolbar:'#persondatagrid',//加入工具
            loadMsg:'数据加载中。。。',
            /**
             * 一旦加入分页工具栏之后 每次请求会自动携带两个参数  一个是page当前页  一个是rows每页显示条数
             * 要求每次响应的结果中必须要有总条数 total 和当前页展示的数据集合 rows
             */
            pagination:true,
            onAfterEdit:function (index,row,changes) {//结束编辑一行自动触发
                //index表示当前行索引  row表示当前修改之后的对象  changes表示被修改的列的对象
                //JSON.stringify(row) 表示将js对象转为json格式字符串
                $.ajax({//发送异步请求
                    url:"/ssm/person/updatePerson",
                    data:JSON.stringify(row),
                    type:"post",
                    contentType:"application/json",//请求格式为json
                    success:function(result){
                        $dg.datagrid('reload','/ssm/person/updatePerson');//刷新datagrid
                    }
                });
            }
        });
        //监听搜索框中的鼠标滑过事件
     /*   $(".items").mouseover(function(){
            $("#mm").menu('setIcon',{
                target:this,//目标选择项
                iconCls:'icon-star',
            });
        }).mouseout(function(){
            $("#mm").menu('setIcon',{
                target:this,
                iconCls:'icon-star_silver',
            });
        });*/
    });
    //删除一条记录
    function delRow(id){
        $.messager.confirm('确定对话框','您确定要删除吗？',function (r) {
            if(r){
              //发送ajax请求删除一条数据  删除成功之后刷新datagrid
                $.get('/ssm/person/delete',{"id":id},function(){
                    $dg.datagrid('reload','/ssm/person/queryAll');//刷新datagrid
                });
            }
        });
    }
//编辑一条记录
    function editRow(index,current){
        //开始编辑
        $dg.datagrid('beginEdit',index);
        $(current).css('display',"none");
        $(current).next().css("display","inline");
    }
//点击搜索根据条件查询用户
    function searchPerson(value,column){

    }

//打开保存用户的对话框
    function openPersonDialog() {
        $("#savePersonDialog").dialog({
            title:"保存用户",
            width:600,
            height:400,
            href:'/ssm/back/person/savePerson.jsp',
            buttons:[{
                text:"保存",
                iconCls:'icon-save',
                handler:savePerson,
            },{
                text:"关闭",
                iconCls:"icon-cancel",
                handler:closeSavePersonDialog,
            }]
        });
    }
//保存用户方法
    function savePerson(){
        $("#savePersonForm").form('submit',{
            url:"/ssm/person/savePerson",
            success:function(result){
                result= JSON.stringify(result);
                $("#savePersonDialog").dialog('close',true);//关闭对话框
                $dg.datagrid('reload',"/ssm/person/queryAll");//刷新datagrid
                if(result.success){
                    $.messager.show({
                        title:"提示信息",
                        msg:result.message,
                    });
                }else{
                    $.messager.show({
                        title:"提示信息",
                        msg:result.message,
                    });
                }
            }
        });
    }
//关闭对话框
    function closeSavePersonDialog(){
        $("#savePersonDialog").dialog('close',true);//关闭对话框
    }
//结束编辑
    function saveRow(index,row){
        $dg.datagrid('endEdit',index);
        $(".del").linkbutton({plain:true,iconCls:'icon-remove'});
        $(".upd").linkbutton({plin:true,iconCls:'icon-edit'});
        $(".save").linkbutton({plain:true,iconCls:'icon-save'});
    }



</script>
<table id="dg"></table>
<%--工具栏--%>
<div id="persondatagrid">
    <form>
        <div>
            <table border="0" width="100%">
                <tr>
                    <td><font style="color: red;">省份：</font> </td>
                    <td>
                        <select id="provinceCode" name="provinceCode" style="width: 180px;" class="easyui-combobox">
                           <%-- <c:forEach items="${provinceEnums}" var="province">
                                <option value="${province.code}">${province.name}</option>
                            </c:forEach>--%>
                        </select>

                  <%-- <input id="provinceCode" name="provinceCode" class="easyui-combobox" style="width:180px;"
                               data-options="required:false,
                               editable:false,
                         onSelect: function(rec){
					      getProvinceCode();
                     }">--%>
                    </td>
                    <td><font style="color: red;">城市：</font></td>
                    <td>
                        <input id="cityCode" name="cityCode" class="easyui-combobox" style="width:180px;"
                            data-options="required:false,editable:false,onSelect:function(rec){getCityCode();}"
                        >
                    </td>
                    <td><font style="color: red;">县区：</font></td>
                    <td>
                        <input id="areaCode" name="areaCode" class="easyui-combobox" style="width:180px;"
                               data-options="required:false,editable:false,onSelect:function(rec){getAreaCode();}"
                        >
                    </td>
                </tr>
            </table>
        </div>
    </form>

    <a class="easyui-linkbutton" onclick="openPersonDialog()" data-options="iconCls:'icon-add',plain:false">添加</a>
  <%--  <div id="mm" style="width:120px; ">
        <div data-options="name:'name',iconCls:'icon-star'" class="items">姓名</div>
        <div data-options="name:'age',iconCls:'icon-star_sliver'" class="items">年龄</div>
        <div data-options="name:'bir',iconCls:'icon-star_sliver'"  class="items" >生日</div>
    </div>--%>
</div>
<%--保存用户的对话框--%>
<div id="savePersonDialog"></div>












