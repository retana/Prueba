package org.retana.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="tipo_instrumento")
public class TipoInstrumento {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTipoInstrumento;
	@Column	private String nombre;
	public Integer getIdTipoInstrumento() {
		return idTipoInstrumento;
	}
	public void setIdTipoInstrumento(Integer idTipoInstrumento) {
		this.idTipoInstrumento = idTipoInstrumento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public TipoInstrumento(Integer idTipoInstrumento, String nombre) {
		super();
		this.idTipoInstrumento = idTipoInstrumento;
		this.nombre = nombre;
	}
	public TipoInstrumento() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
