package com.commerce.demo.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.jboss.logging.Logger;

import com.commerce.demo.Bean.Cliente;
import com.commerce.demo.Bean.CredCuota;
import com.commerce.demo.Bean.Respuesta;
import com.commerce.demo.Bean.SolicitudCredito;
import com.commerce.demo.Bean.TelCliente;
import com.commerce.demo.Bean.Usuario;
import com.commerce.demo.dao.ClientesDao;

import java.math.BigDecimal;
import java.sql.Array;
import java.util.ArrayList;
@Service

public class ClienteServiceImpl implements ClienteService {
	@Autowired
	ClientesDao clientesDAO;
	
	 private static final Logger logger = Logger.getLogger(ClienteServiceImpl.class);
	
	public Respuesta validarUsuario(String usuario, String contrasenha) {
		 
		Usuario user= new Usuario();
				
		Respuesta rpta= new Respuesta();
	    try {
			rpta = clientesDAO.validarUsuario(usuario, contrasenha);
		}catch (Exception e){
			logger.error("Ocurrió un error al realizar la consulta en el DAO: " + e.getMessage(), e);  
		}
		return rpta;
		
		
	}
	
	//Consultar cliente
	public Cliente obtenerCliente(String documento){
		Cliente cliente = new Cliente();
		try {
			cliente= clientesDAO.obtenerCliente(documento);
		}catch (Exception e){
			logger.error("Ocurrió un error al realizar la consulta en el DAO: " + e.getMessage(), e);  
		}
		return cliente;
		
	}
	
	//Dar de alta al cliente
	public Respuesta altaCliente(HttpServletRequest request, Cliente cliente, List<TelCliente> telefonos) {
		Respuesta rpta= new Respuesta();
		try {
			rpta= clientesDAO.altaCliente(request, cliente, telefonos);
		}catch (Exception e){
			logger.error("Ocurrió un error al realizar la consulta en el DAO: " + e.getMessage(), e);  
		}
		return rpta;

	}
	
	//Consultar solicitud
	public SolicitudCredito consultarSolicitud(HttpServletRequest request, String nroSolicitud, String nroDocumento){
	 
		SolicitudCredito solicitud = new SolicitudCredito();
		try {
			solicitud=clientesDAO.consultarSolicitud(request, nroSolicitud, nroDocumento);
		}catch (Exception e){
			logger.error("Ocurrió un error al realizar la consulta en el DAO: " + e.getMessage(), e);  
		}
		return solicitud;
		
	}
	
	//Dar de alta la solicitud
	public Respuesta altaSolicitud(HttpServletRequest request, Cliente cliente, SolicitudCredito solicitud) {
		Respuesta rpta= new Respuesta();
		try {
			rpta= clientesDAO.altaSolicitud(request, cliente,solicitud);
		}catch (Exception e){
			logger.error("Ocurrió un error al realizar la consulta en el DAO: " + e.getMessage(), e);  
		}
		return rpta;

	}
	
	public List<SolicitudCredito> consultarSolicitudes(String idCliente, String fecDesde, String fecHasta){
		 List<SolicitudCredito> listaSolicitudes = new ArrayList<>();
		 try {
			 listaSolicitudes= clientesDAO.consultarSolicitudes(idCliente, fecDesde,fecHasta);
			}catch (Exception e){
				logger.error("Ocurrió un error al realizar la consulta en el DAO: " + e.getMessage(), e);  
			}
		 
		return listaSolicitudes;
	}
	
	public List<CredCuota>simuladorCredito(Integer canCuotas, BigDecimal monto, BigDecimal tasInteres){
		List<CredCuota> listCuotas = new ArrayList<>();
		try {
			listCuotas= clientesDAO.simuladorCredito(canCuotas, monto,tasInteres);
			}catch (Exception e){
				logger.error("Ocurrió un error al realizar la consulta en el DAO: " + e.getMessage(), e);  
			}
		 
		return listCuotas;
	}
	
	

}