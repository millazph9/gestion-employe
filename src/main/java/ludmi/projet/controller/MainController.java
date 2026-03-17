package ludmi.projet.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import ludmi.projet.app.Main;
import ludmi.projet.database.DatabaseConnection;
import ludmi.projet.model.Employe;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainController {
//J'appelle la Table et ses colonnes
    @FXML TableView<Employe> tableEmployes;
    @FXML TableColumn<Employe, String> colPrenom;
    @FXML TableColumn<Employe, String> colNom;
    @FXML TableColumn<Employe, String> colPoste;
    @FXML TableColumn<Employe, String> colDept;
    @FXML TableColumn<Employe, Double> colSalaire;
    @FXML TableColumn<Employe, String> colContrat;
    @FXML TextField tfSearch;
    @FXML ComboBox<String> cbFiltre;



    private List<String> filtre = Arrays.asList(
            "Informatique",
            "Design",
            "Management",
            "Ressources humaines",
            "Finances",
            "Commercial",
            "Infrastructure"
    );

    //création d'une liste
    private ObservableList<Employe> employes = FXCollections.observableArrayList();


    public void initialize() {
        //Je demande à afficher dans la colonne prénom la valeur prénom à l'aide de l'outil PropertyValueFactory ainsi de suite
        colPrenom.setCellValueFactory(new PropertyValueFactory<Employe, String>("prenom"));
        colNom.setCellValueFactory(new PropertyValueFactory<Employe, String>("nom"));
        colPoste.setCellValueFactory(new PropertyValueFactory<Employe, String>("poste"));
        colDept.setCellValueFactory(new PropertyValueFactory<Employe, String>("departement"));
        colSalaire.setCellValueFactory(new PropertyValueFactory<Employe, Double>("salaire"));
        colContrat.setCellValueFactory(new PropertyValueFactory<Employe, String>("contrat"));
        cbFiltre.getItems().addAll(filtre);

        //Employe employe1 = new Employe(0, "Ludmilla", "Zephir", "Dev", "Num", 2000);
        //Employe employe2 = new Employe(0, "Yarina", "Zephir", "Comptable", "Finance", 3000);
        //employes.add(employe1);
        //employes.add(employe2);
        employes.addAll(DatabaseConnection.getAllSelect());
        tableEmployes.setItems(employes);




    }

    /**
     * la methode onAdd permet la redirection vers le formulaire ajout employé
     */
    @FXML
    private void onAdd() {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/fxml/AddEmploye.fxml"));
        try {
            Scene scene = new Scene(loader.load());

            //J'appelle le controller AddEmploye
            AddEmployeController addEmployeController = loader.getController();
            //Je lui défini le controller Main
            addEmployeController.setMainController(this);

            Main.stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * redefinition de la methode par defaut de ObservableList
     * permet d'ajouter un employé
     * @param employe
     */

    public void add(Employe employe) {

        employes.add(employe);
    }

    ///**
     //*
     //* @param employes methode setEmployes() pour connecter la liste des employés en mémoire avec le tableau
     //*/

    //public void setEmployes(ObservableList<Employe> employes){
        //this.employes = employes; // la liste des employés en mémoire
        //tableEmployes.setItems(this.employes); // branche le tableau sur cette liste pour qu'elle soit visible

    //}

    //public ObservableList<Employe> getEmployes(){

        //return employes;
    //}




    @FXML
    private void onEdit() {

        Employe selection = tableEmployes.getSelectionModel().getSelectedItem();
        if(selection == null){
            System.out.println("Pas de séléction");
        }else{
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/fxml/EditEmploye.fxml"));
            try {
                Scene scene = new Scene(loader.load());

                EditEmployeController editEmployeController = loader.getController();
                editEmployeController.setMainController(this);
                editEmployeController.setEmploye(selection);


                Main.stage.setScene(scene);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        //System.out.println("Modifier");

    }



    public void delete(int id){
        DatabaseConnection.deleteEmploye(id);
    }


    @FXML
    private void onDelete() {

       Employe selection = tableEmployes.getSelectionModel().getSelectedItem();
       if(selection == null){
           System.out.println("Pas de selection");
       }else{


            int dialog = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir supprimer cet employé ?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if(dialog == JOptionPane.YES_OPTION){
                delete(selection.getId());
                employes.remove(selection);
            }


       }

    }


    /**
     * methode onSearch : recherche employé dans la barre de recherche par texte ou par département
     */
    @FXML
    private void onSearch(){
        //System.out.println("Recherche");


        String recherche = tfSearch.getText();
        String r =  cbFiltre.getSelectionModel().getSelectedItem();

        if(r == null){
            employes.setAll(DatabaseConnection.getSelect(recherche));
        }else {
            employes.setAll(DatabaseConnection.getSelect(recherche, r));
        }




    }

    /**
     * methode onRead permet la lecture de la fiche d'un employé
     */
    @FXML
    public void onRead(){

        Employe select = tableEmployes.getSelectionModel().getSelectedItem();

        if(select == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Attention");
            alert.setContentText("Veuillez selectionner un employé");
            alert.showAndWait();
        }else {

            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/fxml/ficheEmploye.fxml"));

            try {
                Scene scene = new Scene(loader.load());

                FicheEmployeController ficheEmployeController = loader.getController();
                ficheEmployeController.setMainController(this);
                ficheEmployeController.setEmploye(select);



                Main.stage.setScene(scene
                );
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }







    }










