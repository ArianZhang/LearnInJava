<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>
		您好：${username} [<a href="<%=request.getContextPath()%>/LogoutServlet">注销</a>]
	</h3>
	当前在线用户：
	<table>
		<%
		    List onlineUserList = (List) application.getAttribute("onlineUserList");
		    for (int i = 0; i < onlineUserList.size(); i++) {
		        String onlineUsername = (String) onlineUserList.get(i);
		%>
		<tr>
			<td><%=onlineUsername%></td>
		</tr>
		<%
		    }
		%>
	</table>
</body>
</html>