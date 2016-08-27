<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro Patio</title>
</head>
<body>
	<h2>Cadastro</h2>
	
	<form action="CadastroPatioServlet" method="post">
		<table border="0">
			<tr>
				<td width="109">Nome Pátio:</td>
				<td width="114"><input type="text" name="nomePatio"  size="20"/><br></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Cadastrar"></td>
			</tr>
		</table>
	</form>
</body>
</html>