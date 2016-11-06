package org.retana.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="marca")
public class Marca {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idMarca;
	@Column	private String nombre;
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
		super();
		this.idMarca = idMarca;
		this.nombre = nombre;
	}
	
}
