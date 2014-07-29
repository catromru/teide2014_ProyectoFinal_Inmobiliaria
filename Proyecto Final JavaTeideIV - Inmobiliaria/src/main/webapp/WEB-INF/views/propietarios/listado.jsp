<!-- Autor: Rubén Alejandro Catalán Romero
	 Fecha creación: 24/07/2014
	 Última modificación: 29/07/2014
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado propietarios</title>

	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/estilos.css" />" />
	
</head>
<body>
	<a href="../"><img id="botonVolver" alt="Volver" src='<c:url value="/resources/img/home.png" />' width="30" height="30"/></a> <br/><br/>

	<a href="alta.html">Alta nuevo propietario</a> <br/><br/>
	
	Búsqueda: <input type="text" id="txtBuscar">
	<select>
		<option onclick='buscar("nombre", "NaN")'>Por nombre</option>
		<option onclick='buscar("dni", "NaN")'>Por DNI</option>
		<option onclick="listar()">Ver todos los registros</option>
	</select> <br/><br/><br/>

	<table id="tablaDatos"></table>
	
	<div id="divDetalle">
		<ul id="ulCargando">
			<li>Cargando...</li>
		</ul>
	</div>
</body>

<script type="text/javascript" src='<c:url value="/resources/js/jquery-1.11.1.min.js" />'></script>

<script type="text/javascript" src='<c:url value="/resources/js/funcionesComunes.js" />'></script>

<script type="text/javascript">
	(function(){
		listar();
	})();
	
	function mostrarRegistros(res){
		var tabla = $("#tablaDatos");
		
		$("#divDetalle ul").each(function(){
			$(this).remove();
		});
		
		$("#tablaDatos tr").each(function(){
			$(this).remove();
		});

		tabla.append("<tr><th>Nombre</th><th>DNI</th><th colspan=2>Opciones</th></tr>");

		for ( var i in res) {
			var resultado = "<tr>";
			resultado += "<td>" + res[i].nombre + "</td>";
			resultado += "<td>" + res[i].dni + "</td>";
			resultado += "<td><a href='#' onclick='borrar(" + res[i].idPropietario + ")'>Borrar</a></td>";
			resultado += "<td><a href='modificacion_" + res[i].idPropietario + ".html?'>Modificar</a></td>";
			resultado += "</tr>";

			tabla.append(resultado);
		}
	}

	function borrar(id)
	{
		var idJSON = {idPropietario:id};
		var idString = JSON.stringify(idJSON);

		$.ajax(
			"borrar",
			{data: idString,
			 method: "DELETE",
			 contentType: "application/json",
			 success: function(res){
				 		alert(res);
				 		listar();
					  },
			 error: function(res){
				 		alert( JSON.stringify(res) );
				 	}
			}
		);
	}
</script>

</html>