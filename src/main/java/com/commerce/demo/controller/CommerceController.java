package com.commerce.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

///
import com.commerce.demo.Bean.*;

@RestController
@RequestMapping("/commerce")
public class CommerceController {
	
	@RequestMapping(value="/valida/usuario", method = RequestMethod.POST )
	public Respuesta validarUsuario(HttpServletRequest request, String usuario, String contrasenha){
		 
		Usuario user= new Usuario();
		
		//aca validas contra bd
		
		Respuesta rpta= new Respuesta();
		rpta.setRespuesta("OK");
		rpta.setMensaje("Usuario validado");
		return rpta;
		
		
	}
	
	//Consultar cliente
	@RequestMapping(value="/cliente/consultar", method = RequestMethod.GET )
	public Cliente obtenerCliente(HttpServletRequest request){
	 
		Cliente cliente = new Cliente();
		
		cliente.setApellidos("Ortiz Torales");
		cliente.setNombre("Deysi");
		cliente.setNroDocumento("5100159");
		return cliente;
		
	}
	
	//Dar de alta al cliente
	@RequestMapping(value="/cliente/alta", method = RequestMethod.POST )
	public Respuesta altaCliente(HttpServletRequest request, Cliente cliente) {
		Respuesta rpta= new Respuesta();
		rpta.setRespuesta("OK");
		rpta.setMensaje("Cliente creado");
		return rpta;

	}
	
	//Consultar solicitud
	@RequestMapping(value="/solicitud/consultar", method = RequestMethod.GET )
	public SolicitudCredito consultarSolicitud(HttpServletRequest request){
	 
		SolicitudCredito solicitud = new SolicitudCredito();
		
		solicitud.setNroSolicitud("010101");
		solicitud.setEstadoSolicitud("APROBADA");
		solicitud.setMoneda("GS");
		solicitud.setMonto("10000000");
		solicitud.setDestino("Lavarropas 3000");
		return solicitud;
		
	}
	
	//Dar de alta al solcitud
		@RequestMapping(value="/cliente/alta", method = RequestMethod.POST )
	public Respuesta altaSolicitud(HttpServletRequest request, Cliente cliente) {
		Respuesta rpta= new Respuesta();
		rpta.setRespuesta("OK");
		rpta.setMensaje("Solicitud ingresada");
		return rpta;

	}
	
	
}
