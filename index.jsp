<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@page import="hibernate.dao.*" %>
<%@page import="hibernate.vo.*" %>
<%@page import="org.hibernate.*" %>

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
  
  <body>
    This is my JSP page. <br>
    
    <%
    /*
    	UserDAO dao = new UserDAO();
    	dao.getSession().beginTransaction();
		List<User> list = dao.findAll();
		out.print(list.get(1).getName());
		out.print(list.get(1).getPassword());
	*/
     %>
     <form action="login.action" method="post">
     	用户名: <input type="text" name="name"/><br>
     	密码: <input type="password" name="password"/><br>
     	<input type="submit" value="登录"/>
     	<input type="reset" value="重置"/>
     </form>
  </body>
</html>
