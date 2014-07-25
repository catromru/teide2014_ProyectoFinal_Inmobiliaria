/* Autor: Rubén Alejandro Catalán Romero
   Fecha creación: 24/07/2014
   Última modificación: 25/07/2014
*/

package com.nebur.teide.inmobiliaria.repositorios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nebur.teide.inmobiliaria.modelo.Propietario;

public class RepositorioPropietarios extends Repositorio<Propietario> {
	public Map<Integer, String> getMapaOptions() {
		Map<Integer, String> mapa = new HashMap<Integer, String>();
		List<Propietario> lista = get(Propietario.class);
		
		for (Propietario p : lista) {
			mapa.put( p.getIdPropietario(), p.getNombre() );
		}
		
		
		return mapa;
	}
}
