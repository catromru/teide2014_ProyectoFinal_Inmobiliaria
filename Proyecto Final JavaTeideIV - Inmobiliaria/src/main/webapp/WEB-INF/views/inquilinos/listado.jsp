<!-- Autor: Rubén Alejandro Catalán Romero
	 Fecha creación: 23/07/2014
	 Última modificación: 24/07/2014
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
	<a href="../"><img alt="Volver" src='<c:url value="/resources/img/home.png" />' width="30" height="30"/></a> <br/><br/>

	<a href="alta.html">Alta nuevo inquilino</a> <br/><br/>
	
	Búsqueda: <input type="text" id="txtBuscar">
	<select>
		<option onclick='buscar("nombre", "NaN")'>Por nombre</option>
		<option onclick='buscar("edad", "N")'>Por edad</option>
	</select> <br/><br/><br/>

	<table id="tablaDatos"></table>
	
	<div id="divDetalle"></div>
</body>

<script type="text/javascript" src='<c:url value="/resources/js/jquery-1.11.1.min.js" />'></script>

<script type="text/javascript">
	(function(){
		listar();
	})();
	
	function listar()
	{
		var url = "listar";

		$.get(url, mostrarRegistros);
	}

	function buscar(campo, tipoDato)
	{
		var texto = $("#txtBuscar").val();
		
		if( texto=="" )
		{
			listar();
			return;
		}
		
		var url = "buscar_" + campo + "_" + tipoDato + "_" + texto;

		$.get(url, mostrarRegistros);
	}
	
	function mostrarRegistros(res){
		var tabla = $("#tablaDatos");
		
		$("#tablaDatos tr").each(function(){
			$(this).remove();
		});

		tabla.append("<tr><th>Nombre</th><th>Edad</th><th colspan=3>Opciones</th></tr>");

		for ( var i in res) {
			var resultado = "<tr>";
			resultado += "<td>" + res[i].nombre + "</td>";
			resultado += "<td>" + res[i].edad + "</td>";
			resultado += "<td><a href='#' onclick='verDetalle(" + res[i].idInquilino + ")'>Ver detalle</a></td>";
			resultado += "<td><a href='#' onclick='borrar(" + res[i].idInquilino + ")'>Borrar</a></td>";
			resultado += "<td><a href='modificacion_" + res[i].idInquilino + ".html?'>Modificar</a></td>";
			resultado += "</tr>";

			tabla.append(resultado);
		}
	}

	function verDetalle(id)
	{
		var url = "detalle_" + id;

		$.get(url, function(res){
			var resultado = "<ul>";
			resultado += "<li>Nombre: " + res.nombre + "</li>";
			resultado += "<li>DNI: " + res.dni + "</li>";
			resultado += "<li>Edad: " + res.edad + "</li>";
			resultado += "<li>Trabaja: ";
				if(res.trabaja==1){resultado+="Si";}else{resultado+="No";}
				resultado += "</li>";
			resultado += "</ul>";

			$("#divDetalle").html(resultado);
		});
	}

	function borrar(id)
	{
		var idJSON = {idInquilino:id};
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