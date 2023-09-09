package com.commerce.demo.Bean;

public class TelCliente {
	public String idCliente;
	public String tipTelefono;
	public String nroTelefono;
	public String telPrincipal;
	
	
	public TelCliente() {
		super();
	}



	public TelCliente(String idCliente, String tipTelefono, String nroTelefono, String telPrincipal) {
		super();
		this.idCliente = idCliente;
		this.tipTelefono = tipTelefono;
		this.nroTelefono = nroTelefono;
		this.telPrincipal = telPrincipal;
	}



	public String getIdCliente() {
		return idCliente;
	}



	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}



	public String getTipTelefono() {
		return tipTelefono;
	}



	public void setTipTelefono(String tipTelefono) {
		this.tipTelefono = tipTelefono;
	}



	public String getNroTelefono() {
		return nroTelefono;
	}



	public void setNroTelefono(String nroTelefono) {
		this.nroTelefono = nroTelefono;
	}



	public String getTelPrincipal() {
		return telPrincipal;
	}



	public void setTelPrincipal(String telPrincipal) {
		this.telPrincipal = telPrincipal;
	}



	@Override
	public String toString() {
		return "TelCliente [idCliente=" + idCliente + ", tipTelefono=" + tipTelefono + ", nroTelefono=" + nroTelefono
				+ ", telPrincipal=" + telPrincipal + "]";
	}
	
	
	
	

}
