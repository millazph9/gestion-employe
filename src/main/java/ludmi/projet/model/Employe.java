package ludmi.projet.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

public class Employe {

    private int id;
    private String prenom;
    private String nom;
    private String poste;
    private String departement;
    private double salaire;


    public Employe(int id, String prenom, String nom, String poste, String departement, double salaire) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.salaire = salaire;
        this.poste = poste;
        this.departement = departement;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String toString(){
        return "Prenom : " + this.prenom + " Nom : " + this.nom;
    }



}
