package Modelo;

import java.sql.Blob;
import java.sql.Date;

public class Donantes {

	private int NumDonante;
	private String Nombre;
	private String Apellido1;
	private String Apellido2;
	private String DNI_NIE;
	private String FechaNac;
	private int Tlf;
	private int TLFMovil;
	private String Email;
	private String Sexo;
	private String TipoSang;
	private String Direccion;
	private String Residencia;
	private String Provincia;
	private String Poblacion;
	private int CP;
	private String Pais;
	private String Aptitud;
	private Blob Foto;
	public Donantes(int numDonante, String nombre, String apellido1, String apellido2, String dNI_NIE, String fechaNac,
			int tlf, int tLFMovil, String email, String sexo, String tipoSang, String direccion, String residencia,
			String provincia, String poblacion, int cP, String pais, Blob foto) {
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
		Poblacion = poblacion;
		CP = cP;
		Pais = pais;
		Foto = foto;
	}
	public int getNumDonante() {
		return NumDonante;
	}
	public void setNumDonante(int numDonante) {
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
	public String getFechaNac() {
		return FechaNac;
	}
	public void setFechaNac(String fechaNac) {
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
	public String getPoblacion() {
		return Poblacion;
	}
	public void setPoblacion(String poblacion) {
		Poblacion = poblacion;
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
	public String getAptitud() {
		return Aptitud;
	}
	public void setAptitud(String aptitud) {
		Aptitud=aptitud;
	}
	public Blob getFoto() {
		return Foto;
	}
	public void setFoto(Blob foto) {
		Foto = foto;
	}
	
	
	
	
	}
