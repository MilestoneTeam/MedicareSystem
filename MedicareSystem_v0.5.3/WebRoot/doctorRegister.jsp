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
    
    <title>医保管理系统——用户注册</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="assets/style/all.css" />
	<link rel="stylesheet" type="text/css" href="assets/style/reg.css" />
  </head>
  
  <body>
  	<div class="header">
    <h1>欢迎使用医保管理系统</h1>
    </div>
    
    <div class="wraper">
    	<h2>帐号注册</h2>
     	<s:form action="doctorRegister" method="post">
	     	<s:textfield name="physicianLicenseNum" label="您的医师资格证号" required="true" cssClass="txt" />
	     	<s:password name="password" label="您的密码" required="true" cssClass="txt" />
	     	<s:password name="reInputPassword" label="确认您的密码" required="true" cssClass="txt" />
	     	<s:submit value="提交" cssClass="button"></s:submit>
	     	<s:reset value="重置" cssClass="button"></s:reset>
     	</s:form>
    </div>

	<div class="footer">
		<p>Powered by <a href="">Milestone</a>.2010&copy;</p>
	</div>

  </body>
</html>
