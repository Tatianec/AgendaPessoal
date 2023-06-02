<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
html, body {
	margin: 0;
	padding: 0;
	height: 100%;
	font-family: Arial, Helvetica, sans-serif;
}

h1 {
	text-align: center;
}

form {
	display: block;
	justify-content: center;
	align-items: center;
	height: 100%;
	margin-right: 20%;
	margin-left: 20%;
}

table {
	width: 80%;
}

td {
	padding-top: 10px;
}

input[type="text"], input[type="password"] {
	width: 100%;
	height: 30px;
}

input[type="submit"] {
	background-color: #4CAF50;
	color: white;
	width:140px;
	height: 40px;
	text-align: center;
	text-decoration: none;
	font-size: 14px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	margin-right: 40%;
	margin-left: 40%;
}
</style>
</head>
<body>
	<h1>Registro de Novo Usuario</h1>
	<form action="<%=request.getContextPath()%>/registerUsuario"
		method="post">
		<table>
			<tr>
				<td>Login:</td>
				<td><input type="text" name="login" /></td>
			</tr>
			<tr>
				<td>Senha:</td>
				<td><input type="password" name="senha" /></td>
			</tr>
			<tr>
				<td>Nome:</td>
				<td><input type="text" name="nome" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" /></td>
			</tr>
		</table>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>