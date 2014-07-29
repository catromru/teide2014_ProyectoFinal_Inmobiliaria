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

<form>
	Usuario: <input type="text" id="txtLogin" /> <br/>
	Password: <input type="password" id="pwdLogin" /> <br/>
	<button onclick="conectar()">Conectar</button>
</form>

<br/>
<a href="inquilino/listado.html">Inquilinos</a> 
<a href="propietario/listado.html">Propietarios</a>
<a href="inmueble/listado.html">Inmuebles</a> <br/>

<a href="estadisticas.html">Estadísticas</a>
</body>

<script type="text/javascript" src='<c:url value="/resources/js/jquery-1.11.1.min.js" />'></script>

<script type="text/javascript">
	function conectar()
	{
		var usu = $("#txtLogin").val();
		var pwd = $("#pwdLogin").val();

		var datosJSON = {login:usu, password:pwd};
		var datosString = JSON.stringify(datosJSON);

		$.ajax(
			"conectar",
			{
				data: datosString,
				method: "POST",
				contentType: "application/json",
		});
	}
</script>
</html>
