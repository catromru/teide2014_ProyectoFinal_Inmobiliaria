/* Autor: Rubén Alejandro Catalán Romero
   Fecha creación: 25/07/2014
   Última modificación: 28/07/2014
*/

package com.nebur.teide.inmobiliaria.controladores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nebur.teide.inmobiliaria.modelo.BusquedaJSON;
import com.nebur.teide.inmobiliaria.modelo.Inmueble;
import com.nebur.teide.inmobiliaria.modelo.viewforms.InmuebleViewForm;
import com.nebur.teide.inmobiliaria.repositorios.RepositorioInmuebles;
import com.nebur.teide.inmobiliaria.repositorios.RepositorioInquilinos;
import com.nebur.teide.inmobiliaria.repositorios.RepositorioPropietarios;

@Controller
@RequestMapping(value="/inmueble/")
public class InmueblesController {
	@Autowired
	RepositorioInmuebles daoInmuebles;
	@Autowired
	RepositorioPropietarios daoPro;
	@Autowired
	RepositorioInquilinos daoInq;
	
	
	/* Listado */
	@RequestMapping(value="listado.html")
	public String abrirListado() {
		return "inmuebles/listado";
	}
	
	@RequestMapping(value="listar")
	public @ResponseBody List<Inmueble> listar() {
		return daoInmuebles.get(Inmueble.class);
	}
	
	
	/* Detalle */
	@RequestMapping(value="detalle_{id}")
	public @ResponseBody Inmueble verDetalle(@PathVariable Integer id) {
		return daoInmuebles.get(Inmueble.class, id);
	}
	
	
	/* Búsqueda */
	@RequestMapping(value="buscar")
	public @ResponseBody List<Inmueble> buscarConDecimales(@RequestBody BusquedaJSON valoresJSON) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		
		valoresJSON.getCadenaSegunTipo();
		
		parametros.put("param", valoresJSON.getTexto());
		
		return daoInmuebles.getByConsulta("inmueble_buscarPor_" + valoresJSON.getCampo(), parametros);
	}
	
	
	/* Borrado */
	@RequestMapping(value="borrar", method=RequestMethod.DELETE)
	public @ResponseBody String borrar(@RequestBody Inmueble i) {
		daoInmuebles.delete(i);
		
		
		return "borrado";
	}
	
	
	/* Alta */
	@RequestMapping(value="alta.html", method=RequestMethod.GET)
	public String abrirAlta(ModelMap mapaModelo) {
		InmuebleViewForm ivf = new InmuebleViewForm();
		Map<Integer, String> mapaPropietarios = daoPro.getMapaOptions();
		Map<Integer, String> mapaInquilinos = daoInq.getMapaOptions();
		
		mapaModelo.addAttribute("inmueble", ivf);
		mapaModelo.addAttribute("propietarios", mapaPropietarios);
		mapaModelo.addAttribute("inquilinos", mapaInquilinos);
		
		
		return "inmuebles/formulario";
	}
	
	@RequestMapping(value="alta.html", method=RequestMethod.POST)
	public String hacerAlta(@ModelAttribute("inmueble") InmuebleViewForm ivf, BindingResult resultado, HttpServletRequest request) {
		if( resultado.hasErrors() )
		{
			Map<Integer, String> mapaPropietarios = daoPro.getMapaOptions();
			Map<Integer, String> mapaInquilinos = daoInq.getMapaOptions();
			
			request.setAttribute("propietarios", mapaPropietarios);
			request.setAttribute("inquilinos", mapaInquilinos);
			
			return "inmuebles/formulario";
		}
		
		Inmueble i = ivf.getInmueble();
		daoInmuebles.insert(i);
		
		
		return "redirect:listado.html";
	}
	
	
	/* Modificación */
	@RequestMapping(value="modificacion_{id}.html", method=RequestMethod.GET)
	public String abrirModificacion(@PathVariable Integer id, ModelMap mapaModelo) {
		Inmueble i = daoInmuebles.get(Inmueble.class, id);
		InmuebleViewForm ivf = new InmuebleViewForm();
		
		ivf.fromInmueble(i);
		
		Map<Integer, String> mapaPropietarios = daoPro.getMapaOptions();
		Map<Integer, String> mapaInquilinos = daoInq.getMapaOptions();
//mapaInquilinos.put(null, null);
		
		mapaModelo.addAttribute("inmueble", ivf);
		mapaModelo.addAttribute("propietarios", mapaPropietarios);
		mapaModelo.addAttribute("inquilinos", mapaInquilinos);
		
		
		return "inmuebles/formulario";
	}
	
	@RequestMapping(value="modificacion_{id}.html", method=RequestMethod.POST)
	public String hacerModificacion(@ModelAttribute("inmueble") InmuebleViewForm ivf, BindingResult resultado, HttpServletRequest request) {
		if( resultado.hasErrors() )
		{
			Map<Integer, String> mapaPropietarios = daoPro.getMapaOptions();
			Map<Integer, String> mapaInquilinos = daoInq.getMapaOptions();
			
			request.setAttribute("propietarios", mapaPropietarios);
			request.setAttribute("inquilinos", mapaInquilinos);
			
			return "inmuebles/formulario";
		}
		
		Inmueble i = ivf.getInmueble();
		daoInmuebles.update(i);
		
		
		return "redirect:listado.html";
	}
}
