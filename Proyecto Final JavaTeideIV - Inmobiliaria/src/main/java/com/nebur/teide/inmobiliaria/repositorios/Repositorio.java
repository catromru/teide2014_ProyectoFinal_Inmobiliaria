/* Autor: Rubén Alejandro Catalán Romero
   Fecha creación: 23/07/2014
   Última modificación: 28/07/2014
*/

package com.nebur.teide.inmobiliaria.repositorios;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class Repositorio<T> extends HibernateDaoSupport implements IRepositorio<T> {
	Session sesion = null;

	@Override
	public void comprobarSesion() {
		if( sesion==null || !sesion.isOpen() )
		{
			sesion = getSessionFactory().getCurrentSession();
		}
	}

	@Override
	public List<T> get(Class<T> tipoDato) {
		comprobarSesion();
		
		Query consulta = sesion.createQuery( "from " + tipoDato.getName() );
		
		@SuppressWarnings("unchecked")
		List<T> lista = consulta.list();
		
		
		return lista;
	}

	@Override
	public T get(Class<T> tipoDato, Integer id) {
		comprobarSesion();
		
		@SuppressWarnings("unchecked")
		T obj = (T) sesion.get(tipoDato, id);
		
		
		
		return obj;
	}

	@Override
	public void insert(T objeto) {
		comprobarSesion();
		
		sesion.save(objeto);
	}

	@Override
	public void update(T objeto) {
		comprobarSesion();
		
		sesion.update(objeto);
	}

	@Override
	public void delete(T objeto) {
		comprobarSesion();
		
		sesion.delete(objeto);
	}

	@Override
	public List<T> getByConsulta(String q, Map<String, Object> parametros) {
		comprobarSesion();
		
		Query consulta = sesion.getNamedQuery(q);
		
		for (String param : parametros.keySet()) {
			consulta.setParameter( param, parametros.get(param) );
		}
		
		@SuppressWarnings("unchecked")
		List<T> lista = consulta.list();
		
		
		return lista;
	}

	@Override
	public Object hacerConsulta(String q) {
		comprobarSesion();
		
		Query consulta = sesion.getNamedQuery(q);
		
		@SuppressWarnings("unchecked")
		List<Object> lista = consulta.list();
		
		
		return lista.get(0);
	}

	@Override
	public Object hacerConsultaSQL(String q) {
		comprobarSesion();
		
		SQLQuery consulta = sesion.createSQLQuery(q);
		
		@SuppressWarnings("unchecked")
		List<Object> lista = consulta.list();
		
		
		return lista.get(0);
	}
	
	
}
