package org.retana.controller;

import java.util.List;

import org.retana.bean.Marca;
import org.retana.bean.Pais;
import org.retana.bean.Producto;
import org.retana.bean.TipoInstrumento;
import org.retana.repository.MarcaRepository;
import org.retana.repository.PaisRepository;
import org.retana.repository.ProductoRepository;
import org.retana.repository.TipoInstrumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
	@RequestMapping("/productos")
	public List<Producto> lista(){
		return productoRepository.findAll();
	}
	@RequestMapping("/paises")
	public List<Pais> listaPais(){
		return paisRepository.findAll();
	}
	@RequestMapping("/marcas")
	public List<Marca> listaMarcas(){
		return marcaRepository.findAll();
	}
	@RequestMapping("/tipoInstrumento")
	public List<TipoInstrumento> listaTipoInstrumento(){
		return tipoInstrumentoRepository.findAll();
	}
	@RequestMapping("/search")
	public List<Producto> buscarModelo(@RequestParam String modelo){
		System.out.println("Modelo: "+modelo);
		return productoRepository.findByModelo(modelo);
	}
	@Autowired
	private ProductoRepository productoRepository;
	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private MarcaRepository marcaRepository;
	@Autowired
	private TipoInstrumentoRepository tipoInstrumentoRepository;
	
}
