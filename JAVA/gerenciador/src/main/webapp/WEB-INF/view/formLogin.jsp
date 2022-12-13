<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:url value="/entrada" var="LinkServeletNovaEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Usuario</title>
</head>
<body>
	<h1>Login</h1>
		
		<form action="${LinkServeletNovaEmpresa}" method="post">
			<p>Login:- <input type="text" name="login"/></p>
			<p>Senha:- <input type="password" name="senha"/></p>
			<input type="hidden" name="acao" value="Login"/>
			<input type="submit"/>
		</form>
</body>
</html>