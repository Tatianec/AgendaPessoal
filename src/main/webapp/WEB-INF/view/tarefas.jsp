<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tarefas</title>
<style>
body {
	margin: 0;
	padding: 0;
	display: flex;
	align-items: center;
	justify-content: center;
}

.container {
	width: 100%;
	margin: 10px;
}

table {
	width: 100%;
	margin-top: 2px;
}

td {
	height: 20px;
	width: 250px;
	text-align: center;
	border-bottom: 2px solid #ddd;
}

th {
	background-color: #696969;
	height: 20px;
	width: 250px;
	border-bottom: 2px solid #ddd;
	font-size: 20px;
}

tr:nth-child(even) {
	background-color: #D3D3D3;
}

a {
	text-decoration: none;
	color: #337ab7;
}

button {
	background-color: #FF0000;
	color: white;
	padding: 6px 12px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

.Botao1 {
	display: inline-block;
	background-color: #32CD32;
	color: white;
	padding: 8px 16px;
	text-align: center;
	text-decoration: none;
	font-size: 14px;
	border-radius: 4px;
	transition: background-color 0.3s ease;
}

.Botao1:hover {
	background-color: #45a049;
}

.Botao2 {
	background-color: #FFA500;
	color: white;
	padding: 6px 12px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}


.Botao2:hover {
	background-color: #FF8C00;
}

</style>
</head>
<body>
	<div class="container">
		<table>
			<tr>
				<th>Título</th>
				<th>Descrição</th>
				<th>Data Criação</th>
				<th>Data Conclusão</th>
				<th>Status</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach items="${requestScope.tarefas}" var="c">
				<tr>
					<td>${c.getTitulo()}</td>
					<td>${c.getDescricao()}</td>
					<td>${c.getDataCriacao()}</td>
					<td>${c.getDataConclusao()}</td>
					<td>${c.getStatus()}</td>
					<td><a href="editarTarefa?id=${c.getId()}" class="Botao2">Editar</a></td>
					<td>
						<form method="post" action="excluirTarefa">
							<input type="hidden" name="id" value="${c.getId()}">
							<button type="submit">Excluir</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
		<a href="registrarTarefas?id=${id}" class="Botao1">Nova Tarefa</a>
	</div>
</body>
</html>