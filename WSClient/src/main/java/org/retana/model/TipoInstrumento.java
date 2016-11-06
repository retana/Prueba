package org.retana.model;


public class TipoInstrumento {
	private Integer idTipoInstrumento;
	private String nombre;
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
	public TipoInstrumento(Integer idTipoInstrumento) {
		this.idTipoInstrumento = idTipoInstrumento;
	}
}
