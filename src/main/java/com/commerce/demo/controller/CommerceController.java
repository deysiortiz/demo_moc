package com.commerce.demo.controller;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

///
import com.commerce.demo.Bean.*;
import com.commerce.demo.service.ClienteService;

@RestController
@RequestMapping("/commerce")
public class CommerceController {
	
	// Inyecta el servicio de clientes
	@Autowired
	private ClienteService clienteService;
    
	
	@RequestMapping(value="/valida/usuario/{usuario}", method = RequestMethod.POST )
	public Respuesta validarUsuario(HttpServletRequest request, String usuario, String contrasenha){
		 
		Usuario user= new Usuario();
		
		//aca validas contra bd
		Respuesta rpta= new Respuesta();
		rpta = clienteService.validarUsuario(usuario, contrasenha);
		return rpta;
		
		
		
	}
	
	//Consultar cliente
	@RequestMapping("/cliente/consultar/{documento}")
	//@RequestMapping(value="/cliente/consultar", method = RequestMethod.GET )
	public Cliente obtenerCliente(HttpServletRequest request, @PathVariable String documento){
	 
		Cliente cliente = new Cliente();
		cliente=clienteService.obtenerCliente(documento);
		return cliente;
		
	}
	
	//Dar de alta al cliente
	@RequestMapping(value="/cliente/alta", method = RequestMethod.POST )
	public Respuesta altaCliente(HttpServletRequest request, Cliente cliente, List<TelCliente> telefonos) {
		Respuesta rpta= new Respuesta();
		rpta = clienteService.altaCliente(request, cliente, telefonos);
		return rpta;

	}
	
	//Consultar solicitud
	@RequestMapping(value="/solicitud/consultar", method = RequestMethod.GET )
	public SolicitudCredito consultarSolicitud(HttpServletRequest request, String nroSolicitud, String nroDocumento){
	 
		SolicitudCredito solicitud = new SolicitudCredito();
		solicitud =  clienteService.consultarSolicitud(request, nroSolicitud, nroDocumento);
		return solicitud;
		
	} 
	
	//Dar de alta al solcitud
		@RequestMapping(value="/solicitud/alta", method = RequestMethod.POST )
	public Respuesta altaSolicitud(HttpServletRequest request, Cliente cliente, SolicitudCredito solicitud)  {
		Respuesta rpta= new Respuesta();
		
		rpta = clienteService.altaSolicitud(request, cliente,solicitud);

		return rpta;

	}
	//lista de solicitudes por cliente	
		//Consultar solicitud
		@RequestMapping(value="/solicitudes/consultar", method = RequestMethod.GET )
		public List<SolicitudCredito> consultarSolicitudes(String idCliente, String fecDesde, String fecHasta){
		 
			  List<SolicitudCredito> solicitudes = clienteService.consultarSolicitudes(idCliente,fecDesde,fecHasta);
			  return solicitudes;
			
		}	
	//Lista de solicitudes ingresadas por el comercio en rango desde hasta
    //Simulacion de creditos 
}
