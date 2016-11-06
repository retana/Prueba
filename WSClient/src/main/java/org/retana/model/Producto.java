package org.retana.model;

public class Producto {
	private Integer idProducto;
	private String codigo;
	private String modelo;
	private Double precio;
	private Integer garantia_meses;
	private Pais pais;
	private Marca marca;
	private TipoInstrumento tipoInstrumento;
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Integer getGarantia_meses() {
		return garantia_meses;
	}
	public void setGarantia_meses(Integer garantia_meses) {
		this.garantia_meses = garantia_meses;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	public TipoInstrumento getTipoInstrumento() {
		return tipoInstrumento;
	}
	public void setTipoInstrumento(TipoInstrumento tipoInstrumento) {
		this.tipoInstrumento = tipoInstrumento;
	}
	public Producto(Integer idProducto, String codigo, String modelo, Double precio, Integer garantia_meses, Pais pais,
			Marca marca, TipoInstrumento tipoInstrumento) {
		super();
		this.idProducto = idProducto;
		this.codigo = codigo;
		this.modelo = modelo;
		this.precio = precio;
		this.garantia_meses = garantia_meses;
		this.pais = pais;
		this.marca = marca;
		this.tipoInstrumento = tipoInstrumento;
	}
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
		
}