package org.retana.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.retana.model.ListaMarca;
import org.retana.model.ListaPais;
import org.retana.model.ListaProducto;
import org.retana.model.ListaTipoInstrumento;
import org.retana.model.Marca;
import org.retana.model.Pais;
import org.retana.model.Producto;
import org.retana.model.Rol;
import org.retana.model.TipoInstrumento;
import org.retana.model.Usuario;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Controller
public class AplicationController {
	public static final String URL_BASE = "http://localhost:9000/api/v1/";
	public static final String URL_SERVER= "http://localhost:9000/";
	@RequestMapping("/")
	public String index(HttpServletRequest req,HttpServletResponse res){
		Usuario usuario=new Usuario(1,"Probando ando","test","test",new Rol());
		req.setAttribute("usuario",usuario);
		return "index";
	}
	@RequestMapping("/agregar")
	public String agregar(HttpServletRequest req,HttpServletResponse res){
		HttpHeaders header=(HttpHeaders)req.getSession().getAttribute("header");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ListaMarca> marcasResponse=null;
		ResponseEntity<ListaTipoInstrumento> tiposResponse=null;
		ResponseEntity<ListaPais> paisesResponse=null;
		HttpEntity<String> request = new HttpEntity<String>(header);
		try{
			marcasResponse=restTemplate.exchange(URL_SERVER+"marcas",HttpMethod.GET,request,ListaMarca.class);
			tiposResponse=restTemplate.exchange(URL_SERVER+"tipoInstrumento",HttpMethod.GET,request,ListaTipoInstrumento.class);
			paisesResponse=restTemplate.exchange(URL_SERVER+"paises",HttpMethod.GET,request,ListaPais.class);
		}catch(HttpClientErrorException ex){
			ex.printStackTrace();
		}
		req.setAttribute("listaMarcas", marcasResponse.getBody());
		req.setAttribute("listaPaises",paisesResponse.getBody());
		req.setAttribute("listaTipos",  tiposResponse.getBody());
		return "agregar";
	}
	@RequestMapping("/dashboard")
	public String dashboard(HttpServletRequest req,HttpServletResponse res){
		HttpHeaders header=(HttpHeaders)req.getSession().getAttribute("header");
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> request = new HttpEntity<String>(header);
		ResponseEntity<ListaProducto> productosResponse=null;
		try{
			productosResponse=restTemplate.exchange(URL_SERVER+"productos",HttpMethod.GET,request,ListaProducto.class);
		}catch(HttpClientErrorException ex){
			ex.printStackTrace();
		}
		req.setAttribute("listaProductos", productosResponse.getBody());
		return "dashboard";
	}
	@RequestMapping("/Login.do")
	public String login(HttpServletRequest req,HttpServletResponse res){
		HttpHeaders header=getHeaders(req.getParameter("txtUsuario"), req.getParameter("txtContrasena"));
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> request = new HttpEntity<String>(header);
		ResponseEntity<Usuario> response=null;
		ResponseEntity<ListaProducto> productosResponse=null;
		try{
			response = restTemplate.exchange(URL_BASE+"usuario/search/findByEmail?email="+req.getParameter("txtUsuario"), HttpMethod.GET, request, Usuario.class);
			productosResponse=restTemplate.exchange(URL_SERVER+"productos",HttpMethod.GET,request,ListaProducto.class);
		}catch(HttpClientErrorException ex){
			ex.printStackTrace();
			return "index";
		}
		if(response.hasBody()==true){
			HttpSession sesion=req.getSession(true);
			sesion.setAttribute("header",header);
			sesion.setAttribute("usuario", response.getBody());
			req.setAttribute("listaProductos", productosResponse.getBody());
			sesion.setAttribute("request", request);
			return "dashboard";
		}
		req.setAttribute("usuario", new Usuario(1,"Probando ando","test","test",new Rol()));
		return "index";
	}
	@RequestMapping("/AgregarProducto.do")
	public String agregarProducto(HttpServletRequest req,HttpServletResponse res){
		HttpHeaders header=(HttpHeaders)req.getSession().getAttribute("header");
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity request = new HttpEntity("{\"idProducto\":\"null\",\"codigo\":\""+req.getParameter("txtCodigo")+"\",\"modelo\":\""+req.getParameter("txtModelo")+"\",\"precio\":"+req.getParameter("txtPrecio")+",\"garantia_meses\": "+req.getParameter("txtGarantia")+",\"pais\":\""+URL_BASE+"pais/"+req.getParameter("txtPais")+"\",\"marca\":\""+URL_BASE+"marca/"+req.getParameter("txtMarca")+"\",\"tipoInstrumento\":\""+URL_BASE+"tipoInstrumento/"+req.getParameter("txtTipoInstrumento")+"\"}",header);
		restTemplate.postForEntity(URL_BASE+"producto", request,String.class);
		
		ResponseEntity<ListaProducto> productosResponse=null;
		try{
			productosResponse=restTemplate.exchange(URL_SERVER+"productos",HttpMethod.GET,request,ListaProducto.class);
		}catch(HttpClientErrorException ex){
			ex.printStackTrace();
		}
		req.setAttribute("listaProductos", productosResponse.getBody());
		return "dashboard";
	}
	@RequestMapping("/Logout.do")
	public String logout(HttpServletRequest req,HttpServletResponse res){
		req.getSession().removeAttribute("usuario");
		req.getSession().removeAttribute("header");
		req.getSession().invalidate();
		return "index";
	}
	@RequestMapping("/BuscarProducto.do")
	public String buscarProducto(HttpServletRequest req,HttpServletResponse res){
		HttpHeaders header=(HttpHeaders)req.getSession().getAttribute("header");
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity request = new HttpEntity(header);
		ResponseEntity<ListaProducto> productosResponse=null;
		System.out.println(URL_SERVER+"search?modelo="+req.getParameter("txtBuscar"));
		try{
			productosResponse=restTemplate.exchange(URL_SERVER+"search?modelo="+req.getParameter("txtBuscar"),HttpMethod.GET,request,ListaProducto.class);
		}catch(HttpClientErrorException ex){
			ex.printStackTrace();
		}
		req.setAttribute("listaProductos", productosResponse.getBody());
		return "dashboard";
	}
	public static HttpHeaders getHeaders(String email,String contrasena){
        String plainCredentials=email+":"+contrasena;
        String base64Credentials = new String(Base64.encodeBase64(plainCredentials.getBytes()));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.add("Authorization", "Basic " + base64Credentials);
        headers.add("ContentType", "application/json");
        headers.add("Acept", "application/x-spring-data-verbose+json");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return headers;
    }
	
}
