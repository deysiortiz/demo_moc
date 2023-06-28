package com.commerce.demo.Bean;

import org.springframework.web.multipart.MultipartFile;

public class SolicitudCredito {
	private String nroSolicitud;
	private String nroDocumento;
	private String estadoSolicitud;
	private String fecAprobacion;
	private String monto;
	private String moneda;
	private String plazo;
	private String destino;
	private MultipartFile archivo;
	
	public SolicitudCredito() {
		super();
	}
	public SolicitudCredito(String nroSolicitud, String nroDocumento, String estadoSolicitud, String monto,
			String moneda, String plazo, String destino, MultipartFile archivo) {
		super();
		this.nroSolicitud = nroSolicitud;
		this.nroDocumento = nroDocumento;
		this.estadoSolicitud = estadoSolicitud;
		this.monto = monto;
		this.moneda = moneda;
		this.plazo = plazo;
		this.destino = destino;
		this.archivo = archivo;
	}
	public String getNroSolicitud() {
		return nroSolicitud;
	}
	public void setNroSolicitud(String nroSolicitud) {
		this.nroSolicitud = nroSolicitud;
	}
	public String getNroDocumento() {
		return nroDocumento;
	}
	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}
	public String getEstadoSolicitud() {
		return estadoSolicitud;
	}
	public void setEstadoSolicitud(String estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
	}
	
	public String getFecAprobacion() {
		return fecAprobacion;
	}
	public void setFecAprobacion(String fecAprobacion) {
		this.fecAprobacion = fecAprobacion;
	}
	public String getMonto() {
		return monto;
	}
	public void setMonto(String monto) {
		this.monto = monto;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public String getPlazo() {
		return plazo;
	}
	public void setPlazo(String plazo) {
		this.plazo = plazo;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public MultipartFile getArchivo() {
		return archivo;
	}
	public void setArchivo(MultipartFile archivo) {
		this.archivo = archivo;
	}
	@Override
	public String toString() {
		return "SolicitudCredito [nroSolicitud=" + nroSolicitud + ", nroDocumento=" + nroDocumento
				+ ", estadoSolicitud=" + estadoSolicitud + ", fecAprobacion=" + fecAprobacion + ", monto=" + monto
				+ ", moneda=" + moneda + ", plazo=" + plazo + ", destino=" + destino + ", archivo=" + archivo + "]";
	}
	
	
	
	
	

}
