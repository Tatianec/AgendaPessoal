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
	display: block;
	align-items: center;
	justify-content: center;
}

.container {
	width: 100%;
	margin-top: 1%;
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

.menu {
	width: 100%;
	background-color: #f2f2f2;
}

.menu ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
}

.menu li {
	float: left;
}

.menu li a {
	display: block;
	color: black;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

.menu li a:hover {
	background-color: #ddd;
}

.search-form {
	margin-top: 10px;
	margin-right: 20px;
	float: right;
}

.search-form input[type="text"] {
	padding: 5px;
	border: none;
	border-radius: 3px;
}

.search-form button {
	background-color: #337ab7;
	color: white;
	padding: 5px 10px;
	border: none;
	border-radius: 3px;
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="menu">
		<ul>
			<li><a href="registrarTarefas?id=${id}">Nova Tarefa</a></li>
		</ul>
	</div>
	<div class="container">
		<div class="search-form">
			<form method="GET" action="tarefas">
				<input type="text" name="filtro" placeholder="Filtrar por título">
				<button type="submit">Filtrar</button>
			</form>
		</div>

		<table>
			<tr>
				<th>Título</th>
				<th>Descrição</th>
				<th>Data da Criação</th>
				<th>Data da Conclusão</th>
				<th>Status</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach items="${tarefas}" var="tarefa">
				<tr>
					<td><c:out value="${tarefa.titulo}" /></td>
					<td><c:out value="${tarefa.descricao}" /></td>
					<td><c:out value="${tarefa.dataCriacao}" /></td>
					<td><c:out value="${tarefa.dataConclusao}" /></td>
					<td><c:out value="${tarefa.status}" /></td>
					<td><a href="editarTarefa?id=${tarefa.id}" class="Botao2">Editar</a></td>
					<td>
						<form method="post" action="excluirTarefa"
							onsubmit="return confirm('Tem certeza de que deseja excluir?')">
							<input type="hidden" name="id" value="${tarefa.id}">
							<button type="submit">Excluir</button>
						</form>

					</td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>
