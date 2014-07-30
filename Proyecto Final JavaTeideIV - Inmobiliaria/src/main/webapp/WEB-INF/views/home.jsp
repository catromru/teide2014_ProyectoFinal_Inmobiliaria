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

<form action="conectar.html" method="get">
	Usuario: <input type="text" name="txtLogin" id="txtLogin" /> admin <br/>
	Password: <input type="password" name="pwdLogin" id="pwdLogin" /> 1234 <br/>
	<input type="submit"></input>
</form>

<br/>
<div id="divListado">
	
</div>

<a href="estadisticas.html">Estadísticas</a>
</body>

<script type="text/javascript" src='<c:url value="/resources/js/jquery-1.11.1.min.js" />'></script>

<script type="text/javascript">
	(function(){
		mostrarDiv();
	})();

	function mostrarDiv()
	{
		var usu = "<%=request.getAttribute("nombreUsuario") %>";
		
		if( usu!=null )
		{
			var div = $("#divListado");
			
			resultado = '<a href="inquilino/listado.html">Inquilinos</a> '; 
			resultado += '<a href="propietario/listado.html">Propietarios</a> ';
			resultado += '<a href="inmueble/listado.html">Inmuebles</a> <br/>';

			div.append(resultado);
		}
	}
</script>
</html>
