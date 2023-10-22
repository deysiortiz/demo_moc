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
			//rpta = clienteService.validarUsuario(usu, contrasenha);
			rpta.setCodigo("0");
			rpta.setMensaje("OK");
			return rpta;
			
			
			
		}
		
		//Consultar cliente
		@RequestMapping("/cliente/consultar/{documento}")
		//@RequestMapping(value="/cliente/consultar", method = RequestMethod.GET )
		public Cliente obtenerCliente(HttpServletRequest request, @PathVariable String documento){
		 
			Cliente cliente = new Cliente();
			//cliente=clienteService.obtenerCliente(documento);
			/*





	public String nomEmpresa;
	public String fecIngEmpresa;
	public String tipIngreso;
	public String mtoIngreso;
			 * */
			cliente.setNroDocumento("5100159");
			cliente.setTipDocumento("CI");
			cliente.setNombres("Deysi Ortiz");
			cliente.setApellidos("Ortiz Torales");
			cliente.setCiudadParticular("Asuncion");
			cliente.setFecNacimiento("19/12/1997");
			cliente.setDirParticular("dir partic");
			cliente.setCiudadParticular("luque");
			cliente.setObsDirParticular("ultima casa de la cuadra");
			cliente.setDirLaboral("dire laboral");
			cliente.setCiudadLaboral("asu");
			cliente.setObsDirLaboral("edificio azul");
			
			cliente.setNomEmpresa("banco prueba");
			cliente.setFecIngEmpresa("22/01/2020");
			
			cliente.setTipIngreso("iva");
			cliente.setMtoIngreso("2000000");
			
			return cliente;
			
		}
		
		//Dar de alta al cliente
		@RequestMapping(value = "/cliente/alta", method = RequestMethod.POST)
		public Respuesta altaCliente(HttpServletRequest request, @RequestBody Map<String, Object> requestBody) {
			  ObjectMapper objectMapper = new ObjectMapper();
			    Cliente cliente = objectMapper.convertValue(requestBody.get("cliente"), Cliente.class);
			    List<TelCliente> telefonos = objectMapper.convertValue(requestBody.get("telefonos"), new TypeReference<List<TelCliente>>() {});

		    //Respuesta rpta = clienteService.altaCliente(request, cliente, telefonos);
			    Respuesta rpta = new Respuesta();
			    rpta.setCodigo("0");
			    rpta.setMensaje("OK");
		    return rpta;
		}
	
	//Consultar solicitud
	@RequestMapping(value="/solicitud/consultar", method = RequestMethod.GET )
	public SolicitudCredito consultarSolicitud(HttpServletRequest request, String nroSolicitud, String nroDocumento){
	 
		SolicitudCredito solicitud = new SolicitudCredito();
		//solicitud =  clienteService.consultarSolicitud(request, nroSolicitud, nroDocumento);
		/* private String idSolicitud;
	private String idCliente;
	private String estadoSolicitud;
	private String fecSolicitud;
	private String monto;
	private String plazo;
	private String moneda;
	private String destino;
*/
		solicitud.setIdSolicitud("100");
		solicitud.setIdCliente("425");
		solicitud.setEstadoSolicitud("APR");
		solicitud.setFecSolicitud("22/09/2023");
		solicitud.setMonto("5000000");
		solicitud.setPlazo("24");
		solicitud.setMoneda("GS");
		solicitud.setDestino("heladera");
		return solicitud;
		
	} 
	
	//Dar de alta una solicitud
		@RequestMapping(value="/solicitud/alta", method = RequestMethod.POST )
	public Respuesta altaSolicitud(HttpServletRequest request, @RequestBody Map<String, Object> requestBody)  {
			ObjectMapper objectMapper = new ObjectMapper();
		    Cliente cliente = objectMapper.convertValue(requestBody.get("cliente"), Cliente.class);
		    SolicitudCredito solicitud = objectMapper.convertValue(requestBody.get("solicitud"), SolicitudCredito.class);
			
		Respuesta rpta= new Respuesta();
		
		//rpta = clienteService.altaSolicitud(request, cliente,solicitud);
		rpta.setCodigo("0");
	    rpta.setMensaje("OK");

		return rpta;

	}
	//lista de solicitudes por cliente	
	//Lista de solicitudes ingresadas por el comercio en rango desde hasta
		@RequestMapping(value="/solicitudes/consultar", method = RequestMethod.GET )
		public List<SolicitudCredito> consultarSolicitudes(String idCliente, String fecDesde, String fecHasta){
		 
			  //List<SolicitudCredito> solicitudes = clienteService.consultarSolicitudes(idCliente,fecDesde,fecHasta);
			List<SolicitudCredito> solicitudes = new ArrayList<>();
			solicitudes.add(new SolicitudCredito("0123", "425", "APR", "19/09/2023","5000000", "24", "GS", "heladera",null));
	        solicitudes.add(new SolicitudCredito("0124", "426", "REC", "20/09/2023","2000000", "12", "GS", "aire",null));
	        solicitudes.add(new SolicitudCredito("0125", "427", "APR","21/09/2023","1000000", "8", "GS", "licuadora",null));
			
			
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
			//List<CredCuota> lista = clienteService.simuladorCredito(cantidadCuotas, monto, tasInteres);			
			/*
			 *  private Integer nroCuota;
			    private BigDecimal montoInteres;
			    private BigDecimal montoCuota;
			    private BigDecimal montoTotal;
			    private String fechaVencimiento;
			    private BigDecimal montoCapital;
			 * 
			 * */
			List<CredCuota> lista = new ArrayList<>();
			BigDecimal unoInt = new BigDecimal(100000);
			BigDecimal dosInt = new BigDecimal(98000);
			BigDecimal tresInt = new BigDecimal(95000);
			
			//cuota
			BigDecimal unoCuo = new BigDecimal(200000);
			BigDecimal dosCuo = new BigDecimal(202000);
			BigDecimal tresCuo = new BigDecimal(205000);
			//mtototal
			BigDecimal unotot = new BigDecimal(300000);
			BigDecimal dostot = new BigDecimal(300000);
			BigDecimal trestot = new BigDecimal(300000);
			
			BigDecimal capuno = new BigDecimal(500000);
			BigDecimal capdos = new BigDecimal(300000);
			BigDecimal captres = new BigDecimal(200000);
			
			
			
			lista.add (new CredCuota(1,unoInt, unoCuo,unotot, "22/11/2023", capuno ));
			lista.add (new CredCuota(2,dosInt, dosCuo, dostot,"22/12/2023", capdos ));
			lista.add (new CredCuota(3,tresInt, tresCuo, trestot, "22/01/2024",captres));
			
			return lista;
			
		}
		
}
