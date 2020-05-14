package Modelo;
	import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ConexionBBDD2 {

	private String url= "";
	private   String user = "";
	private String pwd = "";
	private   String usr = "";
	private   Connection conexion;

	public ConexionBBDD2()  {


		Properties propiedades = new Properties();
		InputStream entrada = null;
		try {
			File miFichero = new File("src/Modelo/Datos.ini");
			if (miFichero.exists()){
				entrada = new FileInputStream(miFichero);
				propiedades.load(entrada);
				url=propiedades.getProperty("url");
				user=propiedades.getProperty("user");
				pwd=propiedades.getProperty("pwd");
				usr=propiedades.getProperty("usr");
			}

			else
				System.out.println("Fichero no encontrado");
		} catch (IOException ex) {
			ex.printStackTrace();
		}finally {
			if (entrada != null) {
				try {
					entrada.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(url, user, pwd);

			if(conexion.isClosed())
				System.out.println("Fallo en Conexión con la Base de Datos");


		}catch (Exception e) {
			System.out.println("ERROR en conexión con ORACLE");
			e.printStackTrace();
		}
	}


	public int InsertarDonante(String numDonante, String nombre, String apellido1, String apellido2, String dNI_NIE, Date fechaNac,
			int tlf, int tLFMovil, String email, String sexo, String tipoSang, String direccion, String residencia,
			String provincia, String poblacion, int cP, String pais,String aptitud, Blob foto) throws SQLException{



		// Preparo la sentencia SQL
		String insertsql = "INSERT INTO " + usr +".DONANTES VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,NULL)";

		PreparedStatement pstmt = conexion.prepareStatement (insertsql);
		pstmt.setString(1, numDonante);
		pstmt.setString(2, nombre);
		pstmt.setString(3, apellido1);
		pstmt.setString(4, apellido2);
		pstmt.setString(5, dNI_NIE);
		pstmt.setDate(6, fechaNac);
		pstmt.setInt(7, tlf);
		pstmt.setInt(8, tLFMovil);
		pstmt.setString(9, email);
		pstmt.setString(10, sexo);
		pstmt.setString(11, tipoSang);
		pstmt.setString(12, direccion);
		pstmt.setString(13, residencia );
		pstmt.setString(14, poblacion );
		pstmt.setString(15, provincia);
		pstmt.setInt(16, cP);
		pstmt.setString(17, pais );
		pstmt.setString(18, aptitud );
		//ejecuto la sentencia
		try{
			int resultado = pstmt.executeUpdate();

			if(resultado != 1)
				System.out.println("Error en la inserción " + resultado);
			else
				System.out.println("Persona insertada con éxito!!!");

			return 0;
		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			if(codeErrorSQL.equals("ORA-00001") ){
				System.out.println("Ya existe una persona con  ese Número de donante!!");
				return 1;
			}
			if(codeErrorSQL.equals("ORA-00001") ){
				System.out.println("Ya existe una persona con  ese DNIE/NIE!!");
				return 1;
			}
			else{
				System.out.println("Ha habido algún problema con  Oracle al hacer la insercion");
				return 2;
			}

		}

	}
	}

