<%@ page language="java" import="java.util.*,com.gaea.business.*,com.gaea.domain.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/mytag.tld" prefix="control" %>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>index</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   	<table width="100%" height="100%" border="1" cellpadding="0" cellspacing="0">
   		<tr>
   			<td background="images/front/bg_1.gif">新闻：</td>
   		</tr>
   		<tr>
   			<td valign="top"> <control:news/> </td>
   		</tr>
   		<tr><td>     &nbsp; </td> </tr>
   		<tr>
   			<td background="images/front/bg_1.gif">在研项目：</td>
   		</tr>
   		<tr>
   			<td valign="top">
   				<%ArrayList pl = (ArrayList)Project_Manager.getProjectList(); %>
   				<div align="center">
   				<table width="100%" border="0" cellspacing="1" cellpadding="1" class="table Border" >
   					<%
   						Iterator iter = pl.iterator();
   						while(iter.hasNext()){
   							Project pro = (Project)iter.next();
   					 %>
   					<tr bgcolor="E4EDF9">
   					 	<td align="center" class="titleText">
   					 		<%=pro.getName() %>
   					 	</td>
   						<td > value&nbsp;</td>
   					</tr>
   					<tr bgcolor="F1F3F5">
   						<td width="20%" align="center" class="normalText">起始时间：</td>
   						<td width="80%" class="normalText">
   							<%=pro.getTime() %>
   						</td>
   					</tr>
   					<tr bgcolor="F1F3F5">
   						<td align="center" class="normalText">简介：</td>
   						<td class="normalText">
   							<%=pro.getInfo() %>
   						</td>
   						</tr>
   					<tr>
   						<td colspan="2">&nbsp;</td>
   					</tr>
   				<%
   				}
   				 %>
   				</table>
   				</div>
   			</td>
   	</table>
  </body>
</html>
