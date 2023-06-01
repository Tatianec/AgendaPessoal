<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.Tarefa"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Tarefa</title>
<style>
body {
	display: flex;
	align-items: center;
	justify-content: center;
	height: 50vh;
	margin: 0;
	padding: 0;
	font-size: 20px;
}

.container {
	width: 80%;
	max-width: 600px;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-bottom: 20px;
}

th, td {
	padding: 20px;
	text-align: center;
	border-bottom: 1px solid #ddd;
	width: 250px;
	height: 30px;
}

th {
	background-color: #f2f2f2;
}

input[type="text"], input[type="checkbox"] {
	width: 100%;
	padding: 6px;
	border: 1px solid #ccc;
	border-radius: 4px;
	height: 20px;
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
	<div class="container">
		<form method="post">
			<table>
				<tr>
					<th>Título</th>
					<th>Descrição</th>
					<th>Status</th>
				</tr>
				<tr>
					<td><input type="text" name="titulo"
						value="${tarefa.getTitulo()}" /></td>
					<td><input type="text" name="descricao"
						value="${tarefa.getDescricao()}" /></td>
					<td><input type="checkbox" name="concluido" value="concluido"
						${"Concluído".equals(tarefa.getStatus()) ? 'checked' : ''} />
						Concluído</td>
				</tr>
			</table>
			<input type="submit" value="salvar" />
		</form>
	</div>
</body>
</html>