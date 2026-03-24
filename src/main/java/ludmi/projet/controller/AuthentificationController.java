package ludmi.projet.controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;


import javafx.fxml.FXML;
import javafx.stage.Stage;
import ludmi.projet.app.Main;
import ludmi.projet.database.DatabaseConnection;
import ludmi.projet.model.User;
import org.w3c.dom.Text;

import java.io.IOException;

public class AuthentificationController {

    @FXML TextField tfUser;
    @FXML TextField tfPassword;

    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }


    public void initialize(){
        User user = new User(0, "admin01", "ludmilla25");

    }




    @FXML
    private void onLogin(){

        TextField[] champs = {tfUser, tfPassword};

        for(TextField champ : champs){
            if(champ.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Attention");
                alert.setContentText("Veuillez remplir les champs");
                alert.showAndWait();
                return;
            }
        }

        if(DatabaseConnection.connexionUser(tfUser.getText(), tfPassword.getText())){
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/fxml/main.fxml"));

            try{
                Scene scene = new Scene(loader.load());

                Main.stage.setScene(scene);



            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Attention");
            alert.setContentText("L'identifiant ou le mot de passe est incorrect, veuillez réessayer");
            alert.showAndWait();
            return;
        }
    }
}
