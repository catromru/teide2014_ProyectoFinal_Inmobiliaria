<!-- Autor: Rubén Alejandro Catalán Romero
	 Fecha creación: 23/07/2014
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
<title>Formulario inquilinos</title>

	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/estilos.css" />" />
	
</head>
<body>
	<a href="listado.html">Volver sin guardar</a> <br/><br/>
	
	<form:form method="post" commandName="inquilino">
		<form:hidden path="idInquilino"/>
	
		DNI: <form:input path="dni"/> <br/>
		Nombre: <form:input path="nombre"/> <br/>
		Edad: <form:input path="edad"/> <br/>
		Trabaja (0/1 ó false/true): <form:input path="trabaja"/> <br/> <br/>
		
		<input type="submit" value="Guardar" />
	</form:form>
</body>
</html>