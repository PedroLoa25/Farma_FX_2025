package pe.edu.upeu.farmafx.control;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane; // Import necesario
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pe.edu.upeu.farmafx.utils.NavegadorVistas;
import pe.edu.upeu.farmafx.utils.Vistas;

@Controller
public class MenuClienteController {

    @Autowired
    private NavegadorVistas navegador;

    // Añadimos la referencia al panel principal
    @FXML
    private BorderPane panelPrincipal;

    @FXML
    void cerrarSesionAccion(ActionEvent event) {
        navegador.cambiarEscena(panelPrincipal, Vistas.LOGIN, "Inicio de Sesión");
    }

    @FXML
    void salirAccion(ActionEvent event) {
        Platform.exit();
    }
}