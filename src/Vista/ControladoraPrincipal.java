package Vista;

import java.net.URL;
import java.util.ResourceBundle;

import Controlador.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class ControladoraPrincipal implements Initializable {

    private  Main ProgramaPrincipal;

    @FXML
    private Button button;


    public void setProgramaPrincipal(Main ProgramaPrincipal) {
        this.ProgramaPrincipal = ProgramaPrincipal;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }


    @FXML
    private void nuevaVentana() {
       	this.ProgramaPrincipal.mostrarVentanaSecundaria();
    }
}
