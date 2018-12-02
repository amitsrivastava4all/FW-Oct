<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function doajax(){
	const url = "http://localhost:8080/users";
	var promise = fetch(url);
	promise.then(response=>{
		response.json().then(data=>{
			console.log("Here is the json ",data);
			printTable(data);
		}).catch(err=>{
			console.log("Invalid JSON Error is ",err);
		})
	}).catch(e=>{
		console.log("Invalud URL "+e);
	});;
}
function printTable(data){
	var tbody = document.querySelector("#result");
	for(let d of data.users){
		var tr = tbody.insertRow();
		tr.insertCell(0).innerText = d.userid;
		tr.insertCell(1).innerText = d.password;
	}
}

</script>
</head>
<body>
<h1>I am JSP , Session is ${sessionScope.uid }</h1>
<button onclick="doajax()">Get Data</button>
<table border="1">
<thead>
<tr><th>Userid</th><th>Password</th></tr>
</thead>
<tbody id="result">
</tbody>
</table>
</body>
</html>