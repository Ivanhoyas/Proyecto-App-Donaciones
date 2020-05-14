package Vista;

import Controlador.Main;
import Modelo.Donantes;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
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
	private Button btnEliminarDonanante;                 
        
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
	private TableColumn<Donantes,String> Foto;         
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





}
