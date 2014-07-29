/* Autor: Rubén Alejandro Catalán Romero
   Fecha creación: 28/07/2014
   Última modificación: 29/07/2014
*/

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
	
	var datosJSON = {campo:campo, tipoDato:tipoDato, texto:texto};
	var datosString = JSON.stringify(datosJSON);

	$.ajax(
		"buscar",
		{data: datosString,
		 method: "POST",
		 contentType: "application/json",
		 success: mostrarRegistros,
		 error: mostrarRegistros(null)
		}
	);
}

//function eliminarDatosTabla