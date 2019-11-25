<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单列表</title>
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
	<table id="orderInfo_dg" title="订单列表" class="easyui-datagrid" style="width:1155px;height:460px"
			url="${param.request.contextPath }/orderInfo/list"
			toolbar="#orderInfo_toolbar" pagination="true"
			rownumbers="true" fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<!-- field字段需要与返回数据的属性名一致 -->
				<th field="orderId" width="50">订单编号</th>
				
				<!-- 在列表中显示多表关联数据，需要使用格式化器进行解析数据 -->
				<!-- 如果一个对象的值需要显示多列，filed属性的名字不能相同，formatter的方法名也不能相同 -->
				<th field="user" formatter="userFormatter" width="80">会员名称</th>
				<th field="product" formatter="productFormatter" width="150">商品名称</th>
				
				<th field="num" width="50">订单数量</th>
				<th field="orderState" width="50">订单状态</th>
				<th field="orderTime" width="150">下单时间</th>
				<th field="deliveryTime" width="150">发货时间</th>

			</tr>
		</thead>
	</table>
	<!-- 工具条组件 -->
	<div id="orderInfo_toolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newOrderInfo()">添加</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editOrderInfo()">编辑</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyOrderInfo()">删除</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label>状态：</label>
		<select id="orderState" class="easyui-combobox" name="orderState" style="width:150px;">
		    <option value="已付款">已付款</option>
		    <option value="未付款">未付款</option>
		    <option value="申请退款">申请退款</option>
		</select>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a id="btn" href="#"
			class="easyui-linkbutton"
			data-options="iconCls:'icon-search'" onclick="SearchByState()">查询</a>
	
	</div>
	
	
	
	<!-- 新增和修改start -->
	<div id="orderInfo_dlg" class="easyui-dialog" style="width:660px;height:280px;padding:10px 20px"
		closed="true" buttons="#orderInfo_dlg-buttons">
		<div class="ftitle">添加订单信息</div>
		<form id="orderInfo_fm" enctype="multipart/form-data" method="post">
			<div class="fitem">
				<label>会员名称：</label>
				<input name="user.userId" class="easyui-combobox" id="userIdAndName"
				data-options="valueField:'userId',textField:'userName',
				url:'${param.request.contextPath}/user/listall'" disabled="true">
				
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				<label>商品名称： </label>
				<input name="product.proid" class="easyui-combobox" id="productIdAndName"
				data-options="valueField:'proid',textField:'proname',
				url:'${param.request.contextPath}/product/listall'" disabled="true">
			</div>
			<div class="fitem">
				<label>订单数量： </label>
				<input name="num" class="easyui-validatebox" required="true" disabled="true">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<label>订单状态： </label>
				<!-- <input name="orderState" class="easyui-validatebox" required="true" disabled="true"> -->
				<select class="easyui-combobox" name="orderState" style="width:150px;">
				    <option value="已付款">已付款</option>
				    <option value="未付款">未付款</option>
				    <option value="申请退款">申请退款</option>
				</select>
			</div>
			<div class="fitem">
				<label>下单时间： </label>
				<input name="orderTime" class="easyui-datetimebox" disabled="true">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<label>发货时间： </label>
				<input name="deliveryTime" class="easyui-datetimebox">
			</div>
		</form>
	</div>
	<div id="orderInfo_dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveOrderInfo()">保存</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#orderInfo_dlg').dialog('close')">退出</a>
	</div>
	
	<script type="text/javascript" src="${param.request.contextPath }/jquery-easyui-1.8.8/locale/easyui-lang-zh_CN.js"></script>
	
	<script type="text/javascript">
		//easyUI在处理多列数据时，需要使用格式化器解析数据
		function userFormatter(value,row,index){
			//value是传递进来的kind对象
			//return value.kindName;
			//row是当前行数据，index是第几行数据
			return row.user.userName;
		}
		function productFormatter(value,row,index){
			return row.product.proname;
		}

		function SearchByState(){
			var orderState = $.trim($('#orderState').textbox('getValue'));
			if(orderState==""){
				orderState=null;
			}else{
				$('#orderInfo_dg').datagrid('load', {
					orderState : $('#orderState').textbox('getValue')
				});
				url = '${param.request.contextPath}/orderInfo/list';
			}
		}

		function newOrderInfo(){
			/* $('#orderInfo_dlg').dialog('open').dialog('setTitle','新增订单');
			$('#orderInfo_fm').form('clear');
			url = '${param.request.contextPath}/orderInfo/add';
			loaduserSuccess(0);
			loadProductSuccess(0); */
			$.messager.alert('标题','不能添加订单，只有会员能添加订单!','info');
		}

		function editOrderInfo() {
			var row = $('#orderInfo_dg').datagrid('getSelected');
			if (row) {
				$('#orderInfo_dlg').dialog('open').dialog('setTitle', '修改订单');
				$('#orderInfo_fm').form('load', row);
				url = '${param.request.contextPath}/orderInfo/edit?orderId='
						+ row.orderId;
				loaduserSuccess(row.user.userId);
				loadProductSuccess(row.product.proid);
			}
		}

		//下拉列表反选的方法
		function loaduserSuccess(user) {
			var data = $("#userIdAndName").combobox("getData");
			if (data && data.length > 0) {
				if (user == 0) {
					$("#userIdAndName")
							.combobox("setValue", data[0].userId);
				} else {
					$("#userIdAndName").combobox("setValue", user);
				}
			}
		}
		function loadProductSuccess(product) {
			var data = $("#productIdAndName").combobox("getData");
			if (data && data.length > 0) {
				if (product == 0) {
					$("#productIdAndName")
							.combobox("setValue", data[0].proid);
				} else {
					$("#productIdAndName").combobox("setValue", product);
				}
			}
		}
		
		function saveOrderInfo() {
			$('#orderInfo_fm').form('submit', {
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

					$('#orderInfo_dlg').dialog('close'); // close the dialog
					$('#orderInfo_dg').datagrid('reload'); // reload the user data
				}
			});
		}

		function destroyOrderInfo() {
			var row = $('#orderInfo_dg').datagrid('getSelected');
			if (row) {
				$.messager.confirm('Confirm', '确认删除商品?', function(r) {
					if (r) {
						$.post('${param.request.contextPath}/orderInfo/delete', {
							orderId : row.orderId
						}, function(result) {
							if (result.success) {
								$('#orderInfo_dg').datagrid('reload'); // reload the user data
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