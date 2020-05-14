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


	public int InsertarDonante(String numDonante, String nombre, String apellido1, String apellido2, String dNI_NIE, String fnaci,
			String tLF, String movil, String email, String sexo, String tipoSang, String direccion, String residencia,
			String provincia, String poblacion, String cP, String pais,String aptitud, String foto) throws SQLException{



		// Preparo la sentencia SQL
		String insertsql = "INSERT INTO " + usr +".DONANTES VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,NULL)";

		PreparedStatement pstmt = conexion.prepareStatement (insertsql);
		pstmt.setString(1, numDonante);
		pstmt.setString(2, nombre);
		pstmt.setString(3, apellido1);
		pstmt.setString(4, apellido2);
		pstmt.setString(5, dNI_NIE);
		pstmt.setString(6, fnaci);
		pstmt.setString(7, tLF);
		pstmt.setString(8, movil);
		pstmt.setString(9, email);
		pstmt.setString(10, sexo);
		pstmt.setString(11, tipoSang);
		pstmt.setString(12, direccion);
		pstmt.setString(13, residencia );
		pstmt.setString(14, poblacion );
		pstmt.setString(15, provincia);
		pstmt.setString(16, cP);
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
	
	public ObservableList<Donantes>  ConsultaDonantes() throws SQLException{


        ObservableList<Donantes> ListaDonantes =  FXCollections.observableArrayList();

        //Preparo la conexión para ejecutar sentencias SQL de tipo update
        Statement stm = conexion.createStatement();

        // Preparo la sentencia SQL CrearTablaPersonas
        String selectsql = "SELECT * FROM "+usr+".DONANTES";
        PreparedStatement pstmt = conexion.prepareStatement(selectsql);
        //ejecuto la sentencia
        try{
            ResultSet resultado = pstmt.executeQuery();

            while(resultado.next()){
                Donantes person = new Donantes(resultado.getString(1), resultado.getString(2), resultado.getString(3), resultado.getString(4), resultado.getString(5),
                        resultado.getString(6), resultado.getInt(7), resultado.getInt(8), resultado.getString(9), resultado.getString(10), resultado.getString(11), resultado.getString(12), resultado.getString(13),
                        resultado.getString(14), resultado.getString(15), resultado.getInt(16), resultado.getString(17), resultado.getBlob(19));
                ListaDonantes.add(person);
            }

        }catch(SQLException sqle){



            System.out.println(sqle.getMessage());
        }

        return ListaDonantes;
    }
	}

