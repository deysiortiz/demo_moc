package com.commerce.demo.Bean;

public class Cliente {
	public String nombre;
	public String apellidos;
	public String tipDocumento;
	public String nroDocumento;
	public String dirParticular;
	public String ciudadParticular;
	public String dirLaboral;
	public String ciudadLaboral;
	public String nomEmpresa;
	public String fecIngEmpresa;
	public String tipIngreso;
	public String mtoIngreso;
	public String datAdicional;
	
	
	
	public Cliente() {
		super();
	}



	public Cliente(String nombre, String apellidos, String tipDocumento, String nroDocumento, String dirParticular,
			String ciudadParticular, String dirLaboral, String ciudadLaboral, String nomEmpresa, String fecIngEmpresa,
			String tipIngreso, String mtoIngreso, String datAdicional) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.tipDocumento = tipDocumento;
		this.nroDocumento = nroDocumento;
		this.dirParticular = dirParticular;
		this.ciudadParticular = ciudadParticular;
		this.dirLaboral = dirLaboral;
		this.ciudadLaboral = ciudadLaboral;
		this.nomEmpresa = nomEmpresa;
		this.fecIngEmpresa = fecIngEmpresa;
		this.tipIngreso = tipIngreso;
		this.mtoIngreso = mtoIngreso;
		this.datAdicional = datAdicional;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellidos() {
		return apellidos;
	}



	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}



	public String getTipDocumento() {
		return tipDocumento;
	}



	public void setTipDocumento(String tipDocumento) {
		this.tipDocumento = tipDocumento;
	}



	public String getNroDocumento() {
		return nroDocumento;
	}



	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}



	public String getDirParticular() {
		return dirParticular;
	}



	public void setDirParticular(String dirParticular) {
		this.dirParticular = dirParticular;
	}



	public String getCiudadParticular() {
		return ciudadParticular;
	}



	public void setCiudadParticular(String ciudadParticular) {
		this.ciudadParticular = ciudadParticular;
	}



	public String getDirLaboral() {
		return dirLaboral;
	}



	public void setDirLaboral(String dirLaboral) {
		this.dirLaboral = dirLaboral;
	}



	public String getCiudadLaboral() {
		return ciudadLaboral;
	}



	public void setCiudadLaboral(String ciudadLaboral) {
		this.ciudadLaboral = ciudadLaboral;
	}



	public String getNomEmpresa() {
		return nomEmpresa;
	}



	public void setNomEmpresa(String nomEmpresa) {
		this.nomEmpresa = nomEmpresa;
	}



	public String getFecIngEmpresa() {
		return fecIngEmpresa;
	}



	public void setFecIngEmpresa(String fecIngEmpresa) {
		this.fecIngEmpresa = fecIngEmpresa;
	}



	public String getTipIngreso() {
		return tipIngreso;
	}



	public void setTipIngreso(String tipIngreso) {
		this.tipIngreso = tipIngreso;
	}



	public String getMtoIngreso() {
		return mtoIngreso;
	}



	public void setMtoIngreso(String mtoIngreso) {
		this.mtoIngreso = mtoIngreso;
	}



	public String getDatAdicional() {
		return datAdicional;
	}



	public void setDatAdicional(String datAdicional) {
		this.datAdicional = datAdicional;
	}



	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellidos=" + apellidos + ", tipDocumento=" + tipDocumento
				+ ", nroDocumento=" + nroDocumento + ", dirParticular=" + dirParticular + ", ciudadParticular="
				+ ciudadParticular + ", dirLaboral=" + dirLaboral + ", ciudadLaboral=" + ciudadLaboral + ", nomEmpresa="
				+ nomEmpresa + ", fecIngEmpresa=" + fecIngEmpresa + ", tipIngreso=" + tipIngreso + ", mtoIngreso="
				+ mtoIngreso + ", datAdicional=" + datAdicional + "]";
	}
	
	
	

}
