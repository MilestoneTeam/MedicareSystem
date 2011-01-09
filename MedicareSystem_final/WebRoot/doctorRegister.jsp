<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	
	<script type="text/javascript" src="assets/script/jQuery.js"></script>
	<script type="text/javascript" src="assets/script/artDialog/artDialog.min.js"></script>
	<script type="text/javascript">
	<!--
		// 设置对话框全局默认配置
		(function(){
		    var d = art.dialog.defaults;
		    
		    // 按需加载要用到的皮肤
		    d.skin = ['default', 'chrome'];
		    
		    // 超过此面积大小的对话框使用替身拖动
		    d.showTemp = 100000;
		})();
	-->
	</script>
	<script type="text/javascript" src="assets/script/app/regApp.js"></script>
  </head>
  
  <body>
  	<!--<div class="header">
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
		<p>Powered by <a href="techniqueSupport.jsp">Milestone</a>.2010&copy;</p>
	</div>-->
	<%
		if (request.getAttribute("fail") != null) {
	%>
		<script type="text/javascript">
			art.dialog({
				skin: 'chrome',
				fixed: true,
				lock: true,
				drag: false,
				title: '医保管理系统',
				content: '帐号信息有误',
				yesFn: false,
				noFn: false
			});
		</script>
	<% 
		}
	%>
	
	<div id="top"><h1>欢迎使用医保管理系统</h1></div>
	<div id="main">
		<div class="title"><h2>用户注册</h2></div>
		<div class="register">
			<h3>帐号信息</h3>
			<form action="doctorRegister" method="post" id="regForm" class="form">
				<dl>
				<dt><label for="account">医师资格证号<span class="required">*</span>：</label></dt>
				<dd>
					<input type="text" name="physicianLicenseNum" id="account" class="txt" />
					<p class="msg"></p>
				</dd>
				</dl>
				<dl class="interlace">
				<dt><label for="password">密码<span class="required">*</span>：</label></dt>
				<dd>
					<input type="password" name="password" id="password" class="txt" />
					<p class="msg"></p>
				</dd>
				</dl>
				<dl>
				<dt><label for="repassword">确认密码<span class="required">*</span>：</label></dt>
				<dd>
					<input type="password" name="reInputPassword" id="repassword" class="txt" />
					<p class="msg"></p>
				</dd>
				</dl>
				<p class="button"><input type="submit" value="提交" class="hand" /></p>
				<a href="doctorLogin.jsp">返回首页</a>
			</form>
		</div>
	</div>
	<div id="bottom"><p>Copyright &copy; 2010 MileStone</p></div>
  </body>
</html>
