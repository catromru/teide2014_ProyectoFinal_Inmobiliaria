/* Autor: Rubén Alejandro Catalán Romero
   Fecha creación: 29/07/2014
   Última modificación: 30/07/2014
*/

package com.nebur.teide.inmobiliaria.controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nebur.teide.inmobiliaria.modelo.Usuario;

@Controller
public class ValidacionController {
	@RequestMapping(value="/conectar.html", method=RequestMethod.GET)
	public String validarConexion(HttpServletRequest request, ModelMap mapaModelo) {
		String login = (String) request.getParameter("txtLogin");
		String password = (String) request.getParameter("pwdLogin");
		
		Usuario usu= new Usuario(login, password);
		
		if( usu.getLogin().equals("admin") && usu.getPassword().equals("1234") )
		{
			HttpSession sesion = request.getSession();
			sesion.setAttribute("usuario", usu);
			
			mapaModelo.put("nombreUsuario", usu.getLogin());
		}
		
		
		return "redirect:/";
	}
}
