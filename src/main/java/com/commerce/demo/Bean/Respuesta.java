package com.commerce.demo.Bean;

public class Respuesta {
	private String respuesta;
	private String mensaje;
	
	public Respuesta(String respuesta, String mensaje) {
		super();
		this.respuesta = respuesta;
		this.mensaje = mensaje;
	}

	public Respuesta() {
		super();
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "Respuesta [respuesta=" + respuesta + ", mensaje=" + mensaje + "]";
	}
	
	
	

}
