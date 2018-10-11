<%--
  Created by IntelliJ IDEA.
  User: My
  Date: 2018/10/8
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">

    var $menu;
    $(function(){
        $menu=$("#menu");
        //发送异步get请求，加载菜单选项数据
        $.get("/ssm/back/main/menu.json",function(result){
            //遍历一级菜单
            $.each(result,function(idx,menu){
                //遍历二级菜单
                var content="<div style='text-align: center;'>";
                $.each(menu.children,function(idx,child){
                    var args=child.href+"*"+child.iconCls+"*"+child.title;
                        content += "<div class='easyui-linkbutton' onClick=\"addTabs('"+args+"');\"data-options=\"plain:true,iconCls:'"+child.iconCls+"' \" style='border-radius:5%;margin:5px 0px 5px 0px;width:90%;border: 1px solid #95B8E7;'>"+child.title+"</div><br/>";
                });
                content +="</div>";
                //添加一个新的菜单项
                $menu.accordion('add',{
                    title:menu.title,
                    iconCls:menu.iconCls,
                    selected:menu.selected,
                    content:content,
                });
            });
        },"JSON");
    });
    //跳转路径
    function addTabs(args){
        var arg = args.split("*");
        var href = arg[0];
        var iconCls = arg[1];
        var title = arg[2];
        //判断当前选项卡容器中有没有添加的选项卡
        if(!$("#tabs").tabs('exists',title)){
           $("#tabs").tabs('add',{
               title:title,
               iconCls:iconCls,
               closable:true,
               href:href,
               tools:[{
                   iconCls:'icon-reload',
                   handler:refreshTab,
               }],
           });
        }else{
            //选中当前面板
            $("#tabs").tabs('select',title);
        }
    }
    //刷新当前选项卡
    function refreshTab() {
        //返回当前选项卡面板
        var tab = $("#tabs").tabs('getSelected');
        //调用面板方法
        tab.panel('refresh');
    }

</script>
<div id="menu" class="easyui-accordion" data-options="fit:true"></div>