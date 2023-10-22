package com.commerce.demo.Bean;

import java.math.BigDecimal;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;



public class CredCuota implements SQLData {

    private Integer nroCuota;
    private BigDecimal montoInteres;
    private BigDecimal montoCuota;
    private BigDecimal montoTotal;
    private String fechaVencimiento;
    private BigDecimal montoCapital;

    
    
    private String nombreTipoSQL;

    public CredCuota(int i, BigDecimal unoInt, BigDecimal unoCuo, BigDecimal unotot, String string, BigDecimal capuno) {
		// TODO Auto-generated constructor stub
	}

	public int getNroCuota() {
        return nroCuota;
    }

    public void setNroCuota(int nroCuota) {
        this.nroCuota = nroCuota;
    }

    public BigDecimal getMontoInteres() {
        return montoInteres;
    }

    public void setMontoInteres(BigDecimal montoInteres) {
        this.montoInteres = montoInteres;
    }

    public BigDecimal getMontoCuota() {
        return montoCuota;
    }

    public void setMontoCuota(BigDecimal montoCuota) {
        this.montoCuota = montoCuota;
    }

    public BigDecimal getMontoCapital() {
        return montoCapital;
    }

    public void setMontoCapital(BigDecimal montoCapital) {
        this.montoCapital = montoCapital;
    }

    public String getNombreTipoSQL() {
        return nombreTipoSQL;
    }

    public void setNombreTipoSQL(String nombreTipoSQL) {
        this.nombreTipoSQL = nombreTipoSQL;
    }

    @Override
    public String getSQLTypeName() throws SQLException {
        return this.nombreTipoSQL;
    }
    
    

    public BigDecimal getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(BigDecimal montoTotal) {
		this.montoTotal = montoTotal;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	

	@Override
	public String toString() {
		return "CredCuota [nroCuota=" + nroCuota + ", montoInteres=" + montoInteres + ", montoCuota=" + montoCuota
				+ ", montoTotal=" + montoTotal + ", fechaVencimiento=" + fechaVencimiento + ", montoCapital="
				+ montoCapital + ", nombreTipoSQL=" + nombreTipoSQL + "]";
	}

	@Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException {
        nroCuota=stream.readInt();
        montoInteres=stream.readBigDecimal();
        montoCuota=stream.readBigDecimal();
        montoTotal=stream.readBigDecimal();
        fechaVencimiento=stream.readString();
        montoCapital=stream.readBigDecimal();
        this.nombreTipoSQL=typeName;
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {
        stream.writeInt(nroCuota);
        stream.writeBigDecimal(montoInteres);
        stream.writeBigDecimal(montoCuota);
        stream.writeBigDecimal(montoTotal);
        stream.writeString(fechaVencimiento);
        stream.writeBigDecimal(montoCapital);
    }
}
