package Modelo;

import java.sql.Date;

public class Donaciones {
	private String Codigo;
	private Date Fecha;
	private String Volumen;
	private String Tipo;
	private Date UltDonacion;
	public Donaciones(String codigo, Date fecha, String volumen, String tipo, Date ultDonacion) {
		super();
		Codigo = codigo;
		Fecha = fecha;
		Volumen = volumen;
		Tipo = tipo;
		UltDonacion = ultDonacion;
	}
	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	public String getVolumen() {
		return Volumen;
	}
	public void setVolumen(String volumen) {
		Volumen = volumen;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public Date getUltDonacion() {
		return UltDonacion;
	}
	public void setUltDonacion(Date ultDonacion) {
		UltDonacion = ultDonacion;
	}

}
