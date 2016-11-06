package org.retana.model;


public class Rol {
	private Integer idRol;
	private String nombre;
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
