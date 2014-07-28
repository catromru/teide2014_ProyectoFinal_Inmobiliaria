/* Autor: Rubén Alejandro Catalán Romero
   Fecha creación: 23/07/2014
   Última modificación: 28/07/2014
*/

package com.nebur.teide.inmobiliaria.controladores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.nebur.teide.inmobiliaria.modelo.Inquilino;
import com.nebur.teide.inmobiliaria.repositorios.RepositorioInquilinos;
import com.nebur.teide.inmobiliaria.utilidades.Utilidades;

@Controller
@RequestMapping(value="/inquilino/")
public class InquilinosController {
	@Autowired
	RepositorioInquilinos daoInq;
	
	
	/* Listado */
	@RequestMapping(value="listado.html")
	public String abrirListado() {
		return "inquilinos/listado";
	}
	
	@RequestMapping(value="listar")
	public @ResponseBody List<Inquilino> listar() {
		return daoInq.get(Inquilino.class);
	}
	
	
	/* Detalle */
	@RequestMapping(value="detalle_{id}")
	public @ResponseBody Inquilino verDetalle(@PathVariable Integer id) {
		return daoInq.get(Inquilino.class, id);
	}
	
	
	/* Búsqueda */
	@RequestMapping(value="buscar_{campo}_{tipoDato}_{texto}")
	public @ResponseBody List<Inquilino> buscar(@PathVariable String campo, @PathVariable String tipoDato, @PathVariable Object texto) {
		//System.out.println("**********" + campo + "**********" + texto + "**********");
		Map<String, Object> parametros = new HashMap<String, Object>();
		
		texto = Utilidades.getCadenaSegunTipo(tipoDato, texto);
		
		parametros.put("param", texto);
		
		return daoInq.getByConsulta("inquilino_buscarPor_" + campo, parametros);
	}
	
	
	/* Borrado */
	@RequestMapping(value="borrar", method=RequestMethod.DELETE)
	public @ResponseBody String borrar(@RequestBody Inquilino i) {
		daoInq.delete(i);
		
		
		return "borrado";
	}
	
	
	/* Alta */
	@RequestMapping(value="alta.html", method=RequestMethod.GET)
	public String abrirAlta(ModelMap mapaModelo) {
		Inquilino i = new Inquilino();
		
		mapaModelo.addAttribute("inquilino", i);
		
		
		return "inquilinos/formulario";
	}
	
	@RequestMapping(value="alta.html", method=RequestMethod.POST)
	public String hacerAlta(@ModelAttribute("inquilino") Inquilino i, BindingResult resultado) {
		if( resultado.hasErrors() )
		{
			return "inquilinos/formulario";
		}
		
		daoInq.insert(i);
		
		
		return "redirect:listado.html";
	}
	
	
	/* Modificación */
	@RequestMapping(value="modificacion_{id}.html", method=RequestMethod.GET)
	public String abrirModificacion(@PathVariable Integer id, ModelMap mapaModelo) {
		Inquilino i = daoInq.get(Inquilino.class, id);
		
		mapaModelo.addAttribute("inquilino", i);
		
		
		return "inquilinos/formulario";
	}
	
	@RequestMapping(value="modificacion_{id}.html", method=RequestMethod.POST)
	public String hacerModificacion(@ModelAttribute("inquilino") Inquilino i, BindingResult resultado) {
		if( resultado.hasErrors() )
		{
			return "inquilinos/formulario";
		}
		
		daoInq.update(i);
		
		
		return "redirect:listado.html";
	}
}
