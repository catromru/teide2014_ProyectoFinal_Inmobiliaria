/* Autor: Rubén Alejandro Catalán Romero
   Fecha creación: 29/07/2014
   Última modificación: 30/07/2014
*/

package com.nebur.teide.inmobiliaria.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nebur.teide.inmobiliaria.modelo.Usuario;

/**
 * Servlet Filter implementation class FiltroValidacionUsuarios
 */
public class FiltroValidacionUsuarios implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroValidacionUsuarios() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest hsreq = (HttpServletRequest) request;
		HttpSession sesion = hsreq.getSession();
		
		Usuario usu = (Usuario) sesion.getAttribute("usuario");
		
		if( usu.getLogin()==null )
		{
			HttpServletResponse hsres = (HttpServletResponse) response;
			hsres.sendRedirect("/");
			return;
		}
		
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
