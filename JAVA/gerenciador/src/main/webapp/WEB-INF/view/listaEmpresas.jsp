<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
     <c:url value="/removeEmpresa?id=${empresa.id}" var="LinkServeleRemoveEmpresa"/>
     <c:url value="/entrada" var="LinkServeletNovaEmpresa"/>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Empresas</title>
</head>
<body>
		<div>
			<p>Usuario Logado:${usuarioLogado.login}</p>
		</div>
		<h1>Teste de listas de Empresas</br></h1>
		
			<ul>
				<c:forEach items="${empresas}" var="empresa">
					<li>Nome:-${empresa.nome} // 
						CNPJ:-${empresa.cnpj} // 
						<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy - hh-mm"/>
						<a href="/gerenciador/entrada?acao=MostraEmpresas&id=${empresa.id}">editar</a>					
						<a href="/gerenciador/entrada?acao=RemovaEmpresas&id=${empresa.id}">remove</a>
					</li>
				</c:forEach>
				<br></br>
					<form action="${LinkServeletNovaEmpresa}" method="post">
						<input type="hidden" name="acao" value="NovaEmpresaForm"/>
						<input type="submit"/>
					</form>	
				
			</ul>
	<c:import url="logout-parcial.jsp"/>	
</body>
</html>



	
		