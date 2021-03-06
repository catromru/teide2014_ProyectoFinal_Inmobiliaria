<!-- Autor: Rub�n Alejandro Catal�n Romero
	 Fecha creaci�n: 25/07/2014
	 �ltima modificaci�n: 29/07/2014
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulario inmuebles</title>

	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/estilos.css" />" />
	
</head>
<body>
	<a href="listado.html">Volver sin guardar</a> <br/><br/>
	
	<form:form method="post" commandName="inmueble">
		<form:hidden path="idInmueble"/>
	
		Direcci�n: <form:input path="direccion"/> <br/>
		Precio: <form:input path="precio"/> <br/>
		Propietario: <form:select path="idPropietario">
						<form:options items="${propietarios }"/>
					</form:select> <br/>
		Inquilino: <form:select path="idInquilino">
						<form:option value="${null }" label="-ninguno-"></form:option>
						<form:options items="${inquilinos }"/>
					</form:select> <br/> <br/>
		
		<input type="submit" value="Guardar" />
	</form:form>
</body>
</html>