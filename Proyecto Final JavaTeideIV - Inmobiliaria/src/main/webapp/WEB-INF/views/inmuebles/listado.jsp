<!-- Autor: Rubén Alejandro Catalán Romero
	 Fecha creación: 25/07/2014
	 Última modificación: 29/07/2014
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado inmuebles</title>

	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/estilos.css" />" />
	
</head>
<body>
	<a href="../"><img id="botonVolver" alt="Volver" src='<c:url value="/resources/img/home.png" />' /></a> <br/><br/>

	<a href="alta.html">Alta nuevo inmueble</a> <br/><br/>
	
	Búsqueda: <input type="text" id="txtBuscar">
	<select>
		<option onclick='buscar("direccion", "NaN")'>Por dirección</option>
		<option onclick='buscar("precio", "dbl")'>Por precio</option>
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

		tabla.append("<tr><th>Dirección</th><th>Precio</th><th colspan=3>Opciones</th></tr>");

		for ( var i in res) {
			var resultado = "<tr>";
			resultado += "<td>" + res[i].direccion + "</td>";
			resultado += "<td>" + res[i].precio + "</td>";
			resultado += "<td><a href='#' onclick='verDetalle(" + res[i].idInmueble + ")'>Ver detalle</a></td>";
			resultado += "<td><a href='#' onclick='borrar(" + res[i].idInmueble + ")'>Borrar</a></td>";
			resultado += "<td><a href='modificacion_" + res[i].idInmueble + ".html?'>Modificar</a></td>";
			resultado += "</tr>";

			tabla.append(resultado);
		}
	}

	function verDetalle(id)
	{
		var url = "detalle_" + id;

		$.get(url, function(res){
			var resultado = "<ul>";
			resultado += "<li>Dirección: " + res.direccion + "</li>";
			resultado += "<li>Precio: " + res.precio + "</li>";
			resultado += "<li>Propietario:<ul>";
				resultado += "<li>Nombre: " + res.propietario.nombre + "</li>";
				resultado += "<li>DNI: " + res.propietario.dni + "</li>";
				resultado += "</ul></li>";
			resultado += "<li>Inquilino: ";
				if( res.inquilino!=null )
				{
					resultado += "<ul>";
					resultado += "<li>Nombre: " + res.inquilino.nombre + "</li>";
					resultado += "<li>DNI: " + res.inquilino.dni + "</li>";
					resultado += "<li>Edad: " + res.inquilino.edad + "</li>";
					resultado += "<li>Trabaja: ";
						if(res.inquilino.trabaja==1){resultado+="Si";}else{resultado+="No";}
						resultado += "</li>";
					resultado += "</ul></li>";
				}else{
						resultado += "ninguno</li>";
					 }
			resultado += "</ul>";

			$("#divDetalle").html(resultado);
		});
	}

	function borrar(id)
	{
		var idJSON = {idInmueble:id};
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