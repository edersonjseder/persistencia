<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pesquisa</title>
</head>
<body>
	<h2>Pesquisa</h2>
	
	<form action="PesquisarServlet" method="post">
		<table border="0">
			<tr>
				<td width="109">Pátios</td>
				<td width="114">
					<select name="patios" style="width:150px;">
						<option value="-1">Selecione...</option>
						<c:forEach var="patios" items="${listaPatio}">
							<option value="${patios.idPatio}">${patios.nome}</option>
						</c:forEach>
					</select><br>
				</td>
				<td>
					<input type="submit" value="Pesquisar">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>