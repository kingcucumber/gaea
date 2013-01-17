<%@ page language="java"
	import="java.util.*,com.gaea.business.*,com.gaea.domain.*"
	pageEncoding="UTF-8"%>
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

		<title>reseachProject</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body topmargin="30">
		<div align="center">
			<table width="79%" border="1" cellspacing="0" cellpadding="0">
				<tr>
					<td height="62" align="center">
						<H1 align="center">
							<font face="Arial Black" size="7">科研信息发布平台</font>
						</H1>
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;&nbsp;&gt;&gt;
						<a href="index.jsp" target="_self">首页</a> |
						<a href="news.jsp" target="_self">新闻</a> |
						<a href="researchProject.jsp" target="_self">在研项目</a> |
						<a href="production.jsp" target="_self">研究成果</a> |
						<a href="teachers.jsp" target="_self">老师信息</a> |
						<a href="members.jsp" target="_self">学生信息</a> |
						<a href="down2.jsp" target="_self">软件下载</a> |
						<a href="reg.jsp" target="_self">用户注册</a>
					</td>
				</tr>

				<tr>
					<td  align="center" valign="top"
						background="images/front/bg_1.gif">
						在研项目：
					</td>
				</tr>
				<tr>
					<td height="329" valign="top">
						<%
							ArrayList pl = (ArrayList) Project_Manager.getProjectList();
						%>
						<div align="center">
							<table  width="100%" border="0" cellspacing="1" cellpadding="1"
								class="table Border">
								<%
									Iterator iter = pl.iterator();
									while (iter.hasNext()) {
										Project pro = (Project) iter.next();
								%>
								<tr bgcolor="E4EDF9">
									<td align="center" class="titleText">
										<%=pro.getName()%>
									</td>
									<td>
										value&nbsp;
									</td>
								</tr>
								<tr bgcolor="F1F3F5">
									<td width="20%" align="center" class="normalText">
										起始时间：
									</td>
									<td width="80%" class="normalText">
										<%=pro.getTime()%>
									</td>
								</tr>
								<tr bgcolor="F1F3F5">
									<td align="center" class="normalText">
										简介：
									</td>
									<td class="normalText">
										<%=pro.getInfo()%>
									</td>
								</tr>
								<tr>
									<td colspan="2">
										&nbsp;
									</td>
								</tr>
								<%
									}
								%>
							</table>
						</div>
					</td>
			</table>
		</div>

	</body>
</html>
