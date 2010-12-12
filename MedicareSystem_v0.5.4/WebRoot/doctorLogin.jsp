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
    
    <title>医保管理系统——医生登录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content=MileStone 医保管理系统">
	<meta http-equiv="description" content="The login page for docor.">
	
	<link rel="stylesheet" type="text/css" href="assets/style/all.css" />
	<link rel="stylesheet" type="text/css" href="assets/style/login.css" />
  </head>
  
  <body> 
    <div class="header">
  		<h1>医保管理系统</h1>
  	</div>
    <div class="wraper">
      <s:form action="doctorLogin" method="post">
        <s:textfield name="doctor.physicianLicenseNum" label="医师资格证号" required="true"/>
     	<s:password name="doctor.password" label="密码" required="true" />
     	<s:submit value="登录"/>
     	<!--<input type="reset" value="重置"/> -->
		<a href="doctorRegister.jsp" id="register">注册</a>
     </s:form>
	</div>
	<div class="footer">
		<p>Powered by <a href="techniqueSupport.jsp">Milestone</a>.2010&copy;</p>
	</div>
  </body>
</html>
