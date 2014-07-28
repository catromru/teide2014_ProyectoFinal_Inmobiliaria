<!-- Autor: Rubén Alejandro Catalán Romero
	 Fecha creación: 25/07/2014
	 Última modificación: 28/07/2014
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="./"><img alt="Volver" src='<c:url value="/resources/img/home.png" />' width="30" height="30"/></a> <br/><br/>

	Precio medio por inmueble: ${consulta1} <br/>
	Precio máximo por inmueble: ${consulta2} <br/>
	Propietario con más inmuebles: ${consulta3} <br/>
	Propietario con más ganancias: ${consulta4} <br/>
</body>
</html>