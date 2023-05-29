<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tarefas</title>
</head>
<body>
	<table style="width: 80%">
		<tr>
			<th>Título</th>
			<th>Descrição</th>
			<th>Data Criação</th>
			<th>Data Conclusão</th>
			<th>Status</th>
			<th>Editar</th>
		</tr>
		<c:forEach items="${requestScope.tarefas}" var="c">
			<tr>
				<td>${c.getTitulo()}</td>
				<td>${c.getDescricao()}</td>
				<td>${c.getDataCriacao()}</td>
				<td>${c.getDataConclusao()}</td>
				<td>${c.getStatus()}</td>
				<td><a href="editarTarefa?id=${c.getId()}">Editar</a></td>
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
</body>
</html>