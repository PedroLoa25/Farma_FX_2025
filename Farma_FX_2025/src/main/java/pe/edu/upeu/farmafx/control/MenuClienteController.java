package pe.edu.upeu.farmafx.control;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pe.edu.upeu.farmafx.FarmaFXApplication;
import pe.edu.upeu.farmafx.enums.Estado;
import pe.edu.upeu.farmafx.modelo.Categoria;
import pe.edu.upeu.farmafx.modelo.Usuario;
import pe.edu.upeu.farmafx.servicio.CategoriaServicioI;
import pe.edu.upeu.farmafx.utils.NavegadorVistas;
import pe.edu.upeu.farmafx.utils.Vistas;
import java.util.List;

@Controller
public class MenuClienteController {

    @Autowired
    private NavegadorVistas navegador;

    @Autowired
    private CategoriaServicioI categoriaServicio;

    @FXML
    private BorderPane panelPrincipal;

    @FXML
    private Label dniUsuarioLabel;

    @FXML
    private Menu menuCategorias;

    @FXML
    public void initialize() {
        Usuario usuario = FarmaFXApplication.usuarioLogueado;
        if (usuario != null) {
            dniUsuarioLabel.setText("Usuario: " + usuario.getDni());
        }
        List<Categoria> categorias = categoriaServicio.listarCategorias();
        categorias.stream()
                .filter(c -> c.getEstado() == Estado.ACTIVO)
                .forEach(categoriaActiva ->{
                    MenuItem itemCategoria = new MenuItem(categoriaActiva.getNombre());
                    itemCategoria.setDisable(true);
                    if (menuCategorias != null) {
                        menuCategorias.getItems().add(itemCategoria);
                    }
                });
    }

    @FXML
    void cerrarSesionAccion(ActionEvent event) {
        FarmaFXApplication.usuarioLogueado = null;
        navegador.cambiarEscena(panelPrincipal, Vistas.LOGIN, "Inicio de Sesión");
    }

    @FXML
    void salirAccion(ActionEvent event) {
        Platform.exit();
    }
}