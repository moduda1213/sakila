<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>Sakila Movie</h1>
	
	<div>
		<span>${LoginStaff.email}</span>�����ڴ� <!-- session.loginstaff -->
	</div>
	<div>
		<a href=${pageContext.request.contextPath}/auth/LogoutServlet>�α׾ƿ�</a>
	</div>
</body>
</html>
