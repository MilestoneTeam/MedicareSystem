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
    ��ӭʹ��ҽ������ϵͳ. <br>
	 <s:head/>
     <s:form action="doctorRegister" method="post">
     	<s:textfield name="physicianLicenseNum" label="����������ҽʦ�ʸ�֤��" required="true"/><br>
     	<s:password name="password" label="����������" required="true"/><br>
     	<s:password name="reInputPassword" label="���ٴ���������" required="true"/><br>
     	<s:submit value="�ύ"></s:submit>
     	<s:reset value="����"></s:reset>
     </s:form>

  </body>
</html>
