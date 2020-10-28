<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
ul{
   list-style:none;
   padding-left:0px;
   }
</style>
</head>
<body>
<div>
		<div>
			<h3>Sakila Movie</h3>
		</div>
		<table>
			<tr>
				<td rowspan="2"><a href="#">그림</a></td>
				<td><a href="#"><span>${loginStaff.storeId}</span> 지점</a></td>
			</tr>
			<tr>
				<td><a href="#"><span>${loginStaff.userName}</span>관리자님</a></td>
			</tr>
		</table>
		<div>
			<a type = "button" id="logout" href=${pageContext.request.contextPath}/auth/LogoutServlet>로그아웃</a>
		</div>
		
		<br>
		<br>
		<br>
		
		<ul>
			<li><a href="#">홈</a></li>
			<li><br></li>
			<li><a href="#">영화 반납</a></li>
			<li><hr></li>
			<li><a href="#">회원목록 관리</a></li>
			<li><a href="#">영화목록 관리</a></li>
			<li><a href="#">영화재고 관리</a></li>
			<li><a href="#">영화배우 관리</a></li>
			<li><a href="#">영화 출연배우 등록</a></li>
			<li><hr></li>
			<li><a href="#">매장통계</a></li>
			<li><a href="#">MVP</a></li>
		</ul>
	</div>
</body>
</html>