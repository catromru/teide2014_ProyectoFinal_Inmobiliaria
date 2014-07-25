/* Autor: Rub�n Alejandro Catal�n Romero
   Fecha creaci�n: 23/07/2014
   �ltima modificaci�n: 25/07/2014
*/

package com.nebur.teide.inmobiliaria.repositorios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nebur.teide.inmobiliaria.modelo.Inquilino;

public class RepositorioInquilinos extends Repositorio<Inquilino> {
	public Map<Integer, String> getMapaOptions() {
		Map<Integer, String> mapa = new HashMap<Integer, String>();
		List<Inquilino> lista = get(Inquilino.class);
		
		for (Inquilino i : lista) {
			mapa.put( i.getIdInquilino(), i.getNombre() );
		}
		
		
		return mapa;
	}
}
