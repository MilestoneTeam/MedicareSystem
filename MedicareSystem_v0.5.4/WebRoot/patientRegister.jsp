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
    
    <title>ҽ������ϵͳ�����ʺ�ע��</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="Milestone ҽ������ϵͳ �û�ע��">
	<meta http-equiv="description" content="Register page for patient">

	<link rel="stylesheet" type="text/css" href="assets/style/all.css" />
	<link rel="stylesheet" type="text/css" href="assets/style/reg.css" />
  </head>
  
  <body>
  	<div class="outer">
	  	<div class="header">
	    	<h1>��ӭʹ��ҽ������ϵͳ</h1>
	    </div>
	 
		<div class="wraper">
			<h2>�ʺ�ע��</h2>
	     	<s:form action="doctorRegister" method="post">
		     	<s:textfield name="medicareNum" label="����ҽ������" required="true" cssClass="txt"/>
		     	<s:password name="password" label="��������" required="true" cssClass="txt" />
		     	<s:password name="reInputPassword" label="ȷ����������" required="true" cssClass="txt" />
		     	<s:submit value="�ύ" cssClass="button"></s:submit>
		     	<s:reset value="����" cssClass="button"></s:reset>
	     	</s:form>
		</div>
	
		<div class="footer">
			<p>Powered by <a href="techniqueSupport.jsp">Milestone</a>.2010&copy;</p>
		</div>
	</div>
	
  </body>
</html>
