package ludmi.projet.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;


public class Main extends  Application{

    public static Stage stage;


    @Override
    public void start(Stage stage) throws Exception {
        Main.stage = stage;
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/fxml/main.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Gestion des employés - TEST 123");
        stage.setScene(scene);
        stage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}
