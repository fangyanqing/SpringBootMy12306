<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心</title>
<link rel="stylesheet" type="text/css" href="${param.request.contextPath }/jquery-easyui-1.8.8/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${param.request.contextPath }/jquery-easyui-1.8.8/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${param.request.contextPath }/jquery-easyui-1.8.8/themes/color.css">
	<link rel="stylesheet" type="text/css" href="${param.request.contextPath }/jquery-easyui-1.8.8/demo/demo.css">
	<script type="text/javascript" src="${param.request.contextPath }/jquery-easyui-1.8.8/jquery.min.js"></script>
	<script type="text/javascript" src="${param.request.contextPath }/jquery-easyui-1.8.8/jquery.easyui.min.js"></script>
</head>
<body>
	
	<table id="admin_dg" title="会员列表" class="easyui-datagrid" style="width:1155px;height:460px"
			url="${param.request.contextPath }/admin/personal?adminName=${SESSION_USER }"
			toolbar="#admin_toolbar" pagination="true"
			 fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<!-- field字段需要与返回数据的属性名一致 -->
				<th field="adminId" width="80">编号</th>
				<th field="adminName" width="200">姓名</th>
				<!-- <th field="pic" width="50">图片</th> -->
				<th field="pic" formatter="imageFormatter" align="center"
					width="200" height="10">图片</th>
			</tr>
		</thead>
	</table>
	
	<!-- 工具条组件 -->
	<div id="admin_toolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editAdmin()">编辑</a>
	</div>
	
	<!-- 新增和修改start -->
	<div id="admin_dlg" class="easyui-dialog" style="width:660px;height:280px;padding:10px 20px"
		closed="true" buttons="#admin_dlg-buttons">
		<div class="ftitle">添加分类信息</div>
		<form id="admin_fm" enctype="multipart/form-data" method="post">
			<div class="fitem">
				<label>分类图片： </label>
				<input name="imageFile" class="easyui-filebox">
			</div>
			
		</form>
	</div>
	<div id="admin_dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveAdmin()">保存</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#admin_dlg').dialog('close')">退出</a>
	</div>
	
	
	<script type="text/javascript" src="${param.request.contextPath }/jquery-easyui-1.8.8/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript">
			
		function editAdmin() {
			var row = $('#admin_dg').datagrid('getSelected');
			if (row) {
				$('#admin_dlg').dialog('open').dialog('setTitle', '修改商品分类');
				$('#admin_fm').form('load', row);
				url = '${param.request.contextPath}/admin/edit?adminId='
						+ row.adminId;
				loadProductSuccess(row.admin.adminId);
			}
		}

		function saveAdmin() {
			$('#admin_fm').form('submit', {
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

					$('#admin_dlg').dialog('close'); // close the dialog
					$('#admin_dg').datagrid('reload'); // reload the user data
				}
			});
		}


	
		function imageFormatter(value, row, index) {
			return "<img  width='60' src='${pageContext.request.contextPath}/"+value+"'>";
		}
	</script>

	
</body>
</html>