<%@page import="br.com.fiap.persistencia.bean.Patio"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro Ve�culos</title>
</head>
<body>
	<h2>Cadastro Ve�culos</h2>
	
	<form action="CadastroVeiculoServlet" method="post">
	
		<table border="0">
			<tr>
				<td width="109">P�tios</td>
				<td width="114">
					<select name="patios" style="width:150px;">
						<option value="selecione">Selecione...</option>
						<c:forEach var="patios" items="${listaPatio}">
							<option value="${patios.idPatio}">${patios.nome}</option>
						</c:forEach>
					</select><br>
				</td>
			</tr>
			
			<tr>
				<td width="109">Marca</td>
				<td width="114"><input type="text" name="marca"  size="20"/><br></td>
			</tr>
			<tr>
				<td width="109">Modelo</td>
				<td width="114"><input type="text" name="modelo" size="20"><br></td>
			</tr>
			<tr>
				<td width="109">Ano Fabrica��o</td>
				<td width="114"><input type="text" name="anoFabricacao" size="10"><br></td>
			</tr>
			<tr>
				<td width="109">Ano Modelo</td>
				<td width="114"><input type="text" name="anoModelo" size="10"><br></td>
			</tr>
			<c:if test="${!mensagem eq null}">
				<tr>
					<td width="109">Cadastrado com Sucesso!!</td>
				</tr>
			</c:if>
			<tr>
				<td colspan="2"><input type="submit" value="Cadastrar"></td>
			</tr>
		</table>
	</form>
</body>
</html>