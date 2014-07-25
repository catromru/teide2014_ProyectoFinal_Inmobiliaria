/* Autor: Rubén Alejandro Catalán Romero
   Fecha creación: 25/07/2014
   Última modificación: 25/07/2014
*/

package com.nebur.teide.inmobiliaria.modelo.viewforms;

import com.nebur.teide.inmobiliaria.modelo.Inmueble;
import com.nebur.teide.inmobiliaria.modelo.Inquilino;
import com.nebur.teide.inmobiliaria.modelo.Propietario;

public class InmuebleViewForm {
	private Integer idInmueble;
    private String direccion;
    private double precio;
    private Integer idInquilino;
    private Integer idPropietario;
    
    
	public InmuebleViewForm() {
	}
	
	public InmuebleViewForm(Integer idInmueble, String direccion,
			double precio, Integer idInquilino, Integer idPropietario) {
		this.idInmueble = idInmueble;
		this.direccion = direccion;
		this.precio = precio;
		this.idInquilino = idInquilino;
		this.idPropietario = idPropietario;
	}
	
	
	public Integer getIdInmueble() {
		return idInmueble;
	}
	public void setIdInmueble(Integer idInmueble) {
		this.idInmueble = idInmueble;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Integer getIdInquilino() {
		return idInquilino;
	}
	public void setIdInquilino(Integer idInquilino) {
		this.idInquilino = idInquilino;
	}
	/*public void setIdInquilino(Inquilino i) {
		this.idInquilino = i.getIdInquilino();
	}*/
	public Integer getIdPropietario() {
		return idPropietario;
	}
	public void setIdPropietario(Integer idPropietario) {
		this.idPropietario = idPropietario;
	}
	/*public void setIdPropietario(Propietario p) {
		this.idPropietario = p.getIdPropietario();
	}*/
    
	
	public Inmueble getInmueble() {
		Inmueble i = new Inmueble();
		
		i.setIdInmueble(idInmueble);
		i.setDireccion(direccion);
		i.setPrecio(precio);
		
		Propietario propietario = new Propietario();
		propietario.setIdPropietario(idPropietario);
		i.setPropietario(propietario);
		
		Inquilino inquilino = new Inquilino();
		inquilino.setIdInquilino(idInquilino);
		i.setInquilino(inquilino);
		
		
		return i;
	}
	
	public void fromInmueble(Inmueble i) {
		setIdInmueble(i.getIdInmueble());
		setDireccion(i.getDireccion());
		setPrecio(i.getPrecio());
		setIdPropietario( i.getPropietario().getIdPropietario() );
		
		if( i.getInquilino()!=null )
		{
			setIdInquilino( i.getInquilino().getIdInquilino() );
		}else {
				setIdInquilino(null);
			  }
	}
}
