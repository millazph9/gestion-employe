package ludmi.projet.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import ludmi.projet.app.Main;
import ludmi.projet.database.DatabaseConnection;
import ludmi.projet.model.Employe;

import java.io.IOException;

public class EditEmployeController {

    @FXML TextField tfFNameEdit;
    @FXML TextField tfNameEdit;
    @FXML TextField tfPosteEdit;
    @FXML TextField tfDeptEdit;
    @FXML TextField tfSalaireEdit;

    public MainController mainController;
    private Employe selectEmploye;

    public void setMainController(MainController mainController){
        this.mainController = mainController;
    }

    /**
     *
     * @param employe methode setEmploye affiche les données existantes
     */
    public void setEmploye(Employe employe){
        this.selectEmploye = employe;
        tfFNameEdit.setText(employe.getNom());
        tfNameEdit.setText(employe.getPrenom());
        tfPosteEdit.setText(employe.getPoste());
        tfDeptEdit.setText(employe.getDepartement());
        tfSalaireEdit.setText(String.valueOf(employe.getSalaire()));
    }


    @FXML
    private void onCloseEdit() {


        retourMain();
    }

    public void onSaveEdit() {

        Employe employe = new Employe(selectEmploye.getId(), tfFNameEdit.getText(), tfNameEdit.getText(), tfPosteEdit.getText(), tfDeptEdit.getText(), Double.parseDouble(tfSalaireEdit.getText()));
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
