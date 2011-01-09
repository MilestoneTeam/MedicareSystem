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
    
    <title>医保管理系统——医生登录</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content=MileStone 医保管理系统">
	<meta http-equiv="description" content="The login page for docor.">
	
	<link rel="stylesheet" type="text/css" href="assets/style/all.css" />
	<link rel="stylesheet" type="text/css" href="assets/style/login.css" />
	
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
	<script type="text/javascript" src="assets/script/app/loginApp.js"></script>
  </head>
  
  <body> 
    <!--<div class="header">
  		<h1>医保管理系统</h1>
  	</div>
    <div class="wraper">
      <s:form action="doctorLogin" method="post">
        <s:textfield name="doctor.physicianLicenseNum" label="医师资格证号" required="true"/>
     	<s:password name="doctor.password" label="密码" required="true" />
     	<s:submit value="登录"/>
     	<input type="reset" value="重置"/>
		<a href="doctorRegister.jsp" id="register">注册</a>
     </s:form>
	</div>
	<div class="footer">
		<p>Powered by <a href="techniqueSupport.jsp">Milestone</a>.2010&copy;</p>
	</div>-->
	
	<%
		if (request.getAttribute("fail") != null) {
	%>
		<script type="text/javascript">
			var content = '<p>请输入正确帐号信息，完成登录！</p> \
						   <p>您也可以现在进行<a href="doctorRegister.jsp">注册</a></p>';
			art.dialog({
				skin: 'chrome',
				fixed: true,
				lock: true,
				drag: false,
				title: '医保管理系统',
				content: content,
				yesFn: false,
				noFn: false
			});
		</script>
	<% 
		}
	%>
	
	<div id="top"></div>
	<div id="main">
		<div class="col">
			<div class="col-inner">
				<h1 class="logo">医保管理系统</h1>
				<ul class="description">
					<li>1-轻松完成医疗管理的首选方案...</li>
					<li>2-无须挂号的整合方式，方便用户使用...</li>
					<li>3-强大的后台系统，管理易如反掌...</li>
				</ul>
				<p class="about"><span>?</span><a href="techniqueSupport.jsp">关于我们</a></p>
			</div>
		</div>
		<div class="col col-last">
			<div class="col-inner col-inner-last">
				<h2 class="form-title">登录医保管理系统</h2>
				<form action="doctorLogin" method="post" id="loginForm" class="form">
					<dl>
						<dt><label for="account">帐 号：</label></dt>
						<dd><input type="text" name="doctor.physicianLicenseNum" id="account" class="txt"／></dd>
					</dl>
					<dl>
						<dt><label for="password">密 码：</label></dt>
						<dd><input type="password" name="doctor.password" id="password" class="txt" /></dd>
					</dl>
					<input type="submit" value="登录" class="hand" />
					<p class="reg"><a href="doctorRegister.jsp">注册帐号</a></p>
				</form>
			</div>
		</div>
	</div>
	<div id="bottom"><p class="copy">Copyright &copy; 2010 MileStone</p></div>
  </body>
</html>
