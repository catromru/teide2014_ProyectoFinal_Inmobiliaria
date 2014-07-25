/* Autor: Rubén Alejandro Catalán Romero
   Fecha creación: 24/07/2014
   Última modificación: 25/07/2014
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

import com.nebur.teide.inmobiliaria.modelo.Propietario;
import com.nebur.teide.inmobiliaria.repositorios.RepositorioPropietarios;

@Controller
@RequestMapping(value="/propietario/")
public class PropietariosController {
	@Autowired
	RepositorioPropietarios daoProp;
	
	
	/* Listado */
	@RequestMapping(value="listado.html")
	public String abrirListado() {
		return "propietarios/listado";
	}
	
	@RequestMapping(value="listar")
	public @ResponseBody List<Propietario> listar() {
		return daoProp.get(Propietario.class);
	}
	
	
	/* Búsqueda */
	@RequestMapping(value="buscar_{campo}_{tipoDato}_{texto}")
	public @ResponseBody List<Propietario> buscar(@PathVariable String campo, @PathVariable String tipoDato, @PathVariable Object texto) {
		//System.out.println("**********" + campo + "**********" + texto + "**********");
		Map<String, Object> parametros = new HashMap<String, Object>();
		
		if( tipoDato.equals("NaN") )
		{
			texto = "%" + texto + "%";
		}else {
				if( texto instanceof Integer )
				{
					texto = Integer.parseInt((String) texto);
				}else {
						texto = Double.parseDouble((String) texto);
					  }
			}
		
		parametros.put("param", texto);
		
		return daoProp.getByConsulta("propietario_buscarPor_" + campo, parametros);
	}
	
	
	/* Borrado */
	@RequestMapping(value="borrar", method=RequestMethod.DELETE)
	public @ResponseBody String borrar(@RequestBody Propietario p) {
		daoProp.delete(p);
		
		
		return "borrado";
	}
	
	
	/* Alta */
	@RequestMapping(value="alta.html", method=RequestMethod.GET)
	public String abrirAlta(ModelMap mapaModelo) {
		Propietario p = new Propietario();
		
		mapaModelo.addAttribute("propietario", p);
		
		
		return "propietarios/formulario";
	}
	
	@RequestMapping(value="alta.html", method=RequestMethod.POST)
	public String hacerAlta(@ModelAttribute("propietario") Propietario p, BindingResult resultado) {
		if( resultado.hasErrors() )
		{
			return "propietarios/formulario";
		}
		
		daoProp.insert(p);
		
		
		return "redirect:listado.html";
	}
	
	
	/* Modificación */
	@RequestMapping(value="modificacion_{id}.html", method=RequestMethod.GET)
	public String abrirModificacion(@PathVariable Integer id, ModelMap mapaModelo) {
		Propietario p = daoProp.get(Propietario.class, id);
		
		mapaModelo.addAttribute("propietario", p);
		
		
		return "propietarios/formulario";
	}
	
	@RequestMapping(value="modificacion_{id}.html", method=RequestMethod.POST)
	public String hacerModificacion(@ModelAttribute("propietario") Propietario p, BindingResult resultado) {
		if( resultado.hasErrors() )
		{
			return "propietarios/formulario";
		}
		
		daoProp.update(p);
		
		
		return "redirect:listado.html";
	}
}
