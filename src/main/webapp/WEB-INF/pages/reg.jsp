<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.8.8/jquery.min.js"></script>
</head>
<body background=${pageContext.request.contextPath}/images/bg_login.jpeg>
	<table width="400" border="0" align="center" cellpadding="0" cellspacing="0" style="margin-top:130px" >
		<tr>
			<td background=${pageContext.request.contextPath}/images/bg_login1.jpeg height=250 width=300 style="margin-top:-5px">
				<form id="condition" name="condition" method="post" action="${pageContext.request.contextPath}/admin/add">
					<table width="300" height="250" border="0" align="center" cellpadding="0" cellspacing="0">
						<tr><td align="center" colspan="2" ><h2>注册/<a href="${pageContext.request.contextPath}/admin/login" style="color:red;">登录</a></h2></td></tr>
						<tr>
							<td style="height: 28px" width=80>用户名：</td>
							<td style="height: 28px" width=150>
								<input id="adminName" style="width: 130px" name="adminName" value="${admin.adminName}">
							</td>
						</tr>
						
						<tr>
							<td style="height: 28px" width=80>设置密码：</td>
							<td style="height: 28px" width=150>
								<input id="password" type="password" style="width: 130px" name="password" value="${admin.password}">
							</td>
						</tr>
						
						<tr>
							<td style="height: 28px" width=80>确认密码：</td>
							<td style="height: 28px" width=150>
								<input id="password2" type="password" style="width: 130px" name="password2" value="${admin.password}">
							</td>
						</tr>
						
						<tr>
							<td align="left">
								<image id=btn style="BORDER-TOP-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; BORDER-RIGHT-WIDTH: 0px"
										 src="${pageContext.request.contextPath}/images/reg_button.jpg"
										 onclick="javascript:checkLogin();return false;">
							</td>
							<td align="center">
							<image style="BORDER-TOP-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; BORDER-RIGHT-WIDTH: 0px"
									 src="${pageContext.request.contextPath}/images/reset.jpg"
									 onclick="resetValue();return false;">
							</td>
						</tr>
						<tr height="10">
							<td width="40%" align="center" colspan="2">
								<font color="red" size="5" id="cw" name="cw"></font>
							</td>
						</tr>
						
					</table>
				</form>
			</td>
		</tr>
		
	</table>
	
	<script>
	function resetValue() {
		$('#adminName').val("");
		$('#password').val("");
		$("#cw").text("");
	}
	
	function checkLogin() {
		var adminName = $('#adminName').val();
		var password = $('#password').val();
		if(adminName == null || adminName == "") {
			$("#cw").text("请输入用户名！");
			return;
		} else if(password == null || password == "") {
			$("#cw").text("请输入密码！");
			return;
		} else {
			$('#condition').submit();
		}
	}
</script>
<script type="text/javascript">
	if('${errorMsg}' != '') {
		$("#cw").text('${errorMsg}');
	}
</script>
</body>
</html>