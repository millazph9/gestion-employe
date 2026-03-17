package ludmi.projet.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import ludmi.projet.app.Main;
import ludmi.projet.model.Employe;
import org.w3c.dom.Text;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;

public class FicheEmployeController extends Component {

    @FXML TextField tfFNameRead;
    @FXML TextField tfNameRead;
    @FXML TextField tfPostRead;
    @FXML TextField tfDeptRead;
    @FXML TextField tfSalaryRead;
    @FXML TextField tfContratRead;
    @FXML TextField tfDatePickerRecrutementRead;

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
    }

    @FXML
    private void onAddPic(){


        try {

            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "JPG & GIF Images", "jpg");
            chooser.setFileFilter(filter);
            chooser.showOpenDialog(this);
            File f = chooser.getSelectedFile();
            String fileName = f.getAbsolutePath();
            String cheminFinal = "images";
            File directory = new File(cheminFinal);
            if(!directory.exists()){
                directory.mkdir();
            }

            File sourceFile = new File(fileName);
            File destination = new File("image/" + selectEmploye + ".jpg");
            Files.copy(sourceFile.toPath(), destination.toPath());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        try{

        }catch (Exception e){

        }

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
