package ludmi.projet.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ludmi.projet.database.DatabaseConnection;

import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static javafx.application.Application.launch;


public class Main extends  Application{

    public static Stage stage;
    public static GraphicsDevice myDevice;
    public static Window myWindow;



    @Override
    public void start(Stage stage) throws Exception {

        DatabaseConnection.initDatabase();
        DatabaseConnection.initUser();


        Main.stage = stage; // fenêtre
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/fxml/authentification.fxml"));
        Scene scene = new Scene(loader.load()); //création d'une scene et stockage fichier fxml stocké dans loader
        stage.setTitle("Gestion des employés");
        stage.setScene(scene);//affichage de la scene
        stage.setMaximized(true);
        stage.show();


    }




    public static void main(String[] args) throws SQLException {
        launch(args); // <-- ferme l'application

    }
}
