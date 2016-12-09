<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="java.util.*,javabean.User,java.util.Iterator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body >
	<h3 align="center">这是一个测试成功的页面，显示数据库中的所有用户。</h3>
	<h4 align="center">============美丽的分界线============</h4>
	<p>
	<h3>当前用户：${name }</h3>
	<a href="exitUserServlet"><input type="button" name="exit" value="退出"></a>
	</p>
	<form action="findUserByServlet" method="post">
	<p align="center">
		输入Number：
		<input type="text" name="number" >
		<input type="submit" value="按条件查找" >
		<a href="selectUserServlet"><input type="button" value="显示全部"></a>
	</p>
	</form>
	<table align="center" border="2">
		<tr>
			<th>学号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>备注</th>
			<th>操作</th>
		</tr>
	<%List<User> userlist = (List<User>) session.getAttribute("userlist");
	if(userlist!=null){
	  Iterator<User> it = userlist.iterator();
	  while(it.hasNext()){
		  User user = it.next();
	   %>
		<tr>
			<td>
				<%=user.getNumber() %>
			</td>
			<td>
				<%=user.getName() %>
			</td>
			<td>
				<%=user.getSex() %>
			</td>
			<td>
				<%=user.getBeizhu() %>
			</td>
			<td>
				<a href = "updateuser.jsp?updatenumber=<%= user.getNumber()%>">修改</a>
				&nbsp;<a href = "deleteUserServlet?number=<%= user.getNumber()%>">删除</a>
			</td>
		</tr>
		<% 
	  }
	  }
	else{
		%>
		<h3>userlist列表是空的，没有数据可以显示。</h3>
		<%
	}
	%>
		</table>
		</br>
</body>
</html>