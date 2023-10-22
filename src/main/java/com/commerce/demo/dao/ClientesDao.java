package com.commerce.demo.dao;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Repository;

import com.commerce.demo.Bean.Cliente;
import com.commerce.demo.Bean.CredCuota;
import com.commerce.demo.Bean.Respuesta;
import com.commerce.demo.Bean.SolicitudCredito;
import com.commerce.demo.Bean.TelCliente;

import java.math.BigDecimal;
import java.util.List;
@Repository
public interface ClientesDao {
	
	Respuesta validarUsuario(String usuario, String contrasenha);
	Cliente obtenerCliente(String documento);
	Respuesta altaCliente(HttpServletRequest request, Cliente cliente, List<TelCliente> telefonos);
	SolicitudCredito consultarSolicitud(HttpServletRequest request, String nroSolicitud, String nroDocumento);
	Respuesta altaSolicitud(HttpServletRequest request, Cliente cliente, SolicitudCredito solicitud);
	List<SolicitudCredito> consultarSolicitudes(String idCliente, String fecDesde, String fecHasta);
	List<CredCuota>simuladorCredito(Integer canCuotas, BigDecimal monto, BigDecimal tasInteres);
}
