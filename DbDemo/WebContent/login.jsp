<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="loginUserServlet" method="post">
		<h3 align="center">你好，欢迎欢迎，热烈欢迎。</h3>
		<h4 align="center">============美丽的分界线============</h4>
		<%if(session.getAttribute("ok")==null){session.setAttribute("ok", "欢迎使用");} %>
		<h4 align="center"><%=session.getAttribute("ok")%></h4>
		<table align="center">
			<tr>
				<td>学 号：</td>
				<td><input type="text" name="number" ></td>
			</tr>
			<tr>
				<td>姓 名：</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="登陆">
					<input type="reset" value="重置">
				</td>
			</tr>
		</table>
	</form>
		<h5 align="center"><a href="register.jsp">点击注册</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="login.jsp">忘记密码</a></h5>
</body>
</html>