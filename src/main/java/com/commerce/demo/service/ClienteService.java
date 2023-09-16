package com.commerce.demo.service;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.commerce.demo.Bean.Cliente;
import com.commerce.demo.Bean.CredCuota;
import com.commerce.demo.Bean.Respuesta;
import com.commerce.demo.Bean.SolicitudCredito;
import com.commerce.demo.Bean.TelCliente;

public interface ClienteService {
	
	Respuesta validarUsuario(String usuario, String contrasenha);
	Cliente obtenerCliente(String documento);
	Respuesta altaCliente(HttpServletRequest request, Cliente cliente, List<TelCliente> telefonos);
	SolicitudCredito consultarSolicitud(HttpServletRequest request, String nroSolicitud,String nroDocumento);
	Respuesta altaSolicitud(HttpServletRequest request, Cliente cliente, SolicitudCredito solicitud);
	//reporte
	List<SolicitudCredito> consultarSolicitudes(String idCliente, String fecDesde, String fecHasta);
	List<CredCuota>simuladorCredito(Integer canCuotas, BigDecimal monto, BigDecimal tasInteres);

	}

