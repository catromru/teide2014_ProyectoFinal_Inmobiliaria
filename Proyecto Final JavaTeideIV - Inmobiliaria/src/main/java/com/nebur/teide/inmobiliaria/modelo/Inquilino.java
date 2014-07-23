package com.nebur.teide.inmobiliaria.modelo;
// Generated 23-jul-2014 16:06:43 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Inquilino generated by hbm2java
 */
@Entity
@Table(name="inquilino"
    ,catalog="teide2014"
)
public class Inquilino  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = -6144268812341081609L;
	private Integer idInquilino;
     private String dni;
     private String nombre;
     private int edad;
     private boolean trabaja;
     private Set<Inmueble> inmuebles = new HashSet<Inmueble>(0);

    public Inquilino() {
    }

	
    public Inquilino(String dni, String nombre, int edad, boolean trabaja) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.trabaja = trabaja;
    }
    public Inquilino(String dni, String nombre, int edad, boolean trabaja, Set<Inmueble> inmuebles) {
       this.dni = dni;
       this.nombre = nombre;
       this.edad = edad;
       this.trabaja = trabaja;
       this.inmuebles = inmuebles;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idInquilino", unique=true, nullable=false)
    public Integer getIdInquilino() {
        return this.idInquilino;
    }
    
    public void setIdInquilino(Integer idInquilino) {
        this.idInquilino = idInquilino;
    }

    
    @Column(name="dni", nullable=false, length=45)
    public String getDni() {
        return this.dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }

    
    @Column(name="nombre", nullable=false, length=45)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="edad", nullable=false)
    public int getEdad() {
        return this.edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }

    
    @Column(name="trabaja", nullable=false)
    public boolean isTrabaja() {
        return this.trabaja;
    }
    
    public void setTrabaja(boolean trabaja) {
        this.trabaja = trabaja;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="inquilino")
    public Set<Inmueble> getInmuebles() {
        return this.inmuebles;
    }
    
    public void setInmuebles(Set<Inmueble> inmuebles) {
        this.inmuebles = inmuebles;
    }




}

