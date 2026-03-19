package ludmi.projet.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import ludmi.projet.app.Main;
import ludmi.projet.database.DatabaseConnection;
import ludmi.projet.model.Employe;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;



public class FicheEmployeController extends Component {

    @FXML TextField tfFNameRead;
    @FXML TextField tfNameRead;
    @FXML TextField tfPostRead;
    @FXML TextField tfDeptRead;
    @FXML TextField tfSalaryRead;
    @FXML TextField tfContratRead;
    @FXML TextField tfDatePickerRecrutementRead;
    @FXML ImageView viewImg;

    public MainController mainController;
    public Employe selectEmploye;


    public void setMainController(MainController maincontroller){
        this.mainController = maincontroller;
    }



    public void setEmploye(Employe employe){
        this.selectEmploye = employe;
        tfFNameRead.setText(employe.getNom());
        tfNameRead.setText(employe.getPrenom());
        tfPostRead.setText(employe.getPoste());
        tfDeptRead.setText(employe.getDepartement());
        tfSalaryRead.setText(String.valueOf(employe.getSalaire()));
        tfContratRead.setText(employe.getContrat());
        tfDatePickerRecrutementRead.setText(employe.getDateRecrutement().toString());

        if(employe.getImage() == null){
            Image oui = new Image(Main.class.getResource("/par_defaut.png").toString());
            viewImg.setImage(oui);

        }else{
            Image ok = new Image(employe.getImage());
            viewImg.setImage(ok);
        }




    }

    public static void initialize(){

    }


    @FXML
    private void onAddPic(){


        FileChooser chooser = new FileChooser();
        chooser.setTitle("Ouvrir fichier");
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Images", "*jpg", "*png")
        );

        File selectedFile = chooser.showOpenDialog(Main.stage);
        if(selectedFile != null ){
            Image image = new Image(selectedFile.toURI().toString());
            viewImg.setImage(image);
        }

        Employe em = new Employe(selectEmploye.getId(), tfNameRead.getText(),tfFNameRead.getText(), tfPostRead.getText(), tfDeptRead.getText(), Double.parseDouble(tfSalaryRead.getText()), tfContratRead.getText(), LocalDate.parse(tfDatePickerRecrutementRead.getText()), selectedFile.getAbsolutePath());
        DatabaseConnection.addImage(em);










    }



    @FXML
    private void onCloseRead(){

        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/fxml/main.fxml"));

        try{
            Scene scene = new Scene (loader.load());
            Main.stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




}
