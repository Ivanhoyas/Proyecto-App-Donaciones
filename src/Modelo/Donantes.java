package Modelo;

import java.sql.Blob;
import java.sql.Date;

public class Donantes {

	private String NumDonante;
	private String Nombre;
	private String Apellido1;
	private String Apellido2;
	private String DNI_NIE;
	private Date FechaNac;
	private int Tlf;
	private int TLFMovil;
	private String Email;
	private String Sexo;
	private String TipoSang;
	private String Direccion;
	private String Residencia;
	private String Provincia;
	private String Pobacion;
	private int CP;
	private String Pais;
	private Blob Foto;
	public Donantes(String numDonante, String nombre, String apellido1, String apellido2, String dNI_NIE, Date fechaNac,
			int tlf, int tLFMovil, String email, String sexo, String tipoSang, String direccion, String residencia,
			String provincia, String pobacion, int cP, String pais, Blob foto) {
		super();
		NumDonante = numDonante;
		Nombre = nombre;
		Apellido1 = apellido1;
		Apellido2 = apellido2;
		DNI_NIE = dNI_NIE;
		FechaNac = fechaNac;
		Tlf = tlf;
		TLFMovil = tLFMovil;
		Email = email;
		Sexo = sexo;
		TipoSang = tipoSang;
		Direccion = direccion;
		Residencia = residencia;
		Provincia = provincia;
		Pobacion = pobacion;
		CP = cP;
		Pais = pais;
		Foto = foto;
	}
	public String getNumDonante() {
		return NumDonante;
	}
	public void setNumDonante(String numDonante) {
		NumDonante = numDonante;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido1() {
		return Apellido1;
	}
	public void setApellido1(String apellido1) {
		Apellido1 = apellido1;
	}
	public String getApellido2() {
		return Apellido2;
	}
	public void setApellido2(String apellido2) {
		Apellido2 = apellido2;
	}
	public String getDNI_NIE() {
		return DNI_NIE;
	}
	public void setDNI_NIE(String dNI_NIE) {
		DNI_NIE = dNI_NIE;
	}
	public Date getFechaNac() {
		return FechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		FechaNac = fechaNac;
	}
	public int getTlf() {
		return Tlf;
	}
	public void setTlf(int tlf) {
		Tlf = tlf;
	}
	public int getTLFMovil() {
		return TLFMovil;
	}
	public void setTLFMovil(int tLFMovil) {
		TLFMovil = tLFMovil;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getSexo() {
		return Sexo;
	}
	public void setSexo(String sexo) {
		Sexo = sexo;
	}
	public String getTipoSang() {
		return TipoSang;
	}
	public void setTipoSang(String tipoSang) {
		TipoSang = tipoSang;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getResidencia() {
		return Residencia;
	}
	public void setResidencia(String residencia) {
		Residencia = residencia;
	}
	public String getProvincia() {
		return Provincia;
	}
	public void setProvincia(String provincia) {
		Provincia = provincia;
	}
	public String getPobacion() {
		return Pobacion;
	}
	public void setPobacion(String pobacion) {
		Pobacion = pobacion;
	}
	public int getCP() {
		return CP;
	}
	public void setCP(int cP) {
		CP = cP;
	}
	public String getPais() {
		return Pais;
	}
	public void setPais(String pais) {
		Pais = pais;
	}
	public Blob getFoto() {
		return Foto;
	}
	public void setFoto(Blob foto) {
		Foto = foto;
	}
	
	
	
	
	}
