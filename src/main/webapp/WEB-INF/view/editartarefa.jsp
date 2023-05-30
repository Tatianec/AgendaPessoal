<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.Tarefa"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Tarefa</title>
</head>
<body>
	<form method="post">
		<table style="width: 80%">
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
					${"Concluído".equals(tarefa.getStatus()) ? 'checked' : ''} /> Concluído
				</td>
			</tr>
		</table>
		<input type="submit" value="salvar" />
	</form>
</body>
</html>