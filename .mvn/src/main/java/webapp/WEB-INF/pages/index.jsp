<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统首页</title>
	<!-- 下载并引入jquery easyUI -->
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/jquery-easyui-1.8.8/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/jquery-easyui-1.8.8/themes/icon.css">
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/jquery-easyui-1.8.8/themes/color.css">
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/jquery-easyui-1.8.8/jquery.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/jquery-easyui-1.8.8/jquery.easyui.min.js"></script>
</head>
<body class="easyui-layout">
	<div id="cc" class="easyui-layout"
		style="width: 100%; heith: 100%; min-height: 600px;">
		<div data-options="region:'north',border:false" style="height: 80px;">
			<img alt="logo" src="${pageContext.request.contextPath}/images/logo.png"
				style="padding: 20px 0 0 20px;">
		</div>
		<div data-options="region:'west',title:'菜单',split:true"
			style="width: 200px;">
			<div id="aa" class="easyui-accordion"
				data-options="fit:true,border:false">
				<div title="商品管理" data-options="iconCls:'icon-save',selected:true"
					style="overflow: auto; padding: 10px;">
					<a id="btn" href="javascript:void(0);" class="easyui-linkbutton"
						data-options="plain:true" onclick="open_menu('商品管理','${pageContext.request.contextPath}/product/index')">商品管理</a>
				</div>
				
				<div title="商品分类" data-options="iconCls:'icon-save',selected:true"
					style="overflow: auto; padding: 10px;">
					<a id="btn" href="javascript:void(0);" class="easyui-linkbutton"
						data-options="plain:true" onclick="open_menu('商品分类','${pageContext.request.contextPath}/kind/index')">商品分类</a>
				</div>
				
				<div title="订单管理" data-options="iconCls:'icon-save',selected:true"
					style="overflow: auto; padding: 10px;">
					<a id="btn" href="javascript:void(0);" class="easyui-linkbutton"
						data-options="plain:true" onclick="open_menu('订单管理','${pageContext.request.contextPath}/orderInfo/index')">订单管理</a>
				</div>
				
				
				<div title="会员管理" data-options="iconCls:'icon-man',selected:true"
					style="overflow: auto; padding: 10px;">
					<a id="btn" href="javascript:void(0);" class="easyui-linkbutton"
						data-options="plain:true" onclick="open_menu('会员管理','${pageContext.request.contextPath}/user/index')">会员管理</a>
				</div>
				
				<div title="系统管理" data-options="iconCls:'icon-reload'"
					style="padding: 10px;">
					<a href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true" 
					onclick="open_menu('个人中心','${pageContext.request.contextPath}/admin/index?adminName=${SESSION_USER }')">个人中心</a><br>
					<a href="javascript:void(0);" class="easyui-linkbutton"
						data-options="plain:true">修改密码</a> <br> 
					<a href="javascript:void(0);" class="easyui-linkbutton"
					data-options="plain:true">刷新系统缓存</a><br>
					 <a href="${pageContext.request.contextPath}/admin/logout"
						class="easyui-linkbutton" data-options="plain:true">退出系统</a>
				</div>
			</div>
		</div>

		<div data-options="region:'center',border:false,plain:true" >
			<div id="tt" class="easyui-tabs" fit=true >
				<div title="首页" style="text-align: center; font-size: 24px;">
					<div style="width:1164px;height:483px ;margin-top:-23px;background: url(${pageContext.request.contextPath}/images/bg.jpg);background-repeat: no-repeat;">
						<p style="padding:240px 0;">欢迎${SESSION_USER }来到猫咪铺子后台管理系统</p>
					</div>
					
				</div>
			</div>
		</div>
	</div>
	<div style="height: 40px; text-align: center; font-size: 12px;">
		<p>版权所有,&copy;2016-2018</p>
	</div>


	<script type="text/javascript">
		function open_menu(titleName, menuUrl) {
			if ($("#tt").tabs("exists", titleName)) {
				$("#tt").tabs("select", titleName);
			} else {
				$('#tt').tabs('add', {
					title : titleName,
					href : menuUrl,
					closable : true
				});
			}
		}
	</script>

</body>
</html>