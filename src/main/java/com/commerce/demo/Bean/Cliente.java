package com.commerce.demo.Bean;

import java.sql.SQLException;

public class Cliente {
	public String nombres;
	public String apellidos;
	public String tipDocumento;
	public String nroDocumento;
	public String fecNacimiento;
	public String dirParticular;
	public String ciudadParticular;
	public String obsDirParticular;
	public String dirLaboral;
	public String ciudadLaboral;
	public String obsDirLaboral;
	public String nomEmpresa;
	public String fecIngEmpresa;
	public String tipIngreso;
	public String mtoIngreso;
	public String datAdicional;
	
	
	
	public Cliente() {
		super();
	}


	public Cliente(String nombres, String apellidos, String tipDocumento, String nroDocumento, String fecNacimiento, String dirParticular,
			String ciudadParticular, String obsDirParticular, String dirLaboral, String ciudadLaboral,
			String obsDirLaboral, String nomEmpresa, String fecIngEmpresa, String tipIngreso, String mtoIngreso,
			String datAdicional) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.tipDocumento = tipDocumento;
		this.nroDocumento = nroDocumento;
		this.fecNacimiento = fecNacimiento;
		this.dirParticular = dirParticular;
		this.ciudadParticular = ciudadParticular;
		this.obsDirParticular = obsDirParticular;
		this.dirLaboral = dirLaboral;
		this.ciudadLaboral = ciudadLaboral;
		this.obsDirLaboral = obsDirLaboral;
		this.nomEmpresa = nomEmpresa;
		this.fecIngEmpresa = fecIngEmpresa;
		this.tipIngreso = tipIngreso;
		this.mtoIngreso = mtoIngreso;
		this.datAdicional = datAdicional;
	}



	public String getNombres() {
		return nombres;
	}



	public void setNombres(String nombres) {
		this.nombres = nombres;
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
	
	public void setFecNacimiento(String fecNacimiento) {
		this.fecNacimiento = fecNacimiento;
	}

	public String getFecNacimiento() {
		return fecNacimiento;
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


	public String getObsDirParticular() {
		return obsDirParticular;
	}


	public void setObsDirParticular(String obsDirParticular) {
		this.obsDirParticular = obsDirParticular;
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


	public String getObsDirLaboral() {
		return obsDirLaboral;
	}


	public void setObsDirLaboral(String obsDirLaboral) {
		this.obsDirLaboral = obsDirLaboral;
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
		return "Cliente [nombres=" + nombres + ", apellidos=" + apellidos + ", tipDocumento=" + tipDocumento
				+ ", nroDocumento=" + nroDocumento + ", fecNacimiento=" + fecNacimiento +", dirParticular=" + dirParticular + ", ciudadParticular="
				+ ciudadParticular + ", obsDirParticular=" + obsDirParticular + ", dirLaboral=" + dirLaboral
				+ ", ciudadLaboral=" + ciudadLaboral + ", obsDirLaboral=" + obsDirLaboral + ", nomEmpresa=" + nomEmpresa
				+ ", fecIngEmpresa=" + fecIngEmpresa + ", tipIngreso=" + tipIngreso + ", mtoIngreso=" + mtoIngreso
				+ ", datAdicional=" + datAdicional + "]";
	}
	
	
}


