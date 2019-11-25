<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户会员列表</title>
	<!-- 下载并引入jquery easyui -->
	<link rel="stylesheet" type="text/css" href="${param.request.contextPath }/jquery-easyui-1.8.8/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${param.request.contextPath }/jquery-easyui-1.8.8/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${param.request.contextPath }/jquery-easyui-1.8.8/themes/color.css">
	<link rel="stylesheet" type="text/css" href="${param.request.contextPath }/jquery-easyui-1.8.8/demo/demo.css">
	<script type="text/javascript" src="${param.request.contextPath }/jquery-easyui-1.8.8/jquery.min.js"></script>
	<script type="text/javascript" src="${param.request.contextPath }/jquery-easyui-1.8.8/jquery.easyui.min.js"></script>

</head>
<body>


	<!-- 查询start -->
	<!-- 在页面中使用easy ui组件进行页面编程 -->
	
	<!-- 数据表格组件 -->
	<table id="user_dg" title="会员列表" class="easyui-datagrid" style="width:1155px;height:460px"
			url="${param.request.contextPath }/user/list"
			toolbar="#user_toolbar" pagination="true"
			rownumbers="true" fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<!-- field字段需要与返回数据的属性名一致 -->
				<th field="userId" width="50">编号</th>
				<th field="nickName" width="200">昵称</th>
				<th field="userName" width="50">姓名</th>
				<th field="email" width="50">邮箱</th>
				<th field="phone" width="50">电话</th>
				<th field="address" width="50">地址</th>
				<th field="pic" width="100">图片</th>
				<!-- <th field="tp" formatter="imageFormatter" align="center"
					width="50">图片</th> -->
				
			</tr>
		</thead>
	</table>
	<!-- 工具条组件 -->
	<div id="user_toolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">添加</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">编辑</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">删除</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label>姓名：</label>
		<input class="easyui-textbox" type="text" name="userName1" id="userName1"
				data-options="validType:'user'" />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a id="btn" href="#"
			class="easyui-linkbutton"
			data-options="iconCls:'icon-search'" onclick="SearchByName()">查询</a>
	</div>
	
	
	
	<!-- 新增和修改start -->
	<div id="user_dlg" class="easyui-dialog" style="width:660px;height:280px;padding:10px 20px"
		closed="true" buttons="#user_dlg-buttons">
		<div class="ftitle">添加会员信息</div>
		<form id="user_fm" enctype="multipart/form-data" method="post">
			<div class="fitem">
				<label>昵称：</label>
				<input name="nickName" class="easyui-validatebox" disabled="true">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<label>姓名： </label>
				<input name="userName" class="easyui-validatebox" disabled="true">
			</div>
			<div class="fitem">
				<label>邮箱： </label>
				<input name="email" class="easyui-validatebox" disabled="true">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<label>电话： </label>
				<input name="phone" class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>地址： </label>
				<input name="address" class="easyui-validatebox" required="true">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<label>图片： </label>
				<input name="imageFile" class="easyui-filebox" >
			</div>
		</form>
	</div>
	<div id="user_dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">保存</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#user_dlg').dialog('close')">退出</a>
	</div>
	
	
	<script type="text/javascript" src="${param.request.contextPath }/jquery-easyui-1.8.8/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript">
		/* function SearchByKind(){
			$('#user_dg').datagrid('load',{
				userName: $('#userName').textbox('getValue')
			});
			url = '${param.request.contextPath}/user/userList';
		} */

		function SearchByName(){
			var userName1 = $.trim($('#userName1').textbox('getValue'));
			if(userName1==""){
				userName1=null;
			}else{
				$('#user_dg').datagrid('load', {
					userName1 : $('#userName1').textbox('getValue')
				});
				url = '${param.request.contextPath}/user/list';
			}
		}
			
	
		function newUser(){
			/* $('#user_dlg').dialog('open').dialog('setTitle','新增会员');
			$('#user_fm').form('clear');
			url = '${param.request.contextPath}/user/add'; */
			$.messager.alert('标题','不能添加用户!','info');
		}

		function editUser() {
			var row = $('#user_dg').datagrid('getSelected');
			if (row) {
				$('#user_dlg').dialog('open').dialog('setTitle', '修改会员');
				$('#user_fm').form('load', row);
				url = '${param.request.contextPath}/user/edit?userId='
						+ row.userId;
			}
		}
		
		function saveUser() {
			$('#user_fm').form('submit', {
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

					$('#user_dlg').dialog('close'); // close the dialog
					$('#user_dg').datagrid('reload'); // reload the user data
				}
			});
		}

		function destroyUser() {
			var row = $('#user_dg').datagrid('getSelected');
			if (row) {
				$.messager.confirm('Confirm', '确认删除商品?', function(r) {
					if (r) {
						$.post('${param.request.contextPath}/user/delete', {
							userId : row.userId
						}, function(result) {
							if (result.success) {
								$('#user_dg').datagrid('reload'); // reload the user data
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