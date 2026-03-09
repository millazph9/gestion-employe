package ludmi.projet.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import ludmi.projet.app.Main;
import ludmi.projet.database.DatabaseConnection;
import ludmi.projet.model.Employe;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddEmployeController {

    //j'appelle chaque champs
    @FXML TextField tfFName;
    @FXML TextField tfName;
    @FXML TextField tfPoste;
    @FXML TextField tfDept;
    @FXML TextField tfSalary;


    //Stockage de la reference (des données) qui sera envoyé dans le MainController pour être validée
    private MainController mainController;

    //Methode pour valider et présenter les données
    public void setMainController(MainController mainController){
        this.mainController = mainController;
    }

    @FXML
    private void onSave(){

        String nom = tfFName.getText();
        String prenom = tfName.getText();
        String poste = tfPoste.getText();
        String departement = tfDept.getText();
        double salaire = Double.parseDouble(tfSalary.getText());

        //int id = mainController.getEmployes().size() + 1;

        //Création de l'employé
        Employe employe = new Employe(0, nom, prenom, poste, departement, salaire);

        DatabaseConnection.addEmploye(employe);
        mainController.add(employe);

        retournerMain();

        //((Stage) tfName.getScene().getWindow()).close();



    }



    @FXML
    private void onClose() {

        retournerMain();
    }

    private void retournerMain(){
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/fxml/main.fxml"));

        try{
            Scene scene = new Scene(loader.load());
            Main.stage.setScene(scene);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
