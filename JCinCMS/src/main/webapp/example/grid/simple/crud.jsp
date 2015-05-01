<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>增删改查</title>
    <script type="text/javascript" src="../../../jquery.js"></script>
    <script src="../../../ui/om-core.js"></script>
    <script src="../../../ui/om-validate.js"></script>
    <script src="../../../ui/om-mouse.js"></script>
    <script src="../../../ui/om-draggable.js"></script>
    <script src="../../../ui/om-position.js"></script>
    <script src="../../../ui/om-resizable.js"></script>
    <script type="text/javascript" src="../../../ui/om-grid.js"></script>
    <script src="../../../ui/om-button.js"></script>
    <script src="../../../ui/om-dialog.js"></script>
    <script src="../../../ui/om-ajaxsubmit.js"></script>
    <script src="../../../ui/om-messagetip.js"></script>
    <link rel="stylesheet" type="text/css" href="../../../themes/default/om-all.css" />
    <link rel="stylesheet" href="../../../demos/common/css/demo.css">
    <style>
        #delete{margin-right:20px;}
        #ipForm label {color:red;}
    </style>
    <!-- view_source_begin -->
    <script type="text/javascript">
        $(document).ready(function() {
            $('#grid').omGrid({
                dataSource : '../../../gridcrud.do',
                width : 686,
                height : 332,
                limit : 10,
                colModel : [ {header : 'ID', name : 'id', width : 50, align : 'center'}, 
                             {header : '地区', name : 'city', width : 120, align : 'left'}, 
                             {header : '地址', name : 'address', align : 'left', width : 'autoExpand'},
                             {header : '起始IP', name : 'start',width:120},
                             {header : '结束IP', name : 'end',width:120} ]
            });
            var dialog = $("#dialog-form").omDialog({
                width: 350,
                autoOpen : false,
                modal : true,
                resizable : false,
                buttons : {
                    "提交" : function(){
		                submitDialog();
		                return false; //阻止form的默认提交动作
		            },
                    "取消" : function() {
                        $("#dialog-form").omDialog("close");//关闭dialog
                    }
                }
            });
            //显示dialog并初始化里面的输入框的数据
            var showDialog = function(title,rowData){
                validator.resetForm();
                rowData = rowData || {};
                $("input[name='id']",dialog).val(rowData.id);
                $("input[name='city']",dialog).val(rowData.city);
                $("input[name='address']",dialog).val(rowData.address);
                $("input[name='start']",dialog).val(rowData.start);
                $("input[name='end']",dialog).val(rowData.end);
                dialog.omDialog("option", "title", title);
                dialog.omDialog("open");//显示dialog
            };
            //dialog中点提交按钮时将数据提交到后台并执行相应的add或modify操作
            var submitDialog = function(){
                if (validator.form()) {
	                var submitData={
	                    operation:isAdd?'add':'modify',
	                    id:$("input[name='id']",dialog).val(),
	                    city:$("input[name='city']",dialog).val(),
	                    address:$("input[name='address']",dialog).val(),
	                    start:$("input[name='start']",dialog).val(),
	                    end:$("input[name='end']",dialog).val()
	                };
	                $.post('../../../gridcrud.do',submitData,function(){
	                    if(isAdd){
	                        $('#grid').omGrid('reload',1);//如果是添加则滚动到第一页并刷新
	                        $.omMessageTip.show({title: "操作成功", content: "添加数据成功", timeout: 1500});
	                    }else{
	                        $('#grid').omGrid('reload');//如果是修改则刷新当前页
	                        $.omMessageTip.show({title: "操作成功", content: "修改数据成功", timeout: 1500});
	                    }
	                    $("#dialog-form").omDialog("close"); //关闭dialog
	                });
                }
            };
            var isAdd = true; //弹出窗口中是添加操作还是修改操作？
            $('#create').bind('click', function() {
                isAdd = true;
                showDialog('新增');//显示dialog
            });
            $('#modify').bind('click', function() {
                var selections=$('#grid').omGrid('getSelections',true);
                if (selections.length == 0) {
                    alert('请至少选择一行记录');
                    return false;
                }
                isAdd = false;
                showDialog('修改',selections[0]);//显示dialog
            });
            $('#delete').bind('click', function(e) {
                var selections=$('#grid').omGrid('getSelections',true);
                if (selections.length == 0) {
                    alert('请至少选择一行记录');
                    return false;
                }
                //将选择的记录的id传递到后台去并执行delete操作
                var toDeleteRecordID=selections[0].id;
                $.post('../../../gridcrud.do',{operation:'delete',id:toDeleteRecordID},function(){
                    $('#grid').omGrid('reload');//刷新当前页数据
                    $.omMessageTip.show({title: "操作成功", content: "删除数据成功", timeout: 1500});
                });
            });
            $('#query').bind('click', function(e) {
                var qCity=$('#qCity').val();
                if(qCity===""){ //没要有查询条件，要显示全部数据
                    $('#grid').omGrid("setData", '../../../gridcrud.do');
                }else{ //有查询条件，显示查询数据
                    $('#grid').omGrid("setData", '../../../gridcrud.do?qCity='+encodeURI(qCity));
                }
            });
            
            // 对表单进行校验
            var validator = $('#ipForm').validate({
                rules : {
                    city : {required: true}, 
                    address : {required : true},
                    start : {required : true}, 
                    end : {required : true}
                }, 
                messages : {
                    city : {required : "城市不能为空"},
                    address : {required : "地址不能为空"},
                    start : {required : "开始地址不能为空"},
                    end : {required : "结束地址不能为空"}
                }
            });
        });
    </script>
    <!-- view_source_end -->
</head>
<body>
    <!-- view_source_begin -->
    <div id="tbdiv">
        <input id="create" type="button" value="新增"/>
        <input id="modify" type="button" value="修改"/>
        <input id="delete" type="button" value="删除"/>
        地区(模糊查询，为空时显示全部)：<input id="qCity"></input>
        <input id="query" type="button" value="查询"/>
    </div>
    <table id="grid"></table>
    
    <div id="dialog-form">
        <form id="ipForm">
	        <input name="id" style="display: none"/>
	        <table>
	            <tr>
	                <td>地区：</td>
	                <td><input name="city" /></td>
	            </tr>
	            <tr>
	                <td>地址：</td>
	                <td><input name="address" /></td>
	            </tr>
	            <tr>
	                <td>起始：</td>
	                <td><input name="start" /></td>
	            </tr>
	            <tr>
	                <td>结束：</td>
	                <td><input name="end" /></td>
	            </tr>
	        </table>
        </form>
    </div>
    <!-- view_source_end -->
    <div id="view-desc">
        <p>本示例演示了表格的增删改查功能。增加、修改、删除都是直接修改后台数据模型，然后刷新表格即可。查询功能是修改表格的数据源，加上查询相关参数，修改数据源后表格会自动使用新的数据源刷新表格。 并在提交数据的时候进行校验。</p>
    </div>
</body>
<script type="text/javascript" src="../../../demos/common/js/themeloader.js"></script>
</html>