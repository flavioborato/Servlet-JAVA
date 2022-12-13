<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
        <c:url value="/entrada" var="LinkServeletListaEmpresas"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Empresas cadastradas</title>
</head>
	<body>
	<h1>Status do Cadastro da Empresas</h1>
		<c:if test="${not empty empresanome}">
			Empresa ${empresanome}  cadastrada com sucesso!!!<br/>
			CNPJ - ${empresacnpj} <br/>
			Data - <fmt:formatDate value="${empresadata}" pattern="dd/MM/yyyy"/>
		</c:if> 
		<c:if test="${empty empresanome}">
			Nenhuma Empresa Cadastrada!!!
		</c:if> 
		<form action="${LinkServeletListaEmpresas}" method="post">
		<input type="hidden" name="acao" value="ListaEmpresas"/>
			<input type="submit"/>
		</form>

	<c:import url="logout-parcial.jsp"/>
	</body>
</html>