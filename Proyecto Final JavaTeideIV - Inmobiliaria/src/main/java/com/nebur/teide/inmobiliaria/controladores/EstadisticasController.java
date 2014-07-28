/* Autor: Rubén Alejandro Catalán Romero
   Fecha creación: 25/07/2014
   Última modificación: 28/07/2014
*/

package com.nebur.teide.inmobiliaria.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nebur.teide.inmobiliaria.modelo.Inmueble;
import com.nebur.teide.inmobiliaria.repositorios.RepositorioInmuebles;

@Controller
public class EstadisticasController {
	@Autowired
	RepositorioInmuebles daoInmuebles;
	
	@RequestMapping(value="estadisticas.html")
	public String abrirEstadisticas(ModelMap mapaModelo) {
		Double consulta1 = (Double) daoInmuebles.hacerConsulta("inmueble_precioMedio");
		Double consulta2 = (Double) daoInmuebles.hacerConsulta("inmueble_precioMax");
		
		String consultaSQL1 = "select idPropietario from Inmueble group by idPropietario order by count(idPropietario) desc limit 1";
		Integer id1 = Integer.parseInt( (String) daoInmuebles.hacerConsultaSQL(consultaSQL1).toString() );
		String consulta3 = daoInmuebles.get(Inmueble.class, id1).getPropietario().getNombre();
		
		String consultaSQL2 = "select idPropietario from Inmueble group by idPropietario order by sum(precio) desc limit 1";
		Integer id2 = Integer.parseInt( (String) daoInmuebles.hacerConsultaSQL(consultaSQL2).toString() );
		String consulta4 = daoInmuebles.get(Inmueble.class, id2).getPropietario().getNombre();
		
		
		mapaModelo.addAttribute("consulta1", consulta1);
		mapaModelo.addAttribute("consulta2", consulta2);
		mapaModelo.addAttribute("consulta3", consulta3);
		mapaModelo.addAttribute("consulta4", consulta4);
		
		
		return "estadisticas";
	}
}
