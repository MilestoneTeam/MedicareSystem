<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="hibernate.dao.*" %>
<%@ page import="hibernate.vo.*" %>
<%@ page import="org.hibernate.*" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
    医生登陆页. <br>
    
     <form action="<%=path%>/doctorLogin.action" method="post">
     	医生资格证号: <input type="text" name="doctor.physicianLicenseNum"/><br>
     	密码: <input type="password" name="doctor.password"/><br>
     	<input type="submit" value="登录"/>
     	<input type="reset" value="重置"/>
     </form>

  </body>
</html>
