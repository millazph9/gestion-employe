package ludmi.projet.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ludmi.projet.database.DatabaseConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static javafx.application.Application.launch;


public class Main extends  Application{

    public static Stage stage;


    @Override
    public void start(Stage stage) throws Exception {

        DatabaseConnection.initDatabase();

        Main.stage = stage;
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/fxml/main.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Gestion des employés - TEST 123");
        stage.setScene(scene);
        stage.show();
    }




    public static void main(String[] args) throws SQLException {
        launch(args); // <-- ferme l'application

    }
}
