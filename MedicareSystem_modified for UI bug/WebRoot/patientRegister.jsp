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
    
    <title>医保管理系统——帐号注册</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="Milestone 医保管理系统 用户注册">
	<meta http-equiv="description" content="Register page for patient">

	<link rel="stylesheet" type="text/css" href="assets/style/all.css" />
	<link rel="stylesheet" type="text/css" href="assets/style/reg.css" />
  </head>
  
  <body>
  	<!--<div class="outer">
	  	<div class="header">
	    	<h1>欢迎使用医保管理系统</h1>
	    </div>
		<div class="wraper">
			<h2>帐号注册</h2>
	     	<s:form action="doctorRegister" method="post">
		     	<s:textfield name="medicareNum" label="您的医保卡号" required="true" cssClass="txt"/>
		     	<s:password name="password" label="您的密码" required="true" cssClass="txt" />
		     	<s:password name="reInputPassword" label="确认您的密码" required="true" cssClass="txt" />
		     	<s:submit value="提交" cssClass="button"></s:submit>
		     	<s:reset value="重置" cssClass="button"></s:reset>
	     	</s:form>
		</div>
		<div class="footer">
			<p>Powered by <a href="techniqueSupport.jsp">Milestone</a>.2010&copy;</p>
		</div>
	</div>-->
	
	<div id="top"><h1>欢迎使用医保管理系统</h1></div>
	<div id="main">
		<div class="title"><h2>用户注册</h2></div>
		<div class="register">
			<h3>帐号信息</h3>
			<form acton="patientRegister" method="post" class="form">
				<dl>
				<dt><label for="account">医保卡号<span class="required">*</span>：</label></dt>
				<dd><input type="text" name="medicareNum" id="account" class="txt" /></dd>
				</dl>
				<dl class="interlace">
				<dt><label for="password">密码<span class="required">*</span>：</label></dt>
				<dd><input type="password" name="password" id="password" class="txt" /></dd>
				</dl>
				<dl>
				<dt><label for="repassword">确认密码<span class="required">*</span>：</label></dt>
				<dd><input type="password" name="reInputPassword" id="repassword" class="txt" /></dd>
				</dl>
				<p class="button"><input type="submit" value="提交" class="hand" /></p>
				<a href="patientLogin.jsp">返回首页</a>
			</form>
		</div>
	</div>
	<div id="bottom"><p>Copyright &copy; 2010 MileStone</p></div>
	
  </body>
</html>
