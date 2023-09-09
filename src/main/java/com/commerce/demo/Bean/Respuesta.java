package com.commerce.demo.Bean;

public class Respuesta {
	private String codigo;
	private String mensaje;
	
	public Respuesta(String respuesta, String mensaje) {
		super();
		this.codigo = respuesta;
		this.mensaje = mensaje;
	}

	public Respuesta() {
		super();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "Respuesta [codigo=" + codigo + ", mensaje=" + mensaje + "]";
	}
	
	
	

}
