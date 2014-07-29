/* Autor: Rubén Alejandro Catalán Romero
   Fecha creación: 29/07/2014
   Última modificación: 29/07/2014
*/

package com.nebur.teide.inmobiliaria.controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nebur.teide.inmobiliaria.modelo.Usuario;

@Controller
public class ValidacionController {
	@RequestMapping(value="conectar")
	public @ResponseBody String validarConexion(@RequestBody Usuario usu, HttpServletRequest request) {
		System.out.println("Login:" + usu.getLogin() + "; Password: " + usu.getPassword());
		if( usu.getLogin().equals("admin") && usu.getPassword().equals("1234") )
		{
			System.out.println("Conectado");
			HttpSession sesion = request.getSession();
			sesion.setAttribute("usuario", usu);
		}
		
		
		return "";
	}
}
