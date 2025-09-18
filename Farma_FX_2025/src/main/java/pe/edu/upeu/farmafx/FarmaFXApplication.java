// Ahora está en el paquete raíz
package pe.edu.upeu.farmafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import pe.edu.upeu.farmafx.utils.Vistas;

@SpringBootApplication
// YA NO NECESITAMOS @ComponentScan
public class FarmaFXApplication extends Application {

    private ConfigurableApplicationContext springContext;
    private Parent rootNode;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() throws Exception {
        springContext = new SpringApplicationBuilder(FarmaFXApplication.class)
                .web(WebApplicationType.NONE)
                .run(getParameters().getRaw().toArray(new String[0]));

        FXMLLoader loader = new FXMLLoader(getClass().getResource(Vistas.LOGIN.getRuta()));
        loader.setControllerFactory(springContext::getBean);
        rootNode = loader.load();
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("FarmaFX");
        primaryStage.setScene(new Scene(rootNode));
        primaryStage.show();
    }

    @Override
    public void stop() {
        springContext.close();
    }
}