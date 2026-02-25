package ludmi.projet.composant;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import ludmi.projet.app.Main;

import java.io.IOException;

public class EditEmployeController {


    @FXML


    private void onCloseEdit() {


        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/fxml/Main.fxml"));
        try {
            Scene scene = new Scene(loader.load());
            Main.stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Annuler");
    }

    public void onSaveEdit() {

        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/fxml/EditEmploye.fxml"));
        try {
            Scene scene = new Scene(loader.load());
            Main.stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Modifier");
    }
}
