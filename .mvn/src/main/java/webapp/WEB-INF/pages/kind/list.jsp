<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品分类表</title>
	<!-- 下载并引入jquery easyui -->
	<link rel="stylesheet" type="text/css" href="${param.request.contextPath }/jquery-easyui-1.8.8/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${param.request.contextPath }/jquery-easyui-1.8.8/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${param.request.contextPath }/jquery-easyui-1.8.8/themes/color.css">
	<link rel="stylesheet" type="text/css" href="${param.request.contextPath }/jquery-easyui-1.8.8/demo/demo.css">
	<script type="text/javascript" src="${param.request.contextPath }/jquery-easyui-1.8.8/jquery.min.js"></script>
	<script type="text/javascript" src="${param.request.contextPath }/jquery-easyui-1.8.8/jquery.easyui.min.js"></script>

</head>
<body>
	<!-- 在页面中使用easy ui组件进行页面编程 -->
	
	
	<!-- 数据表格组件 -->
	<table id="kind_dg" title="商品分类表" class="easyui-datagrid" style="width:1155px;height:460px"
			url="${param.request.contextPath }/kind/list"
			toolbar="#kind_toolbar" pagination="true"
			rownumbers="true" fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<!-- field字段需要与返回数据的属性名一致 -->
				<th field="kindId" width="100" height="20">分类编号</th>
				<th field="kindName" width="200" height="20">分类名称</th>
				<th field="kindImage" width="200" height="20">分类图片</th>
				<!-- <th field="kindImage" formatter="imageFormatter" align="center"
					width="20" height="10">图片</th> -->
				
				
			</tr>
		</thead>
	</table>
	<!-- 工具条组件 -->
	<div id="kind_toolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newKind()">添加</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editKind()">编辑</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyKind()">删除</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label>类型：</label>
		<input class="easyui-textbox" type="text" name="kind" id="kind"
				data-options="validType:'kind'" />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a id="btn" href="javascript:searchKind()"
				class="easyui-linkbutton"
				data-options="iconCls:'icon-search'" onclick="SearchByKind()">查询</a>
	</div>
	
	<!-- 新增和修改start -->
	<div id="kind_dlg" class="easyui-dialog" style="width:660px;height:280px;padding:10px 20px"
		closed="true" buttons="#kind_dlg-buttons">
		<div class="ftitle">添加分类信息</div>
		<form id="kind_fm" enctype="multipart/form-data" method="post">
			<div class="fitem">
				<label>分类名称：</label>
				<input name="kindName" class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>分类图片： </label>
				<input name="imageFile" class="easyui-filebox">
			</div>
			
		</form>
	</div>
	<div id="kind_dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveKind()">保存</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#kind_dlg').dialog('close')">退出</a>
	</div>
	
	<script type="text/javascript" src="${param.request.contextPath }/jquery-easyui-1.8.8/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript">
		function SearchByKind(){
			var kind = $.trim($('#kind').val());//获取搜索框的内，$.trim()可以消除前后空格
			if(kind==""){
				kind=null;
			}else{
				$('#kind_dg').datagrid('load', {
					kind : $('#kind').val()
				});
				url = '${param.request.contextPath}/kind/list';
			}
		}

	</script>
	
	<script type="text/javascript">
		function newKind(){
			$('#kind_dlg').dialog('open').dialog('setTitle','新增商品分类');
			$('#kind_fm').form('clear');
			url = '${param.request.contextPath}/kind/add';
			loadProductSuccess(0);
		}

		function editKind() {
			var row = $('#kind_dg').datagrid('getSelected');
			if (row) {
				$('#kind_dlg').dialog('open').dialog('setTitle', '修改商品分类');
				$('#kind_fm').form('load', row);
				url = '${param.request.contextPath}/kind/edit?kindId='
						+ row.kindId;
				loadProductSuccess(row.kind.kindId);
			}
		}

	
		//下拉列表反选的方法
		function loadProductSuccess(kind) {
			var data = $("#kind").combobox("getData");
			if (data && data.length > 0) {
				if (kind == 0) {
					$("#kind")
							.combobox("setValue", data[0].kindId);
				} else {
					$("#kind").combobox("setValue", kind);
				}
			}
		}
		
		function saveKind() {
			$('#kind_fm').form('submit', {
				url : url,
				onSubmit : function() {
					return $(this).form('validate');
				},
				success : function(result) {
					var result = eval('(' + result + ')');
					if (!result.success) {
						$.messager.show({
							title : 'Error',
							msg : result.errorMsg
						});
					} else {
						$.messager.show({
							title : 'Info',
							msg : result.errorMsg
						});
					}

					$('#kind_dlg').dialog('close'); // close the dialog
					$('#kind_dg').datagrid('reload'); // reload the user data
				}
			});
		}

		function destroyKind() {
			var row = $('#kind_dg').datagrid('getSelected');
			if (row) {
				$.messager.confirm('Confirm', '确认删除商品分类?', function(r) {
					if (r) {
						$.post('${param.request.contextPath}/kind/delete', {
							kindId : row.kindId
						}, function(result) {
							if (result.success) {
								$('#kind_dg').datagrid('reload'); // reload the user data
							} else {
								$.messager.show({ // show error message
									title : 'Error',
									msg : result.errorMsg
								});
							}
						}, 'json');
					}
				});
			}
		}

		function imageFormatter(value, row, index) {
			return "<img  width='60' src='${pageContext.request.contextPath}/"+value+"'>";
		}
	</script>
</body>
</html>