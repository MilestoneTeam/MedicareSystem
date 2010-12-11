<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>欢迎使用医保管理系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="MileStone 医保管理系统 用户登录">
	<meta http-equiv="description" content="The login page for patient.">
	
	<link rel="stylesheet" type="text/css" href="assets/style/all.css" />
	<link rel="stylesheet" type="text/css" href="assets/style/login.css" />
	<link rel="stylesheet" type="text/css" href="assets/style/tableForm.css" />
  </head>
  
  <body> 
  	<div class="header">
  		<h1>医保管理系统</h1>
  	</div>
  	
  	<div class="wrapper">
	     <s:form action="patientLogin" method="post">
	     	<s:textfield name="patient.medicareNum" label="医保卡号" required="true"/>
	     	<s:password name="patient.medicareNum" label="密码" required="true" /> 
			<s:submit value="登录" />
			<!--<s:reset value="重置" />-->
			<a href="patientRegister.jsp">注册</a>
	     </s:form>
	</div>
	
	<div class="footer">
		<p>Powered by <a href="">Milestone</a>.2010&copy;</p>
	</div>
  </body>
</html>
