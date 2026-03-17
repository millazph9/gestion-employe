package ludmi.projet.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import ludmi.projet.app.Main;
import ludmi.projet.database.DatabaseConnection;
import ludmi.projet.model.Employe;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


public class AddEmployeController {

    //j'appelle chaque champs
    @FXML TextField tfFName;
    @FXML TextField tfName;
    @FXML ComboBox<String> cbPoste;
    @FXML ComboBox<String> cbDept;
    @FXML TextField tfSalary;
    @FXML ComboBox<String> cbContrat;
    @FXML DatePicker datePickerRecrutement;

    private Employe e;


    private List<String> postes = Arrays.asList(
            "Developpeur web",
            "Ingénieur DevOps",
            "Testeur",
            "Architecte logiciel",
            "Designer",
            "Graphiste",
            "Chef de projet",
            "Responsable RH",
            "Comptable",
            "Assistant administratif",
            "Commercial"

    );

    private List<String> departements = Arrays.asList(
            "Informatique",
            "Design",
            "Management",
            "Ressources humaines",
            "Finances",
            "Commercial",
            "Infrastructure"

    );

    private List<String> contrat = Arrays.asList(
            "CDD",
            "CDI",
            "Interminent",
            "Permanent",
            "Contrat d'apprentissage",
            "Contrat de professionnalisation",
            "CUI"
    );

    public void initialize(){
        cbPoste.getItems().addAll(postes);
        cbDept.getItems().addAll(departements);
        cbContrat.getItems().addAll(contrat);
    }


    //Stockage de la reference (des données) qui sera envoyé dans le MainController pour être validée
    private MainController mainController;

    //Methode pour valider et présenter les données
    public void setMainController(MainController mainController){
        this.mainController = mainController;
    }

    @FXML
    private void onSave(){

        TextField[] champs = {tfFName, tfName, tfSalary};



        for(TextField champ : champs){
            if(champ.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Attention");
                alert.setContentText("Veuillez remplir les champs");
                alert.showAndWait();
                return;
            }
        }

        if(cbPoste.getValue() == null || cbDept.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Attention");
            alert.setContentText("Veuillez remplir les champs");
            alert.showAndWait();
            return;
        }

        if(cbContrat.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Attention");
            alert.setContentText("Veuillez remplir le champ");
            alert.showAndWait();
        }


        String nom = tfFName.getText();
        String prenom = tfName.getText();
        String poste = cbPoste.getValue();
        String departement = cbDept.getValue();
        double salaire;
        String contrat = cbContrat.getValue();
        LocalDate dateRecrutement = datePickerRecrutement.getValue();

       try{
           salaire = Double.parseDouble(tfSalary.getText());

           if(salaire <= 0){

               Alert alert = new Alert(Alert.AlertType.WARNING);
               alert.setTitle("Attention");
               alert.setContentText("Veuillez inscrire un salaire approprié");
               alert.showAndWait();
               return;

           }
       }catch(NumberFormatException e){
           Alert alert = new Alert(Alert.AlertType.WARNING);
           alert.setTitle("Attention");
           alert.setContentText("Veuillez inscrire un salaire approprié");
           alert.showAndWait();
           return;

       }


        //int id = mainController.getEmployes().size() + 1;

        //Création de l'employé
        Employe employe = new Employe(0, nom, prenom, poste, departement, salaire, contrat, dateRecrutement);

       if(DatabaseConnection.select(nom, prenom)){
           System.out.println("non");
       }else{
        DatabaseConnection.addEmploye(employe);
        mainController.add(employe);}

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
