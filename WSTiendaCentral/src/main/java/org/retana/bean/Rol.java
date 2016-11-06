package org.retana.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="rol")
public class Rol {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idRol;
	@Column private String nombre;
	public Rol(Integer idRol, String nombre) {
		super();
		this.idRol = idRol;
		this.nombre = nombre;
	}
	public Rol() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getIdRol() {
		return idRol;
	}
	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
