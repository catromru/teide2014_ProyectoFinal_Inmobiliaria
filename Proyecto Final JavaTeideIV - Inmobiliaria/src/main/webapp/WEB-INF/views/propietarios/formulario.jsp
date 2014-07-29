<!-- Autor: Rubén Alejandro Catalán Romero
	 Fecha creación: 24/07/2014
	 Última modificación: 29/07/2014
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulario propietarios</title>

	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/estilos.css" />" />
	
</head>
<body>
	<a href="listado.html">Volver sin guardar</a> <br/><br/>
	
	<form:form method="post" commandName="propietario">
		<form:hidden path="idPropietario"/>
	
		Nombre: <form:input path="nombre"/> <br/>
		DNI: <form:input path="dni"/> <br/> <br/>
		
		<input type="submit" value="Guardar" />
	</form:form>
</body>
</html>