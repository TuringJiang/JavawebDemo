<%@page import="javabean.User"%>
<%@page import="userdao.userdaoimpl.UserDao"%>
<%@page import="userdao.UserDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<form action="updateUserServlet" method="post">
		<h3 align="center">这是一个信息修改页面，欢迎使用。</h3>
		<h4 align="center">============美丽的分界线============</h4>
		<%
			UserDaoImpl userimpl = new UserDao();
			User user = new User();
			String updatenumber = request.getParameter("updatenumber");
			System.out.println("修改用户的number："+updatenumber);
			user = userimpl.findUserByNumber(updatenumber);
		%>
		<table align="center">
			<tr>
				<td>Number：</td>
				<td><input type="text" name="number" value="<%=user.getNumber() %>"></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" value="<%=user.getName() %>"></td>
			</tr>
			<tr>
				<td>Sex:</td>
				<td><input type="text" name="sex" value="<%=user.getSex() %>"></td>
			</tr>		
			<tr>
				<td>Beizhu:</td>
				<td><input  type="text" name="beizhu" value="<%=user.getBeizhu() %>"></td>
			</tr>
			<tr align="center">
				<td colspan="2">
					<input type="submit" value="修改" >
					<input  type="reset"  value="重置">
				</td>
			</tr>
	</table>
	
</form>

</body>
</html>