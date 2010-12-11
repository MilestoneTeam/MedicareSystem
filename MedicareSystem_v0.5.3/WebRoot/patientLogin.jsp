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
    
    <title>��ӭʹ��ҽ������ϵͳ</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="MileStone ҽ������ϵͳ �û���¼">
	<meta http-equiv="description" content="The login page for patient.">
	
	<link rel="stylesheet" type="text/css" href="assets/style/all.css" />
	<link rel="stylesheet" type="text/css" href="assets/style/login.css" />
	<link rel="stylesheet" type="text/css" href="assets/style/tableForm.css" />
  </head>
  
  <body> 
  	<div class="header">
  		<h1>ҽ������ϵͳ</h1>
  	</div>
  	
  	<div class="wrapper">
	     <s:form action="patientLogin" method="post">
	     	<s:textfield name="patient.medicareNum" label="ҽ������" required="true"/>
	     	<s:password name="patient.medicareNum" label="����" required="true" /> 
			<s:submit value="��¼" />
			<!--<s:reset value="����" />-->
			<a href="patientRegister.jsp">ע��</a>
	     </s:form>
	</div>
	
	<div class="footer">
		<p>Powered by <a href="">Milestone</a>.2010&copy;</p>
	</div>
  </body>
</html>
