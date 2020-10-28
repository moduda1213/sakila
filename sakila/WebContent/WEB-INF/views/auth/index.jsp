<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<style>
	div.row{
		background-color:primary;
	}
</style>
</head>
<body>
	<div>
		<div class="row">
			<div class="col-sm-3 bg-secondary">
				<jsp:include page="/menu/menu.jsp"></jsp:include>
			</div>
			<div class="col-sm-9">
				<p></p>
				<p></p>
				<h3>Index</h3>
				<hr>
				<p>
					Sakila 프로젝트 설명
				</p>
				<p> (대충 Sakila 프로젝트 설명하는 글)</p>
			</div>
		</div>
	</div>
</body>
</html>