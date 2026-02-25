package ludmi.projet.composant;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ludmi.projet.app.Main;
import ludmi.projet.model.Employe;

import java.io.IOException;

public class MainController {
//kvzalbzilddkjdz
    @FXML TableView<Employe> tableEmployes;
    @FXML TableColumn<Employe, String> colPrenom;
    @FXML TableColumn<Employe, String> colNom;
    @FXML TableColumn<Employe, String> colPoste;
    @FXML TableColumn<Employe, String> colDept;
    @FXML TableColumn<Employe, Double> colSalaire;


    //création d'une liste
    private ObservableList<Employe> employes = FXCollections.observableArrayList();

    public void initialize() {
        //Je demande à afficher dans la colonne prénom la valeur prénom à l'aide de l'outil PropertyValueFactory ainsi de suite
        colPrenom.setCellValueFactory(new PropertyValueFactory<Employe, String>("prenom"));
        colNom.setCellValueFactory(new PropertyValueFactory<Employe, String>("nom"));
        colPoste.setCellValueFactory(new PropertyValueFactory<Employe, String>("poste"));
        colDept.setCellValueFactory(new PropertyValueFactory<Employe, String>("departement"));
        colSalaire.setCellValueFactory(new PropertyValueFactory<Employe, Double>("salaire"));
        Employe employe1 = new Employe(0, "Ludmilla", "Zephir", "Dev", "Num", 2000);
        Employe employe2 = new Employe(0, "Yarina", "Zephir", "Comptable", "Finance", 3000);
        employes.add(employe1);
        employes.add(employe2);
        tableEmployes.setItems(employes);



    }

    @FXML
    private void onAdd() {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/fxml/AddEmploye.fxml"));
        try {
            Scene scene = new Scene(loader.load());
            Main.stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    private void onEdit() {

        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/fxml/EditEmploye.fxml"));
        try {
            Scene scene = new Scene(loader.load());
            Main.stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Modifier");

    }

    @FXML
    private void onDelete() {



    }





}
