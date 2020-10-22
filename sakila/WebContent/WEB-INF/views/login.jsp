<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginForm</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<!-- jquery cdn 주소 : https://developers.google.com/speed/libraries#jquery -->
</head>
<body>
	<div>&nbsp;</div>
	<div>&nbsp;</div>
	<div>&nbsp;</div>
	<div>&nbsp;</div>
	<div>&nbsp;</div>
	<div>&nbsp;</div>
	<div>&nbsp;</div>
 
	<div>
		오늘 접속자 수 : ${state.count}
	</div>
	<div>
		총 접속자 수 : ${totalCount}
	</div>
	<div class="container">
		<div class="row">
			<div class="col"></div>
			<div class="col">
				<div class="row">
					<div class="col"></div>
					<div class="col">
						<i class='fas fa-user-circle' style='font-size:120px'></i>
					</div>
					<div class="col"></div>
				</div>
	
				<div>&nbsp;</div>
				
				<form method="post">
					<div>
						<input type="text" name ="id" placeholder="ID" class="form-control form-control">
					</div>
					<div>&nbsp;</div>
					<div>
						<input type="password" name ="pw" placeholder="PW" class="form-control form-control">
					</div>
					<div>&nbsp;</div>
					<div class="row">
						<div class="col"></div>
						<div class="col">
							<button type="submit" class="btn btn-primary" style="width:350px">Log-in</button>
						</div>
						<div class="col"></div>
					</div>
				</form>
			</div>
			<div class="col"></div>
		</div>
	</div>
</body>
</html>