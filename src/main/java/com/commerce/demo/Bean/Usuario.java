package com.commerce.demo.Bean;

public class Usuario {
	private String usuario;
	private String contrasenha;
	
	public Usuario(String usuario, String contrasenha) {
		super();
		this.usuario = usuario;
		this.contrasenha = contrasenha;
	}

	public Usuario() {
		super();
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenha() {
		return contrasenha;
	}

	public void setContrasenha(String contrasenha) {
		this.contrasenha = contrasenha;
	}

	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", contrasenha=" + contrasenha + "]";
	}
	
	

}
