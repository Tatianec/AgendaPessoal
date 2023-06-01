<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>
* {
	margin: 0;
	padding: 0;
	font-family: Arial, Helvetica, sans-serif;
}

h1 {
	color: gray;
	text-align: center;
	margin-top: 10%;
	margin-left: 5%;
	font-size: 40px;
}

table {
	width: 80%;
	margin: 0 auto;
}

td {
	height: 50px; 
	font-size : 25px;
}

input[type="text"], input[type="password"] {
	width: 100%;
	padding: 1px;
	height: 30px; 
	border: 1px solid #ccc;
	border-radius: 3px;
}

input[type="submit"] {
	width: 20%;
	padding: 2px;
	height: 30px; 
	margin-left: 50%;
	margin-right: 30%;
	background-color: black;
	color: white;
	border: none;
	border-radius: 3px;
	cursor: pointer;
	border-radius: 3px;
}

form {
	width: 50%;
	margin-left: 25%;
	margin-right: 25%;
	margin-top: 5%;
}

</style>
</head>
<body>
	<h1>Informe os dados para login</h1>
	<form action="<%=request.getContextPath()%>/login" method="post">
		<table style="with: 80%">
			<tr>
				<td>Login:</td>
				<td><input type="text" name="login" /></td>
			</tr>
			<tr>
				<td>Senha:</td>
				<td><input type="password" name="senha" /></td>
			</tr>
		</table>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>