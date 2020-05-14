package Vista;

import java.sql.Blob;
import java.sql.SQLException;

import Controlador.Main;
import Modelo.ConexionBBDD2;
import Modelo.Donantes;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class ControladoraDonantes {

	private  Main ProgramaPrincipal;

	@FXML
	private Button buttonclose;

	@FXML
	private Button buttonWindows3;
	@FXML     
	private TextField txtNdonante;
	@FXML 
	private TextField txtNonmbre; 
	@FXML
	private TextField txtApellido1; 
	@FXML   
	private TextField txtApellido2; 
	@FXML 
	private Button btnFoto;   
	@FXML    
	private TextField txtDNI;  
	@FXML  
	private TextField txtFecha_nacimiento;   
	@FXML 
	private TextField txtTlf;    
	@FXML 
	private TextField txtTlfMovil;  
	@FXML  
	private TextField txtEmail;
	@FXML 
	RadioButton hombre; 
	@FXML 
	RadioButton mujer;   
	@FXML  
	ToggleGroup sexo;     
	@FXML 
	private TextField txtTipoSangre;  
	@FXML  
	private TextField txtDireccion;   
	@FXML 
	private TextField txtTipoResidencia; 
	@FXML
	private TextField txtPoblacion;   
	@FXML  
	private TextField txtProvincia;  
	@FXML 
	private TextField txtCP;  
	@FXML 
	private TextField txtPaisNatal;   
	
	@FXML     
	private Button btnNuevoDonante;        
	@FXML    
	private Button btnActualizarDonante;         
	@FXML     
	private Button btnEliminarDonante;                 
        
	@FXML    
	private TextField txtBuscar;               
	@FXML    
	private TableView<Donantes> TablaDonantes;      
	@FXML    
	private TableColumn<Donantes,String> Ndonante;     
	@FXML     
	private TableColumn<Donantes,String> Nombre;     
	@FXML    
	private TableColumn<Donantes,String> Apellido_1;     
	@FXML    
	private TableColumn<Donantes,String> Apellido_2;     
       
	@FXML   
	private TableColumn<Donantes,String> DNI_Pasaporte;         
	@FXML     
	private TableColumn<Donantes,String> Fecha_naci;        
	@FXML    
	private TableColumn<Donantes,String> TLF;         
	@FXML    
	private TableColumn<Donantes,String> TLF_mov;         
	@FXML  
	private TableColumn<Donantes,String> Email;         
	@FXML  
	private TableColumn<Donantes,String> Sexo;         
	@FXML
	private TableColumn<Donantes,String> Tipo_sanguineo;
	@FXML
	private TableColumn<Donantes,String> Direccion; 
	@FXML    
	private TableColumn<Donantes,String> T_residencia;
	@FXML
	private TableColumn<Donantes,String> Poblacion;
	@FXML
	private TableColumn<Donantes,String> Provincia;
	@FXML
	private TableColumn<Donantes,String> CP; 
	@FXML
	private TableColumn<Donantes,String> Pais_nacimiento;
	@FXML
	private TableColumn<Donantes,String> Aptitud;
	


	private Stage ventana;

	public void setProgramaPrincipal(Main ProgramaPrincipal) {
        this.ProgramaPrincipal = ProgramaPrincipal;
    }

	public void setStagePrincipal(Stage ventana) {
		// TODO Auto-generated method stub
		this.ventana = ventana;
	}

	public void closeWindow(){
		this.ventana.close();
	}
 ConexionBBDD2 con ;

public void insert () throws SQLException {
		
		con = new ConexionBBDD2();
		
		
		String Ndonante = txtNdonante.getText();
		String Nombre = txtNonmbre.getText();
		String Apellido1 = txtApellido1.getText();
		String Apellido2 = txtApellido2.getText();
		String foto = "NULL";
		String DNI = txtDNI.getText();
		String Fnaci = txtFecha_nacimiento.getText();
		String TLF = txtTlf.getText();
		String movil = txtTlfMovil.getText();
		String Email = txtEmail.getText();
		String Tsangre = txtTipoSangre.getText();
		String Direccion = txtDireccion.getText();
		String Tresidencia = txtTipoResidencia.getText();
		String Poblacion = txtPoblacion.getText();
		String Provincia =  txtProvincia.getText();
		String CP = txtCP.getText();
		String PaisNatal = txtPaisNatal.getText();
		String sexo;
		String Aptitud = "N";
		
		
		
		
		
		if(hombre.isSelected()) {
			sexo = "H";
		}else {
			sexo = "M";}
		
		
		
	

	
		if(txtNdonante.getText().equals("") || txtNonmbre.getText().equals("") || txtApellido1.getText().equals("") || txtApellido2.getText().equals("") || txtDNI.getText().equals("") ||txtFecha_nacimiento.getText().equals("") ||
		txtTlf.getText().equals("") || txtTlfMovil.getText().equals("") || txtEmail.getText().equals("") || txtTipoSangre.getText().equals("") || txtDireccion.getText().equals("") || txtTipoResidencia.getText().equals("") ||
		txtProvincia.getText().equals("") || txtCP.getText().equals("") || txtPaisNatal.getText().equals("")){
			
			
			
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("HAY CAMPOS VACIOS");
			alert.setHeaderText("Introduce todos los datos");
			alert.setContentText("Llena todos los huecos");
			alert.showAndWait();
		}
		else{
			con.InsertarDonante(Ndonante, Nombre, Apellido1, Apellido2, DNI, Fnaci, TLF, movil, Email, sexo, Tsangre, Direccion, Tresidencia, Poblacion, Provincia, CP, PaisNatal, Aptitud, foto);	
		}
	}	


}
