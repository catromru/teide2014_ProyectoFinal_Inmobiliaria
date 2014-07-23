/* Autor: Rub�n Alejandro Catal�n Romero
   Fecha creaci�n: 23/07/2014
   �ltima modificaci�n: 23/07/2014
*/

package com.nebur.teide.inmobiliaria.modelo.hibernate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

public class HibernateAwareObjectMapper extends ObjectMapper {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7311217725677575959L;

	public HibernateAwareObjectMapper() {
		registerModule( new Hibernate4Module() );
	}
}
