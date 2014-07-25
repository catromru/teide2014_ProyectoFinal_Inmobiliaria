<!-- Autor: Rubén Alejandro Catalán Romero
	 Fecha creación: 25/07/2014
	 Última modificación: 25/07/2014
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" commandName="inmueble">
		<form:hidden path="idInmueble"/>
	
		Dirección: <form:input path="direccion"/> <br/>
		Precio: <form:input path="precio"/> <br/>
		Propietario: <form:select path="idPropietario">
						<form:options items="${propietarios }"/>
					</form:select> <br/>
		Inquilino: <form:select path="idInquilino">
						<form:options items="${inquilinos }"/>
					</form:select> <br/> <br/>
		
		<input type="submit" value="Guardar" />
	</form:form>
</body>
</html>