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
    
    <title>ҽ������ϵͳ����ҽ����¼</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content=MileStone ҽ������ϵͳ">
	<meta http-equiv="description" content="The login page for docor.">
	
	<link rel="stylesheet" type="text/css" href="assets/style/all.css" />
	<link rel="stylesheet" type="text/css" href="assets/style/login.css" />
  </head>
  
  <body> 
    <div class="header">
  		<h1>ҽ������ϵͳ</h1>
  	</div>
    <div class="wraper">
      <s:form action="doctorLogin" method="post">
        <s:textfield name="doctor.physicianLicenseNum" label="ҽʦ�ʸ�֤��" required="true"/>
     	<s:password name="doctor.password" label="����" required="true" />
     	<s:submit value="��¼"/>
     	<!--<input type="reset" value="����"/> -->
		<a href="doctorRegister.jsp" id="register">ע��</a>
     </s:form>
	</div>
	<div class="footer">
		<p>Powered by <a href="techniqueSupport.jsp">Milestone</a>.2010&copy;</p>
	</div>
  </body>
</html>
