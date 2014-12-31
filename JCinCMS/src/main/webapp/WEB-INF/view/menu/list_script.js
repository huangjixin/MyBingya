//表示弹窗是创建菜单还是编辑菜单信息；
var isCreate;

$().ready(function() {
	init();
});

// 初始化工作；
function init() {
	createDgMenu();
}

// 创建菜单数据表格
function createDgMenu() {
	var toolbar = [ {
		text : '添加',
		iconCls : 'icon-add',
		handler : function() {
			add();
		}
	}, {
		text : '删除',
		iconCls : 'icon-remove',
		handler : function() {
			remove();
		}
	}, '-', {
		text : '更新',
		iconCls : 'icon-edit',
		handler : function() {
			 update();
		}
	} ];

	$('#dgMenu').datagrid({
		title : '',
		pageSize : 20,// 默认选择的分页是每页5行数据
		pageList : [ 5, 10, 15, 20 ],// 可以选择的分页集合
		nowrap : true,// 设置为true，当数据长度超出列宽时将会自动截取
		striped : true,// 设置为true将交替显示行背景。
		collapsible : true,// 显示可折叠按钮
		url : 'MenuInfoService.queryMenuinfoInfo',// url调用后台方法
		loadMsg : '数据装载中......',
		singleSelect : false,// 为true时只能选择单行
		selectOnCheck: true,
		checkOnSelect: true,
		fitColumns : true,// 允许表格自动缩放，以适应父容器
		fit : true,
		remoteSort : false,
		pagination : true,// 分页
		rownumbers : true,// 显示行数
		toolbar : toolbar
	});
}

// 移除条目；
function remove() {
	//单行删除。
//	var row = $('#dgMenu').datagrid("getSelected");
//	var pam = {
//		staffId : row.staffId
//	};
	//多行删除。
	var row = $('#dgMenu').datagrid('getSelections');  
    var i = 0;  
    var string = "";  
    for(i;i<row.length;i++){  
        string += row[i].staffId;  
        if(i < row.length-1){  
            string += ',';  
        }else{  
            break;  
        }  
    }
    
    if (row.length>0) {  
        $.messager.confirm('Confirm', '确定删除菜单?', function(r) {  
            if (r) {  
            	var pam = {
                		staffId : string
                	};
            	Ajax.getSy().remoteCall("MenuInfoService", "deleteByKey", [ pam ],
            			function(reply) {
            				if (reply) {
            					var result = reply.getResult();
            					if (result != 0) {
            						$("#dgMenu").datagrid('reload'); // 重新加载
            					}
            				}
            			});
            }  
        });  
    } 
}

//添加
function add(){
	isCreate=true;
	$('#dialog_edit').dialog('open');
}


//更新
function update(){
	var row = $('#dgMenu').datagrid("getSelected");
	if(row == null){
		return;
	}
	isCreate=false;
	fillForm();
	$('#dialog_edit').dialog('open');
}
// 保存菜单
function saveMenu() {
	var formMap = DWRUtil.getValues("userForm");
	var checkIndex=$("#stateSelect").get(0).selectedIndex;
	formMap.state = checkIndex;

	if(isCreate){
		Ajax.getSy().remoteCall("MenuInfoService", "save", [ formMap ],
				function(reply) {
					if (reply) {
						var result = reply.getResult();
						if (result != 0) {
							$('#dialog_edit').dialog('close');
							$("#dgMenu").datagrid('reload'); // 重新加载
							clearForm();
						}else{
							alert("234");
						}
					}
				});
	}else{
		var row = $('#dgMenu').datagrid("getSelected");
		formMap.staffId = row.staffId;
		Ajax.getSy().remoteCall("MenuInfoService", "update", [ formMap ],
				function(reply) {
					if (reply) {
						var result = reply.getResult();
						if (result != 0) {
							$('#dialog_edit').dialog('close');
							$("#dgMenu").datagrid('reload'); // 重新加载

							clearForm();
						}
					}
				});
	}
	
}

function fillForm() {
	var row = $('#dgMenu').datagrid("getSelected");
	if (row != null) {
		$("#staffCodeInput").val(row.staffCode);
		$("#staffNameInput").val(row.staffName);
		$("#passwordInput").val(row.password);
//		$("#stateSelect").attr("value",row.state);
//		$("#stateInput").val(row.state);
		$("#stateSelect").val(row.state);
	}
}

function clearForm() {
	$("#staffCodeInput").val("");
	$("#staffNameInput").val("");
	$("#passwordInput").val("");
	$("#stateSelect").val("1");
}

//格式化菜单状态显示。
function formatState(val,row){
    if (val == '0'){
        return '禁用';
    } else if (val == '1'){
        return '正常';
    }
}