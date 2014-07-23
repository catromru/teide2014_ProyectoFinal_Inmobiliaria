/* Autor: Rubén Alejandro Catalán Romero
   Fecha creación: 23/07/2014
   Última modificación: 23/07/2014
*/

package com.nebur.teide.inmobiliaria.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nebur.teide.inmobiliaria.modelo.Inquilino;
import com.nebur.teide.inmobiliaria.repositorios.RepositorioInquilinos;

@Controller
@RequestMapping(value="/inquilino/")
public class InquilinosController {
	@Autowired
	RepositorioInquilinos daoInq;
	
	
	@RequestMapping(value="listado.html")
	public String abrirListado() {
		return "listado";
	}
	
	@RequestMapping(value="listar")
	public @ResponseBody List<Inquilino> listar() {
		return daoInq.get(Inquilino.class);
	}
	
	@RequestMapping(value="borrar", method=RequestMethod.DELETE)
	public @ResponseBody String borrar(@RequestBody Inquilino i) {
		daoInq.delete(i);
		
		
		return "borrado";
	}
	
	@RequestMapping(value="detalle_{id}")
	public @ResponseBody Inquilino verDetalle(@PathVariable Integer id) {
		return daoInq.get(Inquilino.class, id);
	}
}
