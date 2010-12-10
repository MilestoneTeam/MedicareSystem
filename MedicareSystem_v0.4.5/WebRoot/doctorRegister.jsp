<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
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
  
  <body>&nbsp; 
    欢迎使用医保管理系统. <br>
	 <s:head/>
     <s:form action="doctorRegister" method="post">
     	<s:textfield name="physicianLicenseNum" label="请输入您的医师资格证号" required="true"/><br>
     	<s:password name="password" label="请输入密码" required="true"/><br>
     	<s:password name="reInputPassword" label="请再次输入密码" required="true"/><br>
     	<s:submit value="提交"></s:submit>
     	<s:reset value="重置"></s:reset>
     </s:form>

  </body>
</html>
