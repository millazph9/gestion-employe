package ludmi.projet.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import ludmi.projet.app.Main;
import ludmi.projet.database.DatabaseConnection;
import ludmi.projet.model.Employe;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class EditEmployeController {

    @FXML TextField tfFNameEdit;
    @FXML TextField tfNameEdit;
    @FXML ComboBox<String> cbPosteEdit;
    @FXML ComboBox<String> cbDeptEdit;
    @FXML ComboBox<String> cbContratEdit;
    @FXML TextField tfSalaireEdit;
    @FXML
    DatePicker datePickerRecrutementEdit;


    public MainController mainController;
    private Employe selectEmploye;

    public void setMainController(MainController mainController){
        this.mainController = mainController;
    }


    List<String> postes = Arrays.asList(
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

    List<String> departements = Arrays.asList(
            "Informatique",
            "Design",
            "Management",
            "Ressources humaines",
            "Finances",
            "Commercial",
            "Infrastructure"
    );

    List<String> contrats = Arrays.asList(
            "CDD",
            "CDI",
            "Interminent",
            "Permanent",
            "Contrat d'apprentissage",
            "Contrat de professionnalisation",
            "CUI"

    );

    public void initialize(){
        cbPosteEdit.getItems().addAll(postes);
        cbDeptEdit.getItems().addAll(departements);
        cbContratEdit.getItems().addAll(contrats);
    }

    /**
     *
     * @param employe methode setEmploye affiche les données existantes
     */
    public void setEmploye(Employe employe){
        this.selectEmploye = employe;
        tfFNameEdit.setText(employe.getNom());
        tfNameEdit.setText(employe.getPrenom());
        cbPosteEdit.setValue(employe.getPoste());
        cbDeptEdit.setValue(employe.getDepartement());
        tfSalaireEdit.setText(String.valueOf(employe.getSalaire()));
        cbContratEdit.setValue(employe.getContrat());
        datePickerRecrutementEdit.setValue(employe.getDateRecrutement());
    }


    @FXML
    private void onCloseEdit() {


        retourMain();
    }

    public void onSaveEdit() {


        Employe employe = new Employe(selectEmploye.getId(), tfFNameEdit.getText(), tfNameEdit.getText(), cbPosteEdit.getValue(), cbDeptEdit.getValue(), Double.parseDouble(tfSalaireEdit.getText()), cbContratEdit.getValue(), datePickerRecrutementEdit.getValue());
        DatabaseConnection.editEmploye(employe);
        retourMain();
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
