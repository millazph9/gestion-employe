package ludmi.projet.composant;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ludmi.projet.app.Main;
import ludmi.projet.model.Employe;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddEmployeController {

    //j'appelle chaque champs
    @FXML TextField tfId;
    @FXML TextField tfFName;
    @FXML TextField tfName;
    @FXML TextField tfPoste;
    @FXML TextField tfDept;
    @FXML TextField tfSalary;

    private Employe resultat;

    public Employe getResultat() {
        return resultat;
    }


    @FXML
    private void onSave(){

        int id = Integer.parseInt(tfId.getText());
        String nom = tfFName.getText();
        String prenom = tfName.getText();
        String poste = tfPoste.getText();
        String departement = tfDept.getText();
        double salary = Double.parseDouble(tfSalary.getText());

        resultat = new Employe(id, nom, prenom, poste, departement, salary);

        ((Stage) tfName.getScene().getWindow()).close();

    }

    @FXML
    private void onClose() {

        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/fxml/Main.fxml"));
        try {
            Scene scene = new Scene(loader.load());
            Main.stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("annuler");
    }
}
