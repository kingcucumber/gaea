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

		<title>数图实验室</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="Content-Type" content="text/html;charset=gb2312">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>
	<%
		String username = (String) session.getAttribute("username");
		if (username == null || username.equals("")) {
			response.sendRedirect("login.jsp");
		}
	%>
	<body>
	<frameset rows="33,*" border=0 frameborder="yes" name="top_frame">
		<frame src="TopFrame.jsp?" noresize frameborder=no name="ads"
			scrolling="no" marginwidth="0" marginheight="0">
		<frameset rows="675" cols="175,*" border=0 name="down_frame">
			<frame src="LeftFrame.jsp" noresize name="list" marginwidth="0"
				marginheight="0">
			<frame src="RightFrame.jsp" name="main" marginwidth="0"
				marginheight="0">
		</frameset>
	</frameset>
	<noframes></noframes>

	</body>
</html>
