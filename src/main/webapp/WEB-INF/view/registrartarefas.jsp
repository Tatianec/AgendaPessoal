<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar Tarefa</title>
<style>
* {
	margin: 0;
	padding: 0;
	font-family: Arial, Helvetica, sans-serif;
}

form {
	width: 50%;
	margin-left: 25%;
	margin-right: 25%;
}

h1 {
	text-align: center;
	margin-top: 20px;
}

table {
	width: 100%;
	margin-bottom: 20px;
	margin-top: 30px;
}

td {
	height: 30px;
}

input[type="text"] {
	margin-top: 10px;
	width: 100%;
	height: 30px;
	border: 1px solid #ccc;
	border-radius: 4px;
	padding: 6px;
}

input[type="submit"] {
	background-color: #4CAF50;
	color: white;
	padding: 8px 16px;
	text-align: center;
	text-decoration: none;
	font-size: 14px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}
</style>
</head>
<body>
	<h1>Registrar Tarefa</h1>
	<% if (request.getAttribute("error") != null) { %>
	<p style="color: red; text-align: center; margin-top: 20px;"><%= request.getAttribute("error") %></p>
	<% } %>
	<form method="post">
		<table>
			<tr>
				<td><label for="titulo">Titulo:</label></td>
				<td><input type="text" id="titulo" name="titulo" /></td>
			</tr>
			<tr>
				<td><label for="descricao">Descri��o:</label></td>
				<td><input type="text" id="descricao" name="descricao" /></td>
			</tr>
		</table>
		<input type="submit" value="cadastrar" />
	</form>
</body>
</html>
