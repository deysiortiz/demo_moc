package com.commerce.demo.Bean;

import org.springframework.web.multipart.MultipartFile;

public class SolicitudCredito {
	private String idSolicitud;
	private String idCliente;
	private String estadoSolicitud;
	private String fecSolicitud;
	private String monto;
	private String plazo;
	private String moneda;
	private String destino;
	private MultipartFile archivo;
	
	public SolicitudCredito() {
		super();
	}

	public SolicitudCredito(String idSolicitud, String idCliente, String estadoSolicitud, String fecSolicitud,
			String monto, String plazo, String moneda, String destino, MultipartFile archivo) {
		super();
		this.idSolicitud = idSolicitud;
		this.idCliente = idCliente;
		this.estadoSolicitud = estadoSolicitud;
		this.fecSolicitud = fecSolicitud;
		this.monto = monto;
		this.plazo = plazo;
		this.moneda = moneda;
		this.destino = destino;
		this.archivo = archivo;
	}

	public String getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(String idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getEstadoSolicitud() {
		return estadoSolicitud;
	}

	public void setEstadoSolicitud(String estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
	}

	public String getFecSolicitud() {
		return fecSolicitud;
	}

	public void setFecSolicitud(String fecSolicitud) {
		this.fecSolicitud = fecSolicitud;
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

	public String getPlazo() {
		return plazo;
	}

	public void setPlazo(String plazo) {
		this.plazo = plazo;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
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
		return "SolicitudCredito [idSolicitud=" + idSolicitud + ", idCliente=" + idCliente + ", estadoSolicitud="
				+ estadoSolicitud + ", fecSolicitud=" + fecSolicitud + ", monto=" + monto + ", plazo=" + plazo
				+ ", moneda=" + moneda + ", destino=" + destino + ", archivo=" + archivo + "]";
	}
	
	

}
