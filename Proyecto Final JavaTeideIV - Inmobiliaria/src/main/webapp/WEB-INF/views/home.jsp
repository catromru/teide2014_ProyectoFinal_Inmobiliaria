<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>

	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/estilos.css" />" />
</head>
<body>
<h1>
	¡Hola, mundo!  
</h1>

<P>  El tiempo en el servidor es ${serverTime}. </P>

<br/>
<a href="inquilino/listado.html">Inquilinos</a> 
<a href="propietario/listado.html">Propietarios</a>
<a href="inmueble/listado.html">Inmuebles</a> <br/>

<a href="estadisticas.html">Estadísticas</a>
</body>
</html>
