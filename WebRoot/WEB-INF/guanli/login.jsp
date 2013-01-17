<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>admin</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>
	<script type="text/javascript">
	function CheckForm() {
		if (document.loginForm.username.value == "") {
			alert("please input your username:");
			document.loginForm.username.focus();
			return false;
		}
		if (document.loginForm.password.value == "") {
			alert("please input your password:");
			document.loginForm.password.focus();
			return false;
		}
		document.loginForm.submit();
	}
</script>
	<body bgcolor="#CAD7F7" topmargin="100">
		<div align="center">
			<form name="loginForm" method="post" action="/gaea/login">
				<table width="480" border="0" cellspacing="1" cellpadding="1"
					class="tableBorder">
					<tr>
						<td height="28" colspan="2" align="center"
							background="../images/guanli/admin_bg_1.gif" class="whitenormal">
							信息发布平台管理登陆
						</td>
					</tr>
					<tr>
						<td height="78" colspan="2"
							background="../images/guanli/dvbbs.jpg">
							&nbsp;
						</td>
					</tr>
					<tr bgcolor="#F2F3F5">
						<td width="30%" align="right" class="normalText">
							用户名：
						</td>
						<td width="70%">
							<input type="text" name="username" class="textBox">
						</td>
					</tr>
					<tr bgcolor="#F2F3F5">
						<td align="right" class="normalText">
							密&nbsp;&nbsp;码：
						</td>
						<td>
							<input type="password" name="password" class="textBox">
						</td>
					</tr>
					<tr align="center">
						<td colspan="2" bgcolor="#E4EEFA">
							<input type="button" name="Submit" value="提交"
								onClick="CheckForm()">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
