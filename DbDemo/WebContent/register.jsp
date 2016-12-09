<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	<form action="registerUserServlet" method="psot" >
		<h3 align="center">这是一个注册页面，欢迎使用。</h3>
		<h4 align="center">============美丽的分界线============</h4>
		<%
		if((request.getParameter("number")=="" ||request.getParameter("number")==null )&& 
				(request.getParameter("name")=="" || request.getParameter("name")==null)){
			%>
			<h4 align="center">请输入number & name完成注册</h4>
			<%
		}else{
		%>
		<% if (request.getParameter("number")==""||request.getParameter("number")==null){
			%>
			<h4 align="center">账号==不能为空</h4>
			<%
		}if(request.getParameter("name")==null || request.getParameter("name")==""){
			%>
			<h4 align="center">姓名==不能为空</h4>
			<%
		}}
			%>
		<table align="center">
			<tr>
				<td>Number：</td>
				<td><input type="text" name="number"></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Sex:</td>
				<td><input type="text" name="sex" ></td>
			</tr>		
			<tr>
				<td>Beizhu:</td>
				<td><input  type="text" name="beizhu" ></td>
			</tr>
			<tr align="center">
				<td colspan="2">
					<input type="submit" value="注册" >
					<input type="reset" value="重置">
					<a href="loginUserServlet"><input type="button" value="登陆"></a>
				</td>
			</tr>
		</table>
		
	</form>

</body>
</html>