package org.retana.model;


public class Pais {
	private String idPais;
	private String nombre;
	private String href;
	public Pais(String idPais, String nombre) {
		super();
		this.idPais = idPais;
		this.nombre = nombre;
	}
	public Pais() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getIdPais() {
		return idPais;
	}
	public void setIdPais(String idPais) {
		this.idPais = idPais;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Pais(String idPais) {
		super();
		this.idPais = idPais;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	
}
