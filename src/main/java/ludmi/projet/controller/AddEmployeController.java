package ludmi.projet.controller;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import ludmi.projet.model.Employe;
import javafx.scene.control.TextField;


import java.awt.*;

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
}
