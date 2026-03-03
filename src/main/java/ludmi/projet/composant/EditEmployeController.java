package ludmi.projet.composant;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import ludmi.projet.app.Main;

import java.io.IOException;

public class EditEmployeController {

    @FXML TextField tfFName;
    @FXML TextField tfName;
    @FXML TextField tfPoste;
    @FXML TextField tfDept;
    @FXML TextField tfSalary;

    public MainController mainController;

    public void setMainController(MainController mainController){
        this.mainController = mainController;
    }


    private void onCloseEdit() {


        retourMain();
        System.out.println("Annuler");
    }

    public void onSaveEdit() {


        System.out.println("Modifier");
    }

    public void retourMain(){
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/fxml/main.fxml"));

        try{
            Scene scene = new Scene(loader.load());
            Main.stage.setScene(scene);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
