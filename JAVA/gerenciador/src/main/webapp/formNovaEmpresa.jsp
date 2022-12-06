<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <c:url value="/entrada" var="LinkServeletNovaEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrando Empresas</title>
</head>
<body>
	<h1>Cadastro de Empresas</h1>
		
		<form action="${LinkServeletNovaEmpresa}" method="post">
			<p>Nome:- <input type="text" name="nome"/></p>
			<p>CNPJ:- <input type="text" name="CNPJ"/></p>
			<p>Data Abertura:- <input type="text" name="data"/></p>
			<input type="hidden" name="acao" value="NovaEmpresa"/>
			<input type="submit"/>
		</form>
</body>
</html>