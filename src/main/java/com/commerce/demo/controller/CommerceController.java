package com.commerce.demo.controller;

import javax.sql.DataSource;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

///
import com.commerce.demo.Bean.*;
import com.commerce.demo.service.ClienteService;

import io.swagger.annotations.ApiParam;

	@RestController
	@RequestMapping("/commerce")
	public class CommerceController {
		
		// Inyecta el servicio de clientes
		@Autowired
		private ClienteService clienteService;
	    
		
		@RequestMapping(value="/valida/usuario/", method = RequestMethod.POST )
		public Respuesta validarUsuario(HttpServletRequest request,  @RequestBody Usuario usuario){
			 
			String usu = usuario.getUsuario();
			String contrasenha = usuario.getContrasenha();
			
			
			
			//aca validas contra bd
			Respuesta rpta= new Respuesta();
			rpta = clienteService.validarUsuario(usu, contrasenha);
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
		@RequestMapping(value = "/cliente/alta", method = RequestMethod.POST)
		public Respuesta altaCliente(HttpServletRequest request, @RequestBody Map<String, Object> requestBody) {
			  ObjectMapper objectMapper = new ObjectMapper();
			    Cliente cliente = objectMapper.convertValue(requestBody.get("cliente"), Cliente.class);
			    List<TelCliente> telefonos = objectMapper.convertValue(requestBody.get("telefonos"), new TypeReference<List<TelCliente>>() {});

		    Respuesta rpta = clienteService.altaCliente(request, cliente, telefonos);
		    return rpta;
		}
	
	//Consultar solicitud
	@RequestMapping(value="/solicitud/consultar", method = RequestMethod.GET )
	public SolicitudCredito consultarSolicitud(HttpServletRequest request, String nroSolicitud, String nroDocumento){
	 
		SolicitudCredito solicitud = new SolicitudCredito();
		solicitud =  clienteService.consultarSolicitud(request, nroSolicitud, nroDocumento);
		return solicitud;
		
	} 
	
	//Dar de alta una solicitud
		@RequestMapping(value="/solicitud/alta", method = RequestMethod.POST )
	public Respuesta altaSolicitud(HttpServletRequest request, @RequestBody Map<String, Object> requestBody)  {
			ObjectMapper objectMapper = new ObjectMapper();
		    Cliente cliente = objectMapper.convertValue(requestBody.get("cliente"), Cliente.class);
		    SolicitudCredito solicitud = objectMapper.convertValue(requestBody.get("solicitud"), SolicitudCredito.class);
			
		Respuesta rpta= new Respuesta();
		
		rpta = clienteService.altaSolicitud(request, cliente,solicitud);

		return rpta;

	}
	//lista de solicitudes por cliente	
	//Lista de solicitudes ingresadas por el comercio en rango desde hasta
		@RequestMapping(value="/solicitudes/consultar", method = RequestMethod.GET )
		public List<SolicitudCredito> consultarSolicitudes(String idCliente, String fecDesde, String fecHasta){
		 
			  List<SolicitudCredito> solicitudes = clienteService.consultarSolicitudes(idCliente,fecDesde,fecHasta);
			  return solicitudes;
			
		}	
    //Simulacion de creditos 
		@RequestMapping(value="/simulador/creditos/cuota", method = RequestMethod.GET )
		public List<CredCuota> simuladorCredito(
			@ApiParam(name = "cantidadCuotas", value = "Cantidad de cuotas del crédito.")
  			@RequestParam(value = "cantidadCuotas", required = true) int cantidadCuotas,
  			@ApiParam(name = "monto", value = "Monto del crédito.")
  			@RequestParam(value = "monto", required = true) BigDecimal monto,
  			@ApiParam(name = "tasInteres", value = "Tasa de interés.")
  			@RequestParam(value = "tasInteres", required = false) BigDecimal tasInteres
			) {
			List<CredCuota> lista = clienteService.simuladorCredito(cantidadCuotas, monto, tasInteres);			
			
			return lista;
			
		}
		
}
