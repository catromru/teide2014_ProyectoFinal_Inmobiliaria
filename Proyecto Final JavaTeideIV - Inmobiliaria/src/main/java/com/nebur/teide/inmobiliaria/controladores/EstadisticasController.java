/* Autor: Rubén Alejandro Catalán Romero
   Fecha creación: 25/07/2014
   Última modificación: 25/07/2014
*/

package com.nebur.teide.inmobiliaria.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nebur.teide.inmobiliaria.repositorios.RepositorioInmuebles;

@Controller
public class EstadisticasController {
	@Autowired
	RepositorioInmuebles daoInmuebles;
	
	@RequestMapping(value="estadisticas.html")
	public String abrirEstadisticas(ModelMap mapaModelo) {
		Double consulta1 = (Double) daoInmuebles.hacerConsulta("inmueble_precioMedio");
		Double consulta2 = (Double) daoInmuebles.hacerConsulta("inmueble_precioMax");
		/*String consulta3 = (String) daoInmuebles.hacerConsulta("inmueble_propietarioConMasInmuebles");*/
		String consulta4 = (String) daoInmuebles.hacerConsulta("inmueble_propietarioConMasGanancias");
		
		mapaModelo.addAttribute("consulta1", consulta1);
		mapaModelo.addAttribute("consulta2", consulta2);
		/*mapaModelo.addAttribute("consulta3", consulta3);*/
		mapaModelo.addAttribute("consulta4", consulta4);
		
		
		return "estadisticas";
	}
}
