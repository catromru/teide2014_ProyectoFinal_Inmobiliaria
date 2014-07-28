/* Autor: Rubén Alejandro Catalán Romero
   Fecha creación: 28/07/2014
   Última modificación: 28/07/2014
*/

package com.nebur.teide.inmobiliaria.utilidades;

public final class Utilidades {
	public static Object getCadenaSegunTipo(String tipoDato, Object texto) {
		if( tipoDato.equals("NaN") )
		{
			texto = "%" + texto + "%";
		}else if( tipoDato.equals("int") )
			{
				texto = Integer.parseInt((String) texto);
			}else {
					texto = Double.parseDouble((String) texto);
				  }
		
		
		return texto;
	}
}
