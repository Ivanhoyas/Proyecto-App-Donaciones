package Modelo;
	import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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
				System.out.println("Fallo en Conexi�n con la Base de Datos");


		}catch (Exception e) {
			System.out.println("ERROR en conexi�n con ORACLE");
			e.printStackTrace();
		}
	}


	public void InsertarDonante(String ndonante, String nombre, String apellido_1, String apellido_2,
			String dNI_Pasaporte, String fecha_naci, String tLF, String movil, String email, String sexo,
			String tipo_sanguineo, String direccion, String t_residencia, String poblacion, String provinvia,
			String cP, String pais_naci, String aptitud, String foto) throws SQLException{

		//Preparo la conexion para ejecutar sentencias SQL de tipo update
		Statement stm = conexion.createStatement();

		// Preparo la sentencia SQL CrearTablaPersonas
		String insertsql = "INSERT INTO "+usr+".DONANTES VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,NULL)";
		
		PreparedStatement pstmt = conexion.prepareStatement(insertsql);
		pstmt.setString(1, ndonante);
		pstmt.setString(2, nombre);
		pstmt.setString(3, apellido_1);
		pstmt.setString(4, apellido_2);
		pstmt.setString(5, dNI_Pasaporte);
		pstmt.setString(6, fecha_naci);
		pstmt.setString(7, tLF);
		pstmt.setString(8, movil);
		pstmt.setString(9, email);
		pstmt.setString(10, sexo);
		pstmt.setString(11, tipo_sanguineo);
		pstmt.setString(12, direccion);
		pstmt.setString(13, t_residencia);
		pstmt.setString(14, poblacion);
		pstmt.setString(15, provinvia);
		pstmt.setString(16, cP);
		pstmt.setString(17, pais_naci);
		pstmt.setString(18, aptitud);
		
		//ejecuto la sentencia
		try{
			pstmt.executeUpdate();
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("DONANTE INTRODUCIDO");
		alert.setHeaderText("Un donante ha sido introducido con exito");
		alert.setContentText("El donante ha sido guardado con exito en la Base de Datos");
		alert.showAndWait();

		}
		catch(SQLException sqle) {
			
			int pos = sqle.getMessage().indexOf(":");
			String sqlerror = sqle.getMessage().substring(0,pos);
			
			if (sqlerror.equals("ORA-00001")) {
				System.out.println("Ya existe ese numero de donante en la BBDD");
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!!!");
				alert.setHeaderText("Este numero de donante ya existe en la base de datos");
				alert.setContentText("�No se puede guardar un numero de donante que ya existe!");
				alert.showAndWait();
				
			}else {
				System.out.println(sqle.getMessage());
				System.out.println("Un error ha ocurrido");
				
			}
		}
	}
	
	public void UpdateDonante(String ndonante, String nombre, String apellido_1, String apellido_2,
			String dNI_Pasaporte, String fecha_naci, String tLF, String movil, String email, String sexo,
			String tipo_sanguineo, String direccion, String t_residencia, String poblacion, String provinvia,
			String cP, String pais_naci, String aptitud, String foto) throws SQLException{

		//Preparo la conexion para ejecutar sentencias SQL de tipo update
		Statement stm = conexion.createStatement();

		// Preparo la sentencia SQL CrearTablaPersonas
		String updatesql ="UPDATE "+usr+".DONANTES SET NOMBRE=?, APELLIDO_1=?, APELLIDO_2=?, DNI_NIE=?, FECHA_NAC=?,  TLF=?, TLF_MOV=?, EMAIL=?,SEXO=?, TIPO_SANGUINEO=?, DIRECCION=?, T_RESIDENCIA=?,POBLACION=?, PROVINVIA=?, CP=?, Pais_naci=?, Aptitud=? WHERE ndonante=?";
		
		PreparedStatement pstmt = conexion.prepareStatement(updatesql);
		pstmt.setString(1, ndonante);
		pstmt.setString(2, nombre);
		pstmt.setString(3, apellido_1);
		pstmt.setString(4, apellido_2);
		pstmt.setString(5, dNI_Pasaporte);
		pstmt.setString(6, fecha_naci);
		pstmt.setString(7, tLF);
		pstmt.setString(8, movil);
		pstmt.setString(9, email);
		pstmt.setString(10, sexo);
		pstmt.setString(11, tipo_sanguineo);
		pstmt.setString(12, direccion);
		pstmt.setString(13, t_residencia);
		pstmt.setString(14, poblacion);
		pstmt.setString(15, provinvia);
		pstmt.setString(16, cP);
		pstmt.setString(17, pais_naci);
		pstmt.setString(18, aptitud);
		
		//ejecuto la sentencia
		try{
			pstmt.executeUpdate();
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("DONANTE ACTUALIZADO");
		alert.setHeaderText("Un donante ha sido actualizado con exito");
		alert.setContentText("El donante ha sido actualizado con exito en la Base de Datos");
		alert.showAndWait();

		}
		catch(SQLException sqle) {
			
			int pos = sqle.getMessage().indexOf(":");
			String sqlerror = sqle.getMessage().substring(0,pos);
			
			if (sqlerror.equals("ORA-00001")) {
				System.out.println("Ya existe ese numero de donante en la BBDD");
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!!!");
				alert.setHeaderText("Este numero de donante ya existe en la base de datos");
				alert.setContentText("�No se puede guardar un numero de donante que ya existe!");
				alert.showAndWait();
				
			}else {
				System.out.println(sqle.getMessage());
				System.out.println("Un error ha ocurrido");
				
			}
		}
	}
	
	public ObservableList<Donantes>  ConsultaDonantes() throws SQLException{


        ObservableList<Donantes> ListaDonantes =  FXCollections.observableArrayList();

        //Preparo la conexi�n para ejecutar sentencias SQL de tipo update
        Statement stm = conexion.createStatement();

        // Preparo la sentencia SQL CrearTablaPersonas
        String selectsql = "SELECT * FROM "+usr+".DONANTES";
        PreparedStatement pstmt = conexion.prepareStatement(selectsql);
        //ejecuto la sentencia
        try{
            ResultSet resultado = pstmt.executeQuery();

            while(resultado.next()){
                Donantes person = new Donantes(resultado.getInt(1), resultado.getString(2), resultado.getString(3), resultado.getString(4), resultado.getString(5),
                        resultado.getString(6), resultado.getInt(7), resultado.getInt(8), resultado.getString(9), resultado.getString(10), resultado.getString(11), resultado.getString(12), resultado.getString(13),
                        resultado.getString(14), resultado.getString(15), resultado.getInt(16), resultado.getString(17), resultado.getBlob(19));
                ListaDonantes.add(person);
            }

        }catch(SQLException sqle){



            System.out.println(sqle.getMessage());
        }

        return ListaDonantes;
    }
	public void EliminarDonante(int ndonante) throws SQLException{    
	
		Statement stm = conexion.createStatement();
  
		String insertsql = "DELETE FROM "+usr+".DONANTES WHERE Ndonante=?"; 
		PreparedStatement pstmt = conexion.prepareStatement(insertsql);    
		pstmt.setInt(1, ndonante);    
    
		try{      
			pstmt.executeUpdate();                   
		Alert alert = new Alert(AlertType.CONFIRMATION);      
		alert.setTitle("DELETE EXITOSO");   
		alert.setHeaderText("HAS ELIMINADO A UN DONANTE");       
		alert.setContentText("El donante ha sido eliminado de la base de datos");
		alert.showAndWait();    
		}    
		catch(SQLException sqle) {       
			int pos = sqle.getMessage().indexOf(":");
			String sqlerror = sqle.getMessage().substring(0,pos);
			if (sqlerror.equals("ORA-00001")) { 
				System.out.println(sqle.getMessage());       
				}else {       
					System.out.println(sqle.getMessage());    
					System.out.println("Un error ha ocurrido");
					}
			}
		
	}
	public ObservableList<Donantes> BuscarDonante(String DniNie) throws SQLException{

		ObservableList<Donantes> listaDonantes =  FXCollections.observableArrayList();     
		//Preparo la conexi�n para ejecutar sentencias SQL de tipo update
		Statement stm = conexion.createStatement(); 
		// Preparo la sentencia SQL CrearTablaPersonas 
		String selectsql = "SELECT * FROM "+usr+".DONANTES WHERE DNI_NIE=?";    
		PreparedStatement pstmt = conexion.prepareStatement(selectsql);     
		pstmt.setString(1, DniNie);




		//ejecuto la sentencia
		try{
			ResultSet resultado = pstmt.executeQuery();

			int contador = 0;
			while(resultado.next()){
				contador++;

				int numDonante = resultado.getInt(1);
				String nombre = resultado.getString(2);
				String apellido1 = resultado.getString(3);
				String apellido2 = resultado.getString(4);
				String dNI_NIE = resultado.getString(5);
				String fechaNac = resultado.getString(6);
				int tlf = resultado.getInt(7);
				int tLFMovil = resultado.getInt(8);
				String email = resultado.getString(9);
				String sexo = resultado.getString(10);
				String tipoSang = resultado.getString(11);
				String direccion = resultado.getString(12);
				String residencia = resultado.getString(13);
				String provincia = resultado.getString(14);
				String poblacion = resultado.getString(15);
				int cP = resultado.getInt(16);
				String pais = resultado.getString(17);
				
			

				Donantes nueva = new Donantes(numDonante,  nombre,  apellido1,  apellido2,  dNI_NIE,  fechaNac,
						 tlf,  tLFMovil, email,  sexo,  tipoSang,  direccion,  residencia,
						 provincia,  poblacion,  cP,  pais, null);
				listaDonantes.add(nueva);
			}

			if(contador==0)
				System.out.println("no data found");

		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			System.out.println(codeErrorSQL);
		}

		return listaDonantes;
	}
	}

