/* Autor: Rubén Alejandro Catalán Romero
   Fecha creación: 28/07/2014
   Última modificación: 28/07/2014
*/

package com.nebur.teide.inmobiliaria.modelo;

public class BusquedaJSON {
	private String campo;
	private String tipoDato;
	private Object texto;
	
	
	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	public String getTipoDato() {
		return tipoDato;
	}
	public void setTipoDato(String tipoDato) {
		this.tipoDato = tipoDato;
	}
	public Object getTexto() {
		return texto;
	}
	public void setTexto(Object texto) {
		this.texto = texto;
	}
	
	
	public void getCadenaSegunTipo() {
		if( tipoDato.equals("NaN") )
		{
			texto = "%" + texto + "%";
		}else if( tipoDato.equals("int") )
			{
				texto = Integer.parseInt((String) texto);
			}else {
					texto = Double.parseDouble((String) texto);
				  }
	}
}
