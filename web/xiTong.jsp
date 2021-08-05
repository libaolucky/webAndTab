<%--
  Created by IntelliJ IDEA.
  User: NFZ
  Date: 2021/6/17
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="js/layui-v2.5.6/layui/layui.js"></script>
<link rel="stylesheet" href="js/layui-v2.5.6/layui/css/layui.css"></link>

<html>
<head>
    <title>Title</title>
</head>

<body>
<table class="layui-hide" id="test" lay-filter="test"></table>

<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
        <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
        <button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
    </div>
</script>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-normal layui-btn-xs"  lay-event="sel">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script>
    layui.use([ 'form', 'table','util','jquery'], function (args) {
        var form = layui.form;
        var table = layui.table;
        var util = layui.util;
        var $ = layui.jquery;


        //table.render渲染上面的table表格
        table.render({//LayuiServlet
            elem: '#test'
            , url: '/XitongServlet'
            , toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
            , defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
                title: '提示'
                , layEvent: 'LAYTABLE_TIPS'
                , icon: 'layui-icon-tips'
            }]
            , title: '用户数据表'
            , cols: [[
                { type: 'checkbox', fixed: 'left' }
                , { field: 'id', title: '序号', width: 50, edit: 'text', sort: true }
                , { field: 'bid', title: '编号', width: 60 }
                , { field: 'name', title: '系统名称', width: 120 }
                , { field: 'count', title: '个数', width: 50 }
                , { field: 'jibie', title: '级别', width: 80 }
                , { field: 'yuname', title: '漏洞域名', width: 150 }
                , { field: 'type', title: '漏洞类型', width: 200 }
                , { field: 'tongzhi', title: '是否通知', width: 150,templet:function () {
                        return "<input type=\"checkbox\" name=\"notice\"  title=\"已下发\" lay-filter=\"noticeDemo\" checked=\"true\" >";
                    }}
                , { field: 'fankui', title: '是否反馈', width: 150,templet:function () {
                        return "<input type=\"checkbox\" name=\"feedback\" title=\"已反馈\" lay-filter=\"feedbackDemo\" checked=\"true\">";
                    }}
                , { field: 'ctest', title: '是否复测', width: 150 ,templet:function () {
                        return "<input type=\"checkbox\" name=\"retest\"  title=\"已复测\" lay-filter=\"retestDemo\"checked=\"true\" >";
                    }}
                , { field: 'update', title: '是否修复', width: 150 ,templet:function (p) {
                        if(p.repair){
                            return "<input type=\"checkbox\" checked=\"\" name=\"open\" lay-skin=\"switch\" lay-filter=\"switchTest\" lay-text=\"已通过|未通过\" value='已通过'>";
                        }else{
                            return "<input type=\"checkbox\" name=\"close\" lay-skin=\"switch\" lay-filter=\"switchTest\" lay-text=\"已通过|未通过\" value='未通过'>";
                        }
                    }}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:250}
            ]]
            , page: true
        });
        //头工具栏事件
        table.on('toolbar(test)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id);
            switch(obj.event){
                case 'getCheckData':
                    var data = checkStatus.data;
                    layer.alert(JSON.stringify(data));
                    break;
                case 'getCheckLength':
                    var data = checkStatus.data;
                    layer.msg('选中了：'+ data.length + ' 个');
                    break;
                case 'isAll':
                    layer.msg(checkStatus.isAll ? '全选': '未全选');
                    break;

                //自定义头工具栏右侧图标 - 提示
                case 'LAYTABLE_TIPS':
                    layer.alert('这是工具栏右侧自定义的一个图标按钮');
                    break;
            };
        });

        //监听行工具事件
        table.on('tool(test)', function(obj){
            var data = obj.data;
            //console.log(obj)
            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    obj.del();
                    layer.close(index);
                });
            } else if(obj.event === 'edit'){
                layer.prompt({
                    formType: 2
                    ,value: data.email
                }, function(value, index){
                    obj.update({
                        email: value
                    });
                    layer.close(index);
                });
            }
        });

        form.on('checkbox(noticeDemo)', function(data){
            console.log(data.elem); //原始DOM对象
            console.log(data.value); //被选中的值
            console.log(data.othis); //美化后的DOM对象
            if(data.elem.checked){
                //  layer.tips('测试按钮开关的tips开关');
                layer.alert('修改为:已下发',{icon:1});

            }else{
                layer.alert('修改为:未下发',{icon:2});
            }

        });

        //监听指定开关
        form.on('switch(switchTest)', function(data){
            console.log(data.elem); //原始DOM对象
            console.log(data.value); //被选中的值
            console.log(data.othis); //美化后的DOM对象
                if(data.elem.checked){
                    //  layer.tips('测试按钮开关的tips开关');
                    layer.alert('修改为:已完成修复',{icon:1});

                }else{
                    layer.alert('修改为:未完成修复',{icon:2});
                }
            });
            $.ajax({
                url:'/XitongServlet',
                type:'get',
                data:{

                },
                dataType:'json',
                success:function(res){
                    //console.log(res)
                }

            })
            layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
                offset: '6px'
            });
            //layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
        });

</script>

</body>
</html>