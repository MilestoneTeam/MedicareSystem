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
    
    <title>ҽ������ϵͳ�����û�ע��</title>
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
    <h1>��ӭʹ��ҽ������ϵͳ</h1>
    </div>
    
    <div class="wraper">
    	<h2>�ʺ�ע��</h2>
     	<s:form action="doctorRegister" method="post">
	     	<s:textfield name="physicianLicenseNum" label="����ҽʦ�ʸ�֤��" required="true" cssClass="txt" />
	     	<s:password name="password" label="��������" required="true" cssClass="txt" />
	     	<s:password name="reInputPassword" label="ȷ����������" required="true" cssClass="txt" />
	     	<s:submit value="�ύ" cssClass="button"></s:submit>
	     	<s:reset value="����" cssClass="button"></s:reset>
     	</s:form>
    </div>

	<div class="footer">
		<p>Powered by <a href="">Milestone</a>.2010&copy;</p>
	</div>

  </body>
</html>
