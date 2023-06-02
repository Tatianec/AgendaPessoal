<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Registro de Novo Usuario</h1>
  <form action="<%= request.getContextPath() %>/registerUsuario" method="post">
   <table style="with: 80%">
    <tr>
     <td>Login</td>
     <td><input type="text" name="login" /></td>
    </tr>
    <tr>
     <td>Senha</td>
     <td><input type="password" name="senha" /></td>
    </tr>
    <tr>
     <td>Nome</td>
     <td><input type="text" name="nome" /></td>
    </tr>
    <tr>
     <td>Email</td>
     <td><input type="text" name="email" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
</body>
</html>