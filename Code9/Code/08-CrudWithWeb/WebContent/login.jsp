<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<h1>Login Page</h1>
<form role="form" method="post" action="usercontroller">
<div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" name="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" name="pwd" class="form-control" id="exampleInputPassword1" placeholder="Password">
  </div>
  <button type="submit" name="operation" value="add" class="btn btn-success">Add New User</button>
  <button type="submit" name="operation" value="delete" class="btn btn-danger">Delete</button>
  <button type="submit" name="operation" value="update" class="btn btn-info">Update</button>
  <button type="submit" name="operation" value="login" class="btn btn-primary">Login</button>
</form>
</body>
</html>