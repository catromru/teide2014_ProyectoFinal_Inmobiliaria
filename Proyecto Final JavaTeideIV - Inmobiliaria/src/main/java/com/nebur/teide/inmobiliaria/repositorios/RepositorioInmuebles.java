/* Autor: Rub�n Alejandro Catal�n Romero
   Fecha creaci�n: 25/07/2014
   �ltima modificaci�n: 25/07/2014
*/

package com.nebur.teide.inmobiliaria.repositorios;

import org.hibernate.Hibernate;

import com.nebur.teide.inmobiliaria.modelo.Inmueble;

public class RepositorioInmuebles extends Repositorio<Inmueble> {
	@Override
	public Inmueble get(Class<Inmueble> tipoDato, Integer id) {
		Inmueble i = super.get(tipoDato, id);

		Hibernate.initialize( i.getInquilino() );
		Hibernate.initialize( i.getPropietario() );
		
		
		return i;
	}
}
