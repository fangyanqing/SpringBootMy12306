<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
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
	<table id="product_dg" title="商品列表" class="easyui-datagrid" style="width:1155px;height:460px"
			url="${param.request.contextPath }/product/list"
			toolbar="#product_toolbar" pagination="true"
			rownumbers="true" fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<!-- field字段需要与返回数据的属性名一致 -->
				<th field="proid" width="50">编号</th>
				<th field="proname" width="200">名称</th>
				<th field="gender" width="50">性别</th>
				<th field="age" width="50">年龄</th>
				<th field="weight" width="50">体重</th>
				<th field="yj" width="50">原价</th>
				<th field="xj" width="50">现价</th>
				<th field="kcsl" width="50">库存</th>
				<th field="color" width="50">颜色</th>
				<th field="ms" width="200">描述</th>
				<th field="cd" width="50">产地</th>
				<th field="tp" width="100">图片</th>
				<!-- <th field="tp" formatter="imageFormatter" align="center"
					width="50">图片</th> -->
				<th field="sjrq" width="100">上架日期</th>
				<th field="state" width="60">状态</th>
				<!-- 在列表中显示多表关联数据，需要使用格式化器进行解析数据 -->
				<!-- 如果一个对象的值需要显示多列，filed属性的名字不能相同，formatter的方法名也不能相同 -->
				<th field="kind" formatter="kindFormatter" width="80">类型</th>
			</tr>
		</thead>
	</table>
	<!-- 工具条组件 -->
	<div id="product_toolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newProduct()">添加</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editProduct()">编辑</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyProduct()">删除</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label>类型：</label>
		<input  id="kind" name="kind" class="easyui-combobox" 
		data-options="valueField:'kindName',textField:'kindName',
		url:'${param.request.contextPath}/kind/listall'">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a id="btn" href="javascript:searchKind()"
				class="easyui-linkbutton"
				data-options="iconCls:'icon-search'" onclick="SearchByKind()">查询</a>
	</div>
	
	
	
	<!-- 新增和修改start -->
	<div id="product_dlg" class="easyui-dialog" style="width:660px;height:280px;padding:10px 20px"
		closed="true" buttons="#product_dlg-buttons">
		<div class="ftitle">添加商品信息</div>
		<form id="product_fm" enctype="multipart/form-data" method="post">
			<div class="fitem">
				<label>商品名称：</label>
				<input name="proname" class="easyui-validatebox" required="true">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<label>商品性别： </label>
				<input name="gender" class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>商品年龄： </label>
				<input name="age" class="easyui-validatebox" required="true">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<label>商品体重： </label>
				<input name="weight" class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>商品原价： </label>
				<input name="yj" class="easyui-validatebox" required="true">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<label>商品现价： </label>
				<input name="xj" class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>库存数量：</label>
				<input name="kcsl" class="easyui-validatebox" required="true">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<label>商品颜色： </label>
				<input name="color" class="easyui-validatebox" required="true">
			</div>	
			<div class="fitem">
				<label>商品描述： </label>
				<input name="ms" class="easyui-validatebox">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<label>商品产地： </label>
				<input name="cd" class="easyui-validatebox">
			</div>
			<div class="fitem">
				<label>商品图片： </label>
				<input name="imageFile" class="easyui-filebox">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<label>上架日期：</label>
				<input name="sjrq"  class="easyui-datetimebox" >
			</div>	
			<div class="fitem">
				<label>商品状态： </label>
				<input name="state" value="product.jpg">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<label>商品分类：</label>
				<input name="kind.kindId" class="easyui-combobox" id="productKind"
				data-options="valueField:'kindId',textField:'kindName',
				url:'${param.request.contextPath}/kind/listall'">
			</div>
		</form>
	</div>
	<div id="product_dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveProduct()">保存</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#product_dlg').dialog('close')">退出</a>
	</div>
	
	
	<script type="text/javascript" src="${param.request.contextPath }/jquery-easyui-1.8.8/locale/easyui-lang-zh_CN.js"></script>
	
	<script type="text/javascript">
		function SearchByKind(){
			var kind = $.trim($('#kind').val());//获取搜索框的内，$.trim()可以消除前后空格
			if(kind==""){
				kind=null;
			}else{
				$('#product_dg').datagrid('load', {
					kind : $('#kind').val()
				});
				url = '${param.request.contextPath}/product/list';
			}
		}

	</script>
	<script type="text/javascript">
		//easyUI在处理多列数据时，需要使用格式化器解析数据
		function kindFormatter(value,row,index){
			//value是传递进来的kind对象
			//return value.kindName;
			//row是当前行数据，index是第几行数据
			return row.kind.kindName;
		}

		function newProduct(){
			$('#product_dlg').dialog('open').dialog('setTitle','新增商品');
			$('#product_fm').form('clear');
			url = '${param.request.contextPath}/product/add';
			loadProductSuccess(0);
		}

		function editProduct() {
			var row = $('#product_dg').datagrid('getSelected');
			if (row) {
				$('#product_dlg').dialog('open').dialog('setTitle', '修改商品');
				$('#product_fm').form('load', row);
				url = '${param.request.contextPath}/product/edit?proid='
						+ row.proid;
				loadProductSuccess(row.kind.kindId);
			}
		}

		//下拉列表反选的方法
		function loadProductSuccess(kind) {
			var data = $("#productKind").combobox("getData");
			if (data && data.length > 0) {
				if (kind == 0) {
					$("#productKind")
							.combobox("setValue", data[0].kindId);
				} else {
					$("#productKind").combobox("setValue", kind);
				}
			}
		}
		
		function saveProduct() {
			$('#product_fm').form('submit', {
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

					$('#product_dlg').dialog('close'); // close the dialog
					$('#product_dg').datagrid('reload'); // reload the user data
				}
			});
		}

		function destroyProduct() {
			var row = $('#product_dg').datagrid('getSelected');
			if (row) {
				$.messager.confirm('Confirm', '确认删除商品?', function(r) {
					if (r) {
						$.post('${param.request.contextPath}/product/delete', {
							proid : row.proid
						}, function(result) {
							if (result.success) {
								$('#product_dg').datagrid('reload'); // reload the user data
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