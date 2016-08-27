<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Veículos</title>
</head>
<body>
	<h2>Lista de Veículos</h2>
	<c:if test="${empty listaVeiculos}">
		<c:out value="Não Existem Registros!"></c:out>
	</c:if>
	<div>&nbsp;</div>
	<c:if test="${!empty listaVeiculos}">
		<form action="EditarDadoServlet" method="post">
			<table border="1">
				<tr>
					<th>&nbsp;</th>
					<th>Marca</th>
					<th>Modelo</th>
					<th>Ano Fabricação</th>
					<th>Ano Modelo</th>
					<th>Editar</th>
				</tr>
				<c:forEach var="veiculo" items="${listaVeiculos}">
					<tr>
						<td>
							<input type="checkbox" name="codigo" value="${veiculo.idVeiculo}">
						</td>
						<td>${veiculo.marca}</td>
						<td>${veiculo.modelo}</td>
						<td>${veiculo.anoFabricacao}</td>
						<td>${veiculo.anoModelo}</td>
						<td><input type="submit" value="Editar"></td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</c:if>
	<div>
		<form action="CarregarPesquisaServlet" method="post">
			<input type="submit" value="Voltar">
		</form>
	</div>
</body>
</html>