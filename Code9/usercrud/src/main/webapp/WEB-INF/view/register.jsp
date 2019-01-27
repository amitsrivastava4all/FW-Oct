<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
        rel="stylesheet">
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>


</head>
<body>
	<h1 class='alert-success'>Register Form</h1>
	<form action='doregister' method='post'>
	<div class='form-group'>
	<label>Userid</label>
	<input type='text' class='form-control' name='userid' placeholder='Type UserId Here'>
	</div>
	<div class='form-group'>
	<label>Password</label>
	<input type='password' class='form-control' name='password' placeholder='Type Password Here'>
	</div>
	<div class='form-group'>
	<label>Name</label>
	<input class='form-control' type='text' name='username' placeholder='Type User Name Here'>
	</div>
	<div class='form-group'>
	<button class='btn btn-primary' type='submit'>Register</button>
	</div>
	</form>
</body>
</html>