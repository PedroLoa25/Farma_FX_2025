package pe.edu.upeu.farmafx.control;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pe.edu.upeu.farmafx.utils.NavegadorVistas;
import pe.edu.upeu.farmafx.utils.Vistas;

@Controller
public class MenuAdminController {

    @Autowired
    private NavegadorVistas navegador;

    @FXML
    private BorderPane panelPrincipal;

    @FXML
    void abrirGestionCategorias(ActionEvent event) {
        navegador.cambiarEscena(panelPrincipal, Vistas.GESTION_CATEGORIAS, "Gestión de Categorías");
    }

    @FXML
    void abrirGestionMarcas(ActionEvent event) {
        navegador.cambiarEscena(panelPrincipal, Vistas.GESTION_MARCAS, "Gestión de Marcas");
    }

    @FXML
    void abrirGestionProductos(ActionEvent event) {
        System.out.println("Funcionalidad de Productos pendiente.");
    }

    @FXML
    void cerrarSesionAccion(ActionEvent event) {
        navegador.cambiarEscena(panelPrincipal, Vistas.LOGIN, "Inicio de Sesión");
    }

    @FXML
    void salirAccion(ActionEvent event) {
        Platform.exit();
    }
}
