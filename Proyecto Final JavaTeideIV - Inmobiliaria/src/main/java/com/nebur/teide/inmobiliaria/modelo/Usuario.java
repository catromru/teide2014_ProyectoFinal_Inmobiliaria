/* Autor: Rubén Alejandro Catalán Romero
   Fecha creación: 29/07/2014
   Última modificación: 30/07/2014
*/

package com.nebur.teide.inmobiliaria.modelo;

import java.io.Serializable;

public class Usuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8794786619121224179L;
	private String login;
	private String password;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Usuario(String login, String password) {
		this.login = login;
		this.password = password;
	}


	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
