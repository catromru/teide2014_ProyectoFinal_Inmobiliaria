/* Autor: Rubén Alejandro Catalán Romero
   Fecha creación: 23/07/2014
   Última modificación: 28/07/2014
*/

package com.nebur.teide.inmobiliaria.repositorios;

import java.util.List;
import java.util.Map;

public interface IRepositorio<T> {
	public void comprobarSesion();
	public List<T> get(Class<T> tipoDato);
	public T get(Class<T> tipoDato, Integer id);
	public void insert(T objeto);
	public void update(T objeto);
	public void delete(T objeto);
	public List<T> getByConsulta(String q, Map<String, Object> parametros);
	public Object hacerConsulta(String q);
	public Object hacerConsultaSQL(String q);
}
