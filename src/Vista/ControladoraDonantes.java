package Vista;

import Controlador.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControladoraDonantes {

	private  Main ProgramaPrincipal;

	@FXML
	private Button buttonclose;

	@FXML
	private Button buttonWindows3;


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
