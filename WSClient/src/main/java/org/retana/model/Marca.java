package org.retana.model;

public class Marca {
	private Integer idMarca;
	private String nombre;
	public Integer getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Marca() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Marca(Integer idMarca, String nombre) {
		this.idMarca = idMarca;
		this.nombre = nombre;
	}
	public Marca(Integer idMarca) {
		this.idMarca = idMarca;
	}
	
}
