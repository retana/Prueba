package org.retana.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="pais")
public class Pais {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idPais;
	@Column	private String nombre;
	public Pais(Integer idPais, String nombre) {
		super();
		this.idPais = idPais;
		this.nombre = nombre;
	}
	public Pais() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getIdPais() {
		return idPais;
	}
	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
